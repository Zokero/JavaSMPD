package sample;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private static List<String> strings = new ArrayList<>();

    public String writeToFile(String message) {
        System.out.println(message);
        strings.add(message);
        return message;
    }

    public String readFromMap(String userName) {
        if (!strings.isEmpty()) {
            return strings.get(0);
        } else {
            return "Server is empty";
        }
    }
}
