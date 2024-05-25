package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;

public class FactoryCajero implements EmpleadoFactory {
    @Override
    public Empleado crearEmpleado(String nombre, String apellido, String usuario, String contraseña, String documento) {
        return new Cajero(nombre, apellido, usuario, contraseña, documento, new ArrayList<>());
    }
}
