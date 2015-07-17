/*
 * principall.java
 *
 * Created on 6 de abril de 2010, 10:16
 */
package skoa.views;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
import skoa.helpers.ImagePreview;
import skoa.helpers.ImageFilter2;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.JTextField;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 *
 * @author  David
 */
public class NuevoProyecto extends javax.swing.JDialog {
// Definimos algunas variables que utilizaremos

    public static String archivo = ""; //nombre del archivo + path
    public static String nombre_archivo = ""; //nombre.xml
    public static String nombre_vivienda_fichero = "";
    public static String email_fichero = "";
    public static Boolean eshotel = false;
    public static int mail_enviado = 0;

    /** Creates new form principall */
    public NuevoProyecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Para centrar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        //this.setVisible(true);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cargarArchivo = new javax.swing.JTextField();
        examinar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        jLnombre = new javax.swing.JLabel();
        nombreFichero = new javax.swing.JTextField();
        pedir_email = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        pedir_nombre = new javax.swing.JLabel();
        nombre_viv = new javax.swing.JTextField();
        examinar2 = new javax.swing.JButton();
        hotel = new javax.swing.JCheckBox();
        vivienda = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(NuevoProyecto.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(-16777216,true)));
        jPanel1.setName("jPanel1"); // NOI18N

        cargarArchivo.setText(resourceMap.getString("cargarArchivo.text")); // NOI18N
        cargarArchivo.setName("cargarArchivo"); // NOI18N

        examinar.setText(resourceMap.getString("examinar.text")); // NOI18N
        examinar.setName("examinar"); // NOI18N
        examinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinarActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(cargarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(examinar))
                    .addComponent(jLabel1))
                .addGap(88, 88, 88))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jButton2)
                .addContainerGap(403, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examinar)
                    .addComponent(cargarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(-16777216,true)));
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        ruta.setText(resourceMap.getString("ruta.text")); // NOI18N
        ruta.setEnabled(false);
        ruta.setName("ruta"); // NOI18N

        jLnombre.setText(resourceMap.getString("jLnombre.text")); // NOI18N
        jLnombre.setName("jLnombre"); // NOI18N

        nombreFichero.setText(resourceMap.getString("nombreFichero.text")); // NOI18N
        nombreFichero.setName("nombreFichero"); // NOI18N
        nombreFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFicheroActionPerformed(evt);
            }
        });

        pedir_email.setText(resourceMap.getString("pedir_email.text")); // NOI18N
        pedir_email.setEnabled(false);
        pedir_email.setName("pedir_email"); // NOI18N

        email.setText(resourceMap.getString("email.text")); // NOI18N
        email.setEnabled(false);
        email.setName("email"); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        pedir_nombre.setText(resourceMap.getString("pedir_nombre.text")); // NOI18N
        pedir_nombre.setEnabled(false);
        pedir_nombre.setName("pedir_nombre"); // NOI18N

        nombre_viv.setText(resourceMap.getString("nombre_viv.text")); // NOI18N
        nombre_viv.setEnabled(false);
        nombre_viv.setName("nombre_viv"); // NOI18N
        nombre_viv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_vivActionPerformed(evt);
            }
        });

        examinar2.setText(resourceMap.getString("examinar2.text")); // NOI18N
        examinar2.setName("examinar2"); // NOI18N
        examinar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examinar2ActionPerformed(evt);
            }
        });

        hotel.setText(resourceMap.getString("hotel.text")); // NOI18N
        hotel.setName("hotel"); // NOI18N
        hotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hotelActionPerformed(evt);
            }
        });

        vivienda.setText(resourceMap.getString("vivienda.text")); // NOI18N
        vivienda.setName("vivienda"); // NOI18N
        vivienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viviendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(vivienda)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(hotel)
                            .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(pedir_email)
                                            .addGap(26, 26, 26)
                                            .addComponent(email))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(pedir_nombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nombre_viv, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                    .addComponent(jButton4))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ruta, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLnombre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nombreFichero))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(111, 111, 111)
                                                .addComponent(jLabel2))))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(examinar2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(37, 37, 37)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLnombre)
                    .addComponent(nombreFichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(examinar2)))
                .addGap(32, 32, 32)
                .addComponent(hotel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vivienda)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pedir_nombre)
                    .addComponent(nombre_viv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pedir_email)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(21, 21, 21))
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void examinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinarActionPerformed
    JFileChooser fc = null;

    //Set up the file chooser.
    if (fc == null) {
        fc = new JFileChooser();
        String curDir = System.getProperty("user.dir");
        fc.setCurrentDirectory(new File(curDir));
        //Add a custom file filter and disable the default
        //(Accept All) file filter.
        fc.addChoosableFileFilter(new ImageFilter2());
        fc.setAcceptAllFileFilterUsed(false);
        //Add the preview pane.
        fc.setAccessory(new ImagePreview(fc));
    }
    //Show it.
    int returnVal = fc.showDialog(this, "Seleccionar");
    //Process the results.
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        cargarArchivo.setText(file.getAbsolutePath());
        archivo = cargarArchivo.getText();
        nombre_archivo = archivo;

        while (nombre_archivo.contains("\\")) {
            nombre_archivo = nombre_archivo.substring(1);
        }
    }
    //Reset the file chooser for the next time it's shown.
    fc.setSelectedFile(null);
}//GEN-LAST:event_examinarActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    cargarArchivo.setCaretPosition(0);
    cargarArchivo.setText("");
    email.setCaretPosition(0);
    email.setText("");
    nombre_viv.setCaretPosition(0);
    nombre_viv.setText("");
    nombreFichero.setCaretPosition(0);
    nombreFichero.setText("");
    ruta.setCaretPosition(0);
    ruta.setText("");

    // Ocultamos la ventana
    this.dispose();
    // Y ejecutamos el archivo que se encarga de configurar la vivienda
    try {
        ConfiguracionSkoa.main();
    } catch (DocumentException e) {
        e.printStackTrace();
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void nombreFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFicheroActionPerformed
    // Obtenemos el nombre del fichero en la variable
    nombre_archivo = ((JTextField) evt.getSource()).getText() + ".xml";
}//GEN-LAST:event_nombreFicheroActionPerformed

