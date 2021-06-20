package project.SceneControllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import project.FileHandling;
import project.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signUpScreenController implements Initializable {

    Stage stage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private TextField userNameField = new TextField();
    @FXML
    private PasswordField passwordField = new PasswordField();
    @FXML
    private Label errorLabel = new Label();
    private User user = new User();
    private FileHandling fileHandling = new FileHandling();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //in case enter key is pressed
        scenePane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    try {
                        signUp(new ActionEvent());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {

        if ((userNameField.getText() != "") && (passwordField.getText() != "")) {
            user.setUserName(userNameField.getText());
            user.setPassword(passwordField.getText());
        } else {
            errorLabel.setTextFill(Color.RED);
            errorLabel.setText("Username or password fields cannot be empty");
            return;
        }

        if (fileHandling.checkUserName(user)) {
            errorPopup();
            userNameField.setText("");
            passwordField.setText("");
        } else {
            fileHandling.addRecords(user);
            TypingSpeedTestController.setUser(user);
            ScoreSummaryController.setUser(user);
            Parent root = FXMLLoader.load(getClass().getResource("../Scenes/MenuPage.fxml"));

            Scene menuScene = new Scene(root);

            stage = (Stage) scenePane.getScene().getWindow();
            stage.setScene(menuScene);

            stage.show();
        }

    }

    @FXML
    void switchToLogin(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/loginScreen.fxml"));

        Scene loginScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(loginScene);

        stage.show();
    }

    @FXML
    void backToWelcome(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/welcomeScreen.fxml"));

        Scene loginScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(loginScene);

        stage.show();
    }


    @FXML
    void errorPopup() {
        errorLabel.setTextFill(Color.RED);
        errorLabel.setText("This username already exists.\nPlease enter a new username");
    }

}
