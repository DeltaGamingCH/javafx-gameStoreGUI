package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoginController {

    public static boolean loggedIn = false;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorMessage;

    public void initialize() {
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            try {
                String credentials = CredentialsUtil.getCredentials();
                String[] lines = credentials.split("\n");
                for (String line : lines) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        String storedEmail = parts[0].trim();
                        String storedPassword = parts[1].trim();
                        if (storedEmail.equals(email) && storedPassword.equals(password)) {
                            loggedIn = true;
                            App.setRoot("primary");
                            System.out.println("Email & Password are the same");
                            break;
                        } else {
                            System.out.println("Email or password is incorrect.");
                            errorMessage.setVisible(true);
                        }
                    }
                }
            } catch (Exception e) {
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