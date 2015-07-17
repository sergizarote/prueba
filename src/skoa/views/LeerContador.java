/*
 * LeerContador.java
 *
 * Created on 2 de julio de 2009, 12:43
 */
package skoa.views;

// Para poder usar @Action
import skoa.models.VariableGlobal;
import org.jdesktop.application.Action;
// Importado de "Dialog_Read.java"
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import javax.swing.JComboBox;
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JFrame;

import tuwien.auto.eibpoints.*;
import tuwien.auto.eibxlator.PointPDUXlator;
import tuwien.auto.eibxlator.PDUXlatorList;
import tuwien.auto.eicl.CEMI_Connection;
import tuwien.auto.eicl.struct.cemi.CEMI_L_DATA;
import tuwien.auto.eicl.util.*;
import tuwien.auto.eicl.struct.cemi.EIB_Address;

/**
 *
 * @author  David
 */
public class LeerContador extends javax.swing.JDialog {

    public static final long serialVersionUID = 1;
    //private javax.swing.JComboBox cb_Points;
    public static javax.swing.JComboBox cb_Points;
    private javax.swing.JButton b_Cancel;
    private javax.swing.JButton b_Read;
    //private PointList pointList;
    private javax.swing.JLabel l_major;
    private javax.swing.JLabel l_majorvalue;
    private javax.swing.JLabel l_minor;
    private javax.swing.JLabel l_minorvalue;
    private javax.swing.JLabel l_contador;
    private javax.swing.JButton b_Actualizar;
    private CEMI_Connection tunnel;
    private String fecha_hora;

    // Para utilizarlo como tercer parámetro en la llamada a "LeerContador"
    //public static PointList Lcontadores = new PointList();
    /** Creates new form LeerContador */
    public LeerContador(java.awt.Frame parent, boolean modal,
            CEMI_Connection _Tunnel, String _fecha_hora) {
        super(parent, modal);
        //pointList = _PointList;
        tunnel = _Tunnel;
        fecha_hora = _fecha_hora;
        //initComponents();
        initComponents_mio();
    }

