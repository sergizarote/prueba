package skoa.views;

import skoa.helpers.Acciones;
import skoa.models.VariableGlobal;
import skoa.models.MiFormato;
import java.awt.Component;

import java.awt.Image;

import java.awt.Label;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JButton;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.TransferHandler;

public abstract class EstanciaCaracteristicas extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;
    //Frame principal	
    public static JFrame frame_estancia_carac = new JFrame("Añadir Actuadores/Sensores");
//        	static JFrame frame_estancia_carac = new JFrame("Add Actuators/Sensors");
    public static int llamado = 0;
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
    static JButton resetear = new javax.swing.JButton();
    static JButton guardar = new javax.swing.JButton();
    static JSeparator jSeparator1 = new javax.swing.JSeparator();
    static JSeparator jSeparator2 = new javax.swing.JSeparator();
    static Label label1 = new java.awt.Label();
    static int frame1 = 1;
    static String dirGrupo = "";
    static String tipoEstructura = "";
    static String subtipo = "";
    public static List<MiFormato> parametros = new ArrayList<MiFormato>();
    static JLabel plano = new JLabel();
    //label luces regulables
    //static ImageIcon icono = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\luzreg.png");
    static JLabel luzreg = new JLabel( new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "luzreg.png")), JLabel.CENTER);
    //label luces conmutables
    //static ImageIcon icono2 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\bca.png");
    static JLabel luzcon = new JLabel( new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "bca.png")), JLabel.CENTER);
    //label persianas
    //static ImageIcon icono3 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\pa.png");
    static JLabel persianas = new JLabel( new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "pa.png")), JLabel.CENTER);
    //label electrovalvula
    //static ImageIcon icono4 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\elv.png");
    static JLabel electrovalvula = new JLabel(new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "elv.png")), JLabel.CENTER);
    //label apertura/cierre
    //static ImageIcon icono5 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\puc.png");
    static JLabel apertura = new JLabel(new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "puc.png")), JLabel.CENTER);
    //label movimiento
    //static ImageIcon icono6 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\prdetec.png");
    static JLabel movimiento = new JLabel(new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "prdetec.png")), JLabel.CENTER);
    //label temperatura
    //static ImageIcon icono7 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\term.png");
    static JLabel temperatura = new JLabel( new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "term.png")), JLabel.CENTER);
    //label combinado
    //static ImageIcon icono8 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\comb.png");
    static JLabel combinado = new JLabel(new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "comb.png")), JLabel.CENTER);
    //label inundacion
    //static ImageIcon icono9 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\inund.png");
    static JLabel inundacion = new JLabel(new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "inund.png")), JLabel.CENTER);
    //label contadores
    //static ImageIcon icono10 = new ImageIcon(MaipezView.raiz_ficheros+"imagenes\\simbolos\\cont.png");
    static JLabel contadores = new JLabel(new ImageIcon(getImageResource(SkoaMain.ROOT_ICONS_PATH + "cont.png")), JLabel.CENTER);
    
    
    public static JComboBox desplegable_planta = new javax.swing.JComboBox();
    public static JComboBox desplegable_estancia = new javax.swing.JComboBox();
    public static String planta_seleccionada;
    static String estancia_seleccionada;

    
    public static URL getImageResource(String url ){
        return EstanciaCaracteristicas.class.getClass().getResource(url);
    }
    
    public static void main() {
        llamado = 1;
        //ruta imagenes:
//		System.out.println("imagen en: "+MaipezView.raiz_ficheros+"imagenes\\simbolos\\luzreg.png");



        panel_global.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_global.setSize(1000, 5000);
        panel_global.setMinimumSize(panel_global.getPreferredSize());

        panel_plano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_plano.setSize(400, 564);

        //JLabel plano
        plano.setSize(485, 310);
        plano.setBounds(40, 0, 400, 580);

        panel_act.setSize(485, 310);
        panel_sen.setSize(485, 310);


        desplegable_planta.addActionListener((ActionListener) new ButtonModifPlano());
        desplegable_planta.addItem("--Plantas--");
//         desplegable_planta.addItem("--Floors--");

        Acciones.mostrarPlantasVistaEstanciaCaracteristicas();
        desplegable_planta.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EstanciaCaracteristicas.planta_seleccionada = (String) EstanciaCaracteristicas.desplegable_planta.getSelectedItem();

                        if (EstanciaCaracteristicas.planta_seleccionada != "--Plantas--") {
//                                           if(EstanciaCaracteristicas.planta_seleccionada != "--Floors--" ){

                            planta_estancia = EstanciaCaracteristicas.planta_seleccionada;

                            Component[] componentes = EstanciaCaracteristicas.panel_plano.getComponents();
                            for (int indice = 0; indice < componentes.length; indice++) {
                                String name = componentes[indice].getName();
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
                                        EstanciaCaracteristicas.panel_plano.remove(componentes[indice]);// 
                                        EstanciaCaracteristicas.panel_plano.moveToBack(componentes[indice]);
                                    }//end if
                                }
                            }//end for
                            EstanciaCaracteristicas.desplegable_estancia.setEnabled(true);
                            Acciones.mostrarEstanciasVistaEstanciaCaracteristicas();
                        }
                        if (EstanciaCaracteristicas.planta_seleccionada.equals("--Plantas--")) {
                            EstanciaCaracteristicas.desplegable_estancia.setEnabled(false);
                        }

                    }
                });

        desplegable_estancia.addActionListener((ActionListener) new ButtonModifPlano());
        desplegable_estancia.setEnabled(false);
        desplegable_estancia.addItem("--Estancias--");
