package helpdesk.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    @FXML
    Button return_button;
    // Jei nerodo ikonėlių prie FXML elementų patikrinti ar FXML'e yra nurodytas kontroleris

    /**
     * Funkcija grąžinantį vartotoją į login langą
     */
    public void goToLogin(ActionEvent actionEvent) {
        try {
            // Sukuriamas dashboard langas
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 550, 450));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
