package main.hotel.hotelalura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    private final Connection connection;

    public ConnectionFactory() {
        String url = "jdbc:mysql://localhost:3306/hotelDB?useTimezone=true&serverTimezone=UTC";
        String usuario = "hotelDB";
        String password = "hotelDB123456";

        try {
            connection = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}