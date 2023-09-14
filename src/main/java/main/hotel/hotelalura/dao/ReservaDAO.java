package main.hotel.hotelalura.dao;

import java.sql.Connection;

public class ReservaDAO {
    Connection connection;

    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar() {
        System.out.println("Guardando reserva...");
    }

    public void actualizar() {
        System.out.println("Actualizando reserva...");
    }

    public void eliminar() {
        System.out.println("Eliminando reserva...");
    }

    public void buscar() {
        System.out.println("Buscando reserva...");
    }

    public void listar() {
        System.out.println("Listando reservas...");
    }
}
