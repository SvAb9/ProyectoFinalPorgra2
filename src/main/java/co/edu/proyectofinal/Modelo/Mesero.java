package co.edu.proyectofinal.Modelo;

public class Mesero extends Empleado implements GetTipo {
    private Orden orden;

    public Mesero(String nombre, String apellido, String usuario, String contraseña, String documento, String tipo) {
        super(nombre, apellido, usuario, contraseña, documento, tipo);
        this.orden = new Orden();
    }


    public void hacerOrden(String tipoProducto, String nombre, double precio, String especificacion1, String especificacion2) {
        ProductoFactory factory;
        switch (tipoProducto.toLowerCase()) {
            case "sandwich":
                factory = new SandwichFactory();
                break;
            case "bebida":
                factory = new BebidaFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de producto no válido: " + tipoProducto);
        }
        Producto producto = factory.crearProducto(nombre, precio, especificacion1, especificacion2);
        orden.agregarProducto(producto);
        System.out.println("Producto agregado a la orden: " + producto.getNombre());
    }

    public Orden getOrden() {
        return orden;
    }

    public void actualizarEstadoOrden(String estado) {
        orden.setEstado(estado);
        System.out.println("Estado de la orden actualizado a: " + estado);
    }

    @Override
    public String getTipo() {
        return "Mesero";
    }
}
