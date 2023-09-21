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

    public void save(Usuario usuario) {
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

    public List<String> listEmails() {
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

    public List<String> listUsers() {
        List<String> usuarios = new  ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT nombre_usuario FROM usuarios")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    usuarios.add(resultSet.getString("nombre_usuario"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }
}
