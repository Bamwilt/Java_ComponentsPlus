package ComponentCustoms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import java.awt.LinearGradientPaint;
import java.beans.BeanProperty;

public class JavaPanelPlus extends JPanel {

    private Color COLORGRADIENT1 = new Color(98, 114, 164);
    private Color COLORGRADIENT2 = new Color(80, 250, 123);
    private Color COLORGRADIENT3 = new Color(249, 38, 114);
    private Color COLORGRADIENT4 = new Color(241, 250, 140);
    private Color COLORGRADIENT5 = new Color(255, 121, 198);
    private Color COLORGRADIENT6 = new Color(189, 147, 249);
    private Color COLORGRADIENT7 = new Color(139, 233, 253);
    private Color COLORGRADIENT8 = new Color(255, 184, 108);

    private int NUM_GRADIENTS = 1;
    private int DIRECTIONGRADIENT = 1;
    private int RADIUS = 0;
    private boolean visibleGradient = false;

    private Color borderColor = Color.CYAN;
    private int borderThickness = 0;

    public JavaPanelPlus() {
        setOpaque(false);
        setBackground(new Color(56, 96, 95));
    }

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
    public Color getCOLORGRADIENT3() {
        return COLORGRADIENT3;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT3(Color color) {
        this.COLORGRADIENT3 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT4() {
        return COLORGRADIENT4;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT4(Color color) {
        this.COLORGRADIENT4 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT5() {
        return COLORGRADIENT5;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT5(Color color) {
        this.COLORGRADIENT5 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT6() {
        return COLORGRADIENT6;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT6(Color color) {
        this.COLORGRADIENT6 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT7() {
        return COLORGRADIENT7;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT7(Color color) {
        this.COLORGRADIENT7 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getCOLORGRADIENT8() {
        return COLORGRADIENT8;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setCOLORGRADIENT8(Color color) {
        this.COLORGRADIENT8 = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public int getNumGradients() {
        return NUM_GRADIENTS;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setNumGradients(int numGradients) {
        this.NUM_GRADIENTS = Math.max(1, Math.min(8, numGradients));
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public int getDirectionGradient() {
        return DIRECTIONGRADIENT;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setDirectionGradient(int direction) {
        this.DIRECTIONGRADIENT = Math.max(1, Math.min(4, direction));
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
    public Color getBorderColor() {
        return borderColor;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBorderColor(Color color) {
        this.borderColor = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public int getBorderThickness() {
        return borderThickness;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBorderThickness(int thickness) {
        this.borderThickness = Math.max(1, thickness);
        repaint();
    }

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

        if (borderThickness > 0) {
            g2.setColor(borderColor);
            g2.setStroke(new java.awt.BasicStroke(borderThickness));
            g2.draw(roundedRect);
        }

        g2.dispose();
    }

    private LinearGradientPaint createGradient(int width, int height) {
        float[] fractions;
        Color[] colors;

        switch (NUM_GRADIENTS) {
            case 1:
                fractions = new float[]{0f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT1};
                break;
            case 2:
                fractions = new float[]{0f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2};
                break;
            case 3:
                fractions = new float[]{0f, 0.5f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2, COLORGRADIENT3};
                break;
            case 4:
                fractions = new float[]{0f, 0.33f, 0.66f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2, COLORGRADIENT3, COLORGRADIENT4};
                break;
            case 5:
                fractions = new float[]{0f, 0.25f, 0.5f, 0.75f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2, COLORGRADIENT3, COLORGRADIENT4, COLORGRADIENT5};
                break;
            case 6:
                fractions = new float[]{0f, 0.2f, 0.4f, 0.6f, 0.8f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2, COLORGRADIENT3, COLORGRADIENT4, COLORGRADIENT5, COLORGRADIENT6};
                break;
            case 7:
                fractions = new float[]{0f, 0.166f, 0.333f, 0.5f, 0.666f, 0.833f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2, COLORGRADIENT3, COLORGRADIENT4, COLORGRADIENT5, COLORGRADIENT6, COLORGRADIENT7};
                break;
            default:
                fractions = new float[]{0f, 0.142f, 0.285f, 0.428f, 0.571f, 0.714f, 0.857f, 1f};
                colors = new Color[]{COLORGRADIENT1, COLORGRADIENT2, COLORGRADIENT3, COLORGRADIENT4, COLORGRADIENT5, COLORGRADIENT6, COLORGRADIENT7, COLORGRADIENT8};
                break;
        }

        float startX, startY, endX, endY;

        switch (DIRECTIONGRADIENT) {
            case 1:
                startX = 0;
                startY = 0;
                endX = 0;
                endY = height;
                break;
            case 2:
                startX = 0;
                startY = 0;
                endX = width;
                endY = 0;
                break;
            case 3:
                startX = 0;
                startY = 0;
                endX = width;
                endY = height;
                break;
            default:
                startX = 0;
                startY = height;
                endX = width;
                endY = 0;
                break;
        }

        return new LinearGradientPaint(startX, startY, endX, endY, fractions, colors);
    }
}
