package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    public Button btn_back;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpListeners();
    }

    private void setUpListeners() {
        btn_back.setOnAction(event -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/login-view.fxml", btn_back);
        });
    }
}
