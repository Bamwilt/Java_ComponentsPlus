package JavaComponentsPlus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.concurrent.CompletableFuture;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JavaWindowPlus extends javax.swing.JFrame{
    //+++++++++++++++++++++COMMANDS  GETTERS Y SETTERS +++++++++++++++++++++++++++++++ //
//   @BeanProperty(preferred = true, visualUpdate = true) 
     public void addPlus(Component Componente) {
        PANEL_CONTENT.add(Componente);
        PANEL_CONTENT.revalidate();
        PANEL_CONTENT.repaint();
     }

    public void setForeIconColor(Color ForeColor){
        this.COLORFOREICON = ForeColor;
        TitleB.Title.setForeground(COLORFOREICON);
        for (int i = 1; i<5; i++){
        JLabel Simbol = (JLabel) TitleB.Botons[i].getComponent(0);
        Simbol.setForeground(COLORFOREICON);
        }
        repaint();    
    }

    public void setIconPlus(String carpetadeProyecto,String nameImg){
        TitleB.Icon.setIcon(carpetadeProyecto, nameImg);
        repaint();
    }
     
     public void setBottonExitColor(Color color) {
      this.COLOR_EXIT= color;
     repaint();
    }

      public void setBackGroundBorderColor(Color color) {
      this.COLORBORDER = color;
      EnteredBotonColors(COLORBORDER);
       getContentPane().setBackground(COLORBORDER);
       TitleB.setBackground(COLORBORDER);
       ContentPanel.setBackground(COLORBORDER);
         for (int i=1; i<5;i++)
         {
         TitleB.Botons[i].setBackground(COLORBORDER);
          }    
      }

      public void setMarginBorder(int margin) {
       
          if(margin<0){ return;}
          int newMargin = (margin > 35 ) ? (margin - MARGIN) : 35 ;
   
        TitleB.setSize(TitleB.getWidth()-(newMargin*2),TitleB.getHeight());
        TitleB.setLocation( TitleB.getX()+newMargin,  TitleB.getY()+newMargin);
        ContentPanel.setSize(TitleB.getWidth(), ContentPanel.getHeight()-(newMargin*2));
        ContentPanel.setLocation( TitleB.getX(),  TitleB.getY()+TITLEBAR_HEIGHT);
        
        repaint();
         ActualizarRedimension();
        }

      public void setTitleBarHeight(int height) {
         this.TITLEBAR_HEIGHT = height;
        TitleB.setSize(TitleB.getWidth(),TITLEBAR_HEIGHT);
         repaint();
        }
      
        public void setWidthPlus(int XWidth){
         if(XWidth<MIN_WIDTH){XWidth=MIN_WIDTH;}
         setSize( XWidth+(MARGIN*2),  getHeight());
         ActualizarRedimension();
         setLocationRelativeTo(null); 
        }
        
        public void setHeigthPlus(int YHeigth){
         if(YHeigth<MIN_HEIGHT){YHeigth=MIN_HEIGHT;}
         setSize( getWidth(),  YHeigth+(MARGIN*2+TITLEBAR_HEIGHT));
         ActualizarRedimension();
        setLocationRelativeTo(null);  
        }
    
         public void setSizePlus(int XWidth ,int Y){
         if(XWidth<MIN_WIDTH){XWidth=MIN_WIDTH;}
         if(Y<MIN_HEIGHT){Y=MIN_HEIGHT;}
         setSize( XWidth+(MARGIN*2),  Y+(MARGIN*2+TITLEBAR_HEIGHT));
        ActualizarRedimension();
        setLocationRelativeTo(null);
        }
        
        public void setResizablePlus(boolean Check){
          if (RESIZABLE == Check) { return;  }
          RESIZABLE = Check;
          JLabel Simbol = (JLabel) TitleB.Botons[4].getComponent(0);
             
         if (Check) {
            addMouseListener(mouseAdapter);
             addMouseMotionListener(motionAdapter);
             TitleB.Botons[2].addMouseListener(maximizeAdapter);
             Simbol.setText("🕂");
             MensajeTituloResize("Unlocked");
        } else {
            removeMouseListener(mouseAdapter);
            removeMouseMotionListener(motionAdapter);
            TitleB.Botons[2].removeMouseListener(maximizeAdapter);
             Simbol.setText("🕀");
             setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
             MensajeTituloResize("Blocked");
        }
            ActualizarRedimension();
        }
        
        public void setTitlePlus(String Titulo_){
           Titulo=Titulo_;
           TitleB.Title.setText(Titulo);
            ActualizarRedimension();
        }
        
    //+++++++++++++++++++++START CODE MAIN +++++++++++++++++++++++++++++++ //
        private final JPanel PANEL_CONTENT;
    // Constructor
    public JavaWindowPlus(JPanel PANEL_CONTENT_) 
    {
        setTitle("JavaWindowPlus");
        PANEL_CONTENT = PANEL_CONTENT_;
        
        Config();
    }
        private String Titulo;
        
        public JavaWindowPlus(JPanel PANEL_CONTENT_,String Titulo_)
        {
        PANEL_CONTENT=PANEL_CONTENT_;
        Titulo= Titulo_;
        Config();
        }
 
    //+++++++++++++++++++++START CONFIG+++++++++++++++++++++++++++++++ //
     /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+
     | ~ ~ ~ Method:Configuracion                                                                                  |
     | ~Include:Configuraciones Basicas y acoplamiento de componentes mejorados; |
     +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+*/
        
        private int RESIZEX,RESIZEY,SIZEX=550,SIZEY=400;
        private  TitleBar TitleB;
        private   JPanel  ContentPanel;
        private int TITLEBAR_HEIGHT= 40;//Altura del TitleBar
        private final int MARGIN = 5;//Margen del Borde Con el Contenido      
        
        private static final int MIN_BORDER_SIZE = 12;  // Tamaño mínimo del borde
        private static final int MAX_BORDER_SIZE = 60;  // Tamaño máximo del borde
        private static final int MIN_WIDTH = 340;  // Ancho mínimo de la ventana
        private static final int MIN_HEIGHT = 48;  // Altura mínima de la ventana

        private int BORDER_SIZE = MIN_BORDER_SIZE;  // Tamaño inicial del borde

        private Color COLORFOREICON = Color.WHITE;// color Icono, Texto de Botones y titulos
        private Color COLORBORDER= new Color(25, 25, 30);//Color de Borde y title bar
        private Color COLORBUTTON_ENTERED= new Color (65, 65, 75);//Color Mouse Encima de los Botones 
        private Color COLOR_EXIT = new Color(255, 50, 50);
        
         private boolean RESIZABLE = true;
        private void Config()
        {
         setUndecorated(rootPaneCheckingEnabled);
         getContentPane().setBackground(COLORBORDER);
         
         setSize( SIZEX,  SIZEY);
         addResizeListener();        
         setLayout(null);
         
         AddContentPanelToMain();
         TitleB = new TitleBar(this);
         eventActualizarRedimension() ;
         /*=-=-=-RUN--=-=-+*/
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Titulo =   TitleB.Title.getText();
         setLocationRelativeTo(null);
        }

private void eventActualizarRedimension() {    //======= +---- ACTUALIZAR_REDIMENSION  ----+ ======
    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
             ActualizarRedimension();
        }
    });
}

