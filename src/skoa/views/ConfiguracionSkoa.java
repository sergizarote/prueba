package skoa.views;

import skoa.views.ModificarEmail;
import skoa.views.Arbol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import skoa.views.EliminarDispositivos;
import skoa.views.EliminarEstancia;
import skoa.views.EliminarPlanta;
import skoa.views.EstanciaCaracteristicas;
import skoa.views.EstanciaNueva;
import skoa.views.ModificarNombreVivienda;
import skoa.views.ModificarPlano;
import skoa.views.PlantaNueva;
import skoa.views.NuevoProyecto;
import org.dom4j.DocumentException;
import skoa.helpers.Utils;
import skoa.views.SkoaMain;

public class ConfiguracionSkoa {

    public static JFrame frame_configuracion = new JFrame();
    public static int llamado = 0;
    public static JScrollPane arbol_configuracion = new javax.swing.JScrollPane();

    public static void main() throws DocumentException {
              org.jdesktop.application.ResourceMap resourceMap 
          = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class)
                .getContext().getResourceMap(ConfiguracionSkoa.class);
     
        frame_configuracion.setTitle(resourceMap.getString("title"));

        llamado = 1;
        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"	
        //frame_configuracion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_configuracion.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_configuracion.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_configuracion.setLocation(150, 50);
        frame_configuracion.setSize(1000, 700);

        JPanel A_Planta = new javax.swing.JPanel();
        JPanel E_Planta = new javax.swing.JPanel();
        JPanel A_Estancia = new javax.swing.JPanel();
        JPanel E_Estancia = new javax.swing.JPanel();
        JPanel A_Actuadores = new javax.swing.JPanel();
        JPanel E_Actuadores = new javax.swing.JPanel();
        JPanel Mod_Plano = new javax.swing.JPanel();



        A_Planta.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(0, 0, 0)), resourceMap.getString("A_Planta.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N

        E_Planta.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(0, 0, 0)), resourceMap.getString("E_Planta.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N

        A_Estancia.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(0, 0, 0)), resourceMap.getString("A_Estancia.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), 
                new java.awt.Color(0, 0, 0)))); // NOI18N
        
        
        E_Estancia.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder
                (new java.awt.Color(0, 0, 0)), resourceMap.getString("E_Estancia.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N
        A_Actuadores.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(0, 0, 0)), resourceMap.getString("A_Actuadores.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N

        E_Actuadores.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(0, 0, 0)),  resourceMap.getString("E_Actuadores.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N

        Mod_Plano.setBorder(javax.swing.BorderFactory.createTitledBorder(
                javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(
                new java.awt.Color(0, 0, 0)), "Modificar el Plano de una Estancia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N

        JButton boton_a_planta = new javax.swing.JButton();
        JButton boton_e_planta = new javax.swing.JButton();
        JButton boton_a_estancia = new javax.swing.JButton();
        JButton boton_e_estancia = new javax.swing.JButton();
        JButton boton_a_actuadores = new javax.swing.JButton();
        JButton boton_e_actuadores = new javax.swing.JButton();
        JButton boton_mod_plano = new javax.swing.JButton();

        boton_a_planta.setText(resourceMap.getString("boton_a_planta.text"));
        boton_a_planta.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
                //       planta_nueva.main();
                if (PlantaNueva.llamado == 0) {
                    PlantaNueva.main();
                } else {
                    PlantaNueva.framePlantaNueva.setVisible(true);
                }

            }
        });
        boton_e_planta.setText(resourceMap.getString("boton_e_planta.text"));
        boton_e_planta.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
                //	   eliminarPlanta.main();
                if (EliminarPlanta.llamado == 0) {
                    EliminarPlanta.main();
                } else {
                    EliminarPlanta.frameEliminarPlanta.setVisible(true);
                }

            }
        });

        boton_a_estancia.setText(resourceMap.getString("boton_a_estancia.text"));
        boton_a_estancia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
//       estancia_nueva.main();
                if (EstanciaNueva.llamado == 0) {
                    EstanciaNueva.main();
                } else {
                    EstanciaNueva.frame_estancia.setVisible(true);
                }

            }
        });

        boton_e_estancia.setText(resourceMap.getString("boton_e_estancia.text"));//;
        boton_e_estancia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
//       EliminarEstancia.main();
                if (EliminarEstancia.llamado == 0) {
                    EliminarEstancia.main();
                } else {
                    EliminarEstancia.frameEliminarEstancia.setVisible(true);
                }

            }
        });

        boton_a_actuadores.setText(resourceMap.getString("boton_a_actuadores.text"));
        boton_a_actuadores.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
