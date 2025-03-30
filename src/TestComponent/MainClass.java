package TestComponent;

import ComponentCustoms.JavaWindowPlus;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

public class MainClass extends javax.swing.JPanel {
    
    public MainClass() {
        initComponents();
        this.setPreferredSize(new Dimension(841, 535));
        javaImagenPlus1.setImagenPlus("resources", "computer.png");
        JavaWindowPlus wind = new JavaWindowPlus(this);
        wind.setWindowBorderColor(new Color(5,7,9));
        wind.setForeIconColor(Color.CYAN);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        javaScrollPanePlus1 = new ComponentCustoms.JavaScrollPanePlus();
        jMarkdonwEditor1 = new ComponentCustoms.JMarkdonwEditor();
        javaButtonPlus1 = new ComponentCustoms.JavaButtonPlus();
        javaComboPlus1 = new ComponentCustoms.JavaComboPlus();
        javaImagenPlus1 = new ComponentCustoms.JavaImagenPlus();

        setLayout(new java.awt.BorderLayout());

        javaPanelPlus2.setCOLORGRADIENT1(new java.awt.Color(27, 48, 58));
        javaPanelPlus2.setCOLORGRADIENT2(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT3(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT4(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT5(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT6(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT7(new java.awt.Color(13, 17, 23));
        javaPanelPlus2.setCOLORGRADIENT8(new java.awt.Color(27, 48, 58));
        javaPanelPlus2.setNumGradients(8);
        javaPanelPlus2.setVisibleGradient(true);
        javaPanelPlus2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 100)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("PLUS");
        javaPanelPlus2.add(jLabel1);
        jLabel1.setBounds(30, 20, 250, 170);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("JAVA COMPONENTS");
        javaPanelPlus2.add(jLabel2);
        jLabel2.setBounds(30, 0, 360, 80);

        javaScrollPanePlus1.setScrollThumbColor(new java.awt.Color(102, 0, 102));
        javaScrollPanePlus1.setScrollTrackColor(new java.awt.Color(153, 153, 255));
        javaScrollPanePlus1.setToolTipText("");
        javaScrollPanePlus1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        javaScrollPanePlus1.setViewportView(jMarkdonwEditor1);

        javaPanelPlus2.add(javaScrollPanePlus1);
        javaScrollPanePlus1.setBounds(410, 0, 430, 540);

        javaButtonPlus1.setBackground(new java.awt.Color(10, 10, 40));
        javaButtonPlus1.setBackgroundPlus(new java.awt.Color(13, 17, 23));
        javaButtonPlus1.setBorderColor(new java.awt.Color(27, 48, 58));
        javaButtonPlus1.setBorderSize(2);
        javaButtonPlus1.setFontPlus(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        javaButtonPlus1.setForeground(new java.awt.Color(0, 204, 255));
        javaButtonPlus1.setRadius(40);
        javaButtonPlus1.setText("START");
        javaPanelPlus2.add(javaButtonPlus1);
        javaButtonPlus1.setBounds(110, 410, 190, 50);

        javaComboPlus1.setBackgroundPlus(new java.awt.Color(27, 36, 48));
        javaComboPlus1.setForegroundPlus(new java.awt.Color(255, 255, 255));
        javaComboPlus1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "user1", "user2" }));
        javaComboPlus1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        javaComboPlus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaComboPlus1ActionPerformed(evt);
            }
        });
        javaPanelPlus2.add(javaComboPlus1);
        javaComboPlus1.setBounds(290, 90, 100, 30);
        javaPanelPlus2.add(javaImagenPlus1);
        javaImagenPlus1.setBounds(60, 160, 290, 240);

        add(javaPanelPlus2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void javaComboPlus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaComboPlus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_javaComboPlus1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private ComponentCustoms.JMarkdonwEditor jMarkdonwEditor1;
    private ComponentCustoms.JavaButtonPlus javaButtonPlus1;
    private ComponentCustoms.JavaComboPlus javaComboPlus1;
    private ComponentCustoms.JavaImagenPlus javaImagenPlus1;
    private ComponentCustoms.JavaPanelPlus javaPanelPlus2;
    private ComponentCustoms.JavaScrollPanePlus javaScrollPanePlus1;
    // End of variables declaration//GEN-END:variables
}
