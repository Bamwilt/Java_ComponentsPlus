package ComponentCustoms;

import javax.swing.*;
import java.awt.*;
import javax.swing.tree.*;
import java.beans.BeanProperty;

public class JavaTreePlus extends JTree {
    // +++++++++++++++++++++ PROPIEDADES GETTERS Y SETTERS +++++++++++++++++++++ //
    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getForegroundPlus() {
        return foregroundColor;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setForegroundPlus(Color color) {
        foregroundColor = color;
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Font getFontPlus() {
        return super.getFont();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setFontPlus(Font font) {
        super.setFont(font);
        repaint();
    }

    // +++++++++++++++++++++ VARIABLES INTERNAS +++++++++++++++++++++ //
    private Color backgroundColor = new Color(30, 40, 60); 
    private Color foregroundColor = Color.WHITE; 

    // +++++++++++++++++++++ CONSTRUCTORES +++++++++++++++++++++ //
    public JavaTreePlus() {
        super();
        Config();
    }

    public JavaTreePlus(TreeNode root) {
        super(root);
        Config();
    }
    // +++++++++++++++++++++ CONFIGURACIÓN INICIAL +++++++++++++++++++++ //
    private void Config() {
        setBounds(0, 0, 200, 200); 
        setOpaque(true); 
        setBackground(backgroundColor); 
        setCellRenderer(new CustomTreeCellRenderer());
        setFont(new Font("Segoe IU", Font.BOLD, 12));
        setBorder(null); 
    }

    // +++++++++++++++++++++ CLASE RENDERER PERSONALIZADO +++++++++++++++++++++ //
    private class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            setBackgroundNonSelectionColor(new Color(0, 0, 0, 0)); 
            setForeground(foregroundColor);

            setOpaque(true); 

            return this;
        }
    }
}