//	   EstanciaCaracteristicas.main();
                if (EstanciaCaracteristicas.llamado == 0) {
                    EstanciaCaracteristicas.main();
                } else {
                    EstanciaCaracteristicas.frame_estancia_carac.setVisible(true);
                }

            }
        });
        boton_e_actuadores.setText(resourceMap.getString("boton_e_actuadores.text"));
        boton_e_actuadores.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
//	   EliminarDispositivos.main();
                if (EliminarDispositivos.llamado == 0) {
                    EliminarDispositivos.main();
                } else {
                    EliminarDispositivos.frame_eliminar_dispositivos.setVisible(true);
                }
            }
        });


        boton_mod_plano.setText(resourceMap.getString("boton_mod_plano.text"));
        boton_mod_plano.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evento) {
                ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
                try {
//		ModificarPlano.main();
                    if (ModificarPlano.llamado == 0) {
                        ModificarPlano.main();
                    } else {
                        ModificarPlano.frame_modificarPlano.setVisible(true);
                    }

                } catch (DocumentException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

       

        String path = SkoaMain.ROOT_ICONS_PATH + "flecha.jpg";
        //System.out.println(Configuracion.class.getClass().getResource(path));
        ImageIcon icono = Utils.createImageIcon(path);
        JLabel flecha = new JLabel(icono, JLabel.CENTER);
        JLabel flecha2 = new JLabel(icono, JLabel.CENTER);
        JLabel flecha3 = new JLabel(icono, JLabel.CENTER);

        JSeparator jSeparator1 = new javax.swing.JSeparator();
        JSeparator jSeparator2 = new javax.swing.JSeparator();
//          Label label1 = new java.awt.Label();

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
//          label1.setText("Configuration Menu");

        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();


        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++     
        JMenu jMenu3 = new javax.swing.JMenu();
        jMenu3.setText("                                            ");
        jMenu3.setFocusable(false);
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        JMenu jMenu4 = new javax.swing.JMenu();
        String msg = resourceMap.getString("labelMenuTitle");
        msg = msg + NuevoProyecto.nombre_archivo;
        jMenu4.setText(msg);
        jMenu4.setEnabled(false);

        jMenuBar1.add(jMenu4);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        frame_configuracion.setJMenuBar(jMenuBar1);


        Arbol.generarArbol();
        arbol_configuracion = Arbol.MOSTRAR_CONFIGURACION;

        //**************************************************************************

        javax.swing.GroupLayout jPanel1 = new javax.swing.GroupLayout(A_Planta);
        A_Planta.setLayout(jPanel1);
        jPanel1.setHorizontalGroup(
                jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1.createSequentialGroup().addGap(22, 22, 22).addComponent(boton_a_planta).addContainerGap(40, Short.MAX_VALUE)));
        jPanel1.setVerticalGroup(
                jPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_a_planta).addGap(10, 10, 10)));


        javax.swing.GroupLayout jPanel2 = new javax.swing.GroupLayout(E_Planta);
        E_Planta.setLayout(jPanel2);
        jPanel2.setHorizontalGroup(
                jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2.createSequentialGroup().addGap(22, 22, 22).addComponent(boton_e_planta).addContainerGap(40, Short.MAX_VALUE)));
        jPanel2.setVerticalGroup(
                jPanel2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_e_planta).addGap(10, 10, 10)));



        javax.swing.GroupLayout jPanel3 = new javax.swing.GroupLayout(A_Estancia);
        A_Estancia.setLayout(jPanel3);
        jPanel3.setHorizontalGroup(
                jPanel3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3.createSequentialGroup().addGap(22, 22, 22).addComponent(boton_a_estancia).addContainerGap(40, Short.MAX_VALUE)));
        jPanel3.setVerticalGroup(
                jPanel3.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_a_estancia).addGap(10, 10, 10)));



        javax.swing.GroupLayout jPanel4 = new javax.swing.GroupLayout(E_Estancia);
        E_Estancia.setLayout(jPanel4);
        jPanel4.setHorizontalGroup(
                jPanel4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4.createSequentialGroup().addGap(22, 22, 22).addComponent(boton_e_estancia).addContainerGap(40, Short.MAX_VALUE)));
        jPanel4.setVerticalGroup(
                jPanel4.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_e_estancia).addGap(10, 10, 10)));



        javax.swing.GroupLayout jPanel5 = new javax.swing.GroupLayout(A_Actuadores);
        A_Actuadores.setLayout(jPanel5);
        jPanel5.setHorizontalGroup(
                jPanel5.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5.createSequentialGroup().addGap(22, 22, 22).addComponent(boton_a_actuadores).addContainerGap(40, Short.MAX_VALUE)));
        jPanel5.setVerticalGroup(
                jPanel5.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_a_actuadores).addGap(10, 10, 10)));




        javax.swing.GroupLayout jPanel6 = new javax.swing.GroupLayout(E_Actuadores);
        E_Actuadores.setLayout(jPanel6);
        jPanel6.setHorizontalGroup(
                jPanel6.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6.createSequentialGroup().addGap(22, 22, 22).addComponent(boton_e_actuadores).addContainerGap(40, Short.MAX_VALUE)));
        jPanel6.setVerticalGroup(
                jPanel6.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel6.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_e_actuadores).addGap(10, 10, 10)));



        javax.swing.GroupLayout jPanel7 = new javax.swing.GroupLayout(Mod_Plano);
        Mod_Plano.setLayout(jPanel7);
        jPanel7.setHorizontalGroup(
                jPanel7.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_mod_plano).addGap(10, 10, 10)));
        jPanel7.setVerticalGroup(
                jPanel7.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7.createSequentialGroup().addGap(10, 10, 10).addComponent(boton_mod_plano).addGap(10, 10, 10)));


        //+++++++++++++++++

        JLabel nombre_viv = new javax.swing.JLabel();
        nombre_viv.setText(resourceMap.getString("nombre_viv.text") );
        JLabel mail = new javax.swing.JLabel();
        mail.setText(resourceMap.getString("mail.text"));

        JButton boton2 = new javax.swing.JButton(resourceMap.getString("boton2.text"));//;
        boton2.setSize(40, 20);
        boton2.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
