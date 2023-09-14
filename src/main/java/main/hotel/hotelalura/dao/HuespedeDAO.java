package main.hotel.hotelalura.dao;

import java.sql.Connection;

public class HuespedeDAO {

    Connection connection;

    public HuespedeDAO(Connection connection) {
        this.connection = connection;
    }


    public void guardar() {
        System.out.println("Guardando huespede...");
    }

    public void actualizar() {
        System.out.println("Actualizando huespede...");
    }

    public void eliminar() {
        System.out.println("Eliminando huespede...");
    }

    public void buscar() {
        System.out.println("Buscando huespede...");
    }

    public void listar() {
        System.out.println("Listando huespedes...");
    }
}
