package main.hotel.hotelalura.viewController;

import javafx.scene.control.Button;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

public class MenuController {
    public Button btn_booking;
    public Button btn_infoTable;

    public void initialize() {
        btn_booking.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/booking-view.fxml", btn_booking);
        });
        btn_infoTable.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_infoTable);
        });
    }
}
