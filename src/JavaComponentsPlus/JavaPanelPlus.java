 package JavaComponentsPlus;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import java.beans.BeanProperty;
import java.awt.LinearGradientPaint;

public class JavaPanelPlus extends JPanel {

    //+++++++++++++++++++++ GETTERS Y SETTERS +++++++++++++++++++++ //

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT1() {
        return COLORGRADIENT1;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT1(Color color) {
        this.COLORGRADIENT1 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT2() {
        return COLORGRADIENT2;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT2(Color color) {
        this.COLORGRADIENT2 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public int getRADIUS() {
        return RADIUS;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setRADIUS(int radius) {
        this.RADIUS = radius;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public boolean isVisibleGradient() {
        return visibleGradient;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setVisibleGradient(boolean visibleGradient) {
        this.visibleGradient = visibleGradient;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public int getDirectionGradient() {
        return DIRETIONGRADIENT;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setDirectionGradient(int direction) {
        this.DIRETIONGRADIENT = direction;
        repaint();
    }
     //+++++++++++++++++++++ START CODE MAIN +++++++++++++++++++++ //
    private Color COLORGRADIENT1 = new Color(70,70,85);
    private Color COLORGRADIENT2 = new Color(10,10,25);

    private int DIRETIONGRADIENT = 1;
    private int RADIUS = 0;
    private boolean visibleGradient = false;

    public JavaPanelPlus() {
    setOpaque(false); 
    }

     //+++++++++++++++++++++ PAINT PANEL+++++++++++++++++++++ //
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), RADIUS, RADIUS);

        if (visibleGradient) {
            LinearGradientPaint gradientPaint = createGradient(getWidth(), getHeight());
            g2.setPaint(gradientPaint);
            g2.fill(roundedRect);
        } else {
            g2.setColor(getBackground());
            g2.fill(roundedRect);
        }

        g2.dispose();
    }
     //+++++++++++++++++++++ GRADIENT DIRECTION +++++++++++++++++++++ //
private LinearGradientPaint createGradient(int width, int height) {
    switch (DIRETIONGRADIENT) {
        case 1: // Arriba a Abajo
            return new LinearGradientPaint(0, 0, 0, height, 
                    new float[]{0f, 1f},
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2});
        case 2: // Izquierda a Derecha
            return new LinearGradientPaint(0, 0, width, 0, 
                    new float[]{0f, 1f},
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2});
        case 3: // Esquina superior derecha a inferior izquierda
            return new LinearGradientPaint(0, 0, width, height, 
                   new float[]{0f, 1f},
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2});
        case 4: // Esquina superior izquierda a inferior derecha
            return new LinearGradientPaint(0, 0, width, height, 
                    new float[]{0f, 1f},
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2});
          case 5: // Arriba a Abajo
            return new LinearGradientPaint(0, 0, 0, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f}, 
                    new Color[]{COLORGRADIENT1, COLORGRADIENT1.darker(),COLORGRADIENT2 , COLORGRADIENT2.darker()});
        case 6: // Izquierda a Derecha
            return new LinearGradientPaint(0, 0, width, 0, 
                    new float[]{0f, 0.33f, 0.66f, 1f},
                    new Color[]{COLORGRADIENT1,  COLORGRADIENT1.darker(),COLORGRADIENT2 , COLORGRADIENT2.darker()});
        case 7: // Esquina superior derecha a inferior izquierda
            return new LinearGradientPaint(0, 0, width, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f}, 
                       new Color[]{COLORGRADIENT1,  COLORGRADIENT1.darker(),COLORGRADIENT2 , COLORGRADIENT2.darker()});
        case 8: // Esquina superior izquierda a inferior derecha
            return new LinearGradientPaint(0, 0, width, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f},
                    new Color[]{COLORGRADIENT1,  COLORGRADIENT1.darker(),COLORGRADIENT2 , COLORGRADIENT2.darker()});
        case 9: // Arriba a Abajo
            return new LinearGradientPaint(0, 0, 0, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f}, 
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2.brighter(),COLORGRADIENT2, COLORGRADIENT2.darker()});
        case 10: // Izquierda a Derecha
            return new LinearGradientPaint(0, 0, width, 0, 
                    new float[]{0f, 0.33f, 0.66f, 1f},
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2.brighter(),COLORGRADIENT2, COLORGRADIENT2.darker()});
        case 11: // Esquina superior derecha a inferior izquierda
            return new LinearGradientPaint(0, 0, width, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f}, 
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2.brighter(),COLORGRADIENT2, COLORGRADIENT2.darker()});
        case 12: // Esquina superior izquierda a inferior derecha
            return new LinearGradientPaint(0, 0, width, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f},
                    new Color[]{COLORGRADIENT1, COLORGRADIENT2.brighter(),COLORGRADIENT2, COLORGRADIENT2.darker()});
        default: // Por defecto: Arriba a Abajo
            return new LinearGradientPaint(0, 0, 0, height, 
                    new float[]{0f, 0.33f, 0.66f, 1f}, 
                    new Color[]{COLORGRADIENT1, COLORGRADIENT1.darker(), COLORGRADIENT2.brighter(), COLORGRADIENT2});
    }
}
         //+++++++++++++++++++++ END CODE MAIN +++++++++++++++++++++ //
}

