package main.hotel.hotelalura.viewController;

import main.hotel.hotelalura.controller.HuespedeController;
import javafx.scene.control.Button;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.modelo.Reserva;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;



public class HotelController {

    public Button btn_register;

    public Button btn_in;

    HuespedeController huespedeController = new HuespedeController();
    ReservaController reservaController = new ReservaController();


    public void initialize() {
        btn_in.setOnAction(event -> {
            Reserva reserva = new Reserva("2021-10-10", "2021-10-20", 1000.0, "Efectivo");
            reservaController.guardar(reserva);
            int id_reserva = reserva.getId();
            huespedeController.guardar(new Huespede("Juan", "Perez", "2003-2-2", "Argentina", "3216326584", id_reserva));
            System.out.println("Reserva guardada");
        });

        btn_register.setOnAction(event -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/register-view.fxml", btn_register);
        });
    }

}
