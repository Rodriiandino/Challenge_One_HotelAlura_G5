package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Button btn_booking;
    public Button btn_infoTable;
    public Button btn_exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {
        btn_booking.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/booking-view.fxml", btn_booking);
        });
        btn_infoTable.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_infoTable);
        });

        btn_exit.setOnAction(e -> {
            singOff();
        });
    }


    public void singOff() {
        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/login-view.fxml", btn_exit);
    }


}
