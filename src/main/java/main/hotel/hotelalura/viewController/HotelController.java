package main.hotel.hotelalura.viewController;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.hotel.hotelalura.controller.HuespedeController;
import javafx.scene.control.Button;
import main.hotel.hotelalura.factory.ConnectionFactory;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;

import java.io.IOException;


public class HotelController {

    public Button btn_register;

    public Button btn_in;

    HuespedeController huespedeController = new HuespedeController();

    public void initialize() {
        btn_in.setOnAction(event -> {
            System.out.println("Hola mundo");
            huespedeController.guardar();
            System.out.println("Se ha cerrado la conexión a la base de datos");
        });

        btn_register.setOnAction(event -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/register-view.fxml", btn_register);
        });
    }

}
