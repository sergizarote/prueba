/*
 * Escribir.java
 *
 * Created on 2 de julio de 2009, 0:13
 */

package skoa.views;

// Para poder usar @Action
import skoa.models.VariableGlobal;
import org.jdesktop.application.Action;
import tuwien.auto.eibpoints.*;
import tuwien.auto.eibxlator.PointPDUXlator;
import tuwien.auto.eibxlator.PDUXlatorList;
import tuwien.auto.eicl.CEMI_Connection;
import tuwien.auto.eicl.struct.cemi.CEMI_L_DATA;
import tuwien.auto.eicl.util.*;
import tuwien.auto.eicl.struct.cemi.EIB_Address;
import javax.swing.JOptionPane;

/**
 *
 * @author  David
 */
public class Escribir extends javax.swing.JDialog {
    
    private CEMI_Connection tunnel;
    private String fecha_hora;

    /** Creates new form Escribir */
    public Escribir(java.awt.Frame parent, boolean modal, CEMI_Connection _Tunnel, String _fecha_hora) {
        super(parent, modal);
        tunnel = _Tunnel;
        fecha_hora = _fecha_hora;
        initComponents();
        initComponents_mio();
    }
    
    // Para cerrar la ventana al pulsar en "Cancelar"
    @Action public void cerrarEscribirPtos() {
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

        jBEnviar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jCBCont = new javax.swing.JComboBox();
        jLTipo = new javax.swing.JLabel();
        jLSubtipo = new javax.swing.JLabel();
        jLSubtipo2 = new javax.swing.JLabel();
        jLTipo2 = new javax.swing.JLabel();
        jLContador = new javax.swing.JLabel();
        jLValor = new javax.swing.JLabel();
        jTFValor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLValor2 = new javax.swing.JLabel();
        cb_Value = new javax.swing.JComboBox();
        jLV = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getResourceMap(Escribir.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jBEnviar.setFont(resourceMap.getFont("jBEnviar.font")); // NOI18N
        jBEnviar.setText(resourceMap.getString("jBEnviar.text")); // NOI18N
        jBEnviar.setName("jBEnviar"); // NOI18N
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getActionMap(Escribir.class, this);
        jBCancelar.setAction(actionMap.get("cerrarEscribirPtos")); // NOI18N
        jBCancelar.setFont(resourceMap.getFont("jBCancelar.font")); // NOI18N
        jBCancelar.setText(resourceMap.getString("jBCancelar.text")); // NOI18N
        jBCancelar.setName("jBCancelar"); // NOI18N

        jCBCont.setFont(resourceMap.getFont("jCBCont.font")); // NOI18N
        jCBCont.setName("jCBCont"); // NOI18N
        jCBCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBContActionPerformed(evt);
            }
        });

        jLTipo.setFont(resourceMap.getFont("jLTipo.font")); // NOI18N
        jLTipo.setText(resourceMap.getString("jLTipo.text")); // NOI18N
        jLTipo.setName("jLTipo"); // NOI18N

        jLSubtipo.setFont(resourceMap.getFont("jLSubtipo.font")); // NOI18N
        jLSubtipo.setText(resourceMap.getString("jLSubtipo.text")); // NOI18N
        jLSubtipo.setName("jLSubtipo"); // NOI18N

        jLSubtipo2.setFont(resourceMap.getFont("jLSubtipo2.font")); // NOI18N
        jLSubtipo2.setText(resourceMap.getString("jLSubtipo2.text")); // NOI18N
        jLSubtipo2.setName("jLSubtipo2"); // NOI18N

        jLTipo2.setFont(resourceMap.getFont("jLTipo2.font")); // NOI18N
        jLTipo2.setText(resourceMap.getString("jLTipo2.text")); // NOI18N
        jLTipo2.setName("jLTipo2"); // NOI18N

        jLContador.setFont(resourceMap.getFont("jLContador.font")); // NOI18N
        jLContador.setText(resourceMap.getString("jLContador.text")); // NOI18N
        jLContador.setName("jLContador"); // NOI18N

        jLValor.setFont(resourceMap.getFont("jLValor.font")); // NOI18N
        jLValor.setText(resourceMap.getString("jLValor.text")); // NOI18N
        jLValor.setName("jLValor"); // NOI18N

        jTFValor.setText(resourceMap.getString("jTFValor.text")); // NOI18N
        jTFValor.setName("jTFValor"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLValor2.setFont(resourceMap.getFont("jLValor2.font")); // NOI18N
        jLValor2.setText(resourceMap.getString("jLValor2.text")); // NOI18N
        jLValor2.setEnabled(false);
        jLValor2.setName("jLValor2"); // NOI18N

        cb_Value.setEnabled(false);
        cb_Value.setName("cb_Value"); // NOI18N

        jLV.setFont(resourceMap.getFont("jLV.font")); // NOI18N
        jLV.setText(resourceMap.getString("jLV.text")); // NOI18N
        jLV.setName("jLV"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSubtipo)
                            .addComponent(jLContador)
                            .addComponent(jLTipo)
                            .addComponent(jLValor)
                            .addComponent(jLValor2))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLSubtipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTipo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBCont, javax.swing.GroupLayout.Alignment.TRAILING, 0, 239, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cb_Value, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(14, 14, 14)
                        .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLContador)
                    .addComponent(jCBCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTipo)
                    .addComponent(jLTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLSubtipo)
                    .addComponent(jLSubtipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValor)
                    .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLV))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValor2)
                    .addComponent(cb_Value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jBCancelar)
                    .addComponent(jBEnviar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jCBContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBContActionPerformed
try {
            // Se eliminan las posibles opciones que pudiera ofrecer el combobox de los valores
            cb_Value.removeAllItems();
            
            // En caso de que se haya seleccionado algún contador
            if (jCBCont.getSelectedIndex() != -1) 
            {
                // Se obtiene le punto seleccionado
                Point p = VariableGlobal.Lcontadores.getPoint(jCBCont.getSelectedItem().toString());
                // Se muestra por pantalla su tipo y su subtipo
                jLTipo2.setText(PDUXlatorList.getPointTypeMajor().getTypeDescription(p.getMajorType()));
                jLSubtipo2.setText(PDUXlatorList.getPointPDUMinor(p.getMajorType()).get(p.getMinorType())[1]);
                
                // Por defecto, se mantiene esta configuración
                jTFValor.setText("");
                jLV.setText("");
                jLValor.setEnabled(true);
                jTFValor.setEnabled(true);
                jLValor2.setEnabled(false);
                cb_Value.setEnabled(false);
                
                // Y dependiendo del tipo escogido
                if (p.getMajorType().equals(PDUXlatorList.TYPE_BOOLEAN[0])) {
                    // Será necesario añadir al combobox de los valores las posibles opciones a elegir por parte del usuario
                    String[] values = PDUXlatorList.getPointPDUMinor(p.getMajorType()).getTypeValues(p.getMinorType());
                    for (int i=0; i<values.length; i++) 
                        cb_Value.addItem(values[i]);
                    // Se activarán o desactivarán la forma de insertar el valor: mediante el teclado, o seleccionando
                    // un valor predeterminado del combobox
                    jLValor.setEnabled(false);
                    jTFValor.setEnabled(false);
                    jLV.setText("");
                    jLValor2.setEnabled(true);
                    cb_Value.setEnabled(true);
                  // Mismo procedimiento con el resto de tipos
                } else if (p.getMajorType().equals(PDUXlatorList.TYPE_8BIT_UNSIGNED[0])) { // NO LO TENGO POR AHORA
                    jTFValor.setText("");
                    jLValor.setEnabled(true);
                    jTFValor.setEnabled(true);
                    jLValor2.setEnabled(false);
                    cb_Value.setEnabled(false);
                    jLV.setText(PDUXlatorList.getPointPDUMinor(p.getMajorType()).getTypeValues(p.getMinorType())[1]);
                } else if (p.getMajorType().equals(PDUXlatorList.TYPE_2OCTET_FLOAT[0])) {
                    jTFValor.setText("");
                    jLValor.setEnabled(true);
                    jTFValor.setEnabled(true);
                    jLValor2.setEnabled(false);
                    cb_Value.setEnabled(false);
                    jLV.setText(PDUXlatorList.getPointPDUMinor(p.getMajorType()).getTypeValues(p.getMinorType())[1]);
                } else if (p.getMajorType().equals(PDUXlatorList.TYPE_STRING[0])) { // NO LO TENGO POR AHORA
                    jTFValor.setText("");
                    jLValor.setEnabled(true);
                    jTFValor.setEnabled(true);
                    jLV.setText("");
                    jLValor2.setEnabled(false);
                    cb_Value.setEnabled(false);
                } else if (p.getMajorType().equals(PDUXlatorList.TYPE_3BIT_CONTROLLED[0])) {
                    jTFValor.setText("");
                    jTFValor.setEnabled(true);
                    jLValor.setEnabled(true);
                    jLValor2.setEnabled(true);
                    cb_Value.setEnabled(true);
                    cb_Value.removeAllItems();
                    cb_Value.addItem("Aumentar");
                    cb_Value.addItem("Disminuir");
                    jLV.setText("pasos");
                }
                
            } // fin del if principal
        } catch (EICLException ex) {
            SkoaMain.showException(ex.getMessage());
        }    
}//GEN-LAST:event_jCBContActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// En primer lugar, vaciamos los elementos que pudiera tener almacenado el combobox
    jCBCont.removeAllItems();
    
    // Importado de "Dialog_Read.java"
    // Posteriormente, añadimos al combobox los contadores que estén en la base de datos
        Point[] p = VariableGlobal.Lcontadores.getAllPoints();
            for (int i=0; i<p.length; i++)
                jCBCont.addItem(p[i].getDeviceName());
     
     // Y por defecto, no mostramos nada en el combobox, ni el el tipo, ni el el subtipo
     jCBCont.setSelectedIndex(-1);
     jLTipo2.setText("");
     jLSubtipo2.setText("");
     
}//GEN-LAST:event_jButton1ActionPerformed

