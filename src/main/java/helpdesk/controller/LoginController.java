package helpdesk.controller;

import helpdesk.utils.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    Button login_button;
    @FXML
    Button button_register;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label login_error;

    public void onLoginButtonClick(ActionEvent actionEvent) {
        // Aprašomas mygtuko paspaudimas
        // Aprašomi veiksmai, kurie bus atlikti paspaudus mygtuką
        // Atliekama vartotojo įvestų duomenų validacija
        if (Validation.isValidUsername(username.getText()) && Validation.isValidPassword(password.getText())) {
            // Jei gerai įvesti duomenys reikės pereiti iš login ekrano į pagrindinį langą
            goToDashboard(actionEvent);
        } else {
            login_error.setText("Wrong username or password");
        }
    }

    public void onRegisterButtonClick(ActionEvent actionEvent) {
        // Mes esame kontrolerio aplanke, bet vaizdo čia nėra, todėl mes turime pakilti vienu aplanku į viršų (../)
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/register.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene((root), 550, 450));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToDashboard(ActionEvent actionEvent) {
        // Mes esame kontrolerio aplanke, bet vaizdo čia nėra, todėl mes turime pakilti vienu aplanku į viršų (../)
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/dashboard.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 800, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