private void nombre_vivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_vivActionPerformed
    // Obtenemos el nombre de la vivienda en la variable
    nombre_vivienda_fichero = ((JTextField) evt.getSource()).getText() + ".xml";
}//GEN-LAST:event_nombre_vivActionPerformed

private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
    // Obtenemos el nombre del mail en la variable
    email_fichero = ((JTextField) evt.getSource()).getText() + ".xml";
}//GEN-LAST:event_emailActionPerformed

private void examinar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examinar2ActionPerformed
    JFileChooser fc;
    String choosertitle = "Seleccionar un Directorio";
    int result;

    fc = new JFileChooser();
    fc.setCurrentDirectory(new java.io.File("."));
    fc.setDialogTitle(choosertitle);
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    // disable the "All files" option.
    fc.setAcceptAllFileFilterUsed(false);

    if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        ruta.setText(fc.getSelectedFile().toString());
        archivo = fc.getSelectedFile().toString();
    }
}//GEN-LAST:event_examinar2ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    nombre_archivo = nombreFichero.getText() + ".xml";
    //archivo = archivo + "\\" + nombre_archivo;
    if(ruta.getText().equals("")){
        archivo = "." + File.separator + nombre_archivo;
    }else{
         archivo = ruta.getText() + File.separator + nombre_archivo;
    }
    
    nombre_vivienda_fichero = nombre_viv.getText();
    email_fichero = email.getText();

    String auxiliar;
    if (eshotel == false) {
        auxiliar = "Viv. ";
    } else {
        auxiliar = "Hotel ";
    }

    auxiliar = auxiliar + nombre_vivienda_fichero;

    try {
        Document documento = DocumentHelper.createDocument();
        org.dom4j.Element root = documento.addElement("vivienda");
        root.addAttribute("name", nombre_vivienda_fichero);
        root.addAttribute("logo", auxiliar);
        root.addAttribute("contador", "1");

        Element node = (Element) documento.selectSingleNode("//vivienda");//[@nombre]" );
        org.dom4j.Element anadir = node.addElement("email");//( "plantas" );

        node = (Element) documento.selectSingleNode("//vivienda/email");
        anadir = node.addAttribute("direccion", email_fichero);

        FileWriter archivoFW = new FileWriter(archivo, true);
        OutputFormat format = OutputFormat.createPrettyPrint();

        //format.setEncoding("UTF-8");
        format.setEncoding("iso-8859-1");

        XMLWriter writer = new XMLWriter(archivoFW, format);

        writer.write(documento);
        writer.close();

        String mostrar = "Se ha creado el nuevo fichero de";
        mostrar += "\n";
        mostrar += "configuración: " + nombre_archivo;
        JOptionPane.showMessageDialog(null, mostrar, "Información", 1);

        cargarArchivo.setCaretPosition(0);
        cargarArchivo.setText("");

        email.setCaretPosition(0);
        email.setText("");

        nombre_viv.setCaretPosition(0);
        nombre_viv.setText("");

        nombreFichero.setCaretPosition(0);
        nombreFichero.setText("");

        ruta.setCaretPosition(0);
        ruta.setText("");
        ruta.setEnabled(false);

        this.dispose();
        ConfiguracionSkoa.main();

    } catch (IOException e2) {
        e2.printStackTrace();
    } catch (DocumentException e1) {

        e1.printStackTrace();
    }
}//GEN-LAST:event_jButton4ActionPerformed

private void hotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hotelActionPerformed
    eshotel = true;
    if (hotel.isSelected()) {
        vivienda.setSelected(false);
        pedir_nombre.setText("Introduzca el nombre de su hotel: ");
        pedir_nombre.setEnabled(true);
        pedir_email.setEnabled(true);
        nombre_viv.setEnabled(true);
        email.setEnabled(true);
    } else {
        pedir_nombre.setEnabled(false);
        pedir_email.setEnabled(false);
        nombre_viv.setEnabled(false);
        email.setEnabled(false);
    }
}//GEN-LAST:event_hotelActionPerformed

private void viviendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viviendaActionPerformed

    eshotel = false;
    if (vivienda.isSelected()) {
        pedir_nombre.setText("Introduzca el nombre de su vivienda: ");
        hotel.setSelected(false);
        pedir_nombre.setEnabled(true);
        pedir_email.setEnabled(true);
        nombre_viv.setEnabled(true);
        email.setEnabled(true);
    } else {
        pedir_nombre.setEnabled(false);
        pedir_email.setEnabled(false);
        nombre_viv.setEnabled(false);
        email.setEnabled(false);
    }
}//GEN-LAST:event_viviendaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                NuevoProyecto dialog = new NuevoProyecto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JTextField cargarArchivo;
    public static javax.swing.JTextField email;
    private javax.swing.JButton examinar;
    private javax.swing.JButton examinar2;
    private javax.swing.JCheckBox hotel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLnombre;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JTextField nombreFichero;
    public static javax.swing.JTextField nombre_viv;
    private javax.swing.JLabel pedir_email;
    private javax.swing.JLabel pedir_nombre;
    public static javax.swing.JTextField ruta;
    private javax.swing.JCheckBox vivienda;
    // End of variables declaration//GEN-END:variables
}