package main.hotel.hotelalura.viewController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

import java.io.IOException;

public class RegisterController {

    public Button btn_back;

    public void initialize() {
        btn_back.setOnAction(event -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/main-view.fxml", btn_back);
        });
    }
}
