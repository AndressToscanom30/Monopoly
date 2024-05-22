package Monopoli;

import javax.swing.JPanel;

/*@author Andrés Toscano*/

public class Casilla {
 
    private JPanel ubicacion;
    private String nombre;
    private Propiedad propiedad;

    public Casilla() {
    }
    
    public Casilla(JPanel panel, String nombre, Propiedad propiedad) {
    
        this.ubicacion = panel;
        this.nombre = nombre;
        this.propiedad = propiedad;
        
    }

    public JPanel getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(JPanel ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
    
}
