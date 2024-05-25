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

public class ControladorRegistro {

    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidoTextField;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField contraseñaPasswordField;
    @FXML
    private TextField documentoTextField;
    @FXML
    private TextField tipoUsuarioTextField;

    @FXML
    public void registrar() {
        String nombre = nombreTextField.getText();
        String apellido = apellidoTextField.getText();
        String usuario = usuarioTextField.getText();
        String contraseña = contraseñaPasswordField.getText();
        String documento = documentoTextField.getText();
        String tipoUsuario = tipoUsuarioTextField.getText().toLowerCase();

        Restaurante restaurante = ControladorLogin.getRestaurante();
        if (tipoUsuario.equals("empleado")) {
            Empleado empleado = new Mesero(nombre, apellido, usuario, contraseña, documento); // Asumimos mesero por defecto
            restaurante.agregarEmpleado(empleado);
            mostrarAlerta("Empleado registrado: " + nombre + " " + apellido);
        } else if (tipoUsuario.equals("propietario")) {
            Propietario propietario = new Propietario(nombre, apellido, usuario, contraseña, documento, null);
            restaurante.agregarEmpleado(propietario); // Agregamos el propietario como empleado también
            mostrarAlerta("Propietario registrado: " + nombre + " " + apellido);
        } else {
            mostrarAlerta("Tipo de usuario no válido.");
        }

        regresarALogin();
    }

    @FXML
    public void regresarALogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/proyectofinal/Vista/login.fxml"));
            GridPane root = loader.load(); // Ajuste aquí
            Stage stage = (Stage) nombreTextField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
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
