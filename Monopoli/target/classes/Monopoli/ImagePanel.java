package Monopoli;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ImagePanel extends JPanel {
    
    private Image image;
    
    public ImagePanel(String imagePath) {
        
        // Obtener el ClassLoader para cargar recursos desde el classpath
        ClassLoader classLoader = getClass().getClassLoader();

        // Obtener la URL de la imagen utilizando getResource()
        URL imageUrl = classLoader.getResource(imagePath);

        if (imageUrl != null) {
            try {
                // Convertir la URL en un archivo y leer la imagen
                File imageFile = new File(imageUrl.toURI());
                image = ImageIO.read(imageFile);
            } catch (IOException | NullPointerException | IllegalArgumentException | java.net.URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("No se encontró el recurso: " + imagePath);
        }
    }

    // Sobrescribir el método paintComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Dibuja la imagen en el panel
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
