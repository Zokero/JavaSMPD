package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    public TextField b;
    @FXML
    public TextArea textArea;

    public void onButtonClicked() {
        System.out.println("Hello ");
        textArea.setText("testText\n");
        textArea.setText("\ntestTefdsfdfsxt");

       // textArea.appendText("\n");

    }
}

