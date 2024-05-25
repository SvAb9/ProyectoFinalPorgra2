package co.edu.proyectofinal.Modelo;

public interface ProductoFactory {
    Producto crearProducto(String nombre, double precio, String especificacion1, String especificacion2);
}
