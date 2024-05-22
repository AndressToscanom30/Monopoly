package Monopoli;

import java.util.Random;

/*@author Andrés Toscano*/

public class Dado {
    
    private int resultado;
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    public int tirarDado(){
        
        resultado = random.nextInt(6) + 1;
        return resultado;
        
    }
    
}