//         desplegable_estancia.addItem("--Rooms--");
        desplegable_estancia.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        JComboBox combo = (JComboBox) evt.getSource();
                        Object sel = combo.getSelectedItem();
                        EstanciaCaracteristicas.estancia_seleccionada = (String) EstanciaCaracteristicas.desplegable_estancia.getSelectedItem();

                        if (EstanciaCaracteristicas.estancia_seleccionada != "--Estancias--" && EstanciaCaracteristicas.estancia_seleccionada != "null") {

                            //-------------------------------------------------
                            Component[] componentes = EstanciaCaracteristicas.panel_plano.getComponents();
                            for (int indice = 0; indice < componentes.length; indice++) {
                                String name = componentes[indice].getName();
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
                                        EstanciaCaracteristicas.panel_plano.remove(componentes[indice]);// 
                                        EstanciaCaracteristicas.panel_plano.moveToBack(componentes[indice]);
                                    }//end if
                                }
                            }//end for
                            //--------------------------------

                            nombre_estancia = EstanciaCaracteristicas.estancia_seleccionada;
                            EstanciaCaracteristicas.dir_imagen = Acciones.SeleccionarImagen(EstanciaCaracteristicas.planta_estancia, EstanciaCaracteristicas.nombre_estancia);
                            ImageIcon icon = new ImageIcon(EstanciaCaracteristicas.dir_imagen);
                            Image img = icon.getImage();
                            Image newimg = img.getScaledInstance(390, 400, java.awt.Image.SCALE_SMOOTH);
                            ImageIcon newIcon = new ImageIcon(newimg);
                            plano.setIcon(newIcon);


                            plano.setBounds(5, 82, 390, 400);//320, 550);

                            Acciones.mostrarDispositivosVistaEstanciaCaracteristicas(EstanciaCaracteristicas.planta_estancia, EstanciaCaracteristicas.nombre_estancia);

                        }
                    }
                });

        MouseListener listener = new DragMouseAdapter();
        // Para que no se cierre la aplicación entera, sólo el módulo "Nuevo Proyecto"
        //frame_estancia_carac.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame_estancia_carac.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_estancia_carac.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame_estancia_carac.setLocation(120, 20);
        frame_estancia_carac.setSize(1100, 750);

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

        //panel_act.setSize(200, 200);


        // luz regulable, luces conmutadas, persianas, electrovalvula 

        //Panel luces regulables
        panel_luz_reg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //panel_luz_reg.setSize(150, 20);
        luzreg.setName("luzreg");
        luzreg.addMouseListener(listener);
        luzreg.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje1 = new JLabel("Luces Regulables");
