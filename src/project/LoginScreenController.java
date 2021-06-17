package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {

    Stage stage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private ImageView ExitButton;
    @FXML
    private ImageView MinimizeButton;

    @FXML
    void login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));

        Scene menuScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(menuScene);

        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExitButton.setOnMouseClicked(event -> System.exit(0));

        MinimizeButton.setOnMouseClicked(event -> {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.setIconified(true);
        });

    }

}
