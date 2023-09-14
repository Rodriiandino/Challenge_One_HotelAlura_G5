package main.hotel.hotelalura.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreenTransitionUtil {

    public static void changeScreen(Object currentController, String fxmlLocation, Button triggerButton) {
        FXMLLoader loader = new FXMLLoader(currentController.getClass().getResource(fxmlLocation));
        Parent root;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) triggerButton.getScene().getWindow();
        stage.setScene(scene);
    }
}