//          		    	mod_nombre_viv.main();
                        if (ModificarNombreVivienda.llamado == 0) {
                            ModificarNombreVivienda.main();
                        } else {
                            ModificarNombreVivienda.nombre_vivienda.setColumns(15);
                        }
                        ModificarNombreVivienda.nombre_vivienda.setCaretPosition(0);
                        ModificarNombreVivienda.nombre_vivienda.setText("");
                        ModificarNombreVivienda.nombre_vivienda.setSelectionEnd(-1);
                        ModificarNombreVivienda.nombre_vivienda.setSelectionStart(-1);
                        ModificarNombreVivienda.frame_mod_viv.setVisible(true);

                    }
                });

        JButton boton3 = new javax.swing.JButton(resourceMap.getString("boton3.text"));
        boton3.setSize(40, 20);
        boton3.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        ConfiguracionSkoa.frame_configuracion.setVisible(false);//dispose();
//          		    	mod_email.main();
                        if (ModificarEmail.llamado == 0) {
                            ModificarEmail.main();
                        } else {
                            ModificarEmail.frame.setVisible(true);
                        }

                    }
                });

        JPanel panel3 = new JPanel();
        JPanel panel2 = new JPanel();

        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Modificar dirección e-mail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Modificar el nombre de la Vivienda/Hotel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)))); // NOI18N


        //---------
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(nombre_viv).addGap(10, 10, 10).addComponent(boton2).addGap(25, 25, 25)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(nombre_viv).addComponent(boton2)).addGap(10, 10, 10)));



        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(mail).addGap(10, 10, 10).addComponent(boton3).addGap(25, 25, 25)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(mail).addComponent(boton3)).addGap(10, 10, 10)));



        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_configuracion.getContentPane());
        frame_configuracion.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup() //                                  .addComponent(arbol_configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)) // .addComponent(scrollbar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(5, 5, 5) //                              .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                ).addGap(10, 10, 10).addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(A_Actuadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(A_Estancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(A_Planta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(flecha).addComponent(flecha2))).addGroup(layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(flecha3))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(E_Actuadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(E_Estancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(E_Planta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addComponent(Mod_Plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(197, 197, 197)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35) //                 .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE) //                 .addComponent(arbol_configuracion, javax.swing.GroupLayout.DEFAULT_SIZE,  450, javax.swing.GroupLayout.DEFAULT_SIZE)
                .addGap(275, 275, 275).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(75, 75, 75).addComponent(flecha)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(E_Planta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(A_Planta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(E_Estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(A_Estancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(20, 20, 20).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(E_Actuadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(A_Actuadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addGap(20, 20, 20)).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addComponent(flecha2).addGap(78, 78, 78).addComponent(flecha3).addGap(49, 49, 49))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(Mod_Plano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(30, 30, 30).addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(20, 20, 20).addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(243, 243, 243)));




        //********************************************************************************

        frame_configuracion.setVisible(true);

    }//end mail
}
