package main.hotel.hotelalura.dao;

import main.hotel.hotelalura.modelo.Huespede;

import java.sql.*;

public class HuespedeDAO {

    Connection connection;

    public HuespedeDAO(Connection connection) {
        this.connection = connection;
    }


    public void guardar(Huespede huespede) {
        try (PreparedStatement statement = connection.prepareStatement(
    "INSERT INTO HUESPEDES"
            + "(nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)"
                + "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            try (statement) {
                statement.setString(1, huespede.getNombre());
                statement.setString(2, huespede.getApellido());
                statement.setString(3, huespede.getFecha_nacimiento());
                statement.setString(4, huespede.getNacionalidad());
                statement.setString(5, huespede.getTelefono());
                statement.setInt(6, huespede.getId_reserva());

                statement.execute();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        huespede.setId(resultSet.getInt(1));
                        System.out.printf("Fue insertado el huespede: %s%n", huespede);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Guardando huespede...");
    }

    public void actualizar() {
        System.out.println("Actualizando huespede...");
    }

    public void eliminar() {
        System.out.println("Eliminando huespede...");
    }

    public void buscar() {
        System.out.println("Buscando huespede...");
    }

    public void listar() {
        System.out.println("Listando huespedes...");
    }
}
