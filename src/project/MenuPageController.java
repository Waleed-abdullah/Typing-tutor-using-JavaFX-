package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuPageController implements Initializable {

    @FXML
    private ImageView backButton;
    @FXML
    private AnchorPane menuPane;


    Stage stage;
    private MouseEvent event;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene loginScreen = new Scene(root);

        backButton.setOnMouseClicked(mouseEvent -> {
            Alert logoutAlert = new Alert(Alert.AlertType.CONFIRMATION);
            logoutAlert.setHeaderText("You are about to logout!");
            logoutAlert.setContentText("Are you sure you want to go back to the login screen?");

            if(logoutAlert.showAndWait().get() == ButtonType.OK) {
                stage = (Stage) menuPane.getScene().getWindow();
                stage.setScene(loginScreen);
                stage.show();
            }
        });
    }

    @FXML
    void openTypingSpeedMode(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TypingSpeedMode.fxml"));
        Scene typingSpeedMode = new Scene(root);

        stage = (Stage) menuPane.getScene().getWindow();
        stage.setScene(typingSpeedMode);
        stage.show();
    }

    @FXML
    void openScoreSummary(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ScoreSummary.fxml"));
        Scene typingSpeedMode = new Scene(root);

        stage = (Stage) menuPane.getScene().getWindow();
        stage.setScene(typingSpeedMode);
        stage.show();
    }

    @FXML
    void openRandomLettersTest(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RandomLettersTest.fxml"));
        Scene typingSpeedMode = new Scene(root);

        stage = (Stage) menuPane.getScene().getWindow();
        stage.setScene(typingSpeedMode);
        stage.show();
    }

}
