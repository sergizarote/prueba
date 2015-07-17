package skoa.views;

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

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JSeparator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ModificarPlano {

    public static JFrame frame_modificarPlano = new JFrame("Modificar Plano");
    public static String direcPlano;
    static String planta;
    static String estancia;
    public static JComboBox desplegable_planta = new javax.swing.JComboBox();
    public static JComboBox desplegable_estancia = new javax.swing.JComboBox();
    public static String planta_seleccionada;
    public static String estancia_seleccionada;
    static JTextField direccionPlano = new JTextField(15);
    public static int llamado = 0;

    public static void main() throws DocumentException {
        llamado = 1;

        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
        //frame_modificarPlano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_modificarPlano.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_modificarPlano.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_modificarPlano.setLocation(150, 50);
        frame_modificarPlano.setSize(1000, 700);



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
                        frame_modificarPlano.setVisible(false);
//                                frame_modificarPlano.dispose();
                    }
                });
        

        JButton botonVolver = new JButton("Volver");
        //botonVolver.setSize(40, 20);
        botonVolver.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                         ModificarPlano.frame_modificarPlano.setVisible(false);// dispose();
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


        frame_modificarPlano.setJMenuBar(jMenuBar1);




        JPanel panel1 = new javax.swing.JPanel();
        panel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar el Plano de la Estancia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Nuevo Plano para la estancia");

        direccionPlano.setEnabled(false);
        direccionPlano.setSize(250, 20);
        direccionPlano.addFocusListener(new FocusListener() {

            public void focusLost(FocusEvent e) {
                String aux = ((JTextField) e.getSource()).getText();
                ModificarPlano.direcPlano = aux;
            }//end focuslost

            public void focusGained(FocusEvent e) {
                // No hacemos nada
            }
        });


        desplegable_planta.addActionListener((ActionListener) new ButtonModifPlano());
        desplegable_planta.addItem("--Plantas--");
        Acciones.mostrarPlantasVistaModificarPlano();
        desplegable_planta.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        ModificarPlano.planta_seleccionada = (String) ModificarPlano.desplegable_planta.getSelectedItem();
                        if (!ModificarPlano.planta_seleccionada .equals( "--Plantas--")) {
                            ModificarPlano.desplegable_estancia.setEnabled(true);
                            Acciones.mostrarEstanciasVistaModificarPlano();
                        }
                        if (ModificarPlano.planta_seleccionada.equals( "--Plantas--")) {
                            ModificarPlano.desplegable_estancia.setEnabled(false);
                        }

                    }
                });

        desplegable_estancia.addActionListener((ActionListener) new ButtonModifPlano());
        desplegable_estancia.setEnabled(false);
        desplegable_estancia.addItem("--Estancias--");
        desplegable_estancia.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        ModificarPlano.estancia_seleccionada = (String) ModificarPlano.desplegable_estancia.getSelectedItem();

                    }
                });

        JButton boton1 = new JButton("Examinar");
        boton1.setSize(40, 20);
        boton1.addActionListener((ActionListener) new ButtonModifPlano());

        JButton boton2 = new JButton("Modificar Plano");
        boton2.setSize(40, 20);
        boton2.addActionListener((ActionListener) new ButtonModifPlano());



        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(29, 29, 29)
                .addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desplegable_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(direccionPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton1).addGap(52, 52, 52)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(265, Short.MAX_VALUE)
                .addComponent(mensaje1).addGap(116, 116, 116)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(332, Short.MAX_VALUE)
                .addComponent(boton2).addContainerGap()));
        
        
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(24, Short.MAX_VALUE)
                .addComponent(mensaje1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(desplegable_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(direccionPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(boton1)).addGap(19, 19, 19)
                .addComponent(boton2)));





        JPanel panel3 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(84, 84, 84) //    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                ).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(24, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(45, 45, 45).addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE) // .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)));
        ////////////////////////////////////////////////////////////////////////////



        Arbol.generarArbol();

        //**************************************************************************

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_modificarPlano.getContentPane());
        frame_modificarPlano.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                .addGroup(layout.createSequentialGroup()
                
                //.addComponent(botonSalir)
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) 
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(15, 15, 15)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10)
                .addComponent(botonVolver)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) .addContainerGap(259, Short.MAX_VALUE)
                
        ));
     
        
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                
               
                .addComponent(botonVolver)

                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                 
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(17, 17, 17) //                  
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE).addGap(275, 275, 275).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(39, 39, 39)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(300, Short.MAX_VALUE)));

        //********************************************************************************

        frame_modificarPlano.setVisible(true);

    }//end mail
    
}//end class

