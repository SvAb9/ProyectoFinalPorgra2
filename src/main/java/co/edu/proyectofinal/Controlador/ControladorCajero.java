package co.edu.proyectofinal.Controlador;

import java.util.ArrayList;

import co.edu.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class ControladorCajero {
    @FXML
    private ListView<String> ordenesListView;

    private Cajero cajero;

    public void initialize() {
        cajero = new Cajero("Ana", "García", "agarcia", "5678", "987654321", new ArrayList<>(), "cajero");
    }

    @FXML
    public void cobrarOrden() {
        // Aquí deberías obtener la orden seleccionada para cobrar
        // Simularemos con la primera orden disponible
        if (!cajero.getListaFacturas().isEmpty()) {
            Factura factura = cajero.getListaFacturas().get(0);  // Simulación
            cajero.cobrar();
            mostrarAlerta("Total cobrado: $" + factura.getTotal());
            cajero.getListaFacturas().remove(factura);
            actualizarListaOrdenes();
        } else {
            mostrarAlerta("No hay ordenes para cobrar.");
        }
    }

    private void actualizarListaOrdenes() {
        ordenesListView.getItems().clear();
        for (Factura factura : cajero.getListaFacturas()) {
            ordenesListView.getItems().add("Orden - Total: $" + factura.getTotal());
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
