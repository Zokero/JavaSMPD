package sample.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Controller {
    public static List<Message> messageList = new ArrayList<>();
    @FXML
    public TextField b;
    @FXML
    public TextArea textArea;
    public String messageText;
    public String userID = UUID.randomUUID().toString().substring(0, 8);

    public void onButtonClicked() {
        messageText = b.getText();
        if (!messageText.isEmpty()) {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            Message message = new Message(messageText, timestamp.toString(), userID);
            String string = message.getTimestamp() + " " + message.getAuthor() + ": " + message.getMessageText() + "\n";
            textArea.appendText(string);
            messageList.add(message);
            b.clear();
        }
    }
}

