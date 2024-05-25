package co.edu.proyectofinal.Modelo;

public class BebidaFactory implements ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio, String tamaño, String tipo) {
        return new Bebida(nombre, precio, tamaño, tipo);
    }
}
