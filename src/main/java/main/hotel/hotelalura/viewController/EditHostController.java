package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.hotel.hotelalura.controller.HuespedeController;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.Validator;
import main.hotel.hotelalura.utils.HostValidator;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditHostController implements Initializable, Validator {
    public Label text_id;
    public TextField input_name;
    public TextField input_lastName;
    public DatePicker input_birth;
    public ChoiceBox<String> input_nationality;
    public TextField input_number;
    public TextField input_booking;
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
        btn_register.setOnAction(e -> updateHost());
        btn_back.setOnAction(e -> ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_back));
    }

    public void initData(Huespede selectedHuespede) {
        Integer id = selectedHuespede.getId();
        String name = selectedHuespede.getNombre();
        String lastName = selectedHuespede.getApellido();
        String birthDay = selectedHuespede.getFecha_nacimiento();
        String nationality = selectedHuespede.getNacionalidad();
        String number = selectedHuespede.getTelefono();
        Integer id_reservation = selectedHuespede.getId_reserva();

        text_id.setText(String.valueOf(id));
        input_name.setText(name);
        input_lastName.setText(lastName);
        input_birth.setValue(LocalDate.parse(birthDay));
        input_nationality.getItems().addAll("Argentina", "Brasil", "Chile", "Colombia", "Ecuador", "Perú", "Uruguay", "Venezuela");
        input_nationality.setValue(nationality);
        input_number.setText(number);
        input_booking.setText(String.valueOf(id_reservation));
    }
    
    private void updateHost() {
        Integer id = Integer.parseInt(text_id.getText());
        String name = input_name.getText();
        String lastName = input_lastName.getText();
        String birthDay = input_birth.getValue().toString();
        String nationality = input_nationality.getValue();
        String number = input_number.getText();

        Huespede huespede = new Huespede(id, name, lastName, birthDay, nationality, number);

        HuespedeController huespedeController = new HuespedeController();
        huespedeController.update(huespede);
        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/infoTable-view.fxml", btn_register);
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
