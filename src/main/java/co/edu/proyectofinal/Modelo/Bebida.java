package co.edu.proyectofinal.Modelo;

public class Bebida extends Producto {
    public Bebida(String nombre, double precio, String tamaño, String tipo) {
        super(nombre, precio, tamaño, tipo);
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }
}
