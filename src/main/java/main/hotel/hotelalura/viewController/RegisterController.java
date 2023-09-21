package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.hotel.hotelalura.controller.UsuarioController;
import main.hotel.hotelalura.modelo.Usuario;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.validator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterController implements Initializable, validator {

    public Button btn_back;
    public Button btn_register;
    public TextField input_name;
    public TextField input_lastName;
    public TextField input_email;
    public TextField input_user;
    public PasswordField input_password;
    public PasswordField input_repeatPassword;
    public Label text_error;
    private UsuarioController usuarioController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpListeners();
    }

    private void setUpListeners() {

        usuarioController = new UsuarioController();

        validateFields();
        addValidators();
        btn_register.setOnAction(e -> register());

        btn_back.setOnAction(e -> {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/menu-view.fxml", btn_back);
        });
    }

    private void register() {
        String name = input_name.getText().toLowerCase();
        String lastName = input_lastName.getText().toLowerCase();
        String email = input_email.getText().toLowerCase();
        String user = input_user.getText().toLowerCase();
        String password = input_password.getText();

        Usuario usuario = new Usuario(name, lastName, email, user, password);

        usuarioController.save(usuario);

        ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/menu-view.fxml", btn_register);
    }

    @Override
    public void validateFields() {
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

    @Override
    public void addValidators() {
        input_name.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_lastName.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_email.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_user.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_password.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
        input_repeatPassword.textProperty().addListener((observable, oldValue, newValue) -> validateFields());
    }

}
