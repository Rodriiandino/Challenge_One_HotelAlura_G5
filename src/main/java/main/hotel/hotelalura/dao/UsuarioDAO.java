package main.hotel.hotelalura.dao;

import main.hotel.hotelalura.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void login() {
        System.out.println("Iniciando sesión...");
    }

    public void guardar(Usuario usuario) {
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO usuarios "
                        + "(nombre, apellido, email, nombre_usuario, password)"
                        + "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            try (statement) {
                statement.setString(1, usuario.getNombre());
                statement.setString(2, usuario.getApellido());
                statement.setString(3, usuario.getEmail());
                statement.setString(4, usuario.getNombre_usuario());
                statement.setString(5, usuario.getPassword());

                statement.execute();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    while (resultSet.next()) {
                        usuario.setId(resultSet.getInt(1));
                        System.out.printf("Fue insertado el usuario: %s%n", usuario);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminar() {
        System.out.println("Eliminando usuario...");
    }

    public void actualizar() {
        System.out.println("Actualizando usuario...");
    }

    public List<String> listarEmails() {
        List<String> emails = new  ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT email FROM usuarios")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    emails.add(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emails;
    }
}
