package Monopoli;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;

/* @author Andrés Toscano*/

public class Jugador {
    
    private String nombre;
    private int dinero;
    private ArrayList<Propiedad> propiedades;
    private JPanel ficha;
    private boolean eliminado;
    private boolean enCarcel;
    private int turnosEnCarcel;

    public Jugador() {
    }
    
    public Jugador(String nombre, int dinero, ArrayList<Propiedad> propiedades, JPanel ficha) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.propiedades = propiedades;
        this.ficha = ficha;
        this.eliminado = false;
        this.enCarcel = false;
        this.turnosEnCarcel = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }
    
    public void addPropiedad(Propiedad propiedad) {
        this.propiedades.add(propiedad);
    }

    public JPanel getFicha() {
        return ficha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public void setFicha(JPanel ficha) {
        this.ficha = ficha;
    }
    
    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    public boolean isEnCarcel() {
        return enCarcel;
    }

    public void setEnCarcel(boolean enCarcel) {
        this.enCarcel = enCarcel;
        if (enCarcel) {
            this.turnosEnCarcel = 3; // Ejemplo: el jugador pasa 3 turnos en la cárcel
        }
    }

    public int getTurnosEnCarcel() {
        return turnosEnCarcel;
    }

    public void decrementarTurnoCarcel() {
        if (turnosEnCarcel > 0) {
            turnosEnCarcel--;
        }
        if (turnosEnCarcel == 0) {
            enCarcel = false;
        }
    }
    
    public void agregarFichaAJugador(JPanel casilla1, Color color) {
        
        ficha.setPreferredSize(new Dimension(10, 10));
        ficha.setBackground(color);
        casilla1.add(ficha);
        
    }
    
}