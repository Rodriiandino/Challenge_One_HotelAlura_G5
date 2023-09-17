package main.hotel.hotelalura.controller;

import main.hotel.hotelalura.dao.HuespedeDAO;
import main.hotel.hotelalura.factory.ConnectionFactory;
import main.hotel.hotelalura.modelo.Huespede;

import java.util.List;

public class HuespedeController {

        private final HuespedeDAO huespedeDAO;

        public HuespedeController() {
            var factory = new ConnectionFactory();
            this.huespedeDAO = new HuespedeDAO(factory.getConnection());
        }

        public void guardar(Huespede huespede) {
            huespedeDAO.guardar(huespede);
        }

        public void actualizar() {
            huespedeDAO.actualizar();
        }

        public void eliminar() {
            huespedeDAO.eliminar();
        }

        public void buscar() {
            huespedeDAO.buscar();
        }

        public List<Huespede> listar() {
            return huespedeDAO.listar();
        }
}
