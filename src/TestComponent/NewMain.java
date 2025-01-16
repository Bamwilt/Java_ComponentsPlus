package TestComponent;

import JavaComponentsPlus.JavaButtonPlus;
import JavaComponentsPlus.JavaWindowPlus;
import JavaComponentsPlus.JavaComboPlus;
import JavaComponentsPlus.JavaImagenPlus;
import JavaComponentsPlus.JavaPanelPlus;
import java.awt.Color;
import javax.swing.JPanel;

public class NewMain {

    //+++++++++++++++++++++START+++++++++++++++++++++++++++++++ //

    public static void main(String[] args) {
   //Example with  Panel Editor 
   
        MipanelTest PanelEmpress = new MipanelTest();
        JavaWindowPlus WindowsJ = new JavaWindowPlus(PanelEmpress, "Company Empress");
       PanelEmpress.ImageComputer.setImagenPlus("TestComponent", "ComputerImage.png");
        WindowsJ.setSizePlus(817, 507);
        WindowsJ.setBackGroundBorderColor(new Color(20,40,40));
        WindowsJ.setForeIconColor(new Color(0,255,204));
        WindowsJ.setVisible(true);
     
//Example Code ================================
//         JavaPanelPlus PanelPlus = new JavaPanelPlus();
//         PanelPlus.setVisibleGradient(true);
//         PanelPlus.setLayout(null);
// 
//         JavaButtonPlus BotonPlus = new JavaButtonPlus("Boton Plus"); 
//         BotonPlus.setBackgroundPlus(new Color(10,10,50));
//         BotonPlus.setForeground(Color.WHITE);
//         BotonPlus.setLocation(250,50);
//         BotonPlus.setSize(100, 40);
//         BotonPlus.setRadius(20);
//         
//         JavaImagenPlus ImagenPlus = new JavaImagenPlus();
//         ImagenPlus.setImagenPlus("javaComponentsPlus","JavaIcon.png");
//         ImagenPlus.setLocation(300,200);
//         JavaWindowPlus WindowsJ = new JavaWindowPlus(PanelPlus,"Example Window");
//         
//         JavaComboPlus ComboPlus = new JavaComboPlus();
//         ComboPlus.setLocation(100,100);
//         
//         WindowsJ.setVisible(true);
//         WindowsJ.addPlus(ComboPlus);
//         WindowsJ.addPlus(BotonPlus);
//        WindowsJ.addPlus(ImagenPlus);
//Example Code ================================
    }

    //++++++++++++++++++++++END++++++++++++++++++++++++++++++ //

}
