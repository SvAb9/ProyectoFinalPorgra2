package co.edu.proyectofinal.Modelo;

public abstract class Empleado extends Persona {
    public Empleado(String nombre, String apellido, String usuario, String contraseña, String documento) {
        super(nombre, apellido, usuario, contraseña, documento);
    }
    
    public abstract String getTipo();
}
