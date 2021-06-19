package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/loginScreen.fxml"));

        primaryStage.getIcons().add(new Image("icons/atom.png"));
        primaryStage.setTitle("Atomic Type");

        primaryStage.setWidth(1100);
        primaryStage.setHeight(650);
        //primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setResizable(false);

        Scene loginScene = new Scene(root);

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
