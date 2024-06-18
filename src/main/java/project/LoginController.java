package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController {

    public static boolean loggedIn = false;

    public static boolean loggedIn() {
        return loggedIn;
    }

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink toLogin;

    @FXML
    private Hyperlink toRegister;

    @FXML
    private Button returnPrimary;

    @FXML
    public void initialize() {
        // Add click event handler to login button
        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            // Handle login logic here
            String email = emailField.getText();
            String password = passwordField.getText();
            try {
                String content = JsonUtil.readFileAsString("/project/users.json");
                System.out.println("JSON content: " + content);
                loggedIn = true;
                App.setRoot("primary");
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
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