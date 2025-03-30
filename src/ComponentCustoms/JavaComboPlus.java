package ComponentCustoms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.BeanProperty;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

public class JavaComboPlus extends JComboBox {

    //+++++++++++++++++++++ COMMANDS GETTERS Y SETTERS  +++++++++++++++++++++++++++++++ //
    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getBackgroundPlus() {
        return BACKGROUND;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setBackgroundPlus(Color BackG) {
        BACKGROUND = BackG;
        JavaComboUIView.UpdateNewColorUi(BACKGROUND, FOREGROUND);
        setBackground(BACKGROUND);
        setUI(JavaComboUIView);
        repaint();
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public Color getForegroundPlus() {
        return FOREGROUND;
    }

    @BeanProperty(preferred = true, visualUpdate = true)
    public void setForegroundPlus(Color ForeG) {
        FOREGROUND = ForeG;
        JavaComboUIView.UpdateNewColorUi(BACKGROUND, FOREGROUND);
        setForeground(FOREGROUND);
        setUI(JavaComboUIView);
        repaint();
    }

    //+++++++++++++++++++++START CODE MAIN+++++++++++++++++++++++++++++++ //
    // -+-+-+-+-+-+-+-+-+-+-+-+-+-+Constructores
    public JavaComboPlus(String[] Opciones) {
        super(Opciones);
        Config();
    }

    public JavaComboPlus() {
        super(new String[]{"Option 1", "Option 2"});
        Config();
    }

    //+++++++++++++++++++++START CONFIG+++++++++++++++++++++++++++++++ //
    private ComboPlusUI JavaComboUIView;
    private Color BACKGROUND = Color.WHITE;
    private Color FOREGROUND = Color.BLACK;

    private void Config() {
        JavaComboUIView = new ComboPlusUI(BACKGROUND, FOREGROUND);
        setUI(JavaComboUIView);

        setBorder(BorderFactory.createEmptyBorder());
        setBounds(0, 0, 100, 20);
        setBackground(BACKGROUND);
        setForeground(FOREGROUND);

        repaint();
    }

    //+++++++++++++++++++++ CONFIG UI +++++++++++++++++++++++++++++++ //
    private class ComboPlusUI extends BasicComboBoxUI {

        private JButton arrowButton_;

        public ComboPlusUI(Color BackG, Color ForeG) {
            BACKGROUND = BackG;
            FOREGROUND = ForeG;
        }

        public void UpdateNewColorUi(Color BackG, Color ForeG) {
            BACKGROUND = BackG;
            FOREGROUND = ForeG;
            arrowButton_.setForeground(FOREGROUND);
            popupList.setBackground(BACKGROUND);
            popupList.setForeground(FOREGROUND);
            repaint();
        }

        @Override
        protected JButton createArrowButton() {
            arrowButton_ = new JButton("⌵");
            arrowButton_.setBorder(BorderFactory.createEmptyBorder());
            arrowButton_.setForeground(FOREGROUND);
            arrowButton_.setBackground(BACKGROUND);
            return arrowButton_;
        }

        private JList<?> popupList;

        @Override
        protected ComboPopup createPopup() {
            ComboPopup popupOptions = super.createPopup();
            popupList = popupOptions.getList();
            popupList.setBackground(BACKGROUND);
            popupList.setForeground(FOREGROUND);
            return popupOptions;
        }

        @Override
        public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
            super.paintCurrentValue(g, bounds, false);
        }
    }

    public void showpoput() {

    }
    //++++++++++++++++++++++END CODE MAIN++++++++++++++++++++++++++++++ //
}
