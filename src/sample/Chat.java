package sample;

import sample.view.Message;

import java.util.*;

public class Chat {
    private static Map<String, Message> strings = new HashMap<>();
    private static Set<String> stringList;
    private static List<Message> list = new ArrayList<>();


    public String writeToFile(String message, String timestamp, String uuid) {
        System.out.println(message);
        System.out.println(uuid);
        list.add(new Message(message, timestamp, uuid));
        strings.put(uuid, new Message(message, timestamp, uuid));
        return message;
    }

    public String readFromMap(String uuid) {
        StringBuilder sB = new StringBuilder();
        if (!list.isEmpty()) {
            list.forEach(l -> {
                sB.append(l.toString());
                sB.append("\n");
            });
            return sB.toString();
        } else {
            return "";
        }
    }
}