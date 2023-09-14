package main.hotel.hotelalura.controller;

import main.hotel.hotelalura.dao.ReservaDAO;
import main.hotel.hotelalura.factory.ConnectionFactory;

import java.sql.Connection;

public class ReservaController {

    private ReservaDAO reservaDAO;

    public ReservaController() {
        try (var factory = new ConnectionFactory()) {
            this.reservaDAO = new ReservaDAO(factory.getConnection());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void guardar() {
        reservaDAO.guardar();
    }

    public void actualizar() {
        reservaDAO.actualizar();
    }

    public void eliminar() {
        reservaDAO.eliminar();
    }

    public void buscar() {
        reservaDAO.buscar();
    }

    public void listar() {
        reservaDAO.listar();
    }


}
