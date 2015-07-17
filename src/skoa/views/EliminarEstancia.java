package skoa.views;

import skoa.helpers.Acciones;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import org.dom4j.DocumentException;

public class EliminarEstancia {

    public static JFrame frameEliminarEstancia = new JFrame("Eliminar Estancia");
    public static JComboBox desplegable_planta = new javax.swing.JComboBox();
    public static JComboBox desplegable_estancia = new javax.swing.JComboBox();
    public static String planta_seleccionada;
    static String estancia_seleccionada;
    public static int llamado = 0;

    public static void main() {
        llamado = 1;

        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"			
        //frameEliminarEstancia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frameEliminarEstancia.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameEliminarEstancia.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameEliminarEstancia.setLocation(150, 50);
        frameEliminarEstancia.setSize(1000, 700);

        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Seleccione la planta de la estancia que desea eliminar: ");
        JLabel mensaje2 = new JLabel();
        mensaje1.setText("Seleccione la estancia desea eliminar: ");

        desplegable_planta.addActionListener((ActionListener) new ButtonModifPlano());

        Acciones.mostrarPlantasVistaEliminarEstancia();

        desplegable_planta.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EliminarEstancia.planta_seleccionada = (String) EliminarEstancia.desplegable_planta.getSelectedItem();

                        if (!EliminarEstancia.planta_seleccionada.equals("--Plantas--")) {
                            EliminarEstancia.desplegable_estancia.setEnabled(true);
                            Acciones.mostrarEstanciasVistaEliminarEstancia();
                        }
                        if (EliminarEstancia.planta_seleccionada.equals("--Plantas--")) {
                            EliminarEstancia.desplegable_estancia.setEnabled(false);
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
                        EliminarEstancia.estancia_seleccionada = (String) EliminarEstancia.desplegable_estancia.getSelectedItem();

                    }
                });




        JButton boton1 = new JButton("Eliminar Estancia");
        boton1.setSize(40, 20);
        boton1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        if (EliminarEstancia.planta_seleccionada == null || EliminarEstancia.estancia_seleccionada == null
                                || EliminarEstancia.planta_seleccionada.indexOf("--Plantas--") != -1 || EliminarEstancia.estancia_seleccionada.indexOf("--Estancias--") != -1) {
                            //++++++++++++++       MENSAJE ALERTA 
                            String mostrar = "Debe seleccionar una planta y una estancia primero";
                            JOptionPane.showMessageDialog(null, mostrar, "alerta", 1);
                        } else {
                            // Solicitamos al usuario su confirmación
                            Confirmar.main(2);
                        }
                    } // fin de public void actionPerformed
                }); // fin de la llamada a addActionListener







        //Comienza el menu principal
        JSeparator jSeparator1 = new javax.swing.JSeparator();

        JSeparator jSeparator2 = new javax.swing.JSeparator();
        Label label1 = new java.awt.Label();

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");

        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();

        JMenu jMenu1 = new javax.swing.JMenu();
        jMenu1.setText("Archivo");
        JMenuItem archivo_item1 = new JMenuItem("Salir");
        jMenu1.add(archivo_item1);
        archivo_item1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {

                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        // System.exit(0);
                        frameEliminarEstancia.setVisible(false);
//                        frameEliminarEstancia.dispose();
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
                        EliminarEstancia.frameEliminarEstancia.setVisible(false);
                        try {
//						configuracion.main();
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



        EliminarEstancia.frameEliminarEstancia.setJMenuBar(jMenuBar1);





        Arbol.generarArbol();
        //**************************************************************************

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(EliminarEstancia.frameEliminarEstancia.getContentPane());// frame5.getContentPane());
        //frame5
        EliminarEstancia.frameEliminarEstancia.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) // .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(desplegable_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(34, 34, 34).addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(50, Short.MAX_VALUE).addContainerGap(259, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //                  .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(17, 17, 17) //                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                //.addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE).addGap(275, 275, 275).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(134, 134, 134).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(desplegable_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(190, Short.MAX_VALUE)));

        //********************************************************************************


        EliminarEstancia.frameEliminarEstancia.setVisible(true);



    }//end main
}//end class