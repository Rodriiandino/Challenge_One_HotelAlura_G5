package main.hotel.hotelalura.dao;

import main.hotel.hotelalura.modelo.Usuario;

import java.sql.*;

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
                        + "(nombre_usuario, nombre, apellido, email, password)"
                        + "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            try (statement) {
                statement.setString(1, "nombre_usuario");
                statement.setString(2, "nombre");
                statement.setString(3, "apellido");
                statement.setString(4, "email");
                statement.setString(5, "password");

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
}
