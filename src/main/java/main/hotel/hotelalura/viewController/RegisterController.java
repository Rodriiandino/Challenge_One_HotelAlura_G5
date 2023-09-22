package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.hotel.hotelalura.controller.UsuarioController;
import main.hotel.hotelalura.modelo.Usuario;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.UserValidator;
import main.hotel.hotelalura.utils.Validator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterController implements Initializable, Validator {

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
        UserValidator.userRegisterValidator(input_name, input_lastName, input_email, input_user, input_password, input_repeatPassword, text_error, btn_register, usuarioController);
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
