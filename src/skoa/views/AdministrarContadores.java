/*
 * AdministrarContadores.java
 *
 * Created on 2 de julio de 2009, 12:35
 */
package skoa.views;

// Para poder usar @Action
import skoa.models.VariableGlobal;
import org.jdesktop.application.Action;

import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import tuwien.auto.eibpoints.*;
import tuwien.auto.eibxlator.*;
import tuwien.auto.eicl.struct.cemi.EIB_Address;
import tuwien.auto.eicl.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author  David
 */
public class AdministrarContadores extends javax.swing.JDialog {

    // Importado desde "Dialog_Point_mio.java"
    public static final long serialVersionUID = 1;
   

    //private PointList pointList;
    // Para utilizarlo como tercer parámetro en la llamada a "AdministrarContadores"
    //public static PointList Lcontadores = new PointList();
    /** Creates new form AdministrarContadores */
    
    public AdministrarContadores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
      
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getResourceMap(AdministrarContadores.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);
        
        initComponents();
        repaintList();
    }

   
   
    
     // Importado de "Dialog_Point_mio"
    // Proceso que obtiene los puntos insertados y los muestra en la lista
    //private void repaintList() {
    public static void repaintList() {
        // Obtiene una descripción con el nombre y dirección de todos los puntos contenidos en Lcontadores
        ListModel list_PointModel = new DefaultComboBoxModel(VariableGlobal.Lcontadores.getPointDescriptions());
        // Establece el modelo que representa los valores de la lista, notifica los cambios a los listeners
        // y limpia la selección de la lista
        list_Point.setModel(list_PointModel);
    }

    // Para cerrar la ventana al pulsar en "Cerrar"
    @Action
    public void cerrarAdminCont() {
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

        l_Address = new javax.swing.JLabel();
        tf_PointAddress = new javax.swing.JTextField();
        l_Name = new javax.swing.JLabel();
        tf_PointName = new javax.swing.JTextField();
        l_Type_Minor = new javax.swing.JLabel();
        cb_Type_Minor = new javax.swing.JComboBox();
        l_Type = new javax.swing.JLabel();
        cb_Type = new javax.swing.JComboBox();
        b_Add = new javax.swing.JButton();
        b_New = new javax.swing.JButton();
        b_Close = new javax.swing.JButton();
        b_Delete = new javax.swing.JButton();
        scroll_List = new javax.swing.JScrollPane();
        list_Point = new javax.swing.JList();
        list_Point.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(AdministrarContadores.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        l_Address.setFont(resourceMap.getFont("l_Address.font")); // NOI18N
        l_Address.setText(resourceMap.getString("l_Address.text")); // NOI18N
        l_Address.setName("l_Address"); // NOI18N

        tf_PointAddress.setName("tf_PointAddress"); // NOI18N

        l_Name.setFont(resourceMap.getFont("l_Name.font")); // NOI18N
        l_Name.setText(resourceMap.getString("l_Name.text")); // NOI18N
        l_Name.setName("l_Name"); // NOI18N

        tf_PointName.setName("tf_PointName"); // NOI18N

        l_Type_Minor.setFont(resourceMap.getFont("l_Type_Minor.font")); // NOI18N
        l_Type_Minor.setText(resourceMap.getString("l_Type_Minor.text")); // NOI18N
        l_Type_Minor.setName("l_Type_Minor"); // NOI18N

        cb_Type_Minor.setEnabled(false);
        cb_Type_Minor.setName("cb_Type_Minor"); // NOI18N

        l_Type.setFont(resourceMap.getFont("l_Type.font")); // NOI18N
        l_Type.setText(resourceMap.getString("l_Type.text")); // NOI18N
        l_Type.setName("l_Type"); // NOI18N

        cb_Type.setName("cb_Type"); // NOI18N
        String[] help = PDUXlatorList.getPointTypeMajor_mio().getAllTypeDescription();
        for (int i=0; i<help.length; i++){
            // Y los añade al combobox del tipo
            cb_Type.addItem(help[i]);
        }
        // Por defecto, no aparecerá ningún elemento seleccionado del combobox
        cb_Type.setSelectedIndex(-1);
        cb_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TypeActionPerformed(evt);
            }
        });

        b_Add.setFont(resourceMap.getFont("b_Add.font")); // NOI18N
        b_Add.setText(resourceMap.getString("b_Add.text")); // NOI18N
        b_Add.setName("b_Add"); // NOI18N
        b_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_AddActionPerformed(evt);
            }
        });

        b_New.setFont(resourceMap.getFont("b_New.font")); // NOI18N
        b_New.setText(resourceMap.getString("b_New.text")); // NOI18N
        b_New.setName("b_New"); // NOI18N
        b_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_NewActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(AdministrarContadores.class, this);
        b_Close.setAction(actionMap.get("cerrarAdminCont")); // NOI18N
        b_Close.setFont(resourceMap.getFont("b_Close.font")); // NOI18N
        b_Close.setText(resourceMap.getString("b_Close.text")); // NOI18N
        b_Close.setName("b_Close"); // NOI18N
        b_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_CloseActionPerformed(evt);
            }
        });

        b_Delete.setFont(resourceMap.getFont("b_Delete.font")); // NOI18N
        b_Delete.setText(resourceMap.getString("b_Delete.text")); // NOI18N
        b_Delete.setName("b_Delete"); // NOI18N
        b_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DeleteActionPerformed(evt);
            }
        });

        scroll_List.setName("scroll_List"); // NOI18N
        scroll_List.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll_List.setViewportView(list_Point);

        list_Point.setName("list_Point"); // NOI18N
        list_Point.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_PointValueChanged(evt);
            }
        });
        list_Point.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                list_PointFocusGained(evt);
            }
        });
        scroll_List.setViewportView(list_Point);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll_List, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b_New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(b_Close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_Address)
                            .addComponent(l_Name)
                            .addComponent(l_Type_Minor)
                            .addComponent(l_Type))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_Type, 0, 163, Short.MAX_VALUE)
                            .addComponent(cb_Type_Minor, 0, 163, Short.MAX_VALUE)
                            .addComponent(tf_PointName, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(tf_PointAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_Type)
                            .addComponent(cb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_Type_Minor)
                            .addComponent(cb_Type_Minor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_Name)
                            .addComponent(tf_PointName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_Address)
                            .addComponent(tf_PointAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b_Add)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b_Close)
                                    .addComponent(b_New)))
                            .addComponent(b_Delete))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll_List, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



