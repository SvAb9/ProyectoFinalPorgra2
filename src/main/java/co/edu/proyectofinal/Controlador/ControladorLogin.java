package co.edu.proyectofinal.Controlador;

import co.edu.proyectofinal.Modelo.*;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class ControladorLogin {

    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField contraseñaPasswordField;

    private static Restaurante restaurante = new Restaurante();

    @FXML
    public void iniciarSesion() {
        String usuario = usuarioTextField.getText();
        String contraseña = contraseñaPasswordField.getText();

        Empleado empleado = restaurante.verificarCredenciales(usuario, contraseña, "empleado");
        Empleado propietario = restaurante.verificarCredenciales(usuario, contraseña, "propietario");

        if (empleado != null) {
            cargarVista("/co/edu/proyectofinal/Vista/mesero.fxml");
        } else if (propietario != null) {
            cargarVista("/co/edu/proyectofinal/Vista/propietario.fxml");
        } else {
            mostrarAlerta("Credenciales incorrectas");
        }
    }

    @FXML
    public void registrarUsuario() {
        cargarVista("/co/edu/proyectofinal/Vista/registro.fxml");
    }

    private void cargarVista(String vista) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(vista));
            GridPane root = loader.load(); // Ajuste aquí
            Stage stage = (Stage) usuarioTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static Restaurante getRestaurante() {
        return restaurante;
    }
}
