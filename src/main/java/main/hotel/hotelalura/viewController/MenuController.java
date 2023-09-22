package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Button btn_booking;
    public Button btn_infoTable;
    public Button btn_exit;
    public Button btn_addUser;
    public Label text_day;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {

        text_day.setText("Hoy es: " + getDay());

        btn_booking.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/booking-view.fxml", btn_booking);
        });
        btn_infoTable.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_infoTable);
        });

        btn_addUser.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/register-view.fxml", btn_addUser);
        });

        btn_exit.setOnAction(e -> {
            singOff();
        });
    }


    private void singOff() {
        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/login-view.fxml", btn_exit);
    }

    private String getDay() {
        return java.time.LocalDate.now().toString();
    }
}
