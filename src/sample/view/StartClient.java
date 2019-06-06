package sample.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Client;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class StartClient extends Application {
    public static String userID = UUID.randomUUID().toString().substring(0, 8);
    @FXML
    TextArea textArea;
    @FXML
    TextField textField;
    private Client client = new Client();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    @FXML
    public void initialize() {
        Runnable task = () -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    Platform.runLater(() -> {
                        String str = client.getFromServer(userID);
                        textArea.clear();
                        textArea.appendText(str);
                    });

                } catch (InterruptedException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(task).start();
    }

    @FXML
    public void onButtonClicked() {
        String messageText = textField.getText();
        if (!messageText.isEmpty()) {
            Timestamp timestamp = new Timestamp(new Date().getTime());
            Message message = new Message(messageText, timestamp.toString(), userID);
            client.sendToServer(message);
            textField.clear();
        }
    }
}