class ButtonModifPlano extends JPanel
        implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JFileChooser fc;

    ButtonModifPlano() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Examinar")) {


            //Set up the file chooser.
            if (fc == null) {
                fc = new JFileChooser();

                String curDir = System.getProperty("user.dir");
                //curDir = curDir+"\\imagenes\\";
                fc.setCurrentDirectory(new File(curDir));
                fc.addChoosableFileFilter(new ImageFilter());
                fc.setAcceptAllFileFilterUsed(false);


                //Add the preview pane.
                fc.setAccessory(new ImagePreview(fc));
            }

            //Show it.
            int returnVal = fc.showDialog(ButtonModifPlano.this, "Seleccionar");

            //Process the results.
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                ModificarPlano.direccionPlano.setText(file.getAbsolutePath());
                ModificarPlano.direcPlano = ModificarPlano.direccionPlano.getText();
                // log.append("Attaching file: " + file.getName()
                //          + "." + newline);
            } else {
                // log.append("Attachment cancelled by user." + newline);
            }
            //log.setCaretPosition(log.getDocument().getLength());

            //Reset the file chooser for the next time it's shown.
            fc.setSelectedFile(null);

        } //end if

//-------------------------------------------------------------------------------

        if (e.getActionCommand().equals("Modificar Plano")) {
            if (!ModificarPlano.planta_seleccionada.equals("--Plantas--")) {
                if (!ModificarPlano.estancia_seleccionada.equals("--Estancias--")) {
                    if (ModificarPlano.direcPlano != null) {

//			navegar();
                        //++++++++++++++       MENSAJE ALERTA 
                        String mostrar = "Se ha modificado el plano de la nueva estancia";
                        mostrar += "\n";
                        mostrar += "en el fichero de configuración";
                        JOptionPane.showMessageDialog(null, mostrar, "Información", 1);



                        ModificarPlano.desplegable_estancia.setEnabled(false);

                        Acciones.modificarPlanoXML();

                        Arbol.generarArbol();//+HIJOSSSS!!!!!!!!!!!!!
                    }//end if
                    else {
                        String mostrar = "Seleccione el plano para la estancia";
                        JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
                    }
                } else {
                    String mostrar = "Seleccione una Estancia ";
                    JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
                }
            } else {
                String mostrar = "Seleccione una Planta ";
//				mostrar += "\n";
//				mostrar += "que desea realizar";
                JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
            }

        }//end if

//----------------------------------------------------------------------------

        if (e.getActionCommand().equals("Modificar Actuadores/Sensores")) {
        }


    }//end public void

    public void navegar() {
        try {
            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();

            //xmlReader.setEncoding("UTF-8");
            xmlReader.setEncoding("iso-8859-1");


            Document doc = xmlReader.read(aFile);

            Element node = (Element) doc.selectSingleNode("//vivienda");//[@alias]");
            Element node2;
            // System.out.println("planta seleccionada:");
            //System.out.println(estancia_nueva.seleccionado);

            String aux;
            for (Iterator i = node.elementIterator(); i.hasNext();) {
                node = (Element) i.next();
                /*ModificarPlano.planta_seleccionada 
                ModificarPlano.estancia_seleccionada 
                ModificarPlano.direcPlano
                 */
                if (node.getName().equals("email")
                        && node.valueOf("@alias").equals(ModificarPlano.planta_seleccionada)) {


                    node2 = node;
                    for (Iterator ib = node2.elementIterator(); ib.hasNext();) {
                        node2 = (Element) ib.next();
                        if (node2.getName().equals("estancia")
                                && node2.valueOf("@nombre").equals(ModificarPlano.estancia_seleccionada)) {


                            Attribute atributo = node2.attribute("imagen");
                            atributo.setText(ModificarPlano.direcPlano);

                            Element node3 = node2;
                            for (Iterator ic = node3.elementIterator(); ic.hasNext();) {
                                node3 = (Element) ic.next();
                                if (node3.getName().equals("iconos") ){
                                    Element node4 = node3;
                                    for (Iterator icc = node4.elementIterator(); icc.hasNext();) {
                                        node4 = (Element) icc.next();

                                        node4.getParent().remove(node4);

                                    }
                                }
                            }
                        }//end if


                    }//end for

                    break;




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

//			 acciones.inicializarEstancia(estancia_nueva.nombre_e );   YA NO SE LLAMA A NAVEGAR



        } catch (IOException e) {
            e.printStackTrace();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    } //end navegar
}