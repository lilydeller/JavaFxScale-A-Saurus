module scaleasaurus {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;
    requires json.simple;
    requires junit;

    opens scaleasaurus to javafx.fxml;
    exports scaleasaurus;

}
