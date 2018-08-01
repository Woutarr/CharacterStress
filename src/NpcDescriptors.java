import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;


public class NpcDescriptors {





    private String raceGenerator(String firstName, String lastName){
        // random npc race generator or user input
        return (firstName + " " + lastName + " has no race.");
    }
    private String ageRange(String firstName, String lastName){
        // random age range or user input
        return (firstName + " " + lastName + " has no age range");
    }
    private int ageGenerator(String firstName, String lastName){
        // if race && child/teen/adult/old -> random age range generated
        System.out.println(firstName + " " + lastName + " 's age is not generated." );
        return -1;
    }

    private String hairClr(String firstName, String lastName){
        // based on race && age -> hair colour
        return (firstName + " " + lastName + "has no hair colour.");
    }

    private String eyeClr (String firstName, String lastName){
        // based on race -> eye colour.
        return (firstName + " "+lastName + " has no eye colour.");
    }

    private String randomTrait(String firstName, String lastName){
        // random discerning traits

        return (firstName + " "+lastName + " has no discerning traits.");
    }

    // random number for stat
    public int randomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public String clrReader () throws FileNotFoundException {

        String clr;

        ArrayList <String> fileNames = new ArrayList<>();
        fileNames.add("Resources\\yellow.txt");
        fileNames.add("Resources\\orange.txt");
        fileNames.add("Resources\\red.txt");
        fileNames.add("Resources\\pink.txt");
        fileNames.add("Resources\\violet.txt");
        fileNames.add("Resources\\blue.txt");
        fileNames.add("Resources\\green.txt");
        fileNames.add("Resources\\brown.txt");
        fileNames.add("Resources\\grey.txt");

        String[] basicClr = new String[9];
        basicClr[0] = "yellow";
        basicClr[1] = "orange";
        basicClr[2] = "red";
        basicClr[3] = "pink";
        basicClr[4] = "violet";
        basicClr[5] = "blue";
        basicClr[6] = "green";
        basicClr[7] = "brown";
        basicClr[8] = "grey";

        int arraySlct  = randomRange(0, fileNames.size()-1);

        String line;

        try {
            FileReader fileReader = new FileReader(fileNames.get(arraySlct));
            String usedFile = fileNames.get(arraySlct);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            ArrayList<String> clrOptions = new ArrayList<>();

            while (line != null) {

                clrOptions.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            int ranNr = randomRange(0, clrOptions.size()-1);
            clr = clrOptions.get(ranNr);

            System.out.println("The colour is " + clr + " " + basicClr[arraySlct]);
            return clr;

        } catch (java.io.IOException ex) {
            System.out.println("Unable to open file '" + fileNames + "'");
            return ("Failed to choose a colour.");
        }

    }
}
