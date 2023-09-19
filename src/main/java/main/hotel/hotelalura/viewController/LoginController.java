package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import main.hotel.hotelalura.controller.HuespedeController;
import javafx.scene.control.Button;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.controller.UsuarioController;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {

    public Button btn_register;

    public Button btn_in;

    private UsuarioController usuarioController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {
        usuarioController = new UsuarioController();

        btn_in.setOnAction(event -> login());

        btn_register.setOnAction(event -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/register-view.fxml", btn_register);
        });
    }

    private void login() {
        usuarioController.login();
    }

}
