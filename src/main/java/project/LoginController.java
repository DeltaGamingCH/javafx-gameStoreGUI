package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Arrays;

public class LoginController {

    public static boolean loggedIn = false;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    public void initialize() {
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();

            try {
                String credentials = CredentialsUtil.getCredentials();
                System.out.println("Try");

                String[] lines = credentials.split("\n");
                for (String line : lines) {
                    System.out.println("Raw line: " + line);
                    String[] parts = line.split(":");
                    System.out.println("ARRAY: \n" + Arrays.toString(parts) + "\n");
                    System.out.println("Parts length: " + parts.length);
                    if (parts.length == 2) {  // Correct length for email:password
                        String storedEmail = parts[0].trim();
                        String storedPassword = parts[1].trim();

                        System.out.println("Stored Values: " + storedEmail + " " + storedPassword);
                        System.out.println("Entered Values: " + email + " " + password);
                        if (storedEmail.equals(email) && storedPassword.equals(password)) {
                            loggedIn = true;
                            App.setRoot("primary");
                            System.out.println("Email & Password are the same");
                            break;
                        } else {
                            System.out.println("Email or password is incorrect.");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(loggedIn);
            System.out.println(email + password);
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