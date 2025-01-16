package JavaComponentsPlus;

import javax.swing.*;
import java.awt.*;
import java.beans.BeanProperty;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class JavaImagenPlus extends JLabel {
     //+++++++++++++++++++++ SETTERS+++++++++++++++++++++++++++++++ //
    @BeanProperty(preferred = true, visualUpdate = true) 
    public void setImage(File file) {
        if (isValidImageFile(file)) {  // Verificar si el archivo es válido
            try {
                image = ImageIO.read(file); 
                imageLoaded = true;
                revalidate();
                repaint();
            } catch (IOException e) {
                System.err.println("Error al cargar la imagen: " + e.getMessage());
                imageLoaded = false;
            }
        } else {
            System.err.println("Archivo no válido o no es una imagen.");
            imageLoaded = false;
        }
    }   
    
//+++++++++++++++++++++START CODE MAIN+++++++++++++++++++++++++++++++ //

    public JavaImagenPlus() {
      setBounds(0, 0, 100, 100);
       setPreferredSize(new Dimension(100, 100));  
    }


    public JavaImagenPlus(File file) {
        setBounds(0, 0, 100, 100);
        setPreferredSize(new Dimension(100, 100));  
        setImage(file); 
    }

   //+++++++++++++++++++++ IMAGEN +++++++++++++++++++++++++++++++ //
    /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | ~ ~ ~ Method:    setImagenPlus                                                                        |
    | ~Description:   Establece la imagen desde recursos dentro del proyecto.       |
    +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
        private transient Image image;  // Imagen que se cargará
    private boolean imageLoaded = false;  // Estado de carga de imagen

    public void setImagenPlus(String carpetaDeProyecto, String nameImg) {
        if (carpetaDeProyecto != null && nameImg != null) {
            try {
                Image img = new ImageIcon(getClass().getResource("/" + carpetaDeProyecto + "/" + nameImg)).getImage();
                image = img;
                imageLoaded = true;
                revalidate();
                repaint();
            } catch (Exception e) {
                System.err.println("Error cargando imagen desde el proyecto: " + e.getMessage());
                imageLoaded = false;
            }
        } else {
            System.err.println("Carpeta o nombre de imagen inválido.");
            imageLoaded = false;
        }
    }

    private boolean isValidImageFile(File file) {
        try {
            // Intentar leer la imagen y verificar su validez
            return ImageIO.read(file) != null;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageLoaded && image != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);  // Redibujar imagen ajustada al tamaño
            g2d.dispose();
        }
    }
    //+++++++++++++++++++++END CODE MAIN+++++++++++++++++++++++++++++++ //
}
