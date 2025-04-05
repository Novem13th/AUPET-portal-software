package aupet.aupet_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aupet_application.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1600, 900);
        scene.getStylesheets().add(getClass().getResource("application_DARK_stylesheet.css").toExternalForm());
        stage.setTitle("AUPET");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}