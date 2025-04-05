package aupet.aupet_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ControllerAupetMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar progressbar1;

    @FXML
    private ProgressBar progressbar2;

    @FXML
    private ProgressBar progressbar3;

    @FXML
    private ProgressBar progressbar4;

    @FXML
    private ProgressBar progressbar5;

    @FXML
    private ProgressBar progressbar6;

    @FXML
    public Label usernameLabel;

    public void displayName(String username) {
        usernameLabel.setText("Пользователь: " + username);
    }


    @FXML
    void initialize() {

        progressbar1.setStyle(
                "-fx-accent: #7030A0;" +
                        "-fx-control-inner-background: #141414;" + // Background transparency
                        "-fx-border-color: transparent;" + // Border color
                        "-fx-border-radius: 10;" + // Rounded corners for the border
                        "-fx-background-radius: 10;" // Rounded corners for the background
        );

        progressbar2.setStyle(
                "-fx-accent: #7030A0;" +
                        "-fx-control-inner-background: #141414;" + // Background transparency
                        "-fx-border-color: transparent;" + // Border color
                        "-fx-border-radius: 10;" + // Rounded corners for the border
                        "-fx-background-radius: 10;" // Rounded corners for the background
        );

        progressbar3.setStyle(
                "-fx-accent: #7030A0;" +
                        "-fx-control-inner-background: #141414;" + // Background transparency
                        "-fx-border-color: transparent;" + // Border color
                        "-fx-border-radius: 10;" + // Rounded corners for the border
                        "-fx-background-radius: 10;" // Rounded corners for the background
        );

        progressbar4.setStyle(
                "-fx-accent: #7030A0;" +
                        "-fx-control-inner-background: #141414;" + // Background transparency
                        "-fx-border-color: transparent;" + // Border color
                        "-fx-border-radius: 10;" + // Rounded corners for the border
                        "-fx-background-radius: 10;" // Rounded corners for the background
        );

        progressbar5.setStyle(
                "-fx-accent: #7030A0;" +
                        "-fx-control-inner-background: #141414;" + // Background transparency
                        "-fx-border-color: transparent;" + // Border color
                        "-fx-border-radius: 10;" + // Rounded corners for the border
                        "-fx-background-radius: 10;" // Rounded corners for the background
        );

        progressbar6.setStyle(
                "-fx-accent: #7030A0;" +
                        "-fx-control-inner-background: #141414;" + // Background transparency
                        "-fx-border-color: transparent;" + // Border color
                        "-fx-border-radius: 10;" + // Rounded corners for the border
                        "-fx-background-radius: 10;" // Rounded corners for the background
        );

    }



}
