package Monopoli;

import javax.swing.JPanel;

/*@author Andrés Toscano*/

public class CasillaEspecial extends Casilla {

    private TipoCasillaEspecial tipo;
    private int monto;
    private Jugador propietario;
    private static final int[] alquileres = {25, 50, 100, 200}; // Para TREN
    private boolean hipotecada;

    public CasillaEspecial(String nombre, JPanel panel, TipoCasillaEspecial tipo, Propiedad propiedad) {
        super(panel, nombre, propiedad);
        this.tipo = tipo;
        this.monto = 0;
        this.propietario = null;
        this.hipotecada = false;
    }

//    @Override
//    public void accion(Jugador jugador) {
//        switch (tipo) {
//            case SALIDA:
//                jugador.modificarDinero(monto);
//                break;
//            case IMPUESTO:
//                jugador.modificarDinero(-monto);
//                break;
//            case CARCEL:
//                jugador.irALaCarcel();
//                break;
//            case ESTACIONAMIENTO:
//                // No hace nada especial
//                break;
//            case TREN:
//                if (propietario == null) {
//                    if (jugador.getDinero() >= monto) {
//                        jugador.comprarPropiedad(this);
//                        this.propietario = jugador;
//                    }
//                } else if (propietario != jugador && !hipotecada) {
//                    int numeroEstaciones = propietario.contarEstaciones();
//                    int montoAlquiler = alquileres[numeroEstaciones - 1];
//                    jugador.modificarDinero(-montoAlquiler);
//                    propietario.modificarDinero(montoAlquiler);
//                }
//                break;
//        }
//    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public boolean isHipotecada() {
        return hipotecada;
    }

//    public void hipotecar() {
//        hipotecada = true;
//        propietario.modificarDinero(monto / 2);
//    }
//
//    public void deshipotecar() {
//        hipotecada = false;
//        propietario.modificarDinero(-(monto / 2 + (monto / 10)));
//    }
    
}