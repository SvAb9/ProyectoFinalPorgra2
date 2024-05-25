package co.edu.proyectofinal.Modelo;

public abstract class Producto {
    protected String nombre;
    protected double precio;
    protected String especificacion1;
    protected String especificacion2;

    public Producto(String nombre, double precio, String especificacion1, String especificacion2) {
        this.nombre = nombre;
        this.precio = precio;
        this.especificacion1 = especificacion1;
        this.especificacion2 = especificacion2;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEspecificacion1() {
        return especificacion1;
    }

    public String getEspecificacion2() {
        return especificacion2;
    }

    public abstract String getTipo();
}
