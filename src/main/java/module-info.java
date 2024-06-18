module project {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens project to javafx.fxml;
    exports project;
}