// Acción llevada a cabo cuando se pulsa sobre el combobox del tipo
private void cb_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TypeActionPerformed
    // Elimina todos los elementos del combobox subtipo
    cb_Type_Minor.removeAllItems();
    String[] s = new String[0];
    try {
        // Obtiene el tipo seleccionado en el combobox y lo pasa a String
        String help = PDUXlatorList.getPointTypeMajor().getTypeKey(
                cb_Type.getSelectedItem().toString());
        // Obtiene los subtipos pertenecientes al tipo anterior
        s = PDUXlatorList.getPointPDUMinor(help).getAllTypeDescription();
    } catch (EICLException ex) {
        // En caso de que se produzca una excepción
        SkoaMain.showException(ex.getMessage());
    }

    // Se añaden los elementos necesarios al combobox subtipo
    for (int i = 0; i < s.length; i++) {
        cb_Type_Minor.addItem(s[i]);
    }
    // Y se activa dicho combobox, permitiendo al usuario elegir uno
    cb_Type_Minor.setEnabled(true);
}//GEN-LAST:event_cb_TypeActionPerformed

// Acción llevada a cabo al pulsar el botón "Nuevo"
private void b_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_NewActionPerformed

    // Para que no esté seleccionado ningún valor se utiliza el índice -1
    cb_Type_Minor.setSelectedIndex(-1);
    // Desactivamos el combobox del subtipo
    cb_Type_Minor.setEnabled(false);
    // Y Reseteamos los campos del nombre y la dirección de grupo
    tf_PointName.setText("");
    tf_PointAddress.setText("");
    b_Add.setText("Añadir");
}//GEN-LAST:event_b_NewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AdministrarContadores dialog = new AdministrarContadores(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {


                                            //************************************************************
                                            //    DESCONECTAR BUS EIB!!!
                    //	try {
                    //            if (MaipezView.tunnel != null)
                    //                MaipezView.tunnel.disconnect("solicitud realizada por el usuario");
                    //        } catch (EICLException ex) {
                    //            showException(ex.getMessage());
                    //        }
                    //    // Activamos (valor a 8) la variable global que nos servirá para detener las lecturas periódicas en caso
                    //    // de que estén activadas y el usuario se haya olvidado de desactivarlas
                    //    VariableGlobal.desconexion = 8;
                    //    jlEstadoServ_res.setText("No conectado");
                    //    // Y paramos los diferentes "timers" que controlan la monitorización continua de los sensores
                    //    deten_timers();
                                            //************************************************************

                    //                        System.out.println("quiero salir en administrar Contadores");
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

