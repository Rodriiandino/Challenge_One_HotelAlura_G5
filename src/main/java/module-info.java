module main.hotel.hotelalura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens main.hotel.hotelalura to javafx.fxml;
    exports main.hotel.hotelalura;
}