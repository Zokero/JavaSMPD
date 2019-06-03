package sample;

import sample.view.Message;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Chat {
    public Map<String, Message> messageMap = new HashMap<>();

    public String writeToFile(String message) {
        try {
            FileWriter fstream = new FileWriter("E:\\git-repos\\JavaSMPD\\src\\sample\\data.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(message);
            out.newLine();
            out.close();
            String[] xxx = message.split(" ");
            System.out.println(xxx[1]);
            //List<String> array = Arrays.asList(xxx);
            messageMap.put(xxx[2], new Message(xxx[3], xxx[0] + " " + xxx[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    public String readFromMap(String userName) {

        Message msg = messageMap.get(userName);
        System.out.println(msg.getMessageText());
        System.out.println(msg.getTimestamp() + " " + msg.getMessageText());
        return msg.getTimestamp() + " " + msg.getMessageText();

    }
}
