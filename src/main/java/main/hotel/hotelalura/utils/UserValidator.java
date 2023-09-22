package main.hotel.hotelalura.utils;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.hotel.hotelalura.controller.UsuarioController;

import java.util.List;

public class UserValidator {

    public static void userLoginValidator(TextField input_user, TextField input_email, PasswordField input_password, Label text_error, Button btn_in) {
        boolean isGmailValid = !input_email.getText().isEmpty() && input_email.getText().contains("@") && input_email.getText().contains(".com") && input_email.getText().length() > 10;
        boolean isUserValid = !input_user.getText().isEmpty() && input_user.getText().length() > 3 && input_user.getText().length() < 20;
        boolean isPasswordValid = !input_password.getText().isEmpty() && input_password.getText().length() > 3 && input_password.getText().length() < 20;


        if (!isUserValid) text_error.setText("Usuario invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if (!isGmailValid) text_error.setText("Gmail invalido");
        else if (!isPasswordValid)
            text_error.setText("Contraseña invalida (min 3 caracteres, max 20) y no puede estar vacio");
        else text_error.setText("");

        boolean allFieldsValid = isUserValid && isGmailValid && isPasswordValid;

        btn_in.setDisable(!allFieldsValid);
    }

    public static void userRegisterValidator(TextField input_name, TextField input_lastName, TextField input_email, TextField input_user, PasswordField input_password, PasswordField input_repeatPassword, Label text_error, Button btn_register, UsuarioController usuarioController) {
        boolean isNameValid = !input_name.getText().isEmpty() && input_name.getText().length() > 3 && input_name.getText().length() < 20;
        boolean isLastNameValid = !input_lastName.getText().isEmpty();
        boolean isGmailValid = !input_email.getText().isEmpty() && input_email.getText().contains("@") && input_email.getText().contains(".com") && input_email.getText().length() > 10 ;
        boolean isUserValid = !input_user.getText().isEmpty() && input_user.getText().length() > 3 && input_user.getText().length() < 20;
        boolean isPasswordValid = !input_password.getText().isEmpty() && input_password.getText().length() > 3 && input_password.getText().length() < 20;
        boolean isRepeatPasswordValid = !input_repeatPassword.getText().isEmpty() && input_repeatPassword.getText().length() > 3 && input_repeatPassword.getText().length() < 20;
        boolean isRepeatPasswordEqualsPassword = input_repeatPassword.getText().equals(input_password.getText());


        List<String> usuarios = usuarioController.listUsers();
        boolean isUserAlreadyRegistered = usuarios.contains(input_user.getText());

        List<String> emails = usuarioController.listEmails();
        boolean isEmailAlreadyRegistered = emails.contains(input_email.getText());


        if (!isNameValid) text_error.setText("Nombre invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if(!isLastNameValid) text_error.setText("Apellido invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if(!isGmailValid) text_error.setText("Gmail invalido");
        else if(isEmailAlreadyRegistered) text_error.setText("El email ya esta registrado");
        else if(!isUserValid) text_error.setText("Usuario invalido (min 3 caracteres, max 20) y no puede estar vacio");
        else if(isUserAlreadyRegistered) text_error.setText("El usuario ya esta registrado");
        else if(!isPasswordValid) text_error.setText("Contraseña invalida (min 3 caracteres, max 20) y no puede estar vacio");
        else if(!isRepeatPasswordValid) text_error.setText("Repita la contraseña (min 3 caracteres, max 20) y no puede estar vacio");
        else if(!isRepeatPasswordEqualsPassword) text_error.setText("Las contraseñas no coinciden");
        else text_error.setText("");

        boolean allFieldsValid = isNameValid && isLastNameValid && isGmailValid && isUserValid && isPasswordValid && isRepeatPasswordValid && isRepeatPasswordEqualsPassword && !isEmailAlreadyRegistered && !isUserAlreadyRegistered;

        btn_register.setDisable(!allFieldsValid);
    }
}