private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
    String mensaje = "";
    
    try {
        // Nos aseguramos que haya algún contador seleccionado
        if (jCBCont.getSelectedIndex() != -1) 
        {
            // Obtenemos el punto asociado a dicho contador
            Point p = VariableGlobal.Lcontadores.getPoint(jCBCont.getSelectedItem().toString());
            String help = "";
            
            // Si el combobox de los valores está activado
            if (cb_Value.isEnabled())
                // Obtenemos dicho valor
                help = (String) cb_Value.getSelectedItem();
            // Casos especiales: si se trata de aumentar o disminuir la potencia de las luces regulabes
            if (help.indexOf("Aumentar") != -1)
                help = "Increase";
            if (help.indexOf("Disminuir") != -1)
                help = "Decrease";
            
            // Si además está activado el campo Valor y hay algo en él (caso de las luces regulables)
            if (jTFValor.isEnabled() && cb_Value.isEnabled() && !jTFValor.getText().equals(""))
                // Obtenemos el valor del combobox y del campo Valor
                help += " " + jTFValor.getText();
            
            // Si sólo está activado el campo Valor y hay algún valor introducido en él
            if (jTFValor.isEnabled() && !jTFValor.getText().equals("") && !cb_Value.isEnabled())
                // Obtenemos ese valor
                help = jTFValor.getText();
            
            // Si no hay introducido ningún valor, le informamos de ello
            if (jTFValor.isEnabled() && jTFValor.getText().equals(""))
            {
                String err = "Por favor, introduzca algún valor";
                JOptionPane.showMessageDialog(null, err, "Advertencia", 1);
                return;
            }
            
            // Para el caso de las luces regulabes, el valor no puede estar fuera del rango (0-7)
            if (jTFValor.isEnabled() && !jTFValor.getText().equals("") &&
                    (help.indexOf("Increase") != -1 || help.indexOf("Decrease") != -1) &&
                    ((Integer.valueOf(jTFValor.getText()) < 0) || (Integer.valueOf(jTFValor.getText()) > 7)))
            {
                String err = "El valor debe estar comprendido entre 0 y 7. Escoga otro, por favor";
                JOptionPane.showMessageDialog(null, err, "Advertencia", 1);
                return;
            }
            
            // Mandamos la señal de escritura a través del bus)
            PointPDUXlator xlator = PDUXlatorList.getPointPDUXlator(p.getMajorType(),p.getMinorType());
            xlator.setServiceType(PointPDUXlator.A_GROUPVALUE_WRITE);
            xlator.setASDUfromString(help);
            CEMI_L_DATA data = new CEMI_L_DATA((byte) CEMI_L_DATA.MC_L_DATAREQ,
                    new EIB_Address(), p.getDeviceAddress()[0], xlator.getAPDUByteArray());
                
                // Y esperamos por la confirmación
                tunnel.sendFrame(data, CEMI_Connection.WAIT_FOR_CONFIRM);
                    // Informamos de la acción en el log de la aplicación
                    synchronized (SkoaMain.textArea) {
                        mensaje = fecha_hora + ": Mensaje enviado a " + jCBCont.getSelectedItem()
                                + ", valor= " + help + "\n";
                        SkoaMain.textArea.append(mensaje);
                    }
                // Y también en el fichero log
                SkoaMain.escribeMensajeLog(SkoaMain.ficheroLOG, mensaje); 
                this.dispose();
          } // fin del if principal
        } catch (EICLException ex) {
            SkoaMain.showException(ex.getMessage());
        }
}//GEN-LAST:event_jBEnviarActionPerformed

    private void initComponents_mio()
    {
        // Actualizamos los elementos del combobox con los contadores que haya
        Point[] p = VariableGlobal.Lcontadores.getAllPoints();
            for (int i=0; i<p.length; i++)
                jCBCont.addItem(p[i].getDeviceName());
        
        // Por defecto, no aparecerá ninguno seleccionado
        jCBCont.setSelectedIndex(-1);
        // Y se mantendrá esta configuración
        jLTipo2.setText("");
        jLSubtipo2.setText("");
        jTFValor.setText("");
        jLV.setText("");
        jLValor.setEnabled(true);
        jTFValor.setEnabled(true);
        jLValor2.setEnabled(false);
        cb_Value.setEnabled(false);
    }
    
    /**
    * @param args the command line arguments
    */
    public void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Escribir dialog = new Escribir(new javax.swing.JFrame(), true, tunnel, fecha_hora);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_Value;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCBCont;
    private javax.swing.JLabel jLContador;
    private javax.swing.JLabel jLSubtipo;
    private javax.swing.JLabel jLSubtipo2;
    private javax.swing.JLabel jLTipo;
    private javax.swing.JLabel jLTipo2;
    private javax.swing.JLabel jLV;
    private javax.swing.JLabel jLValor;
    private javax.swing.JLabel jLValor2;
    private javax.swing.JTextField jTFValor;
    // End of variables declaration//GEN-END:variables

}