//		JLabel mensaje1 = new JLabel("Adjustable Lights");

        javax.swing.GroupLayout grupolucesReg = new javax.swing.GroupLayout(panel_luz_reg);
        panel_luz_reg.setLayout(grupolucesReg);
        grupolucesReg.setHorizontalGroup(
                grupolucesReg.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupolucesReg.createSequentialGroup().addComponent(luzreg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE) //.addGap(18, 18, 18)
                .addComponent(mensaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE) //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                ));
        grupolucesReg.setVerticalGroup(
                grupolucesReg.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(grupolucesReg.createSequentialGroup().addContainerGap().addGroup(grupolucesReg.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(luzreg).addComponent(mensaje1)).addContainerGap(17, Short.MAX_VALUE)));




        //-Panel luces comnutables
        panel_luz_con.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        luzcon.setName("luzcon");
        luzcon.addMouseListener(listener);
        luzcon.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje2 = new JLabel("Luces Conmutables");
//   	JLabel mensaje2 = new JLabel("Commutables Lights");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(panel_luz_con);
        panel_luz_con.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(luzcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE) //.addGap(18, 18, 18)
                .addComponent(mensaje2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE) //.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                ));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(luzcon).addComponent(mensaje2)).addContainerGap(17, Short.MAX_VALUE)));


        //Panel Persianas
        panel_persianas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        persianas.setName("persianas");
        persianas.addMouseListener(listener);
        persianas.setTransferHandler(new TransferHandler("icon"));

        JLabel mensaje3 = new JLabel("Persianas");
//		JLabel mensaje3 = new JLabel("Blinds");

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
//		JLabel mensaje5 = new JLabel("Open/Close");

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
//	        		JLabel mensaje6 = new JLabel("Movement Detector");

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
//	    	        		JLabel mensaje7 = new JLabel("Temperature Sensor");

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
//	    	    	        		JLabel mensaje8 = new JLabel("Combined Sensor");

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
//	    	    	        		JLabel mensaje9 = new JLabel("Flood Sensor");

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
//	    	    	        		JLabel mensaje10 = new JLabel("Counters");

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



        plano.setTransferHandler(new TransferHandler("icon"));

        javax.swing.GroupLayout plano_central = new javax.swing.GroupLayout(panel_plano);
        panel_plano.setLayout(plano_central);
        plano_central.setHorizontalGroup(
                plano_central.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addGap(0, 64, Short.MAX_VALUE).addComponent(plano)//,javax.swing.GroupLayout.Alignment.CENTER)
                //.addGap(0, 64, Short.MAX_VALUE)
                );
        plano_central.setVerticalGroup(
                plano_central.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(plano)//,javax.swing.GroupLayout.Alignment.CENTER)
                .addGap(0, 51, Short.MAX_VALUE));

        aclaracion.setText("++++++  Seleccionar el icono y arrastrarlo hasta la posición deseada dentro del plano  ++++++");
//	        aclaracion.setText("++++++  Click on the icon and drag it along the desired position inside the plan  ++++++");

        aclaracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aclaracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        resetear.setText("Borrar Todo");
//		    resetear.setText("Delete Everything");

        resetear.addActionListener((ActionListener) new ButtonResetear());
        guardar.setText("Guardar Cambios");
//		    guardar.setText("Save All");

        guardar.addActionListener((ActionListener) new ButtonResetear());
        guardar.setRolloverEnabled(true);

//PANEL GLOBAL ++++++++
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(panel_global);
        panel_global.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(panel_act, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(panel_plano, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE) // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGap(18, 18, 18) //)  
                //.addGroup(jPanel7Layout.createSequentialGroup()
                // .addComponent(resetear)
                .addComponent(panel_sen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addGroup(jPanel7Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(aclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(40, 40, 40).addComponent(resetear).addGap(20, 20, 20).addComponent(guardar)).addGroup(jPanel7Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(panel_despegables, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(panel_despegables, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE).addGap(10, 10, 10)).addContainerGap().addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(aclaracion, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE).addComponent(resetear).addComponent(guardar).addGap(30, 30, 30)).addContainerGap().addGap(20, 20, 20).addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panel_plano, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE).addComponent(panel_sen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(panel_act, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap()));

        //Grupo de menu superior y arbol izquierda     +++++++++++++++++++++++++++++++++++++++++++++++++   

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        label1.setText("Configuración Vivienda");


        JMenuBar jMenuBar1 = new javax.swing.JMenuBar();

       







        JButton botonVolver = new JButton("Volver");
        //botonVolver.setSize(40, 20);
        botonVolver.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent evento) {
                        frame_estancia_carac.setVisible(false);// dispose();
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
//        String msg = "You are using the configuration file: ";

        msg = msg + NuevoProyecto.nombre_archivo;
        jMenu4.setText(msg);
        jMenu4.setEnabled(false);

        jMenuBar1.add(jMenu4);

        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        frame_estancia_carac.setJMenuBar(jMenuBar1);

        Arbol.generarArbol();

        //++++++++++++++++++++++++++++++++++++++++++++++++++  +++++++++++++++++++++++++++++++++++++++++++++++

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame_estancia_carac.getContentPane());
        frame_estancia_carac.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addContainerGap()
                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
                 
                //.addComponent(botonSalir)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))) // .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_global, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 371, 
                Short.MAX_VALUE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35).addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) //                  .addGap(5, 5, 5)
                
                //.addComponent(botonSalir)
                 .addComponent(botonVolver)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 7, javax.swing.GroupLayout.DEFAULT_SIZE)
                .addGap(17, 17, 17) 
                

                .addComponent(Arbol.MOSTRAR_CONFIGURACION, javax.swing.GroupLayout.PREFERRED_SIZE, 450, Short.MAX_VALUE)
                .addGap(275, 275, 275).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_global, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));


        //********************************************************************************

        frame_estancia_carac.setVisible(true);

    }
}

