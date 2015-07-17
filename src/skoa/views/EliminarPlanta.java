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

public class EliminarPlanta {

    public static JFrame frameEliminarPlanta = new JFrame("Eliminar Planta");
    public static JComboBox desplegable_planta = new javax.swing.JComboBox();
    static String planta_seleccionada;
    public static int llamado = 0;

    /*public int confirmacion()
    {
    javax.swing.JButton BSi;
    javax.swing.JButton BNo;
    int resultado = 0;
    
    BSi = new JButton("Sí");
    BSi.addActionListener(new SiBoton());
    BNo = new JButton("No");
    
    }*/
    public static void main() {
        llamado = 1;

        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
        //frameEliminarPlanta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frameEliminarPlanta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameEliminarPlanta.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameEliminarPlanta.setLocation(150, 50);
        frameEliminarPlanta.setSize(1000, 700);

        JLabel mensaje1 = new JLabel();
        mensaje1.setText("Seleccione el nombre de la planta que desea eliminar: ");

        desplegable_planta.addActionListener((ActionListener) new ButtonModifPlano());
        Acciones.mostrarPlantasVistaEliminarPlanta();
        desplegable_planta.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EliminarPlanta.planta_seleccionada = (String) EliminarPlanta.desplegable_planta.getSelectedItem();

                    }
                });

        JButton boton1 = new JButton("Eliminar Planta");
        boton1.setSize(40, 20);
        boton1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        if (EliminarPlanta.planta_seleccionada == null || EliminarPlanta.planta_seleccionada.indexOf("--Plantas--") != -1) //if (eliminarPlanta.planta_seleccionada != "--Plantas--" )
                        {
                            //++++++++++++++       MENSAJE ALERTA 
                            String mostrar = "Debe seleccionar una planta primero";
                            JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
                        } else // Solicitamos al usuario su confirmación
                        {
                            Confirmar.main(1);
                        }
                    }
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
                        //System.exit(0);
                        frameEliminarPlanta.setVisible(false);
//                        frameEliminarPlanta.dispose();
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
                        EliminarPlanta.frameEliminarPlanta.setVisible(false);
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



        EliminarPlanta.frameEliminarPlanta.setJMenuBar(jMenuBar1);

        Arbol.generarArbol();
        //**************************************************************************

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(EliminarPlanta.frameEliminarPlanta.getContentPane());// frame5.getContentPane());

        EliminarPlanta.frameEliminarPlanta.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(2, 2, 2)) // .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(10, 10, 10).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(34, 34, 34).addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(50, Short.MAX_VALUE).addContainerGap(259, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //                  .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(17, 17, 17) //                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                //.addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE).addGap(275, 275, 275).addContainerGap()).addGroup(layout.createSequentialGroup().addGap(134, 134, 134).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(190, Short.MAX_VALUE)));

        //********************************************************************************


        EliminarPlanta.frameEliminarPlanta.setVisible(true);

    }//end main
}//end class