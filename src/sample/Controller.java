package sample;

import database.DatabaseForObjects;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    public TextArea textArea;
    @FXML
    private TextField name;
    @FXML
    private Node border;
    @FXML
    private Button closebutton;
    private DatabaseForObjects base = new DatabaseForObjects();

    public void onButtonClicked() {
        System.out.println("Hello " + name);
    }

    public void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        File returnValue = fileChooser.showOpenDialog(border.getScene().getWindow());
        String value = returnValue.toString();
        try {
            base.loadToDatabase(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeApplication() {
        Platform.exit();
        System.exit(0);
    }

    public void printText() {

        textArea.setText("featuresIDs " + base.getFeautersIDs() + "\n" +
                "featuresNo " + base.getNoFeatures() + "\n" +
                "objectsNo " + base.getNoObjects() + "\n" +
                "namesOfClass " + base.getClassNames() + "\n" +
                "numberOfClass " + base.getClassNames().size() + "\n" +
                "first object created " + base.getSingleObjects().get(1).toString() + "\n" +
                "second object created " + base.getSingleObjects().get(70).toString());
    }
}
