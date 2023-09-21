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

    public void save(Reserva reserva) {
        reservaDAO.save(reserva);
    }

    public void update() {
        reservaDAO.update();
    }

    public void delete(Integer id) {
        reservaDAO.delete(id);
    }

    public void search() {
        reservaDAO.search();
    }

    public List<Reserva> list() {
        return reservaDAO.list();
    }

    public int getLastReservaId() {
        return reservaDAO.getLastReservaId();
    }

    public boolean reservationHasHost(Integer id) {
        return reservaDAO.reservationHasHost(id);
    }

}
