package skoa.views;

import skoa.helpers.Acciones;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import java.io.FileWriter;

import java.io.IOException;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class PlantaNueva extends JPanel {

    public static JFrame framePlantaNueva = new JFrame("Planta Nueva");
    static String nueva = "";
    static JTextField nombre = new JTextField(15);
    public static int llamado = 0;

    public static void main() {
        llamado = 1;

        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
        //framePlantaNueva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //framePlantaNueva.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        framePlantaNueva.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        framePlantaNueva.setLocation(150, 50);
        framePlantaNueva.setSize(1000, 700);

        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Introduzca el nombre de la nueva planta: ");
        //Recoger nombre planta
        nombre.setSize(150, 20);
        nombre.setText("");

        nombre.addFocusListener(new FocusListener() {

            public void focusLost(FocusEvent e) {

                String aux = ((JTextField) e.getSource()).getText(); //lee texto escrito
                PlantaNueva.nueva = aux;


            }//end focuslost

            public void focusGained(FocusEvent e) {
                // No hacemos nada
            }
        });

        JButton boton1 = new JButton("Añadir Planta");
        boton1.setSize(40, 20);
        boton1.addActionListener((ActionListener) new ButtonListener3());


        //Comienza el menu principal
        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        Label label1 = new java.awt.Label();

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");

        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();

        /*JMenu jMenu1 = new javax.swing.JMenu();
        jMenu1.setText("Archivo");
        JMenuItem archivo_item1 = new JMenuItem("Salir");
        jMenu1.add(archivo_item1);
        archivo_item1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        // System.exit(0);
                        framePlantaNueva.setVisible(false);
//                                framePlantaNueva.dispose();
                    }
                });
        jMenuBar1.add(jMenu1);

        JMenu jMenu2 = new javax.swing.JMenu();
        jMenu2.setText("Menú Configuración");
        JMenuItem planta_item_principal = new JMenuItem("Volver");
        jMenu2.add(planta_item_principal);
        jMenuBar1.add(jMenu2);
        planta_item_principal.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        PlantaNueva.framePlantaNueva.setVisible(false);//dispose();
                        try {
//							configuracion.main();
                            if (Configuracion.llamado == 0) {
                                Configuracion.main();
                            } else {
                                Configuracion.frame_configuracion.setVisible(true);
                                Arbol.generarArbol();
                                Configuracion.arbol_configuracion = Arbol.MOSTRAR_CONFIGURACION;
                            }

                        } catch (DocumentException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                });*/
        
        JButton botonSalir = new JButton("Salir");
        botonSalir.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        //System.exit(0);
                        framePlantaNueva.setVisible(false);
//                                frame_modificarPlano.dispose();
                    }
                });




        JButton botonVolver = new JButton("Volver");
        //botonVolver.setSize(40, 20);
        botonVolver.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        PlantaNueva.framePlantaNueva.setVisible(false);//dispose();
                        try {
//							configuracion.main();
                            if (ConfiguracionSkoa.llamado == 0) {
                                ConfiguracionSkoa.main();
                            } else {
                                ConfiguracionSkoa.frame_configuracion.setVisible(true);
                                Arbol.generarArbol();
                                ConfiguracionSkoa.arbol_configuracion = Arbol.MOSTRAR_CONFIGURACION;
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



        PlantaNueva.framePlantaNueva.setJMenuBar(jMenuBar1);



        Arbol.generarArbol();
        //**************************************************************************

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(PlantaNueva.framePlantaNueva.getContentPane());// frame5.getContentPane());

        PlantaNueva.framePlantaNueva.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) 
             
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10)
                 .addComponent(botonVolver)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(34, 34, 34).addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(50, Short.MAX_VALUE).addContainerGap(259, Short.MAX_VALUE)));
        
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //                  .addGap(5, 5, 5)
                .addComponent(botonVolver)
                //.addComponent(botonSalir)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(17, 17, 17) //                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                //.addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE).addGap(275, 275, 275).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(134, 134, 134).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(190, Short.MAX_VALUE)));

        //********************************************************************************


        PlantaNueva.framePlantaNueva.setVisible(true);

    }//end main

    private static DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node =
                new DefaultMutableTreeNode(hierarchy[0]);
        DefaultMutableTreeNode child;
        for (int i = 1; i < hierarchy.length; i++) {
            Object nodeSpecifier = hierarchy[i];
            if (nodeSpecifier instanceof Object[]) // Ie node with children
            {
                child = processHierarchy((Object[]) nodeSpecifier);
            } else {
                child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
            }
            node.add(child);
        }
        return (node);
    }
}//end class
class ButtonListener3 implements ActionListener {

