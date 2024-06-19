package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import org.json.*;

public class RegisterController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    public void initialize() {
        registerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String email = emailField.getText();
            String password = passwordField.getText();
            try {
                String registerInfo = email + ", " + password;
                System.out.println(registerInfo);

                App.setRoot("login");

                if (registerInfo == null || registerInfo.isEmpty()) {
                    System.out.println("Is Empty");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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