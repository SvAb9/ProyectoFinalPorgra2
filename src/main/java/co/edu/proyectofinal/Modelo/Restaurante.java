package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Empleado> empleados;

    public Restaurante() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public Empleado verificarCredenciales(String usuario, String contraseña, String tipo) {
        for (Empleado empleado : empleados) {
            if (empleado.getUsuario().equals(usuario) && empleado.getContraseña().equals(contraseña)) {
                if (tipo.equalsIgnoreCase("empleado") && !(empleado instanceof Propietario)) {
                    return empleado;
                } else if (tipo.equalsIgnoreCase("propietario") && empleado instanceof Propietario) {
                    return empleado;
                }
            }
        }
        return null;
    }

    public void listarEmpleados() {
        empleados.forEach(empleado -> System.out.println("Empleado: " + empleado.getNombre() + " " + empleado.getApellido() + " - Tipo: " + empleado.getTipo()));
    }
}