class ButtonResetear implements ActionListener {

    public void actionPerformed(ActionEvent e) {


        if (e.getActionCommand().equals("Borrar Todo")) {
            Component[] componentes = EstanciaCaracteristicas.panel_plano.getComponents();

            for (int i = 0; i < componentes.length; i++) {
                if (componentes[i].getName().equals("regulacion")
                        || componentes[i].getName().equals("conmutacion")
                        || componentes[i].getName() .equals("persianas")
                        || componentes[i].getName().equals("electrovalvula")
                        || componentes[i].getName() .equals( "puerta")
                        || componentes[i].getName().equals( "movimiento")
                        || componentes[i].getName() .equals( "temperatura")
                        || componentes[i].getName() .equals( "combinado")
                        || componentes[i].getName().equals( "inundacion")
                        || componentes[i].getName() .equals( "contadores") ) {
                    EstanciaCaracteristicas.panel_plano.remove(componentes[i]);// 
                    EstanciaCaracteristicas.panel_plano.moveToBack(componentes[i]);

                }//end if
            }//end for
        }//end if borrar todo



        if (e.getActionCommand().equals("Guardar Cambios")) {

            Component[] componentes = EstanciaCaracteristicas.panel_plano.getComponents();
            JLabel insertar = new JLabel();
            for (int i = 0; i < componentes.length; i++) {
                insertar = (JLabel) componentes[i];
                //AÑADIR PARAMETRO DIRECC GRUPO, TIPO ESTRUCT, SUBTIPO----------------
                Acciones.insertaIconos(insertar, componentes[i].getName());//, EstanciaCaracteristicas.dirGrupo, EstanciaCaracteristicas.tipoEstructura, EstanciaCaracteristicas.subtipo );

            }//end for


            //poner todo al estado inicial 
            Component[] componentes2 = EstanciaCaracteristicas.panel_plano.getComponents();
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
                        EstanciaCaracteristicas.panel_plano.remove(componentes2[i]);
                        EstanciaCaracteristicas.panel_plano.moveToBack(componentes2[i]);
                    }
                }
            }


            Acciones.mostrarDispositivosVistaEstanciaCaracteristicas(EstanciaCaracteristicas.planta_estancia, EstanciaCaracteristicas.nombre_estancia);


            String mostrar = "Se han guardado las modificaciones";
            mostrar += "\n";
            mostrar += "en el fichero de configuración";
            // Al guardar, se cambia la codificación a UTF-8, por lo tanto activamos la variable global
            // Para que se sepa que ha de cambiarse dicha codificación antes de abrir el fichero .xml
            VariableGlobal.codificacion = 1;
            JOptionPane.showMessageDialog(null, mostrar, "Información", 1);
            // Una vez se haya guardado, se desactiva el botón de "Borrar" hasta que no se vuelvan a añadir más actuadores/sensores
            EstanciaCaracteristicas.resetear.setEnabled(false);

        }//end if guardar cambios

    }//end void
}