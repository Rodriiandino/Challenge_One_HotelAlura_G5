package main.hotel.hotelalura.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.modelo.Reserva;
import main.hotel.hotelalura.viewController.EditBookingController;
import main.hotel.hotelalura.viewController.EditHostController;

import java.io.IOException;

public class ScreenTransitionUtil {

    public static void changeScreen(Object currentController, String fxmlLocation, Button triggerButton) {
        FXMLLoader loader = new FXMLLoader(currentController.getClass().getResource(fxmlLocation));
        Parent root;

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) triggerButton.getScene().getWindow();
        stage.setScene(scene);
    }

    public static void showScreenEditHost(Object currentController, String fxmlLocation, Huespede selectedHuespede, Button triggerButton) {
        try {
            FXMLLoader loader = new FXMLLoader(currentController.getClass().getResource(fxmlLocation));
            Parent root = loader.load();

            EditHostController editHostController = loader.getController();

            editHostController.initData(selectedHuespede);

            Scene scene = new Scene(root);
            Stage stage = (Stage) triggerButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showScreenEditBooking(Object currentController, String fxmlLocation, Reserva selectedReserva, Button triggerButton) {
        try {
            FXMLLoader loader = new FXMLLoader(currentController.getClass().getResource(fxmlLocation));
            Parent root = loader.load();

            EditBookingController editBookingController = loader.getController();

            editBookingController.initData(selectedReserva);

            Scene scene = new Scene(root);
            Stage stage = (Stage) triggerButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
