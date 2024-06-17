package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class InitialController {

    @FXML
    private ImageView imageView;

    @FXML
    public void initialize() {
        // Add click event handler to switch scenes
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            try {
                App.setRoot("gameView");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private Button login;

    @FXML
    private void login(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    /*public ImageView getImageView() {
        return imageView;
    }*/
}