    // Para cerrar la ventana al pulsar en "Cancelar"
    @Action
    public void cerrarLeerCont() {
        setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_major = new javax.swing.JLabel();
        l_contador = new javax.swing.JLabel();
        l_minor = new javax.swing.JLabel();
        l_majorvalue = new javax.swing.JLabel();
        cb_Points = new javax.swing.JComboBox();
        l_minorvalue = new javax.swing.JLabel();
        b_Read = new javax.swing.JButton();
        b_Cancel = new javax.swing.JButton();
        b_Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getResourceMap(LeerContador.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        l_major.setFont(resourceMap.getFont("l_major.font")); // NOI18N
        l_major.setText(resourceMap.getString("l_major.text")); // NOI18N
        l_major.setName("l_major"); // NOI18N

        l_contador.setFont(resourceMap.getFont("l_contador.font")); // NOI18N
        l_contador.setText(resourceMap.getString("l_contador.text")); // NOI18N
        l_contador.setName("l_contador"); // NOI18N

        l_minor.setFont(resourceMap.getFont("l_minor.font")); // NOI18N
        l_minor.setText(resourceMap.getString("l_minor.text")); // NOI18N
        l_minor.setName("l_minor"); // NOI18N

        l_majorvalue.setFont(resourceMap.getFont("l_majorvalue.font")); // NOI18N
        l_majorvalue.setText(resourceMap.getString("l_majorvalue.text")); // NOI18N
        l_majorvalue.setName("l_majorvalue"); // NOI18N

        cb_Points.setFont(resourceMap.getFont("cb_Points.font")); // NOI18N
        cb_Points.setName("cb_Points"); // NOI18N
        cb_Points.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_PointsActionPerformed(evt);
            }
        });

        l_minorvalue.setFont(resourceMap.getFont("l_minorvalue.font")); // NOI18N
        l_minorvalue.setText(resourceMap.getString("l_minorvalue.text")); // NOI18N
        l_minorvalue.setName("l_minorvalue"); // NOI18N

        b_Read.setFont(resourceMap.getFont("b_Read.font")); // NOI18N
        b_Read.setText(resourceMap.getString("b_Read.text")); // NOI18N
        b_Read.setName("b_Read"); // NOI18N
        b_Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ReadActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getActionMap(LeerContador.class, this);
        b_Cancel.setAction(actionMap.get("cerrarLeerCont")); // NOI18N
        b_Cancel.setFont(resourceMap.getFont("b_Cancel.font")); // NOI18N
        b_Cancel.setText(resourceMap.getString("b_Cancel.text")); // NOI18N
        b_Cancel.setName("b_Cancel"); // NOI18N
        b_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CancelActionPerformed(evt);
            }
        });

        b_Actualizar.setFont(resourceMap.getFont("b_Actualizar.font")); // NOI18N
        b_Actualizar.setText(resourceMap.getString("b_Actualizar.text")); // NOI18N
        b_Actualizar.setName("b_Actualizar"); // NOI18N
        b_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_major)
                            .addComponent(l_contador)
                            .addComponent(l_minor))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_majorvalue, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                            .addComponent(cb_Points, 0, 255, Short.MAX_VALUE)
                            .addComponent(l_minorvalue, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_Read, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_Cancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_contador)
                    .addComponent(cb_Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_major)
                    .addComponent(l_majorvalue))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_minor)
                    .addComponent(l_minorvalue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_Cancel)
                    .addComponent(b_Read)
                    .addComponent(b_Actualizar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initComponents_mio() {
        l_major = new javax.swing.JLabel();
        l_contador = new javax.swing.JLabel();
        l_minor = new javax.swing.JLabel();
        l_majorvalue = new javax.swing.JLabel();
        cb_Points = new javax.swing.JComboBox();
        l_minorvalue = new javax.swing.JLabel();
        b_Read = new javax.swing.JButton();
        b_Cancel = new javax.swing.JButton();
        b_Actualizar = new javax.swing.JButton();

        // Importado de "Dialog_Read.java"
        Point[] p = VariableGlobal.Lcontadores.getAllPoints();
        for (int i = 0; i < p.length; i++) {
            cb_Points.addItem(p[i].getDeviceName());
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getResourceMap(LeerContador.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        l_major.setFont(resourceMap.getFont("l_major.font")); // NOI18N
        l_major.setText(resourceMap.getString("l_major.text")); // NOI18N
        l_major.setName("l_major"); // NOI18N

        l_contador.setFont(resourceMap.getFont("l_contador.font")); // NOI18N
        l_contador.setText(resourceMap.getString("l_contador.text")); // NOI18N
        l_contador.setName("l_contador"); // NOI18N

        l_minor.setFont(resourceMap.getFont("l_minor.font")); // NOI18N
        l_minor.setText(resourceMap.getString("l_minor.text")); // NOI18N
        l_minor.setName("l_minor"); // NOI18N

        l_majorvalue.setFont(resourceMap.getFont("l_majorvalue.font")); // NOI18N
        l_majorvalue.setText(resourceMap.getString("l_majorvalue.text")); // NOI18N
        l_majorvalue.setName("l_majorvalue"); // NOI18N

        cb_Points.setFont(resourceMap.getFont("cb_Points.font")); // NOI18N
        cb_Points.setName("cb_Points"); // NOI18N
        cb_Points.setSelectedIndex(-1);
        cb_Points.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_PointsActionPerformed(evt);
            }
        });

        l_minorvalue.setFont(resourceMap.getFont("l_minorvalue.font")); // NOI18N
        l_minorvalue.setText(resourceMap.getString("l_minorvalue.text")); // NOI18N
        l_minorvalue.setName("l_minorvalue"); // NOI18N

        b_Read.setFont(resourceMap.getFont("b_Read.font")); // NOI18N
        b_Read.setText(resourceMap.getString("b_Read.text")); // NOI18N
        b_Read.setName("b_Read"); // NOI18N
        b_Read.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ReadActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getActionMap(LeerContador.class, this);
        b_Cancel.setAction(actionMap.get("cerrarLeerCont")); // NOI18N
        b_Cancel.setFont(resourceMap.getFont("b_Cancel.font")); // NOI18N
        b_Cancel.setText(resourceMap.getString("b_Cancel.text")); // NOI18N
        b_Cancel.setName("b_Cancel"); // NOI18N
        b_Cancel.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CancelActionPerformed(evt);
            }
        });

        b_Actualizar.setFont(resourceMap.getFont("b_Actualizar.font")); // NOI18N
        b_Actualizar.setText(resourceMap.getString("b_Actualizar.text")); // NOI18N
        b_Actualizar.setName("b_Actualizar"); // NOI18N
        b_Actualizar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(l_major).addComponent(l_contador).addComponent(l_minor)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(l_majorvalue, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE).addComponent(cb_Points, 0, 255, Short.MAX_VALUE).addComponent(l_minorvalue, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))).addGroup(layout.createSequentialGroup().addComponent(b_Actualizar).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(b_Read, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18).addComponent(b_Cancel))).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(l_contador).addComponent(cb_Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(l_major).addComponent(l_majorvalue)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(l_minor).addComponent(l_minorvalue)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(b_Cancel).addComponent(b_Read).addComponent(b_Actualizar)).addGap(21, 21, 21)));

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                LeerContador dialog = new LeerContador(new javax.swing.JFrame(), true,
                        tunnel, fecha_hora);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.out.println("quiero salir en leerContador.java");
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

