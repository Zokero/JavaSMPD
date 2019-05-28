package sample;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<String> users = new ArrayList<>();
    private List<Message> messageMap = new ArrayList<>();


    public void addMessage(Message message) {
        messageMap.add(message);
    }

    public String addUser(String userName) {
        users.add(userName);
        System.out.println("User " + users.get(0) + " connected");
        return userName;
    }

    public String sendMessage() {
        new Thread(() -> {

            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Send");
                    messageMap.addAll(Controller.getMessageList());
                } catch (InterruptedException e) {

                }
            }
        });
        return "";
    }

    public String readMessage() {

        new Thread(() -> {
            while (true) {

                try {
                    Thread.sleep(2000);
                    System.out.println("Read");
                    System.out.println(Controller.getMessageList().get(0).getMessageText());


                    if (!messageMap.isEmpty()) {
                        System.out.println("messageMap");
                        System.out.println(messageMap.get(0).getTimestamp().toString() + " " + messageMap.get(0).getMessageText());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return "";
    }
}
