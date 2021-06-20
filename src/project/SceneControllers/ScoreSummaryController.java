package project.SceneControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ScoreSummaryController implements Initializable {

    //ks = keyStrokes
    //prev sum means the labels in the prev summ anchorPane and vice versa

    private static String name;
    private static User user;
    Stage stage;
    @FXML
    private TextArea prevSummary;
    @FXML
    private Label currSpeed;
    @FXML
    private Label currAcc;
    @FXML
    private Label currKS;
    @FXML
    private Label currCorrectKS;
    @FXML
    private Label currWrongKS;
    @FXML
    private AnchorPane scenePane;

    public static void setUser(User tempUser) {
        name = tempUser.getUserName();
        user = tempUser;
    }

    @FXML
    void backToMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/MenuPage.fxml"));
        Scene menuScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(menuScene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ShowPrevSummary();

    }


    void ShowPrevSummary() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File( name + ".txt")));

            String line;
            while ((line = reader.readLine()) != null) {
                prevSummary.setText(prevSummary.getText() + "\n" + line);
            }
            reader.close();
        } catch (Exception e) {
            prevSummary.setText("No previous summary available");
        }
    }

    @FXML
    void Summary(MouseEvent event) {
        currAcc.setText(String.valueOf(user.getAccuracy()) + "%");
        currCorrectKS.setText(String.valueOf(user.getCorrectWords()));
        currWrongKS.setText(String.valueOf(user.getWrongWords()));
        currSpeed.setText(String.valueOf(user.getWpm()));
        currWrongKS.setText(String.valueOf(user.getWrongWords()));
        currKS.setText(String.valueOf(user.getKeystroke()));
    }
}
