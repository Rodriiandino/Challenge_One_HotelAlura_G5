package main.hotel.hotelalura.viewController;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.hotel.hotelalura.controller.UsuarioController;
import main.hotel.hotelalura.modelo.Usuario;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.UserValidator;
import main.hotel.hotelalura.utils.Validator;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


public class LoginController implements Initializable, Validator {

    public Button btn_in;
    public TextField input_user;
    public TextField input_email;
    public PasswordField input_password;

    public Label text_error;


    private UsuarioController usuarioController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {
        validateFields();
        addValidators();

        usuarioController = new UsuarioController();

        btn_in.setOnAction(event -> login());
    }

    private void login() {
        String user = input_user.getText();
        String email = input_email.getText();
        String password = input_password.getText();

        Usuario usuario = new Usuario(user, email, password);

        boolean isUserRegister = usuarioController.login(usuario);

        if (isUserRegister) {
            ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/menu-view.fxml", btn_in);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al iniciar sesión");
            alert.setHeaderText("Usuario no registrado");
            alert.setContentText("Este usuario no está registrado en el sistema");

            alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/main/hotel/hotelalura/delete.css")).toExternalForm());

            alert.showAndWait();
        }
    }


    @Override
    public void validateFields() {
        UserValidator.userLoginValidator(input_user, input_email, input_password, text_error, btn_in);
    }

    @Override
    public void addValidators() {
        List<TextField> textFields = List.of(input_user, input_email, input_password);

        textFields.forEach(textField -> textField.textProperty().addListener((observable, oldValue, newValue) -> validateFields()));
    }
}
