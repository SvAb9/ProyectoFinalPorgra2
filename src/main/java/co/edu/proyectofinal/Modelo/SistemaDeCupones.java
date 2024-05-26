package co.edu.proyectofinal.Modelo;

public class SistemaDeCupones {
    
    public void mandarCuponDeRegistro(Cliente cliente){
        System.out.println("Enviando cupon por registro a: " + cliente.getUsuario());
        cliente.addCupon(new CuponPrimerRegistro());
    }

    public void mandarCuponDePrimeraCompra(Cliente cliente){
        System.out.println("enviando cupon por primera compra al usuario: " + cliente.getUsuario());
        cliente.addCupon(new CuponPrimeraCompra());
    }
}
