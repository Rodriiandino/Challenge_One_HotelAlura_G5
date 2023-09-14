package main.hotel.hotelalura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    private final Connection conexion;

    public ConnectionFactory() {
        String url = "jdbc:mysql://localhost:3306/hotelDB?useTimezone=true&serverTimezone=UTC";
        String usuario = "hotelDB";
        String password = "hotelDB123456";

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para obtener la conexion
    public Connection getConnection() {
        return conexion;
    }

    @Override
    public void close() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}