// Acción llevada a cabo al pulsar el botón "Añadir"
private void b_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_AddActionPerformed
    try {
        // Se comprueba que no haya previamente un dispositivo insertado con el mismo nombre
        Point[] vec_p = VariableGlobal.Lcontadores.getAllPoints();
        for (int i = 0; i < vec_p.length; i++) {
            if (vec_p[i].getDeviceName().indexOf(tf_PointName.getText()) != -1) {
                String err = "Ya existe un contador con ese nombre. Escoga otro, por favor.";
                JOptionPane.showMessageDialog(null, err, "Advertencia", 1);
                return;
            }
        }

        // También se comprueba que el nombre no supere los 6 caracteres (limitación de Mide Cuando Arranca)
        if (tf_PointName.getText().length() > 6) {
            String err = "El nombre no puede superar los 6 caracteres. Escoga otro, por favor";
            JOptionPane.showMessageDialog(null, err, "Advertencia", 1);
            return;
        }

        // Se trata de añadir un contador ...
        if (b_Add.getText().equals("Añadir")) {
            // Comprueba que los campos "nombre" y "dir. grupo" tengan información
            if (!tf_PointAddress.getText().equals("") & !tf_PointName.getText().equals("")) {
                // Obtiene la dirección
                EIB_Address eib = new EIB_Address(tf_PointAddress.getText());
                // Obtiene el tipo
                String major = PDUXlatorList.getPointTypeMajor_mio().getTypeKey(
                        (String) cb_Type.getSelectedItem());
                // Y el subtipo
                String minor = PDUXlatorList.getPointPDUMinor_mio(major).getTypeKey(
                        (String) cb_Type_Minor.getSelectedItem());
                // Ya tenemos un nuevo punto, con su nombre, dirección EIB, tipo y subtipo
                Point p = new Point(tf_PointName.getText(), eib, major, minor);
                // Lo añadimos a la lista de puntos
                VariableGlobal.Lcontadores.addPoint(p);
            }

        } else { // Se trata de modificarlo ...
            // Obtenemos el índice del punto seleccionado
            int selected = list_Point.getSelectedIndex();
            // Obtenemos el punto en concreto que va a ser modificado mediante el índice
            Point p = VariableGlobal.Lcontadores.getAllPoints()[selected];
            // Lo eliminamos de la lista
            VariableGlobal.Lcontadores.removePoint(p);
            // Obtenemos la dirección EIB que esté visible en el campo correspondiente
            EIB_Address eib = new EIB_Address(tf_PointAddress.getText());
            // Así como el tipo 
            String major = PDUXlatorList.getPointTypeMajor_mio().getTypeKey(
                    (String) cb_Type.getSelectedItem());
            // Y el subtipo
            String minor = PDUXlatorList.getPointPDUMinor_mio(major).getTypeKey(
                    (String) cb_Type_Minor.getSelectedItem());
            // Ya tenemos toda la información del nuevo punto
            p = new Point(tf_PointName.getText(), eib, major, minor);
            // Por lo que lo añadimos a la lista
            VariableGlobal.Lcontadores.addPoint(p);
        }
        // Dibujamos de nuevo la lista para que se muestren los cambios
        repaintList();
        // Y llamamos a NewActionPerformed, para que todo esté listo para insertar un nuevo punto/contador
        b_NewActionPerformed(evt);
    } catch (EICLException ex) {
        SkoaMain.showException(ex.getMessage());
    }
}//GEN-LAST:event_b_AddActionPerformed

