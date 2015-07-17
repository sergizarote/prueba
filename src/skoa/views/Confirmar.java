/*
 * Confirmar.java
 *
 * Created on 19 de marzo de 2010, 23:29
 */

package skoa.views;

import skoa.helpers.Acciones;
import java.awt.*; // Lo usamos para poder centrar la ventana (Dimension)


/**
 *
 * @author  David
 */
public class Confirmar extends javax.swing.JDialog {
    static int elec;
    
    /** Creates new form Confirmar */
    public Confirmar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBSi = new javax.swing.JButton();
        jBNo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(skoa.views.SkoaApp.class).getContext().getResourceMap(Confirmar.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jBSi.setText(resourceMap.getString("jBSi.text")); // NOI18N
        jBSi.setName("jBSi"); // NOI18N
        jBSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSiActionPerformed(evt);
            }
        });

        jBNo.setText(resourceMap.getString("jBNo.text")); // NOI18N
        jBNo.setName("jBNo"); // NOI18N
        jBNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jBSi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jBNo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNo)
                    .addComponent(jBSi))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jBSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiActionPerformed
    // Dependiendo de la elección, se eliminará una cosa u otra
    // 1: planta
    // 2: estancia
    
    if (elec == 1)
    {
        // Actualizamos los vectores vecDispUsados y vecDispDomoticos
        SkoaMain.planta_eliminada(EliminarPlanta.planta_seleccionada);
        // Eliminamos la planta seleccionada, generamos el árbol de nuevo y mostramos las plantas restantes
        Acciones.eliminarPlantaXML(EliminarPlanta.planta_seleccionada);
        Arbol.generarArbol();

        Acciones.mostrarPlantasVistaEliminarPlanta();
    }
    
    if (elec == 2)
    {
        // Actualizamos los vectores vecDispUsados y vecDispDomoticos
        SkoaMain.estancia_eliminada(EliminarEstancia.planta_seleccionada, EliminarEstancia.estancia_seleccionada);
        // Eliminamos la estancia seleccionada, generamos el árbol de nuevo y mostramos las estancias restantes
        Acciones.eliminarEstanciaXML(EliminarEstancia.planta_seleccionada, EliminarEstancia.estancia_seleccionada);
        Arbol.generarArbol();
	Acciones.mostrarPlantasVistaModificarPlano();
    }
    
    // Ocultamos la ventana y liberamos todos los procesos utilizados por ésta
    this.dispose();
}//GEN-LAST:event_jBSiActionPerformed

private void jBNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNoActionPerformed
    // Ocultamos la ventana y liberamos todos los procesos utilizados por ésta
    this.dispose();
}//GEN-LAST:event_jBNoActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(final int eleccion) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                final Confirmar dialog = new Confirmar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        //System.exit(0);
                        dialog.setVisible(false);
                    }
                });
                // Centramos la ventana
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = dialog.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }
            dialog.setLocation((screenSize.width - frameSize.width) / 2,
                    (screenSize.height - frameSize.height) / 2);
                
                elec = eleccion;
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBNo;
    private javax.swing.JButton jBSi;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}