package JavaComponentsPlus;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.beans.BeanProperty;
import javax.swing.JButton;

public class JavaButtonPlus extends JButton {

    //+++++++++++++++++++++    COMMANDS GETTERS Y SETTERS    +++++++++++++++++++++ //
    @BeanProperty(preferred = true, visualUpdate = true)
    //========
    public Color getBackgroundPlus(){ return COLORBACKGROUND;}
    
    @BeanProperty(preferred = true, visualUpdate = true)
    //========
    public void setBackgroundPlus(Color color){
        COLORBACKGROUND = color;
        setColorHolderClick();
        repaint();
    }
    @BeanProperty(preferred = true, visualUpdate = true)
        //========
    public Font getFontPlus() {
        return getFont();
    }
    @BeanProperty(preferred = true, visualUpdate = true)
        //========
    public void setFontPlus(Font font) {
        super.setFont(font);
        repaint();
    }
    
    @BeanProperty(preferred = true, visualUpdate = true)
    public int getRadius() {
        return RadiusEsquina;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setRadius(int radius) {
        RadiusEsquina = radius;
        repaint();
    }
    //+++++++++++++++++++++ START CODE MAIN +++++++++++++++++++++ //
    // Constructor
    public JavaButtonPlus() {
    super("Click");
    Config();
    }
    // Constructor
    public JavaButtonPlus(String text) {
    super(text);
    Config();
    }
    //+++++++++++++++++++++ CONFIG +++++++++++++++++++++ //
    
   private Color COLORBACKGROUND = new Color (230,230,255);  
    private Color COLORCLICK;
    private Color COLORHOVER; 
    private int RadiusEsquina = 0;
    
    private void Config(){
    setBounds(0, 0, 80, 30);
    setForeground( new Color (10,10,40));
    setFocusPainted(false);
    setColorHolderClick();
    setBorderPainted(false);
    setOpaque(false);  
    }
    //+++++++++++++++++++++ BUTTONPAINT +++++++++++++++++++++ //
        private void setColorHolderClick() {
        COLORHOVER = DefineColors(COLORBACKGROUND, 20); // Más claro
        COLORCLICK = DefineColors(COLORBACKGROUND, -40); // Más oscuro
        }
        
       private Color DefineColors(Color color, int Background) {
        int red = Math.max(0, Math.min(255, color.getRed() + Background));
        int green = Math.max(0, Math.min(255, color.getGreen() + Background));
        int blue = Math.max(0, Math.min(255, color.getBlue() + Background));
        return new Color(red, green, blue);
       }
       
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            RoundRectangle2D RectanguloEsquinas = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), RadiusEsquina, RadiusEsquina);
            if (getModel().isPressed()) {
                g2.setColor(COLORCLICK);
            } else if (getModel().isRollover()) {
                g2.setColor(COLORHOVER);
            } else {
                g2.setColor(COLORBACKGROUND);
            }
             g2.fill(RectanguloEsquinas);

            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics InfoFont = g2.getFontMetrics(getFont()); // Esto proporciona información sobre el tamaño del texto, como su ancho y alto.
            int x = (getWidth() - InfoFont.stringWidth(getText())) / 2; //Centrar =  Boton - Texto / 2
            int y = (getHeight() - InfoFont.getHeight()) / 2 + InfoFont.getAscent(); // Boton - Texto / 2 + Linea de Texto
            g2.drawString(getText(), x, y);
            
           g2.dispose();
        }
    //+++++++++++++++++++++ END CODE MAIN +++++++++++++++++++++ //
}
