package main.hotel.hotelalura.dao;

import main.hotel.hotelalura.modelo.Huespede;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HuespedeDAO {

    Connection connection;

    public HuespedeDAO(Connection connection) {
        this.connection = connection;
    }


    public void save(Huespede huespede) {
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
    }

    public void update(Huespede huespede) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE HUESPEDES SET nombre = ?, apellido = ?, fecha_nacimiento = ?, nacionalidad = ?, telefono = ? WHERE id = ?")) {
            try (statement) {
                statement.setString(1, huespede.getNombre());
                statement.setString(2, huespede.getApellido());
                statement.setString(3, huespede.getFecha_nacimiento());
                statement.setString(4, huespede.getNacionalidad());
                statement.setString(5, huespede.getTelefono());
                statement.setInt(6, huespede.getId());
                statement.execute();
                System.out.printf("Fue actualizado el huespede: %s%n", huespede);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM HUESPEDES WHERE id = ?")) {
            try (statement) {
                statement.setLong(1, id);
                statement.execute();
                System.out.printf("Fue eliminado el huespede con id: %d%n", id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huespede> search(String lastName) {
        List<Huespede> huespedes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM HUESPEDES WHERE apellido LIKE ?")) {
            try (statement) {
                statement.setString(1, lastName + "%");
                statement.execute();
                try (ResultSet resultSet = statement.getResultSet()) {
                    while (resultSet.next()) {
                        huespedes.add(new Huespede(
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("apellido"),
                                resultSet.getString("fecha_nacimiento"),
                                resultSet.getString("nacionalidad"),
                                resultSet.getString("telefono"),
                                resultSet.getInt("id_reserva")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return huespedes;
    }

    public List<Huespede> list() {
        List<Huespede> huespedes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM huespedes")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    huespedes.add(new Huespede(
                            resultSet.getInt("id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido"),
                            resultSet.getString("fecha_nacimiento"),
                            resultSet.getString("nacionalidad"),
                            resultSet.getString("telefono"),
                            resultSet.getInt("id_reserva")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return huespedes;
    }
}
