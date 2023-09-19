package main.hotel.hotelalura.dao;

import main.hotel.hotelalura.modelo.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Reserva reserva) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO RESERVAS "
                        + "(fecha_entrada, fecha_salida, valor, forma_pago) "
                        + "VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            try (statement) {
                statement.setString(1, reserva.getFecha_entrada());
                statement.setString(2, reserva.getFecha_salida());
                statement.setDouble(3, reserva.getValor());
                statement.setString(4, reserva.getForma_pago());

                statement.execute();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        reserva.setId(resultSet.getInt(1));
                        System.out.printf("Fue insertada la reserva: %s%n", reserva);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar() {
        System.out.println("Actualizando reserva...");
    }

    public void eliminar(long id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM RESERVAS WHERE id = ?")) {
            
            try (statement) {
                statement.setLong(1, id);
                statement.execute();
                System.out.printf("Fue eliminada la reserva con id: %d%n", id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buscar() {
        System.out.println("Buscando reserva...");
    }

    public List<Reserva> listar() {
        List<Reserva> reservas = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM reservas")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    reservas.add(new Reserva(
                            resultSet.getInt("id"),
                            resultSet.getString("fecha_entrada"),
                            resultSet.getString("fecha_salida"),
                            resultSet.getDouble("valor"),
                            resultSet.getString("forma_pago")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservas;
    }


    public int getLastReservaId() {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT MAX(id) FROM RESERVAS")) {

            try (statement) {
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                return resultSet.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
