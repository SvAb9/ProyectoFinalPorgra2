package co.edu.proyectofinal.Modelo;



public class Factura {
    private Orden orden;
    private double total;

    public Factura(Orden orden) {
        this.orden = orden;
        this.total = calcularTotal();
    }

    public Orden getOrden() {
        return orden;
    }

    public double getTotal() {
        return total;
    }

    private double calcularTotal() {
        double total = 0.0;
        for (Producto producto : orden.getProductos()) {
            total += producto.getPrecio();
        }
        return total;
    }
}
