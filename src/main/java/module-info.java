module main.hotel.hotelalura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens main.hotel.hotelalura.modelo to javafx.base;
    opens main.hotel.hotelalura to javafx.fxml;
    exports main.hotel.hotelalura;
    exports main.hotel.hotelalura.modelo;
    exports main.hotel.hotelalura.viewController;
    opens main.hotel.hotelalura.viewController to javafx.fxml;
}