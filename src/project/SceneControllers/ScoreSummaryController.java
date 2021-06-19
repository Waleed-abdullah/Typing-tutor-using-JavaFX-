package project.SceneControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoreSummaryController {

    //ks = keyStrokes
    //prev sum means the labels in the prev summ anchorPane and vice versa
    @FXML
    private Label prevSumTestTime;

    @FXML
    private Label prevSumSpeed;

    @FXML
    private Label prevSumAccuracy;

    @FXML
    private Label prevSumKS;

    @FXML
    private Label prevSumCorrectKS;

    @FXML
    private Label prevSumWrongKS;

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

    Stage stage;

    @FXML
    void backToMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/MenuPage.fxml"));
        Scene menuScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(menuScene);
        stage.show();
    }

    @FXML
    void nextSummary(MouseEvent event) {

    }

    @FXML
    void prevSummary(MouseEvent event) {

    }

}
