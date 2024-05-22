package Monopoli;

/*@author Andrés Toscano*/

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class Tablero extends JPanel {

    private JPanel[] paneles;
    private int turno;
    private ArrayList<Casilla> casillas;

    public Tablero() {    
    }
    
    public Tablero(ArrayList<Casilla> casillas){
        
        this.casillas = casillas;
        
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }
    
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    Dado dado = new Dado();

    public void moverJugador(final ArrayList<Jugador> jugadores, final JPanel[] casillasP, final JButton boton, final JTextArea textAreaInfo, ArrayList<Casilla> casillas, JLabel resultadoDado) {
        
        final int carrera = dado.tirarDado();
        resultadoDado.setText(String.valueOf(carrera));

        Timer timer = new Timer(300, new ActionListener() {
            int movimientosRestantes = carrera;
            int indiceJugador = getTurno();

            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugadorActual = jugadores.get(indiceJugador);

                // Verificar si el jugador está en la cárcel
                if (jugadorActual.isEnCarcel()) {
                    if (jugadorActual.getTurnosEnCarcel() > 0) {
                        // Reducir el contador de turnos en la cárcel
                        jugadorActual.decrementarTurnoCarcel();
                        // Actualizar el texto informativo
                        textAreaInfo.append("\n" + jugadorActual.getNombre() + " está en la cárcel. Turnos restantes en la cárcel: " + jugadorActual.getTurnosEnCarcel());
                        return;
                    } else {
                        // Sacar al jugador de la cárcel
                        jugadorActual.setEnCarcel(false);
                        textAreaInfo.append("\n" + jugadorActual.getNombre() + " ha salido de la cárcel.");
                    }
                }

                if (movimientosRestantes > 0) {
                    JPanel panelEn = encontrarPanelContenedor(jugadorActual.getFicha(), casillasP);
                    if (panelEn != null) {
                        int indicePanelActual = Arrays.asList(casillasP).indexOf(panelEn);
                        int nuevaPosicion = (indicePanelActual + 1) % casillasP.length;
                        JPanel nuevoPanel = casillasP[nuevaPosicion];
                        nuevoPanel.add(jugadorActual.getFicha());
                        panelEn.revalidate();
                        panelEn.repaint();
                        nuevoPanel.revalidate();
                        nuevoPanel.repaint();
                        movimientosRestantes--;
                    }
                } else {
                    ((Timer) e.getSource()).stop();
                    boton.setEnabled(true);

                    // Ejecutar la acción de la casilla
                    int indiceCasillaActual = obtenerIndiceCasilla(jugadorActual.getFicha(), casillasP);
                    ejecutarAccionCasilla(indiceCasillaActual, jugadorActual, casillas, textAreaInfo);

                    // Actualizar el turno
                    setTurno((indiceJugador + 1) % jugadores.size());
                    actualizarTextArea(jugadores.get(getTurno()), textAreaInfo);
                }
            }
        });

        timer.start();
    
    }
    
    public void comprarPropiedad(Jugador jugador, Casilla propiedad) {
        
        if (jugador.getDinero() >= propiedad.getPropiedad().getPrecio()) {

            jugador.setDinero(jugador.getDinero() - propiedad.getPropiedad().getPrecio());

            jugador.getPropiedades().add(propiedad.getPropiedad());
            
            propiedad.getPropiedad().setPropietario(jugador);

            System.out.println(jugador.getNombre() + " ha comprado la propiedad " + propiedad.getNombre());
        } else {
            System.out.println(jugador.getNombre() + " no tiene suficiente dinero para comprar la propiedad " + propiedad.getNombre());
        }
    }
    
    private void finalizarJuego(Jugador jugador) {
        
        jugador.setEliminado(true);
        JOptionPane.showMessageDialog(null, "El jugador " + jugador.getNombre() + " ha sido eliminado del juego.");
        
    }
    
    public void ejecutarAccionCasilla(int indice, Jugador jugador, ArrayList<Casilla> casillas, JTextArea textAreaInfo) {
        
        Propiedad propiedadActual = casillas.get(indice).getPropiedad();
        
        switch (indice) {
            case 0:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 1:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 2:
                //JOptionPane.showMessageDialog(null, casillas.get(2).getNombre());
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                
                break;
            case 3:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
              
            case 4:
                //JOptionPane.showMessageDialog(null, casillas.get(4).getNombre());
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                
                break;
            case 5:
                //JOptionPane.showMessageDialog(null, casillas.get(5).getNombre());
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                
                break;
            case 6:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 7:
                //JOptionPane.showMessageDialog(null, casillas.get(7).getNombre());
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
            case 8:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 9:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 10:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 11:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 12:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 13:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 14:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 15:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 16:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 17:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 18:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 19:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 20:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 21:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 22:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 23:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 24:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 25:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 26:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 27:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 28:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre());
                break;
                
            case 29:
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 30:
                JOptionPane.showMessageDialog(null, casillas.get(30).getNombre());
                
                jugador.setEnCarcel(true);
                textAreaInfo.append("\n" + jugador.getNombre() + " ha sido enviado a la cárcel.\n");
                
                break;
                
            case 31:
                
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 32:
                
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 33:
                JOptionPane.showMessageDialog(null, casillas.get(33).getNombre());
                // Acción específica para la casilla 33
                break;
            case 34:
                
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 35:
                JOptionPane.showMessageDialog(null, casillas.get(35).getNombre());
                // Acción específica para la casilla 35
                break;
            case 36:
                
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 37:
                JOptionPane.showMessageDialog(null, casillas.get(37).getNombre());
                // Acción específica para la casilla 37
                break;
            case 38:
                
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
            case 39:
                
                textAreaInfo.append("\n--------\n" + casillas.get(indice).getNombre() + "\n");

                if (propiedadActual == null) {
                    JOptionPane.showMessageDialog(null, "Error: La propiedad es inválida.");
                    return;
                }

                // Mostrar información detallada de la casilla
                textAreaInfo.append("Tipo de casilla: Propiedad\n");
                textAreaInfo.append("Precio de la propiedad: $" + propiedadActual.getPrecio() + "\n");

                if (propiedadActual.getPropietario() == null) {
                    textAreaInfo.append("Propietario: Disponible para compra\n");

                    // Verificar si el jugador tiene suficiente dinero para comprar la propiedad
                    if (jugador.getDinero() >= propiedadActual.getPrecio()) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas comprar " + casillas.get(indice).getNombre() + " por $" + propiedadActual.getPrecio() + "?", "Confirmación", JOptionPane.YES_NO_OPTION);

                        if (opcion == JOptionPane.YES_OPTION) {
                            propiedadActual.setPropietario(jugador);
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getPrecio());
                            jugador.addPropiedad(propiedadActual);
                            JOptionPane.showMessageDialog(null, "Has comprado la propiedad: " + casillas.get(indice).getNombre());
                            textAreaInfo.append("Estado: Comprado por " + jugador.getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "Has decidido no comprar la propiedad.");
                        }
                    } else {
                    }
                } else {
                    textAreaInfo.append("Propietario: " + propiedadActual.getPropietario().getNombre() + "\n");
                    textAreaInfo.append("Renta: $" + propiedadActual.getRenta() + "\n");

                    if (jugador == propiedadActual.getPropietario()) {
                        
                    } else {
                        if (propiedadActual.getRenta() <= 0) {
                            return;
                        }

                        if (jugador.getDinero() >= propiedadActual.getRenta()) {
                            JOptionPane.showMessageDialog(null, "Pagas $" + propiedadActual.getRenta() + " a " + propiedadActual.getPropietario().getNombre());
                            jugador.setDinero(jugador.getDinero() - propiedadActual.getRenta());
                            propiedadActual.getPropietario().setDinero(propiedadActual.getPropietario().getDinero() + propiedadActual.getRenta());
                            textAreaInfo.append("Estado: Pago de renta a " + propiedadActual.getPropietario().getNombre() + "\n");
                            actualizarTextArea(jugador, textAreaInfo); // Actualizar información del jugador
                        } else {
                            JOptionPane.showMessageDialog(null, "X Fin del juego X");
                            finalizarJuego(jugador);
                        }
                    }
                }

                break;
                
        }
    
    }
    
    public int obtenerIndiceCasilla(JPanel ficha, JPanel[] casillasP) {
        
        for (int i = 0; i < casillasP.length; i++) {
            
            if (Arrays.asList(casillasP[i].getComponents()).contains(ficha)){
                
                return i;
                
            }
            
        }
        
        return -1;
        
    }
    
    public void actualizarTextArea(Jugador jugador, JTextArea textAreaInfo) {
        
        textAreaInfo.setText("Turno de: " + jugador.getNombre() + "\n" +
                             "Dinero: " + jugador.getDinero() + "\n" +
                             "Propiedades: " + jugador.getPropiedades().size());
        
    }
    
    void reiniciarJuego(ArrayList<Jugador> jugadores, ArrayList<Casilla> casillas, JTextArea textAreaInfo) {
        // Reiniciar jugadores
        for (Jugador jugador : jugadores) {
            jugador.setDinero(0); // Establece la cantidad inicial de dinero (ajústala según tus reglas)
            jugador.getPropiedades().clear(); // Elimina todas las propiedades del jugador
            jugador.setEliminado(false); // Marca al jugador como no eliminado
        }

        // Reiniciar propiedades
        for (Casilla casilla : casillas) {
            if (casilla.getPropiedad() != null) {
                casilla.getPropiedad().setPropietario(null); // Elimina el propietario de la propiedad
            }
        }

        // Reiniciar interfaz de usuario
        textAreaInfo.setText(""); // Limpia el JTextArea
        for (Jugador jugador : jugadores) {
            textAreaInfo.append(jugador.getNombre() + " - Dinero: $" + jugador.getDinero() + "\n");
        }

        // Reiniciar turno
        setTurno(0); // Establece el turno al primer jugador
    }
    
    public void imprimirJugadoresCasillas(ArrayList<Jugador> participantes, JTextArea txtInfo, ArrayList<Casilla> casillas) {

        System.out.println("Jugadores y propiedades");
        System.out.println("---------");
        
        actualizarTextArea(participantes.get(0), txtInfo);
        
        for (int i = 0; i < participantes.size(); i++) {

            System.out.println(participantes.get(i).getNombre());

        }
        
        System.out.println("----------");
        
        for (int i = 0; i < casillas.size(); i++) {

            System.out.println(casillas.get(i).getNombre());

        }
        
        System.out.println("");

    }
    
    public boolean buttonPressed(JButton siguienteTurno){
        
        return true;
        
    }

    public JPanel encontrarPanelContenedor(JPanel panelBuscado, JPanel[] casillasP) {

        for (JPanel panel : casillasP) {

            Component[] componentes = panel.getComponents();

            for (Component componente : componentes) {

                if (componente.equals(panelBuscado)) {

                    return panel;

                }

            }

        }

        return null;

    }

}