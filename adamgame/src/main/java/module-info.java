module com.adamgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.adamgame to javafx.fxml;
    exports com.adamgame;
}