private void ActualizarRedimension() {

    RESIZEX = getWidth();
             RESIZEY = getHeight();

            int NEWX = RESIZEX - SIZEX;
            int NEWY = RESIZEY - SIZEY;

            TitleB.setSize(TitleB.getWidth() + NEWX, TitleB.getHeight());
            Ajustar_Botones();
            
            ContentPanel.setSize(ContentPanel.getWidth() + NEWX, ContentPanel.getHeight() + NEWY);
            TitleB.Title.setSize(TitleB.Title.getWidth()+NEWX,TitleB.Title.getHeight());
            
            SIZEX = RESIZEX;  
            SIZEY = RESIZEY;
}

    private void Ajustar_Botones(){   //- + - + - + - + - + - + - + - +
    int Posicion=40;    
    for (int i=1; i<5;i++)
    {
        TitleB.Botons[i].setLocation(TitleB.getWidth() - (Posicion*i),0);
    }    
    }
    
  //+++++++++++++++++++++START CODE REDIMENSION +++++++++++++++++++++++++++++++ //

private boolean isDragging = false;
private MouseAdapter mouseAdapter;
private MouseMotionAdapter motionAdapter;
private MouseAdapter maximizeAdapter;
 
private void addResizeListener() {    // =-=====-===-===-===-===-== Eventos Redimension
    // Crear e inicializar los listeners
    mouseAdapter = new MouseAdapter() {
        private Point mousePressPoint;

        @Override
        public void mousePressed(MouseEvent e) { // arrastre
            mousePressPoint = e.getPoint();
             if (isNearEdge(mousePressPoint)) {
             isDragging = true; 
            BORDER_SIZE = MAX_BORDER_SIZE; 
             }
  
        }

        @Override
        public void mouseReleased(MouseEvent e) {  // Termina el arrastre
            isDragging = false; 
            BORDER_SIZE = MIN_BORDER_SIZE; 
        }
    };

    motionAdapter = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {  //Redimensionar
            handleResize(e);
        }

        @Override
        public void mouseMoved(MouseEvent e) {  // Cursor
            setCursor(Cursor.getPredefinedCursor(getCursor(e))); 
     
        }
    };

    // Agregar los listeners al componente
    addMouseListener(mouseAdapter);
    addMouseMotionListener(motionAdapter);
}


