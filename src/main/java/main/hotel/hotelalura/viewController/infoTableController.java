package main.hotel.hotelalura.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.hotel.hotelalura.controller.HuespedeController;
import main.hotel.hotelalura.modelo.Huespede;

import java.util.List;

public class infoTableController {
    public Button btn_host;
    public Button btn_booking;

    public TableView<Huespede> table;
    private HuespedeController huespedeController;
    private ObservableList<Huespede> huespedeList;

    public void initialize() {
        createColumns();
        huespedeController = new HuespedeController();
        huespedeList = FXCollections.observableArrayList();
        listarHuespedes();
        table.setItems(huespedeList);
    }

    private void createColumns() {
        TableColumn<Huespede, Integer> idColumn;
        TableColumn<Huespede, String> nombreColumn;
        TableColumn<Huespede, String> apellidoColumn;
        TableColumn<Huespede, String> fechaNacimientoColumn;
        TableColumn<Huespede, String> nacionalidadColumn;
        TableColumn<Huespede, String> telefonoColumn;
        TableColumn<Huespede, Integer> idReservaColumn;

        idColumn = new TableColumn<>("ID");
        nombreColumn = new TableColumn<>("Nombre");
        apellidoColumn = new TableColumn<>("Apellido");
        fechaNacimientoColumn = new TableColumn<>("Fecha de Nacimiento");
        nacionalidadColumn = new TableColumn<>("Nacionalidad");
        telefonoColumn = new TableColumn<>("Telefono");
        idReservaColumn = new TableColumn<>("ID Reserva");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        fechaNacimientoColumn.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
        nacionalidadColumn.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        idReservaColumn.setCellValueFactory(new PropertyValueFactory<>("id_reserva"));


        table.getColumns().add(idColumn);
        table.getColumns().add(nombreColumn);
        table.getColumns().add(apellidoColumn);
        table.getColumns().add(fechaNacimientoColumn);
        table.getColumns().add(nacionalidadColumn);
        table.getColumns().add(telefonoColumn);
        table.getColumns().add(idReservaColumn);
    }

    private void listarHuespedes() {
        List<Huespede> huespedes = huespedeController.listar();
        huespedeList.addAll(huespedes);
    }
}
