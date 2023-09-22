package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.modelo.Reserva;
import main.hotel.hotelalura.utils.BookingValidator;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.WayToPay;
import main.hotel.hotelalura.utils.Validator;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class EditBookingController implements Initializable, Validator {
    public Label text_id;
    public DatePicker input_dateIn;
    public DatePicker input_dateOut;
    public TextField input_value;
    public ChoiceBox<WayToPay> input_wayToPay;
    public Button btn_register;

    public Button btn_back;
    public Label text_error;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {
        validateFields();
        addValidators();

        input_dateIn.setDayCellFactory(getDayCellFactory());
        input_dateOut.setDayCellFactory(getDayCellFactory());

        btn_register.setOnAction(e -> updateBooking());
        btn_back.setOnAction(e -> ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_back));
    }

    public void initData(Reserva selectedReserva) {
        Integer id = selectedReserva.getId();
        String dateIn = selectedReserva.getFecha_entrada();
        String dateOut = selectedReserva.getFecha_salida();
        Double value = selectedReserva.getValor();
        String wayToPay = selectedReserva.getForma_pago();

        text_id.setText(String.valueOf(id));
        input_dateIn.setValue(LocalDate.parse(dateIn));
        input_dateOut.setValue(LocalDate.parse(dateOut));
        input_value.setText(String.valueOf(value));


        List<WayToPay> wayToPayList = Arrays.asList(WayToPay.values());
        input_wayToPay.getItems().addAll(wayToPayList);
        wayToPayList.forEach(way -> {
            if (way.toString().equals(wayToPay)) {
                input_wayToPay.setValue(way);
            }
        });
    }

    private void updateBooking() {
        Integer id = Integer.valueOf(text_id.getText());
        String dateIn = input_dateIn.getValue().toString();
        String dateOut = input_dateOut.getValue().toString();
        Double value = Double.valueOf(input_value.getText());
        String wayToPay = input_wayToPay.getValue().toString();

        Reserva reserva = new Reserva(id, dateIn, dateOut, value, wayToPay);

        ReservaController reservaController = new ReservaController();

        reservaController.update(reserva);

        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_register);
    }

    @Override
    public void validateFields() {
        BookingValidator.bookingValidator(input_dateIn, input_dateOut, input_value, input_wayToPay, text_error, btn_register);
    }

    @Override
    public void addValidators() {
        input_dateIn.valueProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_dateOut.valueProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_value.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_wayToPay.valueProperty().addListener((observable, oldValue, newValue) -> validateFields());
    }

    private Callback<DatePicker, DateCell> getDayCellFactory() {
        return datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (item.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setStyle("-fx-background-color: #ffc0cb;");
                }
            }
        };

    }
}
