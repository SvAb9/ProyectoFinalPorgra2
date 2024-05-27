package co.edu.proyectofinal.Controlador;

import java.util.ArrayList;
import java.util.UUID;

import co.edu.proyectofinal.Modelo.*;
import co.edu.proyectofinal.Modelo.Factura.Builder;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorVista {
    @FXML
    private ComboBox<String> tipoProductoComboBox;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField precioTextField;
    @FXML
    private TextField especificacion1TextField;
    @FXML
    private TextField especificacion2TextField;
    @FXML
    private ListView<String> ordenListView;
    @FXML
    private ComboBox<String> estadoComboBox;

    private Mesero mesero;
    private Cajero cajero;

    public void initialize() {
        tipoProductoComboBox.setItems(FXCollections.observableArrayList("Sandwich", "Bebida"));
        estadoComboBox.setItems(FXCollections.observableArrayList("Pendiente", "Preparando", "Listo", "Entregado"));

        mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero");
        cajero = new Cajero("Ana", "García", "agarcia", "5678", "987654321", new ArrayList<>(), "cajero");  // Asegúrate de pasar una lista vacía
    }

    @FXML
    public void agregarProducto() {
        String tipoProducto = tipoProductoComboBox.getValue();
        String nombre = nombreTextField.getText();
        double precio = Double.parseDouble(precioTextField.getText());
        String especificacion1 = especificacion1TextField.getText();
        String especificacion2 = especificacion2TextField.getText();

        mesero.hacerOrden(tipoProducto, nombre, precio, especificacion1, especificacion2);
        actualizarListaOrden();
    }

    @FXML
    public void actualizarEstadoOrden() {
        String estado = estadoComboBox.getValue();
        mesero.actualizarEstadoOrden(estado);
    }

    @FXML
    public void cobrarOrden() {
        double subTotal= mesero.getOrden().getProductos().stream().mapToDouble(Producto::getPrecio).sum();
        double total= subTotal;
        UUID codigo= UUID.randomUUID();

        Factura factura= new Factura.Builder().subTotal(subTotal).total(total).codigoFactura(codigo).build();
        cajero.agregarFactura(factura);
        mostrarAlerta("El total de la orden es de: $" + factura.getTotal());

        Mesero mesero= new Mesero("Emilio","Echeverry","Emi","123","1234","mesero");
        actualizarListaOrden();

    }

    private void actualizarListaOrden() {
        ordenListView.getItems().clear();
        for (Producto producto : mesero.getOrden().getProductos()) {
            ordenListView.getItems().add(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
