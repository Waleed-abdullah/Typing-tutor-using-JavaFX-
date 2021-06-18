package project.SceneControllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import project.TypingDataCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TypingSpeedTestController implements Initializable {
    @FXML
    private AnchorPane scenePane;

    @FXML
    private ImageView ExitButton;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView MinimizeButton;

    @FXML
    private TextField TypingField;

    @FXML
    private TextArea textDisplay;

    @FXML
    private Text WPM;

    @FXML
    private Label KeyStrokes;

    @FXML
    private Label Accuracy;

    @FXML
    private Label CorrectKS;

    @FXML
    private Label WrongKS;

    @FXML
    private Button timerButton;

    private TypingDataCalculator calculator;

    private Stage stage;

    private int errorCount;

    private int totalChar;

    private char expectedKey;

    private char typedKey;

    private int typedKS = 0;//typed keystroke counter

    private int indexOfLine = 0;

    private String testText = "";

    private int wordCount = 0;

    //Timer variables
    private Timeline timeline;

    private int mins = 0, secs = 0, millis = 0;

    private boolean sos = true;

    private boolean timerStarted = false;


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
        //Initially Elapsed time is set to 0.
        timeLabel.setText("00:00");

        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeTime();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        //Action to be performed by timer button on firing.
        timerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sos) {
                    timeline.play();
                    sos = false;
                    timerButton.setText("Stop");
                } else {
                    timeline.pause();
                    sos = true;
                    timerButton.setText("Start");
                }
            }
        });

        ExitButton.setOnMouseClicked(event -> System.exit(0));

        MinimizeButton.setOnMouseClicked(event -> {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.setIconified(true);
        });

        //the method for the test from here
        loadTest();


    }

    private void loadTest() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/project/textFiles/Test.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                textDisplay.setText(textDisplay.getText() + line);
                testText += line;
            }
            reader.close();
            textDisplay.requestFocus();
            errorCount = 0;
            indexOfLine = 0;
            wordCount = 0;
            totalChar = testText.length();

            textDisplay.setStyle("-fx-highlight-fill: #bbdefb; -fx-highlight-text-fill: #2196f3;");
            textDisplay.selectRange(indexOfLine, indexOfLine + 1);

            TypingField.setOnKeyTyped(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (!timerStarted) {
                        timerStarted = true;
                        timerButton.fire();
                    }

                    expectedKey = testText.charAt(indexOfLine);
                    //System.out.println(expectedKey);
                    typedKey = event.getCharacter().charAt(0);
                    typedKS++;
                    if (indexOfLine < testText.length()) {
                        if (typedKey != expectedKey) {
                            errorCount++;
                            indexOfLine++;
                            textDisplay.setStyle("-fx-background-color: #ffcdd2;-fx-highlight-fill: #bbdefb; -fx-highlight-text-fill: #2196f3;");
                            textDisplay.selectRange(indexOfLine, indexOfLine + 1);
                        } else {
                            if (typedKey == ' ')
                                wordCount++;
                            indexOfLine++;
                            textDisplay.setStyle("-fx-background-color: white;-fx-highlight-fill: #bbdefb; -fx-highlight-text-fill: #2196f3;");
                            textDisplay.selectRange(indexOfLine, indexOfLine + 1);
                        }

                    }
                    if (indexOfLine == testText.length()) {
                        timerButton.fire();
                    }
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //method to change the text for the time label
    void changeTime() {
        if (millis == 1000) {
            secs++;
            millis = 0;
        }
        if (secs == 60) {
            mins++;
            secs = 0;
        }
        timeLabel.setText((((mins / 10) == 0) ? "0" : "") + mins + ":"
                + (((secs / 10) == 0) ? "0" : "") + secs);
        millis++;
        if (timeLabel.getText().equals("01:00")) {
            timerButton.fire();
            TypingField.setEditable(false);
            showResult();
        }
    }

    //method for showing result on the screen
    private void showResult() {
        calculator = new TypingDataCalculator(typedKS,errorCount, 60);

        WPM.setText(Integer.toString(calculator.calculateWPM()));
        Accuracy.setText(String.format("%.1f", calculator.calculateAccuracy()) + "%");
        KeyStrokes.setText(Integer.toString(calculator.getTotalKeyStrokes()));
        CorrectKS.setText(Integer.toString(calculator.getCorrectKeyStrokes()));
        WrongKS.setText(Integer.toString(calculator.getWrongKeyStrokes()));

    }

    @FXML
    void refreshTest(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/TypingSpeedMode.fxml"));
        Scene menuScene = new Scene(root);

        stage = (Stage) scenePane.getScene().getWindow();
        stage.setScene(menuScene);
        stage.show();
    }
}
