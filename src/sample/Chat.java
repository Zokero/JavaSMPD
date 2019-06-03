package sample;

import sample.view.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat {
    public Map<String, Message> messageMap = new HashMap<>();
    private static List<String> strings = new ArrayList<>();

    public String writeToFile(String message) {
        System.out.println(message);
        strings.add(message);
        return message;
//        try {
//            FileWriter fstream = new FileWriter("E:\\git-repos\\JavaSMPD\\src\\sample\\data.txt", true);
//            BufferedWriter out = new BufferedWriter(fstream);
//            out.write(message);
//            out.newLine();
//            out.close();
//            String[] xxx = message.split(" ");
//            System.out.println(xxx[1]);
//            messageMap.put(xxx[2], new Message(xxx[3], xxx[0] + " " + xxx[1]));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return message;
    }

    public String readFromMap(String userName) {

        if(!strings.isEmpty()){
            return strings.get(0);
        }else {
            return "XD";
        }
//        Message msg = messageMap.get(userName);
//        System.out.println(msg.getMessageText());
//        System.out.println(msg.getTimestamp() + " " + msg.getMessageText());
//        return msg.getTimestamp() + " " + msg.getMessageText();

    }
}
