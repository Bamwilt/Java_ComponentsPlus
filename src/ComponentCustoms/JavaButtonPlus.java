package ComponentCustoms;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.beans.BeanProperty;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class JavaButtonPlus extends JButton {

    //+++++++++++++++++++++    COMMANDS GETTERS Y SETTERS    +++++++++++++++++++++ //
    @BeanProperty(preferred = true, visualUpdate = true)
    //========
    public void SetToolTipPlus(String Text) {
        TooltipText = Text;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    //========
    public String getToolTipPlus() {
        return TooltipText;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    //========
    public Color getBackgroundPlus() {
        return COLORBACKGROUND;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    //========
    public void setBackgroundPlus(Color color) {
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

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBorderSize(int size) {
        borderSize = size;
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

    private Color COLORBACKGROUND = new Color(230, 230, 255);
    private Color COLORCLICK;
    private Color COLORHOVER;
    private int RadiusEsquina = 0;
    private int borderSize = 0;
    private Color borderColor = new Color(50, 50, 50); // Color del borde

    private void Config() {

        setFontPlus(new Font("Dialog", 1, 12));
        setBounds(0, 0, 80, 30);
        setForeground(new Color(10, 10, 40));
        setFocusPainted(false);
        setColorHolderClick();
        setBorderPainted(false);
        setOpaque(false);
        AddTooltipListener();

    }
    Point LocationButton;
    Dimension SizeButton;
    Timer TooltipDisplay;
    Window TooltipPopup = new Window(null);
    private String TooltipText = "";
    private String TooltipTextCurrent = "";
    JLabel TextDisplay = new JLabel();
    private int SizeFont = 12;
    private int MarginTooltip = 5;
    Font StileFont = new Font("Dialog", 1, SizeFont);

    private void AddTooltipListener() {
        AddTooltip();
        ConfigTimer();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (TooltipText.isEmpty()) {
                    return;
                }
                TooltipDisplay.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                TooltipDisplay.stop();
                TooltipPopup.setVisible(false);
            }
        });
    }

    private void AddTooltip() {
        TextDisplay.setFont(StileFont);
        TextDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        TooltipPopup.setLayout(new BorderLayout());
        TooltipPopup.add(TextDisplay);
    }

    private void ConfigTimer() {
        TooltipDisplay = new Timer(1500, (ActionEvent e) -> {
            CheckRedimension();
            TooltipPopup.setBackground(this.getBackgroundPlus().darker());
            TextDisplay.setForeground(this.getForeground().brighter());
            TooltipPopup.setOpacity(0.7f);
            TooltipPopup.setVisible(true);
            LocationPosition(4);
        });
        TooltipDisplay.setRepeats(false);
    }

    // TODO: VERIFICAR QUE X y Y CUMPLAN EL MINIMO DE 80X & 20Y
    Map<Integer, Runnable> MapSetLocation = new HashMap<>() {
        {
            put(1, () -> TooltipPopup.setLocation(LocationButton.x, LocationButton.y + SizeButton.height + MarginTooltip));
            put(2, () -> TooltipPopup.setLocation(LocationButton.x, LocationButton.y - TooltipPopup.getSize().height - MarginTooltip));
            put(3, () -> TooltipPopup.setLocation(LocationButton.x - TooltipPopup.getSize().width - MarginTooltip, LocationButton.y));
            put(4, () -> TooltipPopup.setLocation(LocationButton.x + SizeButton.width + MarginTooltip, LocationButton.y));
        }
    };

    private void LocationPosition(int Locat) {
        LocationButton = new Point(this.getLocationOnScreen());
        SizeButton = new Dimension(this.getSize());
        MapSetLocation.get(Locat).run();
    }

    private void CheckRedimension() {
        if (!TooltipTextCurrent.equals(TooltipText)) {
            TooltipTextCurrent = TooltipText;
            TextDisplay.setText(TooltipText);
            TooltipPopup.setSize(SizeToolTip());
        }
    }

    private Dimension SizeToolTip() {

        FontMetrics fontMetrics = getFontMetrics(StileFont);
        int sizeToolTipX = fontMetrics.stringWidth(TooltipText) + SizeFont;
        int sizeToolTipY = fontMetrics.getHeight();

        return new Dimension(sizeToolTipX, sizeToolTipY);
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

        RoundRectangle2D rect = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, RadiusEsquina, RadiusEsquina);

        if (getModel().isPressed()) {
            g2.setColor(COLORCLICK);
        } else if (getModel().isRollover()) {
            g2.setColor(COLORHOVER);
        } else {
            g2.setColor(COLORBACKGROUND);
        }
        g2.fill(rect);

        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
        g2.draw(rect);

        g2.setColor(getForeground());
        g2.setFont(getFont());
        FontMetrics fm = g2.getFontMetrics(getFont());
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(getText(), x, y);

        g2.dispose();
    }

    //+++++++++++++++++++++ END CODE MAIN +++++++++++++++++++++ //
}
