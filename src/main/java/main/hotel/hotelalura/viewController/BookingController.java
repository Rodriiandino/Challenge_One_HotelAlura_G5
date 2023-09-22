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

public class BookingController implements Initializable, Validator {

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

        List<WayToPay> wayToPayList = Arrays.asList(WayToPay.values());
        input_wayToPay.getItems().addAll(wayToPayList);
        input_wayToPay.setValue(WayToPay.CREDIT_CARD);

        btn_register.setOnAction(e -> register());
        btn_back.setOnAction(e -> ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/menu-view.fxml", btn_back));
    }

    private void register() {
        String dateIn = input_dateIn.getValue().toString();
        String dateOut = input_dateOut.getValue().toString();
        String value = input_value.getText();
        String wayToPay = input_wayToPay.getValue().toString();

        Reserva reserva = new Reserva(dateIn, dateOut, Double.valueOf(value), wayToPay);

        ReservaController reservaController = new ReservaController();
        reservaController.save(reserva);

        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/host-view.fxml", btn_register);
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
