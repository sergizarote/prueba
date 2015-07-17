package skoa.views;

import javax.swing.*;

import java.awt.Label;
import java.awt.event.*;
import java.io.*;

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
import skoa.views.NuevoProyecto;

public class ModificarEmail extends JPanel {

    public static JFrame frame = new JFrame("Modificar e-mail");
    static String mail = "";
    public static JTextField email_envio = new JTextField(15);
    static Label nombreviv = new Label();
    public static int llamado = 0;

    public static void main() {
        llamado = 1;
        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLocation(150, 50);
        frame.setSize(1000, 700);


        ModificarEmail.email_envio.setSize(150, 20);
        ModificarEmail.email_envio.setText("");

        ModificarEmail.email_envio.addFocusListener(new FocusListener() {

            public void focusLost(FocusEvent e) {

                String aux = ((JTextField) e.getSource()).getText(); //lee texto escrito
                ModificarEmail.mail = aux;

            }//end focuslost

            public void focusGained(FocusEvent e) {
                // No hacemos nada
            }
        });



        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();

        JMenu jMenu1 = new javax.swing.JMenu();
        jMenu1.setText("Archivo");
        JMenuItem archivo_item1 = new JMenuItem("Salir");
        jMenu1.add(archivo_item1);
        archivo_item1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        //System.exit(0);
                        frame.setVisible(false);
//                        frame.dispose();
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
                        ModificarEmail.frame.setVisible(false);
//        		    	mod_email.frame.dispose();

                        try {
//						configuracion.main();

                            if (ConfiguracionSkoa.llamado == 0) {
                                ConfiguracionSkoa.main();
                            } else {
                                ConfiguracionSkoa.frame_configuracion.setVisible(true);
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

        ModificarEmail.frame.setJMenuBar(jMenuBar1);

        //Solicitar email
        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Introduzca su nueva direccion de email: ");



        JButton boton1 = new JButton("Modificar e-mail");
        boton1.setSize(40, 20);
        boton1.addActionListener((ActionListener) new ButtonModEmail());




        // TRABAJAR CON EL JPANEL--------------------------------------------



        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
        Label label1 = new java.awt.Label();

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");
        nombreviv.setSize(450, 30);
        try {

            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();
            //xmlReader.setEncoding("UTF-8");
            xmlReader.setEncoding("iso-8859-1");
            Document doc = xmlReader.read(aFile);
            Element node = (Element) doc.selectSingleNode("//vivienda/email");

            nombreviv.setText("E-mail de contacto Actual:       " + node.valueOf("@direccion"));


        } catch (DocumentException e) {
            e.printStackTrace();
        }



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(ModificarEmail.frame.getContentPane());
        ModificarEmail.frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) // .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addComponent(mensaje1).addGap(18, 18, 18).addComponent(email_envio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(boton1)).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addComponent(nombreviv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addGap(120, 120, 120) //.addComponent(boton2)
                )).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup() //                  .addContainerGap()
                .addGap(55, 55, 55).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.DEFAULT_SIZE, 450, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(175, 175, 175).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup() //                		 .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(nombreviv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(55, 55, 55)).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mensaje1).addComponent(email_envio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(boton1)).addGap(42, 42, 42).addGap(475, 475, 475) //.addComponent(boton2)
                ));





        //--------------------------------------------------------------------------


        frame.setVisible(true);



    } // end main
} //end class
class ButtonModEmail implements ActionListener {

    static JFrame frame3 = new JFrame();

    ButtonModEmail() {
    }