private void b_ReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ReadActionPerformed
    try {
        // Indicamos en la variable global que se trata de una lectura manual
        VariableGlobal.lectura_manual = 0;
        // Obtenemos el punto (contador) que queremos tratar
        Point p = VariableGlobal.Lcontadores.getPoint(cb_Points.getSelectedItem().toString());
        PointPDUXlator xlator = PDUXlatorList.getPointPDUXlator(p.getMajorType(), p.getMinorType());
        xlator.setServiceType(PointPDUXlator.A_GROUPVALUE_READ);
        // Creamos un nuevo dato con la información del contador
        CEMI_L_DATA data = new CEMI_L_DATA((byte) CEMI_L_DATA.MC_L_DATAREQ, new EIB_Address(),
                p.getDeviceAddress()[0], xlator.getAPDUByteArray());
        // Se envía el frame y se espera por su confirmación
        tunnel.sendFrame(data, CEMI_Connection.WAIT_FOR_CONFIRM);
        // Informamos de la petición en el LOG de la aplicación
        synchronized (SkoaMain.textArea) {
            SkoaMain.textArea.append(fecha_hora + ": Solicitud de lectura a "
                    + p.getDeviceName() + " enviada \n");
        }
        this.dispose();
    } catch (EICLException ex) {
        SkoaMain.showException(ex.getMessage());
    }
}//GEN-LAST:event_b_ReadActionPerformed

private void b_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CancelActionPerformed
    this.dispose();
}//GEN-LAST:event_b_CancelActionPerformed

    private void cb_PointsActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (cb_Points.getSelectedIndex() != -1) {
                Point p = VariableGlobal.Lcontadores.getPoint(cb_Points.getSelectedItem().toString());
                l_majorvalue.setText(PDUXlatorList.getPointTypeMajor().getTypeDescription(p.getMajorType()));
                l_minorvalue.setText(PDUXlatorList.getPointPDUMinor(p.getMajorType()).get(p.getMinorType())[1]);
            }
        } catch (EICLException ex) {
            SkoaMain.showException(ex.getMessage());
        }
    }

private void b_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ActualizarActionPerformed
    // En primer lugar, vaciamos los elementos que pudiera tener almacenado el combobox
    cb_Points.removeAllItems();

    // Importado de "Dialog_Read.java"
    // Posteriormente, añadimos al combobox los contadores que estén en la base de datos
    Point[] p = VariableGlobal.Lcontadores.getAllPoints();
    for (int i = 0; i < p.length; i++) {
        cb_Points.addItem(p[i].getDeviceName());
    }

    // Y por defecto, no mostramos nada en el combobox
    cb_Points.setSelectedIndex(-1);
}//GEN-LAST:event_b_ActualizarActionPerformed
// Fin de la clase LeerContador
}

/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Actualizar;
    private javax.swing.JButton b_Cancel;
    private javax.swing.JButton b_Read;
    private javax.swing.JComboBox cb_Points;
    private javax.swing.JLabel l_contador;
    private javax.swing.JLabel l_major;
    private javax.swing.JLabel l_majorvalue;
    private javax.swing.JLabel l_minor;
    private javax.swing.JLabel l_minorvalue;
    // End of variables declaration//GEN-END:variables
 */
