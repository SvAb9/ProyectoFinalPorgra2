module co.edu.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens co.edu.proyectofinal to javafx.fxml;
    opens co.edu.proyectofinal.Controlador to javafx.fxml;
    opens co.edu.proyectofinal.Modelo to javafx.fxml; // Asegúrate de abrir el paquete Modelo si es necesario

    exports co.edu.proyectofinal;
    exports co.edu.proyectofinal.Controlador;
}
