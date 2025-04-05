package aupet.aupet_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ControllerRegistration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RegistrationButton;

    @FXML
    private Button BackToButton;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private ChoiceBox<String> usertypeChoicebox;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private String[] userType = {"Преподователь","Студент"};

    @FXML
    void initialize() {

        usertypeChoicebox.getItems().addAll(userType);

        BackToButton.setOnAction(actionEvent -> {
            BackToButton.getScene().getWindow().hide();

            try {
                // Загружаем FXML файл нового окна
                FXMLLoader loader = new FXMLLoader(getClass().getResource("aupet_application.fxml"));
                Parent root = loader.load();

                // Создаем новое окно (Stage)
                Stage stage = new Stage();
                stage.setTitle("AUPET");
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show(); // Отображаем окно
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        RegistrationButton.setOnAction(actionEvent -> {
            if(!firstname.getText().equals("") &&
                    !lastname.getText().equals("") &&
                    !password.getText().equals("") &&
                    !username.getText().equals("") &&
                    !usertypeChoicebox.equals("")) {
                System.out.println("-------------------------------------------" +
                        "\nПользователь нажал-а на кнопку регистраций." +
                        "\nДанные пользователя:" +
                        "\n\tИмя: "+ firstname.getText().trim() +
                        "\n\tФамилия: "+ lastname.getText().trim() +
                        "\n\tЛогин: "+ username.getText().trim() +
                        "\n\tПароль: "+ password.getText().trim() +
                        "\n\tТип пользователя: "+ usertypeChoicebox.getValue());

                signUpNewUser();

                RegistrationButton.getScene().getWindow().hide();

                try {
                    // Загружаем FXML файл нового окна
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("aupet_application.fxml"));
                    Parent root = loader.load();

                    // Связка первого и второго контроллера для передачи инфы об имени пользователя

                    // Создаем новое окно (Stage)
                    Stage stage = new Stage();
                    stage.setTitle("AUPET");
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.show(); // Отображаем окно
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else System.out.println(ANSI_RED + "ERROR: The fields are empty, there is no data to authorize!" + ANSI_RESET);
        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String userfirstname = firstname.getText().trim();
        String userlastname = lastname.getText().trim();
        String userpassword = password.getText().trim();
        String userlogin = username.getText().trim();
        String usertype = usertypeChoicebox.getValue();

        User user = new User(userfirstname,userlastname,userlogin,userpassword,usertype);


        dbHandler.signUpUser(user);

    }

}
