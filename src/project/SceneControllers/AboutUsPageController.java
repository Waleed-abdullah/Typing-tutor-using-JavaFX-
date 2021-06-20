package project.SceneControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutUsPageController {

    @FXML
    AnchorPane scenePane;

    Stage stage;
    @FXML
    void backToWelcome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/welcomeScreen.fxml"));

        Scene loginScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(loginScene);

        stage.show();
    }
}
