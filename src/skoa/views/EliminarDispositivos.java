package skoa.views;

import skoa.helpers.Acciones;
import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;


import org.dom4j.DocumentException;

import java.awt.event.MouseListener;


import javax.swing.TransferHandler;

public abstract class EliminarDispositivos extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    public static int llamado = 0;
    //Frame principal	
    public static JFrame frame_eliminar_dispositivos = new JFrame("Eliminar Actuadores/Sensores");
//	static JFrame frame_eliminar_dispositivos = new JFrame("Delete Actuators/Sensors");
    //Paneles
    static JPanel panel_global = new javax.swing.JPanel();
    public static JLayeredPane panel_plano = new javax.swing.JLayeredPane();
    static JPanel panel_act = new javax.swing.JPanel();
    static JPanel panel_sen = new javax.swing.JPanel();
    static JPanel panel_luz_reg = new javax.swing.JPanel();
    static JPanel panel_luz_con = new javax.swing.JPanel();
    static JPanel panel_persianas = new javax.swing.JPanel();
    static JPanel panel_electrovalvula = new javax.swing.JPanel();
    // ...
    static JPanel panel_apertura = new javax.swing.JPanel();
    static JPanel panel_movimiento = new javax.swing.JPanel();
    static JPanel panel_temperatura = new javax.swing.JPanel();
    static JPanel panel_combinado = new javax.swing.JPanel();
    static JPanel panel_inundacion = new javax.swing.JPanel();
    static JPanel panel_contadores = new javax.swing.JPanel();
    static JPanel panel_despegables = new javax.swing.JPanel();
    //Variables Globales
    public static String planta_estancia = "";
    public static String nombre_estancia = "";
    static String dir_imagen = "";
    static ImageIcon iconito = new ImageIcon();
    static JLabel aclaracion = new javax.swing.JLabel();
    static JSeparator jSeparator1 = new javax.swing.JSeparator();
    static JSeparator jSeparator2 = new javax.swing.JSeparator();
    static Label label1 = new java.awt.Label();
    static int frame1 = 1;
    static JLabel plano = new JLabel();
    //label luces regulables
    //static ImageIcon icono = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\luzreg.png");
    static ImageIcon icono = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "luzreg.png"));
    static JLabel luzreg = new JLabel(icono, JLabel.CENTER);//luces regulables
    //label luces conmutables
    //static ImageIcon icono2 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\bca.png");
    static ImageIcon icono2 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "bca.png"));
    static JLabel luzcon = new JLabel(icono2, JLabel.CENTER);
    //label persianas
    //static ImageIcon icono3 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\pa.png");
    static ImageIcon icono3 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "pa.png"));
    static JLabel persianas = new JLabel(icono3, JLabel.CENTER);
    //label electrovalvula
    //static ImageIcon icono4 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\elv.png");
    static ImageIcon icono4 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "elv.png"));
    static JLabel electrovalvula = new JLabel(icono4, JLabel.CENTER);
    //label apertura/cierre
    //static ImageIcon icono5 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\puc.png");
    static ImageIcon icono5 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "pucelv.png"));
    static JLabel apertura = new JLabel(icono5, JLabel.CENTER);
    //label movimiento
    //static ImageIcon icono6 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\prdetec.png");
    static ImageIcon icono6 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "prdetec.png"));
    static JLabel movimiento = new JLabel(icono6, JLabel.CENTER);
    //label temperatura
    //static ImageIcon icono7 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\term.png");
    static ImageIcon icono7 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "term.png"));
    static JLabel temperatura = new JLabel(icono7, JLabel.CENTER);
    //label combinado
    //static ImageIcon icono8 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\comb.png");
    static ImageIcon icono8 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "comb.png"));
    static JLabel combinado = new JLabel(icono8, JLabel.CENTER);
    //label inundacion
    //static ImageIcon icono9 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\inund.png");
    static ImageIcon icono9 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "inund.png"));
    static JLabel inundacion = new JLabel(icono9, JLabel.CENTER);
    //label contadores
    //static ImageIcon icono10 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\cont.png");
    static ImageIcon icono10 = new ImageIcon(EliminarDispositivos.class.getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "cont.png"));
    static JLabel contadores = new JLabel(icono10, JLabel.CENTER);
    public static JComboBox desplegable_planta = new javax.swing.JComboBox();
    public static JComboBox desplegable_estancia = new javax.swing.JComboBox();
    public static String planta_seleccionada;
    public static String estancia_seleccionada;

    public static void main() {
        llamado = 1;

        plano.setSize(485, 310);
        plano.setBounds(40, 0, 400, 580);

        Acciones.mostrarPlantasVistaEliminarDispositivos();
        desplegable_planta.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EliminarDispositivos.planta_seleccionada = (String) EliminarDispositivos.desplegable_planta.getSelectedItem();

                        if (!EliminarDispositivos.planta_seleccionada.equals("--Plantas--")) {
                            planta_estancia = EliminarDispositivos.planta_seleccionada;
                            EliminarDispositivos.desplegable_estancia.setEnabled(true);
                            Acciones.mostrarEstanciasVistaEliminarDispositivos();
                        }
                        if (EliminarDispositivos.planta_seleccionada.equals("--Plantas--")) {
                            EliminarDispositivos.desplegable_estancia.setEnabled(false);
                            Component[] componentes = EliminarDispositivos.panel_plano.getComponents();
                            for (int i = 0; i < componentes.length; i++) {
                                EliminarDispositivos.panel_plano.remove(componentes[i]);// 
                                EliminarDispositivos.panel_plano.moveToBack(componentes[i]);


                            }//end for
                        }

                    }
                });

        desplegable_estancia.setEnabled(false);
        desplegable_estancia.addItem("--Estancias--");
