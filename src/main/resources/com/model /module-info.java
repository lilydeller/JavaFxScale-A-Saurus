module com.scaleasaurus {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens com.scaleasaurus to javafx.fxml;
    exports com.scaleasaurus;

    opens model to javafx.fxml;
    exports model;
}
