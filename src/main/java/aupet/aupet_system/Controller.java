package aupet.aupet_system;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AdditionalyText;

    @FXML
    private AnchorPane BgAnchorPane;

    @FXML
    private Circle BgCircle1;

    @FXML
    private Circle BgCircle2;

    @FXML
    private Circle CircleBig;

    @FXML
    private Circle CircleLittle1;

    @FXML
    private Circle CircleLittle2;

    @FXML
    private Label InfoText;

    @FXML
    private Line LineLeft;

    @FXML
    private Line LineRight;

    @FXML
    private AnchorPane LoginAnchor;

    @FXML
    private Button LoginButton;

    @FXML
    private Label LoginText;

    @FXML
    private TextField LoginTextField;

    @FXML
    private Label PassText;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button RegistrationButton;

    @FXML
    private Label UpperLabel;

    @FXML
    private ImageView aupetlogo;

    @FXML
    private Button LightThemeButton;

    @FXML
    private Button DarkThemeButton;

    @FXML
    private Label WrongPasswordLoginText;


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    @FXML
    void initialize() {
        WrongPasswordLoginText.setVisible(false);
        LoginButton.setOnAction(actionEvent -> {

            String loginUsername = LoginTextField.getText().trim();
            String loginPassword = PasswordField.getText().trim();

            if(!LoginTextField.getText().equals("") && !PasswordField.getText().equals("")) {
                loginUser(loginUsername, loginPassword);

                System.out.println("-------------------------------------------" +
                        "\nПользователь нажал-а на кнопку войти." +
                        "\n\tИмя пользователя: " + loginUsername +
                        "\n\tПароль: "+ loginPassword);

                LoginButton.getScene().getWindow().hide();

                try {
                    // Загружаем FXML файл нового окна
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("aupet_menu.fxml"));
                    Parent root = loader.load();

                    // Связка первого и второго контроллера для передачи инфы об имени пользователя
                    ControllerAupetMenu controllerAupetMenu = loader.getController();
                    controllerAupetMenu.displayName(loginUsername);

                    // Создаем новое окно (Stage)
                    Stage stage = new Stage();
                    stage.setTitle("AUPET");
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.show(); // Отображаем окно
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                WrongPasswordLoginText.setVisible(true);
                System.out.println(ANSI_RED + "ERROR: Incorrect login and password data!" + ANSI_RESET);
            }
        });

        RegistrationButton.setOnAction(actionEvent -> {

            System.out.println("Пользователь нажал-а на кнопку регистраций.");

            RegistrationButton.getScene().getWindow().hide();

            try {
                // Загружаем FXML файл нового окна
                FXMLLoader loader = new FXMLLoader(getClass().getResource("aupet_registration.fxml"));
                Parent root = loader.load();

                // Связка первого и второго контроллера для передачи инфы об имени пользователя

                // Создаем новое окно (Stage)
                Stage stage = new Stage();
                root.getStylesheets().add(getClass().getResource("registration_DARK_stylesheet.css").toExternalForm());
                stage.setTitle("AUPET");
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show(); // Отображаем окно
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

    private void loginUser(String loginUsername, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginUsername);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while(true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        if(counter >= 1){
            System.out.println(ANSI_GREEN + "Пользователь найден в базе данных. Авторизация прошла успешно!"+ ANSI_RESET);
        }
    }

}
