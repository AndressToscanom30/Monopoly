package Monopoli;

/*@author Andrés Toscano*/
import javax.swing.*;
import java.awt.*;

public class Ficha extends JPanel {
    
    private Color color;

    public Ficha() {
    }
    
    public Ficha(Color color) {
        
        this.color = color;
        setOpaque(false);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(0, 0, getWidth(), getHeight());
        
    }
    
}