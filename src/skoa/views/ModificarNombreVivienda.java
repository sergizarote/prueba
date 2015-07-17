package skoa.views;

import javax.swing.*;

import java.awt.Label;
import java.awt.event.*;
import java.io.*;

import javax.swing.JButton;

import javax.swing.JPanel;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import java.io.IOException;
import java.io.File;

public class ModificarNombreVivienda extends JPanel {

    public static JFrame frame_mod_viv = new JFrame("Modificar Nombre Vivienda");
    static String nombre = "";
    public static JTextField nombre_vivienda = new JTextField(15);
//	static JTextField imagen_vivienda = new JTextField(15);
    static String imagen_viv = "";
    static Label nombreviv = new Label();
    public static int llamado = 0;
    private static final long serialVersionUID = 1L;

    public static void main() {
        llamado = 1;

//		JLabel mensaje = new JLabel();
//		mensaje.setText("***Si sólo desea modificar el nombre de la vivienda no seleccione ninguna imagen.");

        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"	
        //frame_mod_viv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_mod_viv.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_mod_viv.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_mod_viv.setLocation(150, 50);
        frame_mod_viv.setSize(1000, 700);

        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();

        JMenu jMenu1 = new javax.swing.JMenu();
        jMenu1.setText("Archivo");
        JMenuItem archivo_item1 = new JMenuItem("Salir");
        jMenu1.add(archivo_item1);
        archivo_item1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        //System.exit(0);
                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        //frame_mod_viv.setVisible(false);
                        frame_mod_viv.setVisible(false);//dispose();
                    }
                });
        jMenuBar1.add(jMenu1);

        JMenu jMenu2 = new javax.swing.JMenu();
        jMenu2.setText("Menú Configuración");
        JMenuItem archivo_item2 = new JMenuItem("Volver");
        jMenu2.add(archivo_item2);
        archivo_item2.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        ModificarNombreVivienda.frame_mod_viv.setVisible(false);//dispose();

                        try {
//								configuracion.main();
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
        jMenuBar1.add(jMenu2);

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


        frame_mod_viv.setJMenuBar(jMenuBar1);

        //Solicitar email
        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Modificar el nombre de la vivienda: ");

//        JLabel mensaje2 = new JLabel();
//        mensaje2.setText("Seleccionar imagen de la vivienda: ");

        //Recoger email
        ModificarNombreVivienda.nombre_vivienda.setColumns(15);
        ModificarNombreVivienda.nombre_vivienda.setCaretPosition(0);
        ModificarNombreVivienda.nombre_vivienda.setText("");
        ModificarNombreVivienda.nombre_vivienda.setSelectionEnd(-1);
        ModificarNombreVivienda.nombre_vivienda.setSelectionStart(-1);

        nombre_vivienda.setText("");
        nombre_vivienda.setSize(250, 20);



        nombre_vivienda.addFocusListener(new FocusListener() {

            public void focusLost(FocusEvent e) {

                String aux = ((JTextField) e.getSource()).getText(); //lee texto escrito
                ModificarNombreVivienda.nombre = aux;



            }//end focuslost

            public void focusGained(FocusEvent e) {
                // No hacemos nada
            }
        });

//        imagen_vivienda.setText("");
//		imagen_vivienda.setSize(250, 20);
//		 JButton boton = new JButton("Examinar");
//	     boton.setSize(40, 20);
//	     boton.addActionListener((ActionListener) new ButtonModViv());



        JButton boton1 = new JButton("Aceptar");
        boton1.setSize(40, 20);
        boton1.addActionListener((ActionListener) new ButtonModViv());


        // TRABAJAR CON EL JPANEL--------------------------------------------


        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        Label label1 = new java.awt.Label();
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");
        nombreviv.setSize(150, 30);
        try {

            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();
            //xmlReader.setEncoding("UTF-8");
            xmlReader.setEncoding("iso-8859-1");
            Document doc = xmlReader.read(aFile);
            Element node = (Element) doc.selectSingleNode("//vivienda");

            nombreviv.setText("Nombre Actual de la vivienda:       " + node.valueOf("@name"));

        } catch (DocumentException e) {
            e.printStackTrace();
        }







        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(ModificarNombreVivienda.frame_mod_viv.getContentPane());
        ModificarNombreVivienda.frame_mod_viv.getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) // .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup() //                                		.addComponent(mensaje2)
                .addGap(400, 400, 400).addComponent(boton1)).addGroup(layout.createSequentialGroup().addComponent(mensaje1).addGap(18, 18, 18).addComponent(nombre_vivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addComponent(nombreviv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)) //                                .addGroup(layout.createSequentialGroup()
                )))).addGroup(layout.createSequentialGroup().addContainerGap(145, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup() //                  .addContainerGap()
                .addGap(55, 55, 55).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.DEFAULT_SIZE, 450, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(175, 175, 175).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(100, 100, 100).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(nombreviv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(55, 55, 55)).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mensaje1).addComponent(nombre_vivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(boton1)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING) //                        .addComponent(imagen_vivienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                ).addContainerGap().addGap(50, 50, 50).addContainerGap()));



        //--------------------------------------------------------------------------     
        frame_mod_viv.setVisible(true);

    } // end main
} //end class
class ButtonModViv extends JPanel
        implements ActionListener {

    static JFrame frame_ButtonModViv = new JFrame();

    ButtonModViv() {
    }

    public void navegar() {

        try {

            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();
            //xmlReader.setEncoding("UTF-8");
            xmlReader.setEncoding("iso-8859-1");
            Document doc = xmlReader.read(aFile);

            if (!ModificarNombreVivienda.nombre.equals("")) {
                Element node = (Element) doc.selectSingleNode("//vivienda");//[@nombre]" );
                Attribute atributo = node.attribute("name");
                atributo.setText(ModificarNombreVivienda.nombre);

                if (!ModificarNombreVivienda.imagen_viv.equals("")) {
                    Attribute atributo2 = node.attribute("logo");
                    atributo2.setText(ModificarNombreVivienda.imagen_viv);

                    String mostrar = "Se ha modificado el nombre e imagen de la vivienda";
                    mostrar += "\n";
                    mostrar += "en el fichero de configuración";
                    JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
                    Arbol.generarArbol();
                } else {
                    String mostrar = "Se ha modificado el nombre de la vivienda";
                    mostrar += "\n";
                    mostrar += "en el fichero de configuración";
                    JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
                    Arbol.generarArbol();
                }

                try {

                    File aFile1 = new File(NuevoProyecto.archivo);
                    SAXReader xmlReader1 = new SAXReader();
                    //xmlReader1.setEncoding("UTF-8");
                    xmlReader1.setEncoding("iso-8859-1");
                    Document doc1 = xmlReader1.read(aFile1);
                    Element node1 = (Element) doc1.selectSingleNode("//vivienda/email");

                    ModificarNombreVivienda.nombreviv.setText("Nombre Actual de la vivienda:       " + ModificarNombreVivienda.nombre);


                } catch (DocumentException e1) {
                    e1.printStackTrace();
                }

            } else {
                String mostrar = "Ha de introducir un nombre para la vivienda";
                JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
            }

            String aux = doc.asXML();
            FileWriter archivo;

            archivo = new FileWriter(NuevoProyecto.archivo);
            OutputFormat format = OutputFormat.createPrettyPrint();

            //format.setEncoding("UTF-8");
            format.setEncoding("iso-8859-1");

            XMLWriter writer = new XMLWriter(new FileWriter(NuevoProyecto.archivo));
            writer.write(doc);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    } //end navegar
    private JFileChooser fc;

    public void actionPerformed(ActionEvent e) {

        frame_ButtonModViv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//HIDE_ON_CLOSE);

        JLabel texto_ButtonModViv = new javax.swing.JLabel();

        //-----------------------
        if (e.getActionCommand().equals("Aceptar")) {

            try {
                File f = new File(NuevoProyecto.archivo);

                if (!f.exists()) {
                    if (!ModificarNombreVivienda.nombre.equals("")) {
                        if (!ModificarNombreVivienda.imagen_viv.equals("")) {
                            Document documento = DocumentHelper.createDocument();
                            org.dom4j.Element root = documento.addElement("vivienda");
                            root.addAttribute("name", ModificarNombreVivienda.nombre);
                            root.addAttribute("logo", ModificarNombreVivienda.imagen_viv);
                            root.addAttribute("contador", "1");

                            FileWriter archivo = new FileWriter(NuevoProyecto.archivo, true);
                            OutputFormat format = OutputFormat.createPrettyPrint();

                            //format.setEncoding("UTF-8");
                            format.setEncoding("iso-8859-1");

                            XMLWriter writer = new XMLWriter(archivo, format);

                            writer.write(documento);
                            writer.close();
                            String mostrar = "Se ha modificado el nombre e imagen de la vivienda";
                            mostrar += "\n";
                            mostrar += "en el fichero de configuración";
                            JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
                            Arbol.generarArbol();

                            try {

                                File aFile = new File(NuevoProyecto.archivo);
                                SAXReader xmlReader = new SAXReader();
                                //xmlReader.setEncoding("UTF-8");
                                xmlReader.setEncoding("iso-8859-1");
                                Document doc = xmlReader.read(aFile);
                                Element node = (Element) doc.selectSingleNode("//vivienda/email");

                                ModificarNombreVivienda.nombreviv.setText("Nombre Actual de la vivienda:       " + ModificarNombreVivienda.nombre);


                            } catch (DocumentException e1) {
                                e1.printStackTrace();
                            }

                        } else {
                            String mostrar = "Se esta creando el fichero.";
                            mostrar += "\n";
                            mostrar += "Debe selecciona una imagen para la vivienda";
                            JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
                        }
                    } else {
                        String mostrar = "Debe introducir un nombre para la vivienda";
                        JOptionPane.showMessageDialog(null, mostrar, "Alerta", 1);
                    }
                } else {
                    navegar();

                }//end else

            } catch (IOException e2) {
                e2.printStackTrace();
            }


            ButtonModViv.frame_ButtonModViv.setVisible(false);
            texto_ButtonModViv.setText("");



            ModificarNombreVivienda.nombre_vivienda.setColumns(0);
            ModificarNombreVivienda.nombre_vivienda.setCaretPosition(0);
            ModificarNombreVivienda.nombre_vivienda.setText("");
            ModificarNombreVivienda.nombre_vivienda.setSelectionEnd(-1);
            ModificarNombreVivienda.nombre_vivienda.setSelectionStart(-1);


            Arbol.generarArbol();

        }





    }
}