    public void navegar() {

        try {
            if (ModificarEmail.mail.length() != 0) {
                File aFile = new File(NuevoProyecto.archivo);
                SAXReader xmlReader = new SAXReader();

                //xmlReader.setEncoding("UTF-8");
                xmlReader.setEncoding("iso-8859-1");

                Document doc = xmlReader.read(aFile);

                Element node = (Element) doc.selectSingleNode("//vivienda/email");
                if (node == null) {
                    node = (Element) doc.selectSingleNode("//vivienda");//[@nombre]" );
                    org.dom4j.Element anadir = node.addElement("email");//( "plantas" );

                    node = (Element) doc.selectSingleNode("//vivienda/email");
                    anadir = node.addAttribute("direccion", ModificarEmail.mail);
                    NuevoProyecto.email_fichero = ModificarEmail.mail;
                }//end if
                else {
                    Attribute atributo = node.attribute("direccion");
                    atributo.setText(ModificarEmail.mail);

                }//end else
                String aux = doc.asXML();
                FileWriter archivo;

                archivo = new FileWriter(NuevoProyecto.archivo);
                OutputFormat format = OutputFormat.createPrettyPrint();

                //format.setEncoding("UTF-8");
                format.setEncoding("iso-8859-1");

                XMLWriter writer = new XMLWriter(new FileWriter(NuevoProyecto.archivo));
                writer.write(doc);
                writer.close();

                String mostrar = "Se ha introducido su email";
                mostrar += "\n";
                mostrar += ModificarEmail.mail;
                mostrar += "\n";
                mostrar += "en el fichero de configuración";
                JOptionPane.showMessageDialog(null, mostrar, "Información", 1);


                try {

                    File aFile1 = new File(NuevoProyecto.archivo);
                    SAXReader xmlReader1 = new SAXReader();
                    //xmlReader1.setEncoding("UTF-8");
                    xmlReader1.setEncoding("iso-8859-1");
                    Document doc1 = xmlReader1.read(aFile1);
                    Element node1 = (Element) doc1.selectSingleNode("//vivienda/email");

                    ModificarEmail.nombreviv.setText("E-mail de contacto Actual:       " + ModificarEmail.mail);


                } catch (DocumentException e1) {
                    e1.printStackTrace();
                }
            } else {
                String mostrar2 = "Ha de introducir una dirección de email";
                JOptionPane.showMessageDialog(null, mostrar2, "Alerta", 1);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    } //end navegar

    public void actionPerformed(ActionEvent e) {

        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ModificarEmail.email_envio.setText("");

        JLabel texto2 = new javax.swing.JLabel();

        if (e.getActionCommand().equals("Modificar e-mail")) {


            try {
                File f = new File(NuevoProyecto.archivo);

                if (!f.exists()) {
                    if (ModificarEmail.mail.length() != 0) {
                        Document documento = DocumentHelper.createDocument();
                        org.dom4j.Element root = documento.addElement("vivienda");

                        @SuppressWarnings("unused")
                        org.dom4j.Element email = root.addElement("email").addAttribute("direccion", ModificarEmail.mail);
                        FileWriter archivo = new FileWriter(NuevoProyecto.archivo, true);
                        OutputFormat format = OutputFormat.createPrettyPrint();

                        //format.setEncoding("UTF-8");
                        format.setEncoding("iso-8859-1");

                        XMLWriter writer = new XMLWriter(archivo, format);

                        writer.write(documento);
                        writer.close();

                        String mostrar = "Se ha introducido su email";
                        mostrar += "\n";
                        mostrar += ModificarEmail.mail;
                        mostrar += "\n";
                        mostrar += "en el fichero de configuración";
                        JOptionPane.showMessageDialog(null, mostrar, "Información", 1);

                        ModificarEmail.email_envio.setCaretPosition(0);
                        ModificarEmail.email_envio.setText("");

                        try {

                            File aFile = new File(NuevoProyecto.archivo);
                            SAXReader xmlReader = new SAXReader();
                            //xmlReader.setEncoding("UTF-8");
                            xmlReader.setEncoding("iso-8859-1");
                            Document doc = xmlReader.read(aFile);
                            Element node = (Element) doc.selectSingleNode("//vivienda/email");

                            ModificarEmail.nombreviv.setText("E-mail de contacto Actual:       " + ModificarEmail.mail);


                        } catch (DocumentException e1) {
                            e1.printStackTrace();
                        }

                    } else {
                        String mostrar2 = "Ha de introducir una dirección de email";
                        JOptionPane.showMessageDialog(null, mostrar2, "Alerta", 1);
                    }
                } else {
                    navegar();

                }//end else

            } catch (IOException e2) {
                e2.printStackTrace();
            }



        }//end if

        if (e.getActionCommand().equals("Aceptar")) {
            ModificarEmail.frame.dispose();

//	   mod_email.email_envio.setColumns(0);
            ModificarEmail.email_envio.setCaretPosition(0);
            ModificarEmail.email_envio.setText("");
            ModificarEmail.email_envio.setSelectionEnd(-1);
            ModificarEmail.email_envio.setSelectionStart(-1);


            texto2.setText("");

            ModificarEmail.mail = "";
            //arbol.generar_arbol();
        }//end if


    }//end public void
}//end class

