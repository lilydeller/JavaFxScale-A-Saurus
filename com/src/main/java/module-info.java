module scaleasaurus {
    requires javafx.controls;
    requires javafx.fxml;

    opens scaleasaurus to javafx.fxml;
    exports scaleasaurus;
}
