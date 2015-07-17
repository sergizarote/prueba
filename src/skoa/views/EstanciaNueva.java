package skoa.views;

import skoa.views.Arbol;
import skoa.helpers.Acciones;
import skoa.helpers.ImageFilter;
import skoa.helpers.ImagePreview;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class EstanciaNueva {

    static String nombre_e = "";
    static String imagen_e = "";
    public static String seleccionado = "";
    public static JTextField nombre_estancia = new JTextField(15);
    public static JTextField imagen_estancia = new JTextField(15);
    public static JPanel panel1 = new javax.swing.JPanel();
    public static JComboBox desplegable = new javax.swing.JComboBox();
    public static JFrame frame_estancia = new JFrame("Nueva Estancia");
    public static int llamado = 0;

    

    public static void main() {
        llamado = 1;
        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"	
        //frame_estancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_estancia.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_estancia.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_estancia.setLocation(150, 50);
        frame_estancia.setSize(1000, 700);

        panel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Añadir Nueva Estancia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Nombre Estancia: ");

        nombre_estancia.setText("");
        nombre_estancia.setSize(250, 20);
        nombre_estancia.addFocusListener(new FocusListener() {

            public void focusLost(FocusEvent e) {
                String aux = ((JTextField) e.getSource()).getText(); //lee texto escrito
                EstanciaNueva.nombre_e = aux;

            }//end focuslost

            public void focusGained(FocusEvent e) {
                // No hacemos nada
            }
        });

        JLabel mensaje2 = new JLabel();
        mensaje2.setText("Imagen de la estancia: ");

        imagen_estancia.setText("");
        imagen_estancia.setSize(250, 20);
        imagen_estancia.addFocusListener(new FocusListener() {

            public void focusLost(FocusEvent e) {
                String aux = ((JTextField) e.getSource()).getText(); //lee texto escrito
                EstanciaNueva.imagen_e = aux;
            }//end focuslost

            public void focusGained(FocusEvent e) {
                // No hacemos nada
            }
        });

        JButton boton1 = new JButton("Examinar");
        boton1.setSize(40, 20);
        boton1.addActionListener((ActionListener) new ButtonEstanciaNueva());

        JButton boton2 = new JButton("Añadir Estancia");
        boton2.setSize(40, 20);
        boton2.addActionListener((ActionListener) new ButtonEstanciaNueva());



        JLabel mensaje3 = new JLabel();
        mensaje3.setText("Seleccione la Planta donde desea añadir la estancia: ");

        Arbol.generarDesplegable();

        desplegable.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EstanciaNueva.seleccionado = (String) EstanciaNueva.desplegable.getSelectedItem();

                    }
                });


        Arbol.generarDesplegable();



        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        Label label1 = new java.awt.Label();

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");

        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();


        JButton botonSalir = new JButton("Salir");
        botonSalir.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        //System.exit(0);
                        frame_estancia.setVisible(false);
