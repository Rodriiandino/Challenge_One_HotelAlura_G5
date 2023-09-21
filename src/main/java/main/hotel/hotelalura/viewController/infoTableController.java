package main.hotel.hotelalura.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.hotel.hotelalura.controller.HuespedeController;
import main.hotel.hotelalura.controller.ReservaController;
import main.hotel.hotelalura.modelo.Huespede;
import main.hotel.hotelalura.modelo.Reserva;
import main.hotel.hotelalura.utils.EntidadHotel;
import main.hotel.hotelalura.utils.ScreenTransitionUtil;
import main.hotel.hotelalura.utils.TableDataType;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class infoTableController implements Initializable {
    public Button btn_host;
    public Button btn_booking;
    public Button btn_back;
    public Button btn_edit;
    public Button btn_remove;

    public TableView<EntidadHotel> table;
    private HuespedeController huespedeController;
    private ReservaController reservaController;
    private TableDataType currentTableDataType = TableDataType.HUESPEDE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupListeners();
    }

    private void setupListeners() {
        huespedeController = new HuespedeController();
        reservaController = new ReservaController();

        createColumns();
        listar();

        btn_host.setOnAction(event -> changeToHost());
        btn_booking.setOnAction(event -> changeToBooking());
        btn_remove.setOnAction(event -> delete());
        btn_back.setOnAction(e -> ScreenTransitionUtil.changeScreen(this, "/main/hotel/hotelalura/menu-view.fxml", btn_back));
    }

    private void createColumns() {
        table.getColumns().clear();

        if (currentTableDataType == TableDataType.HUESPEDE) {
            TableColumn<EntidadHotel, Integer> idColumn;
            TableColumn<EntidadHotel, String> nombreColumn;
            TableColumn<EntidadHotel, String> apellidoColumn;
            TableColumn<EntidadHotel, String> fechaNacimientoColumn;
            TableColumn<EntidadHotel, String> nacionalidadColumn;
            TableColumn<EntidadHotel, String> telefonoColumn;
            TableColumn<EntidadHotel, Integer> idReservaColumn;

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

        } else if (currentTableDataType == TableDataType.RESERVA) {
            TableColumn<EntidadHotel, Integer> idColumn;
            TableColumn<EntidadHotel, String> fechaEntradaColumn;
            TableColumn<EntidadHotel, String> fechaSalidaColumn;
            TableColumn<EntidadHotel, Double> valorColumn;
            TableColumn<EntidadHotel, String> formaPagoColumn;

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

            table.getColumns().add(idColumn);
            table.getColumns().add(fechaEntradaColumn);
            table.getColumns().add(fechaSalidaColumn);
            table.getColumns().add(valorColumn);
            table.getColumns().add(formaPagoColumn);
        }
    }

    private void listar() {
        ObservableList<EntidadHotel> huespedeList = FXCollections.observableArrayList();
        ObservableList<EntidadHotel> reservaList = FXCollections.observableArrayList();

        if (currentTableDataType == TableDataType.RESERVA) {
            List<Reserva> reservas = reservaController.list();
            reservaList.addAll(reservas);
            table.setItems(reservaList);
        } else if (currentTableDataType == TableDataType.HUESPEDE) {
            List<Huespede> huespedes = huespedeController.list();
            huespedeList.addAll(huespedes);
            table.setItems(huespedeList);
        }
    }

    public void changeToBooking() {
        btn_booking.setStyle("-fx-background-color: #3D7A5D");
        btn_host.setStyle("-fx-background-color: #638A77");
        currentTableDataType = TableDataType.RESERVA;
        createColumns();
        listar();
    }

    public void changeToHost() {
        btn_host.setStyle("-fx-background-color: #3D7A5D");
        btn_booking.setStyle("-fx-background-color: #638A77");
        currentTableDataType = TableDataType.HUESPEDE;
        createColumns();
        listar();
    }

    public void delete() {
        if (currentTableDataType == TableDataType.HUESPEDE) {
            Huespede selectedHuespede = (Huespede) table.getSelectionModel().getSelectedItem();
            if (selectedHuespede != null) {
                Integer id = selectedHuespede.getId();
                if (windowConfirmation("Eliminar Huesped con id: " + id, "¿Estás seguro de que quieres eliminar este registro?")) {
                    huespedeController.delete(id);
                    listar();
                }
            }
        } else if (currentTableDataType == TableDataType.RESERVA) {
            Reserva selectedReserva = (Reserva) table.getSelectionModel().getSelectedItem();
            if (selectedReserva != null) {
                Integer id = selectedReserva.getId();
                if (reservaController.reservationHasHost(id)) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error al eliminar reserva");
                    alert.setHeaderText("No se puede eliminar la reserva");
                    alert.setContentText("La reserva con id: " + id + " tiene un huespede asociado");

                    alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/main/hotel/hotelalura/delete.css")).toExternalForm());

                    alert.showAndWait();
                } else {
                    if (windowConfirmation("Eliminar Reserva con id: " + id, "¿Estás seguro de que quieres eliminar este registro?")) {
                        reservaController.delete(id);
                        listar();
                    }
                }
            }
        }
    }

    public boolean windowConfirmation(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminacion de registro");
        alert.setHeaderText(titulo);
        alert.setContentText(mensaje);

        alert.getDialogPane().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/main/hotel/hotelalura/delete.css")).toExternalForm());

        ButtonType buttonTypeYes = new ButtonType("Sí");
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == buttonTypeYes;
    }
}
