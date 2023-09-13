package main.hotel.hotelalura;


import javafx.scene.control.Button;
import main.hotel.hotelalura.factory.ConnectionFactory;

import java.sql.SQLException;

public class HotelController {

    public Button btn_in;

    public void initialize() {
        btn_in.setOnAction(event -> {
            System.out.println("Hola mundo");
            try (ConnectionFactory connectionFactory = new ConnectionFactory()) {
                connectionFactory.getConnection();
                System.out.println("Conexión exitosa a la base de datos");
            } catch (Exception e) {
                System.out.println("No se ha podido conectar a la base de datos");
                e.printStackTrace();
            }
            System.out.println("Se ha cerrado la conexión a la base de datos");
        });

    }
}
