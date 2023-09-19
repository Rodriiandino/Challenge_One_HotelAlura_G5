package main.hotel.hotelalura.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.hotel.hotelalura.controller.HuespedeController;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.modelo.Reserva;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.TableDataType;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.modelo.Reserva;
import main.hotel.hotelalura.utils.WayToPay;

import java.util.List;

public class infoTableController {
    public Button btn_host;
    public Button btn_booking;
    public Button btn_back;
    public Button btn_edit;
    public Button btn_remove;

    public TableView table;
    private HuespedeController huespedeController;
    private ReservaController reservaController;
    private ObservableList<Huespede> huespedeList;
    private ObservableList<Reserva> reservaList;
    private TableDataType currentTableDataType = TableDataType.HUESPEDE;


    public void initialize() {
        setupListeners();
    }

    private void setupListeners() {
        createColumns();
        huespedeController = new HuespedeController();
        reservaController = new ReservaController();

        listar();

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectRow();
        });

        btn_host.setOnAction(event -> changeToHost());
        btn_booking.setOnAction(event -> changeToBooking());
        btn_back.setOnAction(e -> ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/menu-view.fxml", btn_back));
    }


    private void selectRow() {
        if (currentTableDataType == TableDataType.HUESPEDE) {
            Huespede selectedHuespede = (Huespede) table.getSelectionModel().getSelectedItem();
            if (selectedHuespede != null) {
                showDataForEditing(selectedHuespede);
            }
        } else if (currentTableDataType == TableDataType.RESERVA) {
            Reserva selectedReserva = (Reserva) table.getSelectionModel().getSelectedItem();
            if (selectedReserva != null) {
                showDataForEditing(selectedReserva);
            }
        }


    }

    private void showDataForEditing(Huespede selectedHuespede) {
        System.out.println("Selected Huespede: " + selectedHuespede);
    }

    private void showDataForEditing(Reserva selectedReserva) {
        System.out.println("Selected Reserva: " + selectedReserva);
    }


    private void createColumns() {
        table.getColumns().clear();

        if (currentTableDataType == TableDataType.HUESPEDE) {
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

            table.getColumns().addAll(idColumn, nombreColumn, apellidoColumn, fechaNacimientoColumn, nacionalidadColumn, telefonoColumn, idReservaColumn);

        } else if (currentTableDataType == TableDataType.RESERVA) {
            TableColumn<Reserva, Integer> idColumn;
            TableColumn<Reserva, String> fechaEntradaColumn;
            TableColumn<Reserva, String> fechaSalidaColumn;
            TableColumn<Reserva, Double> valorColumn;
            TableColumn<Reserva, String> formaPagoColumn;

            idColumn = new TableColumn<>("ID");
            fechaEntradaColumn = new TableColumn<>("Fecha de Entrada");
            fechaSalidaColumn = new TableColumn<>("Fecha de Salida");
            valorColumn = new TableColumn<>("Valor");
            formaPagoColumn = new TableColumn<>("Forma de Pago");

            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            fechaEntradaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha_entrada"));
            fechaSalidaColumn.setCellValueFactory(new PropertyValueFactory<>("fecha_salida"));
            valorColumn.setCellValueFactory(new PropertyValueFactory<>("valor"));
            formaPagoColumn.setCellValueFactory(new PropertyValueFactory<>("forma_pago"));

            table.getColumns().addAll(idColumn, fechaEntradaColumn, fechaSalidaColumn, valorColumn, formaPagoColumn);
        }
    }

    private void listar() {
        huespedeList = FXCollections.observableArrayList();
        reservaList = FXCollections.observableArrayList();

        if (currentTableDataType == TableDataType.RESERVA) {
            listarReservas();
            table.setItems(reservaList);
        } else if (currentTableDataType == TableDataType.HUESPEDE) {
            listarHuespedes();
            table.setItems(huespedeList);
        }
    }

    private void listarHuespedes() {
        List<Huespede> huespedes = huespedeController.listar();
        huespedeList.addAll(huespedes);
    }

    private void listarReservas() {
        List<Reserva> reservas = reservaController.listar();
        reservaList.addAll(reservas);
    }

    public void changeToBooking() {
        currentTableDataType = TableDataType.RESERVA;
        createColumns();
        listar();
    }

    public void changeToHost() {
        currentTableDataType = TableDataType.HUESPEDE;
        createColumns();
        listar();
    }

}