    static JFrame frame5 = new JFrame();
    //private Object element;

    ButtonListener3() {
    }
    Document doc = DocumentHelper.createDocument();

    public void navegar() {
        try {
            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();

            //xmlReader.setEncoding("UTF-8");
            xmlReader.setEncoding("iso-8859-1");

            Document doc = xmlReader.read(aFile);

            Element node = (Element) doc.selectSingleNode("//vivienda/planta");

            if (node == null) {
                node = (Element) doc.selectSingleNode("//vivienda");//[@nombre]" );
                org.dom4j.Element anadir = node.addElement("planta");//( "plantas" );

                node = (Element) doc.selectSingleNode("//vivienda/planta");
                anadir = node.addAttribute("alias", PlantaNueva.nueva);// planta_nueva.nueva );
            }//end if
            else {
                node = (Element) doc.selectSingleNode("//vivienda");
                org.dom4j.Element anadir2 = node.addElement("planta").addAttribute("alias", PlantaNueva.nueva);

            }//end else

            String aux = doc.asXML();

            FileWriter archivo;
            archivo = new FileWriter(NuevoProyecto.archivo);
            OutputFormat format = OutputFormat.createPrettyPrint();

            //format.setEncoding("UTF-8");
            format.setEncoding("iso-8859-1");


            XMLWriter writer = new XMLWriter(new FileWriter(NuevoProyecto.archivo), format);
            writer.write(doc);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    } //end navegar

    public void actionPerformed(ActionEvent e) {
        JLabel texto2 = new javax.swing.JLabel();

        PlantaNueva.nombre.setText("");

        if (e.getActionCommand().equals("Añadir Planta")) {
            if (PlantaNueva.nueva != "") {
                if (Acciones.plantaUnica(PlantaNueva.nueva) == false) {

                    navegar();
                    //++++++++++++++       MENSAJE ALERTA 
                    String mostrar = "Se ha introducido la nueva planta";
                    mostrar += "\n";
                    mostrar += PlantaNueva.nueva;
                    mostrar += "\n";
                    mostrar += "en el fichero de configuración";
                    JOptionPane.showMessageDialog(null, mostrar, "Información", 1);

//		   planta_nueva.nombre.setColumns(0);
                    PlantaNueva.nombre.setCaretPosition(0);
                    PlantaNueva.nombre.setText("");
//	       planta_nueva.nombre.setSelectionEnd(-1);
//	       planta_nueva.nombre.setSelectionStart(-1);


                    Arbol.generarArbol();
                    PlantaNueva.nueva = "";

                } else {
                    String mostrar = "Ya existe una planta con ese nombre";
                    JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
                }
            } else {
                //++++++++++++++       MENSAJE ALERTA 
                String mostrar = "Debe introducir un nombre para la planta";

                JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
            }
        }

        if (e.getActionCommand().equals("Aceptar")) {
            ButtonListener3.frame5.dispose();

            PlantaNueva.nombre.setColumns(0);
            PlantaNueva.nombre.setCaretPosition(0);
            PlantaNueva.nombre.setText("");
            PlantaNueva.nombre.setSelectionEnd(-1);
            PlantaNueva.nombre.setSelectionStart(-1);


            texto2.setText("");

            PlantaNueva.nueva = "";
            Arbol.generarArbol();
        }

        if (e.getActionCommand().equals("Salir")) {
            // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto" 
            //System.exit(0);
            //planta_nueva.framePlantaNueva.setVisible(false);
            PlantaNueva.framePlantaNueva.dispose();

        }

    }
}