private void handleResize(MouseEvent e) {
    Point mousePosition = e.getPoint();
    Rectangle bounds = getBounds();

    if (isDragging) {
        if (mousePosition.x <= BORDER_SIZE) { // Borde izquierdo
            int deltaX = e.getXOnScreen() - bounds.x;
            if (bounds.width - deltaX >= MIN_WIDTH) {
                bounds.x += deltaX;
                bounds.width -= deltaX;
            }
        }

        if (mousePosition.x >= bounds.width - BORDER_SIZE) { // Borde derecho
            int deltaX = e.getXOnScreen() - (bounds.x + bounds.width);
            if (bounds.width + deltaX >= MIN_WIDTH) {
                bounds.width += deltaX;
            }
        }

        if (mousePosition.y <= BORDER_SIZE) { // Borde superior
            int deltaY = e.getYOnScreen() - bounds.y;
            if (bounds.height - deltaY >= MIN_HEIGHT) {
                bounds.y += deltaY;
                bounds.height -= deltaY;
            }
        }

        if (mousePosition.y >= bounds.height - BORDER_SIZE) { // Borde inferior
            int deltaY = e.getYOnScreen() - (bounds.y + bounds.height);
            if (bounds.height + deltaY >= MIN_HEIGHT) {
                bounds.height += deltaY;
            }
        }
        setBounds(bounds);
    }
}

private boolean isNearEdge(Point mousePosition) {
    Rectangle bounds = getBounds();
    return (mousePosition.x <= BORDER_SIZE || mousePosition.x >= bounds.width - BORDER_SIZE ||
            mousePosition.y <= BORDER_SIZE || mousePosition.y >= bounds.height - BORDER_SIZE);
}

