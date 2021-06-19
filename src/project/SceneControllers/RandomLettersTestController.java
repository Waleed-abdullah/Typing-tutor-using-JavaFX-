package project.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RandomLettersTestController {

    Stage stage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label errors;
    @FXML
    private Label txt1;
    @FXML
    private Label txt2;
    @FXML
    private Label txt3;
    @FXML
    private Label txt4;
    @FXML
    private Label txt5;
    @FXML
    private Label txt6;
    @FXML
    private Label txt7;
    @FXML
    private Label txt8;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;
    @FXML
    private TextField textField7;
    @FXML
    private TextField textField8;


    @FXML
    void submitTest(ActionEvent event) {
        int errorCount = 0;

        if (!(txt1.getText().equals(textField1.getText()))) {
            errorCount++;
            txt1.setStyle("-fx-background-color:Red;");
        }

        if (!(txt2.getText().equals(textField2.getText()))) {
            errorCount++;
            txt2.setStyle("-fx-background-color:Red;");
        }

        if (!(txt3.getText().equals(textField3.getText()))) {
            errorCount++;
            txt3.setStyle("-fx-background-color:Red;");
        }

        if (!(txt4.getText().equals(textField4.getText()))) {
            errorCount++;
            txt4.setStyle("-fx-background-color:Red;");
        }

        if (!(txt5.getText().equals(textField5.getText()))) {
            errorCount++;
            txt5.setStyle("-fx-background-color:Red;");
        }


        if (!(txt6.getText().equals(textField6.getText()))) {
            errorCount++;
            txt6.setStyle("-fx-background-color:Red;");
        }

        if (!(txt7.getText().equals(textField7.getText()))) {
            errorCount++;
            txt7.setStyle("-fx-background-color:Red;");
        }

        if (!(txt8.getText().equals(textField8.getText()))) {
            errorCount++;
            txt8.setStyle("-fx-background-color:Red;");
        }

        //now setting the value on the screen
        errors.setText(Integer.toString(errorCount));

    }

    @FXML
    void RefreshTest(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Scenes/RandomLettersTest.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene menuScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(menuScene);
        stage.show();
    }

    @FXML
    void backToMenu(MouseEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../Scenes/MenuPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene menuScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(menuScene);
        stage.show();
    }

}
