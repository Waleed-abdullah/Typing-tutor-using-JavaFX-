package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {

    @FXML
    private AnchorPane scenePane;

    Stage stage;

    @FXML
    void closeApp(MouseEvent event) {
            stage = (Stage)scenePane.getScene().getWindow();
            stage.close();
    }

    @FXML
    void minimizeApp(MouseEvent event) {
        stage = (Stage)scenePane.getScene().getWindow();
        stage.setIconified(true);

    }

    @FXML
    void login(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));

            Scene menuScene = new Scene(root);

            stage = (Stage) scenePane.getScene().getWindow();
            stage.setScene(menuScene);

            stage.show();


    }


}