private int getCursor(MouseEvent e) {
    Point mousePosition = e.getPoint();
    Rectangle bounds = getBounds();
    
    boolean[] edges = new boolean[8];
    edges[0] = mousePosition.x <= MIN_BORDER_SIZE && mousePosition.y <= MIN_BORDER_SIZE;
    edges[1] = mousePosition.x >= bounds.width - MIN_BORDER_SIZE && mousePosition.y <= MIN_BORDER_SIZE;
    edges[2] = mousePosition.x <= MIN_BORDER_SIZE && mousePosition.y >= bounds.height - MIN_BORDER_SIZE;
    edges[3] = mousePosition.x >= bounds.width - MIN_BORDER_SIZE && mousePosition.y >= bounds.height - MIN_BORDER_SIZE;
    edges[4] = mousePosition.x <= MIN_BORDER_SIZE;
    edges[5] = mousePosition.x >= bounds.width - MIN_BORDER_SIZE;
    edges[6] = mousePosition.y <= MIN_BORDER_SIZE;
    edges[7] = mousePosition.y >= bounds.height - MIN_BORDER_SIZE;

    int index = -1;
    for (int i = 0; i < edges.length; i++) {
        if (edges[i]) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        switch (index) {
            case 0: return Cursor.NW_RESIZE_CURSOR;
            case 1: return Cursor.NE_RESIZE_CURSOR;
            case 2: return Cursor.SW_RESIZE_CURSOR;
            case 3: return Cursor.SE_RESIZE_CURSOR;
            case 4: return Cursor.W_RESIZE_CURSOR;
            case 5: return Cursor.E_RESIZE_CURSOR;
            case 6: return Cursor.N_RESIZE_CURSOR;
            case 7: return Cursor.S_RESIZE_CURSOR;
        }
    }

    return Cursor.DEFAULT_CURSOR;
}

