package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class LoginController {

    private boolean isLoggedIn = false;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

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
                App.setRoot("primary");
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
        });
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    @FXML
    private void returnPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}