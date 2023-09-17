package main.hotel.hotelalura.dao;

import main.hotel.hotelalura.modelo.Reserva;

import java.sql.*;

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

    public void eliminar() {
        System.out.println("Eliminando reserva...");
    }

    public void buscar() {
        System.out.println("Buscando reserva...");
    }

    public void listar() {
        System.out.println("Listando reservas...");
    }
}
