package project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class GameViewController {

    @FXML
    private void returnPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
}
