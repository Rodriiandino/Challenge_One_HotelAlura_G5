package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.hotel.hotelalura.controller.HuespedeController;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.Validator;
import main.hotel.hotelalura.utils.HostValidator;

import java.net.URL;
import java.util.ResourceBundle;

public class HostController implements Initializable, Validator {

    public TextField input_name;
    public TextField input_lastName;
    public DatePicker input_birth;
    public ChoiceBox<String> input_nationality;
    public TextField input_number;
    public TextField input_booking;
    public Button btn_register;
    public Label text_error;
    public Button btn_back;

    ReservaController reservaController = new ReservaController();
    int id_reserva = reservaController.getLastReservaId();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {
        validateFields();
        addValidators();
        input_booking.setText(String.valueOf(id_reserva));
        input_nationality.getItems().addAll("Argentina", "Brasil", "Chile", "Colombia", "Ecuador", "Perú", "Uruguay", "Venezuela");
        input_nationality.setValue("Argentina");
        btn_register.setOnAction(e -> register());
        btn_back.setOnAction(e -> backToBooking());
    }

    private void register() {
        String name = input_name.getText().toLowerCase();
        String lastName = input_lastName.getText().toLowerCase();
        String birthDay = input_birth.getValue().toString();
        String nationality = input_nationality.getValue();
        String number = input_number.getText();
        int id_reservation = Integer.parseInt(input_booking.getText());

        Huespede huespede = new Huespede(name, lastName, birthDay, nationality, number, id_reservation);

        HuespedeController huespedeController = new HuespedeController();
        huespedeController.save(huespede);

        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_register);
    }

    private void backToBooking() {
        reservaController.delete(id_reserva);
        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/booking-view.fxml", btn_back);
    }

    @Override
    public void validateFields() {
        HostValidator.hostValidator(input_name, input_lastName, input_birth, input_number, text_error, btn_register);
    }

    @Override
    public void addValidators() {
        input_name.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_lastName.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_birth.valueProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_number.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
    }

}