//                                frame_modificarPlano.dispose();
                    }
                });




        JButton botonVolver = new JButton("Volver");
        //botonVolver.setSize(40, 20);
        botonVolver.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        EstanciaNueva.frame_estancia.setVisible(false);//dispose();
                        try {
//							configuracion.main();
                            if (ConfiguracionSkoa.llamado == 0) {
                                ConfiguracionSkoa.main();
                            } else {
                                ConfiguracionSkoa.frame_configuracion.setVisible(true);
                                Arbol.generarArbol();
                            }


                        } catch (DocumentException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });



        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++     
        JMenu jMenu3 = new javax.swing.JMenu();
        jMenu3.setText("                                            ");
        jMenu3.setFocusable(false);
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        JMenu jMenu4 = new javax.swing.JMenu();
        String msg = "Está usando el fichero de configuración: ";
        msg = msg + NuevoProyecto.nombre_archivo;
        jMenu4.setText(msg);
        jMenu4.setEnabled(false);

        jMenuBar1.add(jMenu4);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        EstanciaNueva.frame_estancia.setJMenuBar(jMenuBar1);

        Arbol.generarArbol();
        //**************************************************************************

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(mensaje3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(mensaje1).addGap(18, 18, 18)
                .addComponent(nombre_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(mensaje2).addGap(18, 18, 18)
                .addComponent(imagen_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(10, 10, 10).addComponent(boton1)).addGroup(jPanel1Layout.createSequentialGroup().addGap(61, 61, 61).addComponent(boton2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(61, 61, 61) // .addComponent(boton3)
                )).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        
        
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(desplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje3)).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mensaje1).addComponent(nombre_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mensaje2).addComponent(imagen_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(boton1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE).addComponent(boton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE) // .addComponent(boton3)
                .addContainerGap()));

        Arbol.generarArbol();
        //++++++++++++++++++++++++++++++++++++++++++++++++++  

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(EstanciaNueva.frame_estancia.getContentPane());
        EstanciaNueva.frame_estancia.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) //.addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                
                .addComponent(botonVolver)
                //.addComponent(botonSalir)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                
                
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(259, Short.MAX_VALUE)));


        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35)
                .addComponent(botonVolver)
                //.addComponent(botonSalir)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //                  .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(17, 17, 17) //                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                //.addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE).addGap(275, 275, 275).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(116, 116, 116).addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(115, Short.MAX_VALUE)));

        //********************************************************************************

        EstanciaNueva.frame_estancia.setVisible(true);


    }
}

