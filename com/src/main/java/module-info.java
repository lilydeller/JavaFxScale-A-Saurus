module scaleasaurus {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;
    requires json.simple;

    opens scaleasaurus to javafx.fxml;
    exports scaleasaurus;
}
