import org.json.JSONException;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String [] args) throws FileNotFoundException, JSONException {

        StatGenerator newNPC = new StatGenerator();
        newNPC.generator();

        NpcDescriptors newDescriptors = new NpcDescriptors();

        newDescriptors.clrReader();
    }

}


