package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cajero extends Empleado {
    private List<Factura> listaFacturas;

    public Cajero(String nombre, String apellido, String usuario, String contraseña, String documento, List<Factura> listaFacturas) {
        super(nombre, apellido, usuario, contraseña, documento);
        this.listaFacturas = listaFacturas != null ? listaFacturas : new ArrayList<>();
    }

    public String getTipo() {
        return "Cajero";
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public void agregarFactura(Factura factura) {
        listaFacturas.add(factura);
    }

    public double cobrar() {
        double total = 0.0;
        for (Factura factura : listaFacturas) {
            total += factura.getTotal();
        }
        return total;
    }
}
