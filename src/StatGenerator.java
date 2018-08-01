import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StatGenerator {

    private int str;
    private int dex;
    private int con;
    private int intel;
    private int wis;
    private int cha;
    int[] stats = {this.str, this.dex, this.con, this.intel, this.wis, this.cha};

    // generate stats at random
    public void generator() {

        for (int i = 1; i < stats.length + 1; i++) {
            int pick = i - 1;
            stats[pick] = randomWithRange(4, 18);
        }

        String firstName = firstNameGenerator();
        String lastName = lastNameGenerator();

        System.out.println("Name of NPC: " + firstName + " " + lastName);

        System.out.println(" Str = " + stats[0] + "\n Dex = " + stats[1] + "\n Con = " + stats[2] +
                "\n int = " + stats[3] + "\n wis = " + stats[4] + "\n Cha = " + stats[5]);
    }

    // random number for stat
    public int randomWithRange(int min, int max) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }


    public String firstNameGenerator() {

        String firstName;

        String fileName = ("Resources\\first-names");
        String line;

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            ArrayList<String> names = new ArrayList<>();

            while (line != null) {

                names.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            int ranNr = randomWithRange(0, names.size());
            firstName = names.get(ranNr);
            return firstName;

        } catch (java.io.IOException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
            return ("failed to create first name");
        }
    }

        public String lastNameGenerator(){

            String lastName;

            String fileName = ("Resources\\last-names");
            String line;

        try {
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            ArrayList<String> names = new ArrayList<>();

            while (line != null) {

                names.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            int ranNr = randomWithRange(0, names.size());
            lastName = names.get(ranNr);
            return lastName;

        } catch (java.io.IOException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
            return ("Failed to create last name");
        }




    }
}





