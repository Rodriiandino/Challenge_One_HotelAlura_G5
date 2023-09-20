package main.hotel.hotelalura.controller;

import main.hotel.hotelalura.dao.UsuarioDAO;
import main.hotel.hotelalura.factory.ConnectionFactory;
import main.hotel.hotelalura.modelo.Usuario;

import java.util.List;

public class UsuarioController {

    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        var factory = new ConnectionFactory();
        this.usuarioDAO = new UsuarioDAO(factory.getConnection());
    }

    public void login() {
        usuarioDAO.login();
    }

    public void guardar(Usuario usuario) {
        usuarioDAO.guardar(usuario);
    }

    public void eliminar() {
        usuarioDAO.eliminar();
    }

    public void actualizar() {
        usuarioDAO.actualizar();
    }

    public List<String> listarEmails() {
        return usuarioDAO.listarEmails();
    }
}
