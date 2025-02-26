module com.scaleasaurus {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.scaleasaurus to javafx.fxml;
    exports com.scaleasaurus;
}
