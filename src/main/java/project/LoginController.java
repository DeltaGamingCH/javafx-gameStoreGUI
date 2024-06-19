package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import org.json.*;

public class LoginController {

    public static boolean loggedIn = false;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    public void initialize() {
        System.out.println();
    }

    @FXML
    private void returnPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void toLogin(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
    private void toRegister(ActionEvent event) throws IOException {
        App.setRoot("register");
    }
}