// Acción llevada a cabo al pulsar el botón "Eliminar"
private void b_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DeleteActionPerformed
    // Elimina el punto seleccionado
    VariableGlobal.Lcontadores.removePoint(VariableGlobal.Lcontadores.getAllPoints()[list_Point.getSelectedIndex()]);
    // Y no dejamos seleccionado ningún otro punto
    list_Point.setSelectedIndex(-1);
    // Dibujamos la lista de nuevo
    repaintList();
    // Y limpiamos todos los campos, listo para seguir añadiendo ptos/contadores
    b_NewActionPerformed(evt);
}//GEN-LAST:event_b_DeleteActionPerformed

// Acción llevada a cabo al pulsar el botón "Cerrar"
private void b_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_CloseActionPerformed
    this.dispose();
}//GEN-LAST:event_b_CloseActionPerformed



 // Si quiero que al seleccionar la lista se genere algún evento debo agregar
private void list_PointValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_PointValueChanged

    list_SelectionChanged(evt);

}//GEN-LAST:event_list_PointValueChanged

private void list_PointFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_list_PointFocusGained
}//GEN-LAST:event_list_PointFocusGained

    // Obtenido de "Dialog_Point_mio.java"
    // Evento que se produce cuando el usuario selecciona algún valor de la lista
    public void list_SelectionChanged(ListSelectionEvent e) {
        // Se obtiene el índice del valor seleccionado
        int selected = list_Point.getSelectedIndex();
        // En caso de haber seleccionado algún pto ...
        if (selected != -1) {
            // Se obtiene el punto en concreto
            Point p = VariableGlobal.Lcontadores.getAllPoints()[selected];

            // Mostramos por pantalla en los campos correspondientes los valores
            // del noombre y la dirección del punto, respectivamente
            tf_PointName.setText(p.getDeviceName());
            tf_PointAddress.setText(p.getDeviceAddress()[0].toString());

            try {
                // Así como el tipo al que pertenecía
                cb_Type.setSelectedItem(PDUXlatorList.getPointTypeMajor().getTypeDescription(
                        p.getMajorType()));
                // No estoy seguro que esta instrucción haga falta, exportada de "Dialog_Point_mio.java"
                cb_TypeActionPerformed(null);
            } catch (EICLException ex) {
                SkoaMain.showException(ex.getMessage());
            }

            try {
                // Y su subtipo
                cb_Type_Minor.setSelectedItem(PDUXlatorList.getPointPDUMinor(p.getMajorType()).getTypeDescription(
                        p.getMinorType()));
            } catch (EICLException ex) {
                SkoaMain.showException(ex.getMessage());
            }
            // Si se ha seleccionado algún pto, se cambia el botón "Añadir" por "Modificar"
            b_Add.setText("Modificar");
        }
    } // Fin de este procedimiento





    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b_Add;
    private javax.swing.JButton b_Close;
    private javax.swing.JButton b_Delete;
    public javax.swing.JButton b_New;
    private javax.swing.JComboBox cb_Type;
    private javax.swing.JComboBox cb_Type_Minor;
    private javax.swing.JLabel l_Address;
    private javax.swing.JLabel l_Name;
    private javax.swing.JLabel l_Type;
    private javax.swing.JLabel l_Type_Minor;
    public static javax.swing.JList list_Point;
    private javax.swing.JScrollPane scroll_List;
    private javax.swing.JTextField tf_PointAddress;
    private javax.swing.JTextField tf_PointName;
    // End of variables declaration//GEN-END:variables
} // Fin de "public class AdministrarContadores"
 
