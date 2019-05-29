package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Timestamp;
import java.util.*;

public class Controller {
    @FXML
    public TextField b;
    @FXML
    public TextArea textArea;

    public static String userID = UUID.randomUUID().toString().substring(0, 8);
    public static Stack<Message> messageStack = new Stack<>();

    public void onButtonClicked() {
        String messageText = b.getText();
        if (!messageText.isEmpty()) {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            Message message = new Message(messageText, timestamp.toString(), userID);
            String string = message.getTimestamp() + " " + message.getAuthor() + ": " + message.getMessageText() + "\n";
            textArea.appendText(string);
            messageStack.add(message);
            b.clear();
        }
    }
}

