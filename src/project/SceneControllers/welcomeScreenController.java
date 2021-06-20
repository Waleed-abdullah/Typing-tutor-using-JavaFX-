package project.SceneControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class welcomeScreenController {
    @FXML
    private AnchorPane scenePane;
    Stage stage;


    @FXML
    void goToSignUp(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/signUpScreen.fxml"));

        Scene signUpScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(signUpScene);

        stage.show();
    }

    @FXML
    void goToLogin(ActionEvent actionEvent)throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/loginScreen.fxml"));

        Scene loginScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(loginScene);

        stage.show();
    }

    @FXML
    void toAboutUs(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/AboutUs.fxml"));

        Scene loginScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(loginScene);

        stage.show();
    }
}
