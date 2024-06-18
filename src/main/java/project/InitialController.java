package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class InitialController {

    @FXML
    private ImageView imageViewGame1;

    @FXML
    private ImageView imageViewGame2;

    @FXML
    private Button viewGameButton;

    @FXML
    private Button loginButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
        imageViewGame1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                App.setRoot("gameView");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        imageViewGame2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                App.setRoot("gameView");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        viewGameButton.setOnAction(event -> {
            try {
                App.setRoot("gameView");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        updateButtonVisibility();

        loginButton.setOnAction(event -> {
            try {
                App.setRoot("login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Add click event handler to logout
        logoutButton.setOnAction(event -> {
            LoginController.loggedIn = false;
            updateButtonVisibility();
        });
    }

    @FXML
    private Button login;

    @FXML
    private void login(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    private void updateButtonVisibility() {
        if (LoginController.loggedIn) {
            loginButton.setVisible(false);
            logoutButton.setVisible(true);
            System.out.println("Updated login status: " + LoginController.loggedIn);
        } else {
            loginButton.setVisible(true);
            logoutButton.setVisible(false);
            System.out.println("Updated login status: " + LoginController.loggedIn);
        }
    }
}
