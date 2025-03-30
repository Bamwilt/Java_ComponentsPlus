package ComponentCustoms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.beans.BeanProperty;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class JavaScrollPanePlus extends JScrollPane {

    // +++++++++++++++++++++ PROPIEDADES GETTERS Y SETTERS +++++++++++++++++++++ //
    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getScrollTrackColor() {
        return scrollTrackColor;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setScrollTrackColor(Color color) {
        scrollTrackColor = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getScrollThumbColor() {
        return scrollThumbColor;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setScrollThumbColor(Color color) {
        scrollThumbColor = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public int getThumbWidth() {
        return thumbWidth;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setThumbWidth(int width) {
        thumbWidth = width;
        revalidate();
        repaint();
    }

    // +++++++++++++++++++++ VARIABLES INTERNAS +++++++++++++++++++++ //
    private Color scrollTrackColor = new Color(118,104,125); // Color inicial del track
    private Color scrollThumbColor = new Color(60,68,80); // Color inicial del thumb
    private int thumbWidth = 10; // Ancho inicial del thumb

    // +++++++++++++++++++++ CONSTRUCTORES +++++++++++++++++++++ //
    public JavaScrollPanePlus() {
        getVerticalScrollBar().setUI(new SimpleScrollBarUI());
        getHorizontalScrollBar().setUI(new SimpleScrollBarUI());
        setOpaque(false);
        setPreferredSize(new Dimension(100, 100));
        setSize(100, 100);
        setBounds(0, 0, 100, 100);
        setBorder(null);

    }

    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }

    @Override
    public void updateUI() {
        super.updateUI();
        getVerticalScrollBar().setOpaque(false);
        getHorizontalScrollBar().setOpaque(false);
    }

    // +++++++++++++++++++++ CLASE SIMPLESCROLLBARUI +++++++++++++++++++++ //
    private class SimpleScrollBarUI extends javax.swing.plaf.basic.BasicScrollBarUI {

        @Override
        protected void installDefaults() {
            super.installDefaults();
            scrollbar.setPreferredSize(new Dimension(thumbWidth, thumbWidth));
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(scrollTrackColor);
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            g2.dispose();
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(scrollThumbColor);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
            g2.dispose();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return new JButton();
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return new JButton();
        }
    }
    
    }
