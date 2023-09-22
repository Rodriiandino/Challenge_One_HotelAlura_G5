package main.hotel.hotelalura.utils;

import javafx.scene.control.*;

public class BookingValidator {
    public static void bookingValidator(DatePicker inputDateIn, DatePicker inputDateOut, TextField inputValue, ChoiceBox<WayToPay> inputWayToPay, Label textError, Button btnRegister) {
        boolean isDateInValid = inputDateIn.getValue() != null;
        boolean isDateOutValid = inputDateOut.getValue() != null;
        boolean isValueValid = !inputValue.getText().isEmpty() && inputValue.getText().matches("\\d+(\\.\\d+)?");
        boolean isWayToPayValid = inputWayToPay.getValue() != null;

        boolean isDateInAfterDateOut = inputDateIn.getValue() != null && inputDateOut.getValue() != null && inputDateIn.getValue().isAfter(inputDateOut.getValue());

        if (!isDateInValid) textError.setText("Fecha de entrada esta vacía");
        else if (!isDateOutValid) textError.setText("Fecha de salída esta vacía");
        else if (isDateInAfterDateOut) textError.setText("Fecha de entrada no puede ser después de la fecha de salida");
        else if (!isValueValid) textError.setText("Valor inválido (solo números)");
        else if (!isWayToPayValid) textError.setText("Forma de pago inválida");
        else textError.setText("");

        boolean allFieldsValid = isDateInValid && isDateOutValid && isValueValid && isWayToPayValid && !isDateInAfterDateOut;
        btnRegister.setDisable(!allFieldsValid);
    }
}
