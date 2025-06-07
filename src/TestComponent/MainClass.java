package TestComponent;

import ComponentCustoms.JavaWindowPlus;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

public class MainClass extends javax.swing.JPanel {
    
    public MainClass() {
        initComponents();
        this.setPreferredSize(new Dimension(841, 535));
        JavaWindowPlus wind = new JavaWindowPlus(this);
        wind.setBackgroundPlus(new Color(24,73,92));
        wind.setForegroundPlus(Color.WHITE);
        wind.setVisiblePlusRelativeTo(null);
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(//--
                () -> {
                    MainClass mainClass = new MainClass();
                }
        );//==
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javaPanelPlus2 = new ComponentCustoms.JavaPanelPlus();
        jMarkdonwEditor1 = new ComponentCustoms.JMarkdonwEditor();
        javaButtonPlus1 = new ComponentCustoms.JavaButtonPlus();
        jLabel1 = new javax.swing.JLabel();
        javaComboPlus1 = new ComponentCustoms.JavaComboPlus();
        javaImagenPlus1 = new ComponentCustoms.JavaImagenPlus();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        javaPanelPlus2.setCOLORGRADIENT1(new java.awt.Color(255, 255, 153));
        javaPanelPlus2.setCOLORGRADIENT2(new java.awt.Color(51, 255, 204));
        javaPanelPlus2.setCOLORGRADIENT3(new java.awt.Color(21, 37, 45));
        javaPanelPlus2.setCOLORGRADIENT4(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT5(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT6(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT7(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT8(new java.awt.Color(27, 48, 58));
        javaPanelPlus2.setDirectionGradient(7);
        javaPanelPlus2.setNumGradients(2);
        javaPanelPlus2.setVisibleGradient(true);
        javaPanelPlus2.setLayout(null);
        javaPanelPlus2.add(jMarkdonwEditor1);
        jMarkdonwEditor1.setBounds(120, 220, 510, 230);

        javaButtonPlus1.setBackgroundPlus(new java.awt.Color(204, 255, 255));
        javaButtonPlus1.setFontPlus(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        javaButtonPlus1.setForeground(new java.awt.Color(24, 73, 92));
        javaButtonPlus1.setRadius(25);
        javaButtonPlus1.setText("Try it now");
        javaPanelPlus2.add(javaButtonPlus1);
        javaButtonPlus1.setBounds(310, 480, 150, 50);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 73, 92));
        jLabel1.setText("<html>\n<p style='font-size:24px;'>Java component</p>\n<p><b><span style='font-size:72px;'>PLUS</span></b></p>\n</html>");
        javaPanelPlus2.add(jLabel1);
        jLabel1.setBounds(250, 30, 280, 200);

        javaComboPlus1.setBackgroundPlus(new java.awt.Color(0, 255, 204));
        javaComboPlus1.setForegroundPlus(new java.awt.Color(51, 51, 51));
        javaComboPlus1.setMaximumRowCount(100);
        javaComboPlus1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Options", "Option 2" }));
        javaComboPlus1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        javaPanelPlus2.add(javaComboPlus1);
        javaComboPlus1.setBounds(710, 10, 120, 30);

        javaImagenPlus1.setBrightness(0.5F);
        javaImagenPlus1.setImage(new java.io.File("C:\\Users\\Bryan Maradiaga\\Downloads\\texture2.png"));
        javaImagenPlus1.setOpacity(0.1F);
        javaImagenPlus1.setRotation(60.0F);
        javaImagenPlus1.setScaleX(0.5F);
        javaPanelPlus2.add(javaImagenPlus1);
        javaImagenPlus1.setBounds(100, 20, 1050, 980);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(24, 73, 92));
        jLabel2.setText("Versions");
        javaPanelPlus2.add(jLabel2);
        jLabel2.setBounds(100, 10, 90, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(24, 73, 92));
        jLabel3.setText("Update");
        javaPanelPlus2.add(jLabel3);
        jLabel3.setBounds(10, 10, 70, 20);

        add(javaPanelPlus2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private ComponentCustoms.JMarkdonwEditor jMarkdonwEditor1;
    private ComponentCustoms.JavaButtonPlus javaButtonPlus1;
    private ComponentCustoms.JavaComboPlus javaComboPlus1;
    private ComponentCustoms.JavaImagenPlus javaImagenPlus1;
    private ComponentCustoms.JavaPanelPlus javaPanelPlus2;
    // End of variables declaration//GEN-END:variables
}
