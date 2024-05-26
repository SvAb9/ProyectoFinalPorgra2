package co.edu.proyectofinal.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    
    private List<CuponStrategy> cupones;
    

    public Cliente(String nombre, String apellido, String usuario, String contraseña, String documento, List<CuponStrategy> cupones) {
        super(nombre, apellido, usuario, contraseña, documento);
        this.cupones = new ArrayList<>();
    }

    public String getusuario() {
        return documento;
    }

    public void addCupon(CuponStrategy cupon){
        cupones.add(cupon);
    }
    
    public List<CuponStrategy> getCupones(){
        return cupones;
    }

    public double aplicarCupon(double total, CuponStrategy cuponSeleccionado){
        return cuponSeleccionado.aplicarDescuento(total);
    }
}