//         desplegable_estancia.addItem("--Rooms--");
        desplegable_estancia.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EliminarDispositivos.estancia_seleccionada = (String) EliminarDispositivos.desplegable_estancia.getSelectedItem();

                        if (EliminarDispositivos.estancia_seleccionada != "--Estancias--" && EliminarDispositivos.estancia_seleccionada != "null") {
//			       		  if(EliminarDispositivos.estancia_seleccionada != "--Rooms--" && EliminarDispositivos.estancia_seleccionada != "null"){

                            nombre_estancia = EliminarDispositivos.estancia_seleccionada;
                            EliminarDispositivos.dir_imagen = Acciones.SeleccionarImagen(EliminarDispositivos.planta_estancia, EliminarDispositivos.nombre_estancia);

                            Component[] componentes = EliminarDispositivos.panel_plano.getComponents();
                            for (int i = 0; i < componentes.length; i++) {

                                String name = componentes[i].getName();

                                if (name != null) {
                                    if (name.equals("regulacion")
                                            || name.equals("conmutacion")
                                            || name.equals("persianas")
                                            || name.equals("electrovalvula")
                                            || name.equals("puerta")
                                            || name.equals("movimiento")
                                            || name.equals("temperatura")
                                            || name.equals("combinado")
                                            || name.equals("inundacion")
                                            || name.equals("contadores")
                                            || name.substring(0, 5).equals("boton")) {

                                        EliminarDispositivos.panel_plano.remove(componentes[i]);// 
                                        EliminarDispositivos.panel_plano.moveToBack(componentes[i]);

                                    }//end if
                                }
                            }//end for

                            ImageIcon icon = new ImageIcon(dir_imagen);
                            Image img = icon.getImage();
                            Image newimg = img.getScaledInstance(390, 400, java.awt.Image.SCALE_SMOOTH);
                            ImageIcon newIcon = new ImageIcon(newimg);
                            plano.setIcon(newIcon);
                            plano.setBounds(5, 82, 390, 400);;


                            Acciones.mostrarDispositivosVistaEliminarDispositivos(EliminarDispositivos.planta_estancia, EliminarDispositivos.nombre_estancia);

                        }
                    }
                });







        MouseListener listener = new DragMouseAdapter();
        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
        //frame_eliminar_dispositivos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_eliminar_dispositivos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_eliminar_dispositivos.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_eliminar_dispositivos.setLocation(120, 20);
        frame_eliminar_dispositivos.setSize(1100, 750);

        panel_global.setBorder(new javax.swing.border.MatteBorder(null));

        //grupo despegables
        javax.swing.GroupLayout grupoDespegables = new javax.swing.GroupLayout(panel_despegables);
        panel_despegables.setLayout(grupoDespegables);
        grupoDespegables.setHorizontalGroup(
                grupoDespegables.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grupoDespegables.createSequentialGroup().addGap(29, 29, 29).addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(desplegable_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGap(52, 52, 52)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grupoDespegables.createSequentialGroup().addContainerGap(265, Short.MAX_VALUE).addGap(116, 116, 116)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grupoDespegables.createSequentialGroup().addContainerGap(332, Short.MAX_VALUE).addContainerGap()));
        grupoDespegables.setVerticalGroup(
                grupoDespegables.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grupoDespegables.createSequentialGroup().addContainerGap(24, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(grupoDespegables.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(desplegable_planta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(desplegable_estancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(19, 19, 19)));






//Panel actuadores
        panel_act.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_act.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTUADORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
//		panel_act.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACTUATORS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N


        // luz regulable, luces conmutadas, persianas, electrovalvula 

        //Panel luces regulables
        panel_luz_reg.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        luzreg.setName("luzreg");
        luzreg.addMouseListener(listener);
        luzreg.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje1 = new JLabel("Luces Regulables");
//                JLabel mensaje1 = new JLabel("Adjustable Lights");

        javax.swing.GroupLayout grupolucesReg = new javax.swing.GroupLayout(panel_luz_reg);
        panel_luz_reg.setLayout(grupolucesReg);
        grupolucesReg.setHorizontalGroup(
                grupolucesReg.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupolucesReg.createSequentialGroup().addComponent(luzreg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupolucesReg.setVerticalGroup(
                grupolucesReg.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupolucesReg.createSequentialGroup().addContainerGap().addGroup(grupolucesReg.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(luzreg).addComponent(mensaje1)).addContainerGap(17, Short.MAX_VALUE)));




        //-Panel luces comnutables
        panel_luz_con.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        luzcon.setName("luzcon");
        luzcon.addMouseListener(listener);
        luzcon.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje2 = new JLabel("Luces Conmutables");
//        JLabel mensaje2 = new JLabel("Commutable Lights");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panel_luz_con);
        panel_luz_con.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(luzcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(luzcon).addComponent(mensaje2)).addContainerGap(17, Short.MAX_VALUE)));


        //Panel Persianas
        panel_persianas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        persianas.setName("persianas");
        persianas.addMouseListener(listener);
        persianas.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje3 = new JLabel("Persianas");
//                JLabel mensaje3 = new JLabel("Blinds");

        javax.swing.GroupLayout grupoPersianas = new javax.swing.GroupLayout(panel_persianas);
        panel_persianas.setLayout(grupoPersianas);
        grupoPersianas.setHorizontalGroup(
                grupoPersianas.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoPersianas.createSequentialGroup().addComponent(persianas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoPersianas.setVerticalGroup(
                grupoPersianas.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoPersianas.createSequentialGroup().addContainerGap().addGroup(grupoPersianas.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(persianas).addComponent(mensaje3)).addContainerGap(17, Short.MAX_VALUE)));


        //Panel electrovalvulas
        panel_electrovalvula.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        electrovalvula.setName("electrovalvula");
        electrovalvula.addMouseListener(listener);
        electrovalvula.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje4 = new JLabel("Electrovalvula");
//		JLabel mensaje4 = new JLabel("Electrovalve");

        javax.swing.GroupLayout grupoElectrovalvula = new javax.swing.GroupLayout(panel_electrovalvula);
        panel_electrovalvula.setLayout(grupoElectrovalvula);
        grupoElectrovalvula.setHorizontalGroup(
                grupoElectrovalvula.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoElectrovalvula.createSequentialGroup().addComponent(electrovalvula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoElectrovalvula.setVerticalGroup(
                grupoElectrovalvula.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoElectrovalvula.createSequentialGroup().addContainerGap().addGroup(grupoElectrovalvula.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(electrovalvula).addComponent(mensaje4)).addContainerGap(17, Short.MAX_VALUE)));



//Grupo del panel de ACTUADORES- la izquierda
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel_act);
        panel_act.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel_luz_reg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_luz_con, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_persianas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_electrovalvula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(100, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(panel_luz_reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_luz_con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_persianas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_electrovalvula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        //---

        //Panel SENSORES
/* mecanismo apertura/cierre, detector movimiento, detector temperatura, sensor combinado, 
        sensor inundacion, contadores */

        panel_sen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel_sen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SENSORES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
//		panel_sen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SENSORS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        panel_sen.setSize(300, 200);

        //Panel apertura/cierre puertas
        panel_apertura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        apertura.setName("apertura");
        apertura.addMouseListener(listener);
        apertura.setTransferHandler(new TransferHandler("icon"));
        JLabel mensaje5 = new JLabel("Apertura/Cierre");
//	JLabel mensaje5 = new JLabel("Open/Close");
        javax.swing.GroupLayout grupoApertura = new javax.swing.GroupLayout(panel_apertura);
        panel_apertura.setLayout(grupoApertura);
        grupoApertura.setHorizontalGroup(
                grupoApertura.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoApertura.createSequentialGroup().addComponent(apertura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoApertura.setVerticalGroup(
                grupoApertura.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoApertura.createSequentialGroup().addContainerGap().addGroup(grupoApertura.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(apertura).addComponent(mensaje5)).addContainerGap(17, Short.MAX_VALUE)));

        //Panel sensor movimiento
        panel_movimiento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        movimiento.setName("movimiento");
        movimiento.addMouseListener(listener);
        movimiento.setTransferHandler(new TransferHandler("icon"));
        JLabel mensaje6 = new JLabel("Detector Movimiento");
//	        	JLabel mensaje6 = new JLabel("Movement Detector");
        javax.swing.GroupLayout grupoMovimiento = new javax.swing.GroupLayout(panel_movimiento);
        panel_movimiento.setLayout(grupoMovimiento);
        grupoMovimiento.setHorizontalGroup(
                grupoMovimiento.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoMovimiento.createSequentialGroup().addComponent(movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoMovimiento.setVerticalGroup(
                grupoMovimiento.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoMovimiento.createSequentialGroup().addContainerGap().addGroup(grupoMovimiento.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(movimiento).addComponent(mensaje6)).addContainerGap(17, Short.MAX_VALUE)));


        //Panel sensor temperatura
        panel_temperatura.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        temperatura.setName("temperatura");
        temperatura.addMouseListener(listener);
        temperatura.setTransferHandler(new TransferHandler("icon"));
        JLabel mensaje7 = new JLabel("Sensor Temperatura");
//	    	        	JLabel mensaje7 = new JLabel("Temperature Sensor");

        javax.swing.GroupLayout grupoTemperatura = new javax.swing.GroupLayout(panel_temperatura);
        panel_temperatura.setLayout(grupoTemperatura);
        grupoTemperatura.setHorizontalGroup(
                grupoTemperatura.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoTemperatura.createSequentialGroup().addComponent(temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoTemperatura.setVerticalGroup(
                grupoTemperatura.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoTemperatura.createSequentialGroup().addContainerGap().addGroup(grupoTemperatura.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(temperatura).addComponent(mensaje7)).addContainerGap(17, Short.MAX_VALUE)));

        //Panel sensor Combinado
        panel_combinado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        combinado.setName("combinado");
        combinado.addMouseListener(listener);
        combinado.setTransferHandler(new TransferHandler("icon"));
        JLabel mensaje8 = new JLabel("Sensor combinado");
//                                                JLabel mensaje8 = new JLabel("Combined Sensor");

        javax.swing.GroupLayout grupoCombinado = new javax.swing.GroupLayout(panel_combinado);
        panel_combinado.setLayout(grupoCombinado);
        grupoCombinado.setHorizontalGroup(
                grupoCombinado.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoCombinado.createSequentialGroup().addComponent(combinado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoCombinado.setVerticalGroup(
                grupoCombinado.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoCombinado.createSequentialGroup().addContainerGap().addGroup(grupoCombinado.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(combinado).addComponent(mensaje8)).addContainerGap(17, Short.MAX_VALUE)));



        //Panel sensor Inundacion
        panel_inundacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        inundacion.setName("inundacion");
        inundacion.addMouseListener(listener);
        inundacion.setTransferHandler(new TransferHandler("icon"));
        JLabel mensaje9 = new JLabel("Sensor Inundacion");
//                                                JLabel mensaje9 = new JLabel("Flood Sensor");

        javax.swing.GroupLayout grupoInundacion = new javax.swing.GroupLayout(panel_inundacion);
        panel_inundacion.setLayout(grupoInundacion);
        grupoInundacion.setHorizontalGroup(
                grupoInundacion.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoInundacion.createSequentialGroup().addComponent(inundacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoInundacion.setVerticalGroup(
                grupoInundacion.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoInundacion.createSequentialGroup().addContainerGap().addGroup(grupoInundacion.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(inundacion).addComponent(mensaje9)).addContainerGap(17, Short.MAX_VALUE)));




        //Panel Contadores
        panel_contadores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contadores.setName("contadores");
        contadores.addMouseListener(listener);
        contadores.setTransferHandler(new TransferHandler("icon"));
        JLabel mensaje10 = new JLabel("Contadores");
//                                                JLabel mensaje10 = new JLabel("Counters");

        javax.swing.GroupLayout grupoContadores = new javax.swing.GroupLayout(panel_contadores);
        panel_contadores.setLayout(grupoContadores);
        grupoContadores.setHorizontalGroup(
                grupoContadores.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoContadores.createSequentialGroup().addComponent(contadores, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(mensaje10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)));
        grupoContadores.setVerticalGroup(
                grupoContadores.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupoContadores.createSequentialGroup().addContainerGap().addGroup(grupoContadores.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(contadores).addComponent(mensaje10)).addContainerGap(17, Short.MAX_VALUE)));

//Grupo panel SENSORES
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(panel_sen);
        panel_sen.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel_apertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_combinado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_inundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(panel_contadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(100, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(panel_apertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_movimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_temperatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_combinado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_inundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_contadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
        //-----------------------------------------


        //Panel central layered pane. Plano de la estancia
        panel_plano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_plano.setSize(400, 564);



        plano.setTransferHandler(new TransferHandler("icon"));

        javax.swing.GroupLayout plano_central = new javax.swing.GroupLayout(panel_plano);
        panel_plano.setLayout(plano_central);
        plano_central.setHorizontalGroup(
                plano_central.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addGap(0, 64, Short.MAX_VALUE).addComponent(plano, javax.swing.GroupLayout.Alignment.CENTER));
        plano_central.setVerticalGroup(
                plano_central.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(plano, javax.swing.GroupLayout.Alignment.CENTER).addGap(0, 51, Short.MAX_VALUE));

        aclaracion.setText("++++++  Asegurese de que el dispositivo que desea eliminar es el correcto  ++++++");
//	         aclaracion.setText("++++++  Make sure of the device you want to delete is the right one  ++++++");

        aclaracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        aclaracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panel_apertura.setEnabled(false);
        panel_contadores.setEnabled(false);
        panel_electrovalvula.setEnabled(false);
        panel_inundacion.setEnabled(false);
        panel_luz_con.setEnabled(false);
        panel_luz_reg.setEnabled(false);
        panel_movimiento.setEnabled(false);
        panel_persianas.setEnabled(false);
        panel_temperatura.setEnabled(false);
        panel_combinado.setEnabled(false);

        luzreg.setEnabled(false);
        luzcon.setEnabled(false);
        persianas.setEnabled(false);
        electrovalvula.setEnabled(false);
        apertura.setEnabled(false);
        movimiento.setEnabled(false);
        temperatura.setEnabled(false);
        combinado.setEnabled(false);
        inundacion.setEnabled(false);
        contadores.setEnabled(false);

        mensaje1.setEnabled(false);
        mensaje2.setEnabled(false);
        mensaje3.setEnabled(false);
        mensaje4.setEnabled(false);
        mensaje5.setEnabled(false);
        mensaje6.setEnabled(false);
        mensaje7.setEnabled(false);
        mensaje8.setEnabled(false);
        mensaje9.setEnabled(false);
        mensaje10.setEnabled(false);

//PANEL GLOBAL ++++++++
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(panel_global);
        panel_global.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(panel_act, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_plano, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE).addGap(18, 18, 18) //)  
                //.addGroup(jPanel7Layout.createSequentialGroup()
                // .addComponent(resetear)
                .addComponent(panel_sen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(jPanel7Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(aclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40) // .addComponent(resetear)
                .addGap(20, 20, 20) //.addComponent(guardar)
                ).addGroup(jPanel7Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(panel_despegables, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(panel_despegables, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE).addGap(10, 10, 10)).addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(aclaracion, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE) //                    .addComponent(resetear)
                //                    .addComponent(guardar)
                .addGap(30, 30, 30)).addContainerGap().addGap(20, 20, 20).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel_plano, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE).addComponent(panel_sen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panel_act, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));


        //Grupo de menu superior y arbol izquierda     +++++++++++++++++++++++++++++++++++++++++++++++++   


        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");
//        label1.setText("Configuration");

        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();

        JMenu jMenu1 = new javax.swing.JMenu();
        jMenu1.setText("Archivo");
//         jMenu1.setText("File");
        JMenuItem archivo_item1 = new JMenuItem("Salir");
//         JMenuItem archivo_item1 = new JMenuItem( "Exit" );
        jMenu1.add(archivo_item1);
        archivo_item1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        //ACCION
                        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
                        //System.exit(0);
                        frame_eliminar_dispositivos.setVisible(false);
//                        frame_eliminar_dispositivos.dispose();
                    }
                });
        jMenuBar1.add(jMenu1);

        JMenu jMenu2 = new javax.swing.JMenu();
        jMenu2.setText("Menú Configuración");
//         jMenu2.setText("Configuration Menu");
        JMenuItem planta_item_principal = new JMenuItem("Volver");
//        JMenuItem planta_item_principal = new JMenuItem( "Go Back" );
        jMenu2.add(planta_item_principal);
        jMenuBar1.add(jMenu2);
        planta_item_principal.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        frame_eliminar_dispositivos.setVisible(false);//dispose();//setVisible(false);
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
                } // fin de la clase interna anónima
                );


        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++     
        JMenu jMenu3 = new javax.swing.JMenu();
        jMenu3.setText("                                            ");
        jMenu3.setFocusable(false);
        jMenu3.setEnabled(false);
        jMenuBar1.add(jMenu3);

        JMenu jMenu4 = new javax.swing.JMenu();
        String msg = "Está usando el fichero de configuración: ";
//        String msg = "You are using the configuration file: ";
        msg = msg + NuevoProyecto.nombre_archivo;
        jMenu4.setText(msg);
        jMenu4.setEnabled(false);

        jMenuBar1.add(jMenu4);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        frame_eliminar_dispositivos.setJMenuBar(jMenuBar1);

        Arbol.generarArbol();

        //++++++++++++++++++++++++++++++++++++++++++++++++++  +++++++++++++++++++++++++++++++++++++++++++++++

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_eliminar_dispositivos.getContentPane());
        frame_eliminar_dispositivos.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addGap(29, 29, 29).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))) // .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(panel_global, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(35, 35, 35).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //                  .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE).addGap(17, 17, 17) //                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                //.addComponent(scrollbar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE).addGap(275, 275, 275).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(panel_global, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


        //********************************************************************************

        frame_eliminar_dispositivos.setVisible(true);


    }
}

class ButtonResetear3 implements ActionListener {

    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Borrar Todo")) {
            Component[] componentes = EliminarDispositivos.panel_plano.getComponents();

            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i].getName() .equals( "regulacion")
                        || componentes[i].getName() .equals( "conmutacion")
                        || componentes[i].getName() .equals( "persianas")
                        || componentes[i].getName() .equals( "electrovalvula")
                        || componentes[i].getName() .equals( "puerta")
                        || componentes[i].getName() .equals( "movimiento")
                        || componentes[i].getName() .equals( "temperatura")
                        || componentes[i].getName() .equals( "combinado")
                        || componentes[i].getName() .equals( "inundacion")
                        || componentes[i].getName() .equals( "contadores") ){
                    EliminarDispositivos.panel_plano.remove(componentes[i]);// 
                    EliminarDispositivos.panel_plano.moveToBack(componentes[i]);

                }//end if
            }//end for


        }//end if borrar todo

    }//end void
}
