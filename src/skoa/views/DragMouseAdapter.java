package skoa.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DragMouseAdapter extends MouseAdapter {

    JLabel insertar = new JLabel();
    int posx;//= EstanciaCaracteristicas.panel_plano.getX();
    int posy;//= EstanciaCaracteristicas.panel_plano.getY();
    int posYpanel;
    int derecha = 0;
    String labelPulsado = "";
    int anchoPanel;
    int altoPanel;
    static String nombreLabel = "";

    public void mousePressed(MouseEvent e) {
        JComponent c = (JComponent) e.getSource();

        if (c.getName().equals("luzreg")) {
            nombreLabel = "regulacion";
            labelPulsado = "luzreg";
            //  System.out.println("luz regulable pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"bra.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_luz_reg.getY();
            anchoPanel = EstanciaCaracteristicas.panel_luz_reg.getWidth();

        }//end if


        if (c.getName().equals("luzcon")) {
            nombreLabel = "conmutacion";
            labelPulsado = "luzcon";
            //  System.out.println("luz conmutable pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"bca.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));


            posYpanel = EstanciaCaracteristicas.panel_luz_con.getY();
            anchoPanel = EstanciaCaracteristicas.panel_luz_con.getWidth();
        } //end if

        if (c.getName().equals("persianas")) {
            nombreLabel = "persianas";
            labelPulsado = "persianas";
            //  System.out.println("persianas pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"pa.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_persianas.getY();
            anchoPanel = EstanciaCaracteristicas.panel_persianas.getWidth();
        } //end if

        if (c.getName().equals("electrovalvula")) {
            nombreLabel = "electrovalvula";
            labelPulsado = "electrovalvula";
            //  System.out.println("electrovalvula pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"elv.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_electrovalvula.getY();
            anchoPanel = EstanciaCaracteristicas.panel_electrovalvula.getWidth();
        } //end if

        //----------------Grupo de la derecha---------------
        if (c.getName().equals("apertura")) {
            nombreLabel = "puerta";
            labelPulsado = "apertura";
            // System.out.println("apertura pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"puc.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_apertura.getY();
            anchoPanel = EstanciaCaracteristicas.panel_apertura.getWidth();
            derecha = 1;
        } //end if

        if (c.getName().equals("movimiento")) {
            nombreLabel = "movimiento";
            labelPulsado = "movimiento";
            // System.out.println("apertura pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"prdetec.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));


            posYpanel = EstanciaCaracteristicas.panel_movimiento.getY();
            anchoPanel = EstanciaCaracteristicas.panel_movimiento.getWidth();
            derecha = 1;
        } //end if

        if (c.getName().equals("temperatura")) {
            nombreLabel = "temperatura";
            labelPulsado = "temperatura";
            // System.out.println("apertura pulsada");


            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(SkoaMain.ROOT_ICONS_PATH + "term.png"));


            posYpanel = EstanciaCaracteristicas.panel_temperatura.getY();
            anchoPanel = EstanciaCaracteristicas.panel_temperatura.getWidth();
            derecha = 1;
        } //end if

        if (c.getName().equals("combinado")) {
            nombreLabel = "combinado";
            labelPulsado = "combinado";
            // System.out.println("apertura pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"comb.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_combinado.getY();
            anchoPanel = EstanciaCaracteristicas.panel_combinado.getWidth();
            derecha = 1;
        } //end if

        if (c.getName().equals("inundacion")) {
            nombreLabel = "inundacion";
            labelPulsado = "inundacion";
            // System.out.println("apertura pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"inund.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_inundacion.getY();
            anchoPanel = EstanciaCaracteristicas.panel_inundacion.getWidth();
            derecha = 1;
        } //end if

        if (c.getName().equals("contadores")) {
            nombreLabel = "contadores";
            labelPulsado = "contadores";
            // System.out.println("apertura pulsada");

            String path = SkoaMain.ROOT_ICONS_PATH+"cont.png";
            EstanciaCaracteristicas.iconito = new ImageIcon(getClass().getResource(path));

            posYpanel = EstanciaCaracteristicas.panel_contadores.getY();
            anchoPanel = EstanciaCaracteristicas.panel_contadores.getWidth();
            derecha = 1;
        } //end if



    } //end mousepressed

    public void mouseReleased(MouseEvent e) {
        if (EstanciaCaracteristicas.frame1 == 1) {

            JComponent c = (JComponent) e.getSource();
            posx = EstanciaCaracteristicas.panel_plano.getX();
            posy = EstanciaCaracteristicas.panel_plano.getY();
            int x = 0;
            int y = 0;
            int aux1 = EstanciaCaracteristicas.panel_plano.getWidth();
            int aux2 = EstanciaCaracteristicas.plano.getWidth();
            int plano_huecoAncho = (aux1 - aux2) / 2;
            aux1 = EstanciaCaracteristicas.panel_plano.getHeight();
            aux2 = EstanciaCaracteristicas.plano.getHeight();
            int plano_huecoAlto = (aux1 - aux2) / 2;
            String tipo = ""; // Nos indicará el tipo de icono que estamos insertando
            int opcion = 0; // Nos indicará el tipo de icono que salió elegido (para usar con el switch)
            int numero = 0; // El número que se pasará a la llamada InsertarActSen.main()

            if (derecha == 0) { //Caso grupo izquierda
                x = e.getX() - anchoPanel - (posx / 4);
                y = e.getY() + posYpanel; //+ posYpanel - posy ;
            } else //Caso grupo derecha
            if (derecha == 1) {
                x = e.getX() + EstanciaCaracteristicas.panel_plano.getWidth() + 20;
                y = e.getY() + posYpanel - 5;
                derecha = 0;
            }


            if (EstanciaCaracteristicas.desplegable_planta.getSelectedItem().equals("--Plantas--")
                    || EstanciaCaracteristicas.desplegable_estancia.getSelectedItem().equals("--Estancias--")) {
                String mostrar = "¡Seleccione planta y estancia!";
//		    	mostrar += "\n";
//		    	mostrar += "No se insertara";
                JOptionPane.showMessageDialog(null, mostrar, "alerta", 1);
            } else {
                if (x < 0 || x > EstanciaCaracteristicas.panel_plano.getWidth() - 20
                        || y > 461 || y < 58) {
                    String mostrar = "¡Icono situado fuera del plano!";
                    mostrar += "\n";
                    mostrar += "No se insertará";
                    JOptionPane.showMessageDialog(null, mostrar, "alerta", 1);
                } else {
                    // Activamos el botón de "Borrar Todo" desde que se inserta algún actuador/sensor
                    EstanciaCaracteristicas.resetear.setEnabled(true);

                    // A continuación se averigüará cual es el tipo del icono que se va a insertar
                    String ico = EstanciaCaracteristicas.iconito.toString();
                    // Y dependiendo de cual sea, lo indicamos en la variable tipo
                    if (ico.indexOf("luzreg.png") != -1) {
                        tipo = "luz_reg";
                        opcion = 1;
                    }
                    if (ico.indexOf("bca.png") != -1) {
                        tipo = "luz_conm";
                        opcion = 2;
                    }
                    if (ico.indexOf("pa.png") != -1) {
                        tipo = "pers";
                        opcion = 3;
                    }
                    if (ico.indexOf("elv.png") != -1) {
                        tipo = "electrov";
                        opcion = 4;
                    }
                    if (ico.indexOf("puc.png") != -1) {
                        tipo = "puerta";
                        opcion = 5;
                    }
                    if (ico.indexOf("prdetec.png") != -1) {
                        tipo = "mov";
                        opcion = 6;
                    }
                    if (ico.indexOf("term.png") != -1) {
                        tipo = "temp";
                        opcion = 7;
                    }
                    if (ico.indexOf("comb.png") != -1) {
                        tipo = "comb";
                        opcion = 8;
                    }
                    if (ico.indexOf("inund.png") != -1) {
                        tipo = "inund";
                        opcion = 9;
                    }
                    if (ico.indexOf("cont.png") != -1) {
                        tipo = "cont";
                        opcion = 10;
                    }

                    // Ya conocemos los parámetros para la llamada a InsertarActSen: las posiciones x e y, 
                    // el nombre de la planta, de la estancia, el tipo y la variable opción (nos servirá para saber el número)
                    // Llamamos a InsertarActSen para que el usuario introduzca los parámetros del actuador/sensor insertado (direc. grupo, tipo, subtipo y nombre)
                    InsertarActSen.main(Integer.toString(x), Integer.toString(y),
                            EstanciaCaracteristicas.planta_seleccionada, EstanciaCaracteristicas.estancia_seleccionada, tipo, opcion);
                }
            }
        }//end if    
        else {
           /* JComponent c = (JComponent) e.getSource();
            posx = EstanciaCaracteristicas2.panel_plano.getX();
            posy = EstanciaCaracteristicas2.panel_plano.getY();
            int x = 0;
            int y = 0;
            int aux1 = EstanciaCaracteristicas2.panel_plano.getWidth();
            int aux2 = EstanciaCaracteristicas2.plano.getWidth();
            int plano_huecoAncho = (aux1 - aux2) / 2;
            aux1 = EstanciaCaracteristicas2.panel_plano.getHeight();
            aux2 = EstanciaCaracteristicas2.plano.getHeight();
            int plano_huecoAlto = (aux1 - aux2) / 2;

            if (derecha == 0) //Caso grupo izquierda
            {
                x = e.getX() - anchoPanel - plano_huecoAncho;// - posx    ;
                y = e.getY() + posYpanel; //+ posYpanel - posy ;
            } else //Caso grupo derecha
            {
                if (derecha == 1) {
                    x = e.getX() + EstanciaCaracteristicas2.panel_plano.getWidth() + 20;
                    y = e.getY() + posYpanel - 5;
                    derecha = 0;
                }
            }

            JLabel insertar = new JLabel();
            insertar.setName(nombreLabel);//"insertado");
            insertar.setIcon(EstanciaCaracteristicas2.iconito);
            insertar.setBounds(x, y, 50, 60);
            EstanciaCaracteristicas2.panel_plano.add(insertar, javax.swing.JLayeredPane.DRAG_LAYER);*/

        }//end else
    }//end mouseReleased
}//end class

