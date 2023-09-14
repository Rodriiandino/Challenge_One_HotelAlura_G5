package main.hotel.hotelalura.controller;

import main.hotel.hotelalura.dao.HuespedeDAO;
import main.hotel.hotelalura.factory.ConnectionFactory;

public class HuespedeController {

        private HuespedeDAO huespedeDAO;

        public HuespedeController() {
            try (var factory = new ConnectionFactory()) {
                this.huespedeDAO = new HuespedeDAO(factory.getConnection());
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        public void guardar() {
            huespedeDAO.guardar();
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

        public void listar() {
            huespedeDAO.listar();
        }
}
