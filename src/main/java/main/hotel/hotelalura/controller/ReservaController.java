package main.hotel.hotelalura.controller;

import main.hotel.hotelalura.dao.ReservaDAO;
import main.hotel.hotelalura.factory.ConnectionFactory;
import main.hotel.hotelalura.modelo.Reserva;

import java.util.List;

public class ReservaController {

    private final ReservaDAO reservaDAO;

    public ReservaController() {
        var factory = new ConnectionFactory();
        this.reservaDAO = new ReservaDAO(factory.getConnection());
    }

    public void guardar(Reserva reserva) {
        reservaDAO.guardar(reserva);
    }

    public void actualizar() {
        reservaDAO.actualizar();
    }

    public void eliminar(long id) {
        reservaDAO.eliminar(id);
    }

    public void buscar() {
        reservaDAO.buscar();
    }

    public List<Reserva> listar() {
        return reservaDAO.listar();
    }

    public int getLastReservaId() {
        return reservaDAO.getLastReservaId();
    }

}
