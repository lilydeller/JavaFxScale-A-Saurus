module scaleasaurus {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;
    requires json.simple;
    requires junit;

    opens controllers to javafx.fxml;
    exports controllers;

}
