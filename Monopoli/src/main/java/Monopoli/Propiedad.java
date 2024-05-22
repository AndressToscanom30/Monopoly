package Monopoli;

/*@author Andrés Toscano*/

public class Propiedad {
    
    private String nombre;
    private int precio;
    private int renta;
    private Jugador propietario;

    public Propiedad() {
    }

    public Propiedad(String nombre, int precio, int renta, Jugador propietario) {
    
        this.nombre = nombre;
        this.precio = precio;
        this.renta = renta;
        this.propietario = propietario;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    
}
