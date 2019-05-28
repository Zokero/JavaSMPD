package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Chat {

    public String writeToFile(String message) {
//        for (Object m : message) {
            try {
                FileWriter fstream = new FileWriter("C:\\Users\\pikuk1\\Documents\\git-repos\\JavaSMPD\\src\\sample\\data.txt", true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(message);
                out.newLine();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//        }
        return "";
    }
}
