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

        public void save(Huespede huespede) {
            huespedeDAO.save(huespede);
        }

        public void update() {
            huespedeDAO.update();
        }

        public void delete(Integer id) {
            huespedeDAO.delete(id);
        }

        public void search() {
            huespedeDAO.search();
        }

        public List<Huespede> list() {
            return huespedeDAO.list();
        }
}
