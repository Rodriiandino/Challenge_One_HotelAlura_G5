package main.hotel.hotelalura.utils;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HostValidator {
    public static void hostValidator(TextField inputName, TextField inputLastName, DatePicker inputBirth, TextField inputNumber, Label textError, Button btnRegister) {
        boolean isNameValid = !inputName.getText().isEmpty() && inputName.getText().length() > 3 && inputName.getText().length() < 20;
        boolean isLastNameValid = !inputLastName.getText().isEmpty() && inputLastName.getText().length() > 3 && inputLastName.getText().length() < 20;
        boolean isBirthValid = inputBirth.getValue() != null;
        boolean isNumberValid = !inputNumber.getText().isEmpty() && inputNumber.getText().matches("[0-9]+");

        if (!isNameValid) textError.setText("Nombre invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if (!isLastNameValid)
            textError.setText("Apellido invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if (!isBirthValid) textError.setText("La fecha de nacimiento no puede estar vacía");
        else if (!isNumberValid) textError.setText("El número de teléfono no puede estar vacío y debe ser numérico");
        else textError.setText("");

        boolean allFieldsValid = isNameValid && isLastNameValid && isBirthValid && isNumberValid;
        btnRegister.setDisable(!allFieldsValid);
    }
}
