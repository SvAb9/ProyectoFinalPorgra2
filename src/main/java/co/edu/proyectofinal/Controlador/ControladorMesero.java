package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorMesero {
    @FXML
    private ComboBox<String> tipoProductoComboBox;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField precioTextField;
    @FXML
    private ListView<String> ordenListView;

    private Mesero mesero;

    public void initialize() {
        tipoProductoComboBox.setItems(FXCollections.observableArrayList("Sandwich", "Bebida"));
        mesero = new Mesero("Juan", "Pérez", "jperez", "1234", "123456789", "mesero");
    }

    @FXML
    public void agregarProducto() {
        String tipoProducto = tipoProductoComboBox.getValue();
        String nombre = nombreTextField.getText();
        double precio = Double.parseDouble(precioTextField.getText());

        mesero.hacerOrden(tipoProducto, nombre, precio);
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
