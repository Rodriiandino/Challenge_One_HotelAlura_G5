package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.hotel.hotelalura.controller.HuespedeController;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.validator;

import java.net.URL;
import java.util.ResourceBundle;

public class hostController implements Initializable, validator {

    public TextField input_name;
    public TextField input_lastName;
    public DatePicker input_birth;
    public ChoiceBox input_nationality;
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
        String nationality = input_nationality.getValue().toString();
        String number = input_number.getText();
        int id_reserva = Integer.parseInt(input_booking.getText());

        Huespede huespede = new Huespede(name, lastName, birthDay, nationality, number, id_reserva);

        HuespedeController huespedeController = new HuespedeController();
        huespedeController.guardar(huespede);

        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_register);
    }

    private void backToBooking() {
        reservaController.eliminar(id_reserva);
        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/booking-view.fxml", btn_back);
    }

    @Override
    public void validateFields() {
        boolean isNameValid = !input_name.getText().isEmpty() && input_name.getText().length() > 3 && input_name.getText().length() < 20;
        boolean isLastNameValid = !input_lastName.getText().isEmpty() && input_lastName.getText().length() > 3 && input_lastName.getText().length() < 20;
        boolean isBirthValid = input_birth.getValue() != null;
        boolean isNumberValid = !input_number.getText().isEmpty() && input_number.getText().matches("[0-9]+");

        if (!isNameValid) text_error.setText("Nombre invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if (!isLastNameValid) text_error.setText("Apellido invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if (!isBirthValid) text_error.setText("La fecha de nacimiento no puede estar vacía");
        else if (!isNumberValid) text_error.setText("El número de teléfono no puede estar vacío y debe ser numérico");
        else text_error.setText("");

        boolean allFieldsValid = isNameValid && isLastNameValid && isBirthValid && isNumberValid;
        btn_register.setDisable(!allFieldsValid);
    }

    @Override
    public void addValidators() {
        input_name.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_lastName.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_birth.valueProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_number.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
    }

}