class ButtonEstanciaNueva extends JPanel
        implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JFileChooser fc;

    ButtonEstanciaNueva() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Examinar")) {
            //Set up the file chooser.
            if (fc == null) {
                fc = new JFileChooser();
                String curDir = System.getProperty("user.dir");
                fc.setCurrentDirectory(new File(curDir));
                //Add a custom file filter and disable the default
                //(Accept All) file filter.
                fc.addChoosableFileFilter(new ImageFilter());
                fc.setAcceptAllFileFilterUsed(false);
                //Add the preview pane.
                fc.setAccessory(new ImagePreview(fc));
            }
            //Show it.
            int returnVal = fc.showDialog(ButtonEstanciaNueva.this, "Seleccionar");
            //Process the results.
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                EstanciaNueva.imagen_estancia.setText(file.getAbsolutePath());
                EstanciaNueva.imagen_e = EstanciaNueva.imagen_estancia.getText();
            }
            //Reset the file chooser for the next time it's shown.
            fc.setSelectedFile(null);

        } //end if

        //-------------------------------------------------------------------------------

        //estancia_nueva.seleccionado = (String)estancia_nueva.desplegable.getSelectedItem();
        //estancia_nueva.nombre_e = estancia_nueva.nombre_estancia.getText();

        if (e.getActionCommand().equals("Añadir Estancia")) {
            if (!EstanciaNueva.seleccionado.equals("--Plantas--")) {
                //if (estancia_nueva.seleccionado.indexOf("--Plantas--") == -1){
                if (!EstanciaNueva.nombre_e.equals("")) {
                    //if (estancia_nueva.nombre_e.indexOf("") == -1){
                    if (!EstanciaNueva.imagen_e.equals("")) {
                        //if (estancia_nueva.imagen_e.indexOf("") == -1){
                        if (Acciones.estanciaUnica(EstanciaNueva.seleccionado, EstanciaNueva.nombre_e) == false) {
                            navegar();
                            //++++++++++++++       MENSAJE ALERTA 
                            String mostrar = "Se ha introducido la nueva estancia";
                            mostrar += "\n";
                            mostrar += EstanciaNueva.nombre_e;
                            mostrar += "\n";
                            mostrar += "en el fichero de configuración";
                            JOptionPane.showMessageDialog(null, mostrar, "Información", 1);

                            EstanciaNueva.nombre_estancia.setCaretPosition(0);
                            EstanciaNueva.nombre_estancia.setText("");

                            EstanciaNueva.imagen_estancia.setCaretPosition(0);
                            EstanciaNueva.imagen_estancia.setText("");

                            // Reinciamos las variables para que no falle al seguir insertando estancias
                            EstanciaNueva.nombre_e = "";
                            EstanciaNueva.imagen_e = "";

                            Arbol.generarArbol();
                            Arbol.generarDesplegable();
                        } // Para cuando haya una estancia con el mismo nombre en la misma planta
                        else {

                            //++++++++++++++       MENSAJE ALERTA 
                            String mostrar = "No pueden haber dos estancias con ";
                            mostrar += "\n";
                            mostrar += "el mismo nombre en la misma planta";
                            JOptionPane.showMessageDialog(null, mostrar, "alerta", 1);
                        }
                    } // Para cuando no se haya elegido una imagen para la estancia
                    else {
                        //++++++++++++++       MENSAJE ALERTA 
                        String mostrar = "Debe seleccionar una imagen para la estancia";

                        JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
                    }
                } // Para cuando no se introduzca ningún nombre en la estancia
                else {
                    //++++++++++++++       MENSAJE ALERTA 
                    String mostrar = "Debe seleccionar una nombre para la estancia";

                    JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
                }
            } // Para cuando no se haya seleccionado ninguna planta
            else {
                //++++++++++++++       MENSAJE ALERTA 
                String mostrar = "Debe seleccionar una planta primero";

                JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
            }
        }//end if

        //----------------------------------------------------------------------------

        if (e.getActionCommand().equals("Añadir Actuadores/Sensores")) {
            EstanciaNueva.frame_estancia.setVisible(false);
            EstanciaCaracteristicas.main();
        }


    }//end public void

    public void navegar() {
        try {
            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();

            //xmlReader.setEncoding("UTF-8"); // ********************************************
            xmlReader.setEncoding("iso-8859-1");


            Document doc = xmlReader.read(aFile);

            Element node = (Element) doc.selectSingleNode("//vivienda");

 
            for (Iterator i = node.elementIterator(); i.hasNext();) {
                node = (Element) i.next();

                if ( !node.getName().equals("email")) {
                

                    if (node.valueOf("@alias").equals(EstanciaNueva.seleccionado)) {
                        //ESTEFANÍA: Añadido para que se coja la imagen del plano desde la carpeta
                        //donde está el ejecutable. Esto se hace para que no hayan rutas absolutas
                        //y si se cambia la carpeta de ejecutables de directorio, siga funcionando.
                        //SIEMPRE Y CUANDO, SE MANTENGA EL MISMO NOMBRE DE LA CARPETA DONDE SE SACARON
                        //LAS IMÁGENES DE LOS PLANOS AL CREAR EL PROYECTO, Y EL MISMO NOMBRE DE LA
                        //IMAGEN.
                        File dir_iniciall = new File("./");
                        String a = dir_iniciall.getAbsolutePath();
                        System.out.println("raiz=" + a);
                        int ind = EstanciaNueva.imagen_e.indexOf(a);
                        int lon = a.length();
                        String b = EstanciaNueva.imagen_e.substring(ind + lon);
                        System.out.println("ruta relativa=" + b);
                        System.out.println("ruta absoluta=" + EstanciaNueva.imagen_e);
                        org.dom4j.Element anadir = node.addElement("estancia").addAttribute("nombre", EstanciaNueva.nombre_e) //.addAttribute("imagen", estancia_nueva.imagen_e)
                                .addAttribute("imagen", b);
                        break;
                    }//end if auxi
                }//end if
            }//end for

            String auxiliar = doc.asXML();

            FileWriter archivo;
            archivo = new FileWriter(NuevoProyecto.archivo);
            OutputFormat format = OutputFormat.createPrettyPrint();

            //format.setEncoding("UTF-8"); 
            format.setEncoding("iso-8859-1");

            XMLWriter writer = new XMLWriter(new FileWriter(NuevoProyecto.archivo), format);
            writer.write(doc);
            writer.close();

//			 acciones.inicializarEstancia(estancia_nueva.nombre_e );
            Acciones.inicializarEstancia(EstanciaNueva.seleccionado, EstanciaNueva.nombre_e);


        } catch (IOException e) {
            e.printStackTrace();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    } //end navegar
}
