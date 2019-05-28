package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Controller {
    @FXML
    public TextField b;
    @FXML
    public TextArea textArea;
    public String messageText;
    public static List<Message> messageList = new ArrayList<>();

    public void onButtonClicked() {
        messageText = b.getText();
        if (!messageText.isEmpty()) {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            textArea.appendText(timestamp.toString() + ": " + messageText + "\n");
            b.clear();
            messageList.add(new Message(messageText, timestamp));
        }
    }

    public static List<Message> getMessageList() {
        if (!messageList.isEmpty()) {
            System.out.println(messageList.get(0).getMessageText());
        }

        return messageList;
    }
}

