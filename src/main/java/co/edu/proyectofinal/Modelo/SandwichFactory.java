package co.edu.proyectofinal.Modelo;

public class SandwichFactory implements ProductoFactory {
    @Override
    public Producto crearProducto(String nombre, double precio, String tipoPan, String tipoCarne) {
        ComponenteSandwich sandwich = new Sandwich(tipoPan, tipoCarne, false); // Sandwich básico sin queso

        // Aplicar decoradores según el tipo de sándwich
        if (nombre.toLowerCase().contains("queso")) {
            sandwich = new QuesoDecorador(sandwich);
        }
        // Si hay otros rellenos, puedes agregar más lógica aquí
        // por ejemplo, si el nombre contiene otros ingredientes
        if (nombre.toLowerCase().contains("lechuga")) {
            sandwich = new RellenoDecorador(sandwich, "Lechuga");
        }
        if (nombre.toLowerCase().contains("tomate")) {
            sandwich = new RellenoDecorador(sandwich, "Tomate");
        }

        // Crear el ProductoSandwich usando el componente decorado
        return new ProductoSandwich(nombre, sandwich.getCosto(), tipoPan, tipoCarne, sandwich);
    }
}