//===========END REDIMENSION

     //+++++++++++++++++++++START TITLEBAR+++++++++++++++++++++++++++++++ //
      /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+
     | ~ ~ ~ Method: Barra de Titulo                                                                                                                           |
     | ~Include: Componente que  cumple la funcion de mover, cerrar y demas                                                        |
     +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/
     
        private class TitleBar extends JPanel{

        private final JFrame mainF;
        
        public TitleBar(JFrame Frame)
        {
        mainF = Frame;
        setLayout(null);
         Acomplar();
        }
        //=+=+ aqui inician los procesos de acomplamientos al Jframe+=+=+=+
         private void Acomplar() 
         {    
         setBounds(MARGIN, MARGIN, mainF.getWidth()-(MARGIN*2), TITLEBAR_HEIGHT);
         setBackground(COLORBORDER);
//         setBackground(Color.blue);
         Componentes();
         Eventos();
         mainF.add(this);
        }
         
         //__________________________
        private int xMouse,yMouse;
        public JPanel[] Botons = new JPanel[5];
        public JLabel Title;
                
        //===Evento de Arrastre
        private void Eventos() {

         addMouseListener(new MouseAdapter() {
            @Override
        public void mousePressed(MouseEvent e) {
            xMouse = e.getX();
            yMouse = e.getY(); 
                                                                            }
            @Override
        public void mouseEntered(MouseEvent e) {
            setCursor(Cursor.getDefaultCursor());
        }   
        }
        );

        addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {

            int venX = e.getXOnScreen();
            int venY = e.getYOnScreen();
            mainF.setLocation(venX - xMouse, venY - yMouse);
                                                                            }
        }
        );
        
        }
        
      /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-==-=-=-=+
     | ~ ~ ~ Method:   Agregar Componetes                                                     |
     | ~Include:  Icono, Titulo, Botones                                                             |
     +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=+=-=-=-==-=-=-=*/
       public  IconPanel  Icon;
        private void Componentes()
         {
         //========+ Icon
         Icon = new IconPanel ();
          add(Icon);
         //========+ Title
         Title = new JLabel();
         Title.setForeground(COLORFOREICON);
         Title.setText("JavaWindowPlus");
         Title.setBounds(40, 10, getWidth()-210,20);
         if(Titulo != null ){Title.setText(Titulo);}
         add(Title);
        //========+ Buttons

         int AjustePosition =40;
        
        for(int i = 1; i<5; i++){
    
        JPanel Boton = new JPanel();
         Botons[i] = Boton;
         Boton.setBounds(getWidth()-AjustePosition,0,40, getHeight());
         Boton.setLayout(null);
         Boton.setBackground(getBackground()); 
         
         AsignarFuncion(i, Boton);
         add(Boton);
             AjustePosition+=40;
        } 
         } 
         
         
     /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=+
     | ~ ~ ~ Method:  Funciones de Botones                                                         |
     | ~Include: Distinguiendo cada Boton para Darles una Funcionalidad           |
     +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+=-=-=-==-=-=-=*/
         private void AsignarFuncion(int Number, JPanel Boton){
             
        JLabel TextB = new JLabel();
         TextB.setBounds(0, 0, Boton.getWidth(), Boton.getHeight());
         Boton.add(TextB);  TextB.setHorizontalAlignment(SwingConstants.CENTER);
         TextB.setFont(new Font("Sungui IU", Font.PLAIN, 14));
         TextB.setForeground(COLORFOREICON);
             
         switch(Number){
             case 1:
                          TextB.setText("✕");
                          //=====CERRAR
                          Boton.addMouseListener(new MouseAdapter() {
                        @Override
                           public void mouseClicked(MouseEvent e) {
                                System.exit(0);  // Cierra la aplicación al hacer clic
                                 }
                           
                        @Override
                              public void mouseEntered(MouseEvent e) {
                              Boton.setBackground(COLOR_EXIT);    
                              }
                              
                        @Override
                              public void mouseExited(MouseEvent e) {
                              Boton.setBackground(COLORBORDER);  
                               }
                           
                           });
                      
             break;
             case 2:
                          TextB.setText("🗖");
                         //=====MAXIMIZAR
                        maximizeAdapter = new MouseAdapter() {
                        private boolean isMaximized = false;

                         @Override
                         public void mouseClicked(MouseEvent e) {
                                  if (isMaximized) {
                                                 mainF.setExtendedState(JFrame.NORMAL);
                                                 TextB.setText("🗖");
                                    } else {
                                                 mainF.setExtendedState(JFrame.MAXIMIZED_BOTH);
                                                TextB.setText("🗗");
                                   }
                                                isMaximized = !isMaximized;
                                    }

                                    @Override
                                  public void mouseEntered(MouseEvent e) {
                                      Boton.setBackground(COLORBUTTON_ENTERED); 
                                    }

                                  @Override
                                  public void mouseExited(MouseEvent e) {
                                             e.getComponent().setBackground(COLORBORDER); 
                                     }
                                     };

                                            Boton.addMouseListener(maximizeAdapter);
             break;
             case 3:
                           TextB.setText("―");
                          //=====MINIMIZAR
                  Boton.addMouseListener(new MouseAdapter() {
                        @Override
                           public void mouseClicked(MouseEvent e) {
                                    setState(JFrame.ICONIFIED);
                                 }
                           
                                @Override
                              public void mouseEntered(MouseEvent e) {
                              Boton.setBackground(COLORBUTTON_ENTERED);    
                              }
                              
                        @Override
                              public void mouseExited(MouseEvent e) {
                              Boton.setBackground(COLORBORDER);  
                               }
                           });
             break;
              case 4:
                          TextB.setText("🕂");
                
                         //=====REDIMENSIONAR
                 Boton.addMouseListener(new MouseAdapter() {
                  private boolean isResizable = false;

                 @Override
                 public void mouseClicked(MouseEvent e) {
                  if (isResizable) {
                      setResizablePlus(true);
                    } else {
                      setResizablePlus(false);
                    }
                   isResizable= !isResizable; 
                     }
                 
                      @Override
                              public void mouseEntered(MouseEvent e) {
                              Boton.setBackground(COLORBUTTON_ENTERED);    
                              }
                              
                        @Override
                              public void mouseExited(MouseEvent e) {
                              Boton.setBackground(COLORBORDER);  
                               }
               });
                 new MouseAdapter() {
                        @Override
                              public void mouseEntered(MouseEvent e) {
                              Boton.setBackground(COLORBUTTON_ENTERED);    
                              }    
                    };
    
             break;
             default:
                      System.out.println("ERROR");
             break;
         }
              Boton.add(TextB);
         }
        //=========EndTTB
        }
        
        private void MensajeTituloResize(String Mensaje){
           TitleB.Title.setText(""+ Mensaje +" - "+Titulo);
            CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000); 
                 TitleB.Title.setText(Titulo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Tarea interrumpida.");
            }
        });
        }
        
        private void EnteredBotonColors(Color COLORORIGIN) {

        int red = COLORORIGIN.getRed();
        int green = COLORORIGIN.getGreen();
        int blue = COLORORIGIN.getBlue();

         double luminance = 0.2126 * red + 0.7152 * green + 0.0722 * blue;

         int adjustment = (luminance < 200) ? 40 : -40;

         red = Math.max(0, Math.min(255, red + adjustment));
         green = Math.max(0, Math.min(255, green + adjustment));
         blue = Math.max(0, Math.min(255, blue + adjustment));

         COLORBUTTON_ENTERED = new Color(red, green, blue);
        }
 //+++++++++++++++++++++START CONTENTPANEL+++++++++++++++++++++++++++++++ //
      /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=+
     | ~ ~ ~ Method:    ContentPanel                                                     |
     | ~Include: Panel donde Estaran Contenido los Componentes       |
     +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+=-=-=-==-=-=-=*/

        private void AddContentPanelToMain()
        {
        ContentPanel = new JPanel();    
        ContentPanel.setBackground(COLORBORDER);
        ContentPanel.setLayout(null);
        ContentPanel.setLayout(new java.awt.BorderLayout());
        ContentPanel.add(PANEL_CONTENT, java.awt.BorderLayout.CENTER);
        ContentPanel.setBounds(MARGIN, MARGIN+TITLEBAR_HEIGHT, getWidth()-(MARGIN*2), getHeight()-TITLEBAR_HEIGHT-(MARGIN*2));
        add(ContentPanel);
        }
 //+++++++++++++++++++++START PAINT ICON+++++++++++++++++++++++++++++++ //
      /*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=+
     | ~ ~ ~ Method:    ContentPanel                                                     |
     | ~Include: Panel donde Estaran Contenido los Componentes       |
     +=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+=-=-=-==-=-=-=*/
        public class IconPanel extends JPanel {

    private String NameImagen = null;  
    private String CarpetaDeProyecto = null;  


    public IconPanel() {
        setBounds(4, 4, 28, 28);
        setBackground(new Color(0,0,0,0));
    }


    public void setIcon(String carpetadeProyecto,String nameImg) {
        this.NameImagen= nameImg;  
        CarpetaDeProyecto = carpetadeProyecto;
        repaint();  
    }
@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    if (NameImagen != null && CarpetaDeProyecto != null) {
        try {
            Image img = new ImageIcon(getClass().getResource("/" + CarpetaDeProyecto + "/" + NameImagen)).getImage();
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), null);
              setIconImage(img);
        } catch (Exception e) {
            System.err.println("Error cargando imagen: " + e.getMessage());
            drawDefaultIcon(g2d);
        }
    } else {
        drawDefaultIcon(g2d);
    }
}

private void drawDefaultIcon(Graphics2D g2d) {
    g2d.setColor(COLORFOREICON);
    g2d.fillRect(8, 8, 14, 13); // taza
    g2d.fillRect(23, 10, 5, 9); // mango
    g2d.fillRect(6, 22, 18, 3); // plato
}
}
    //++++++++++++++++++++++END CODE MAIN ++++++++++++++++++++++++++++++ //
}
