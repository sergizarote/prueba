package skoa.views;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class ElectorFicheros extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public JButton openButton, saveButton;
	public JTextField log,logruta;
	JFileChooser fc;
	String name="", route="";
	File fseleccionado;	//fichero seleccionado.
	static String ruta;
	 
	public ElectorFicheros() {
            File dir_inicial = new File ("./");
            String x =dir_inicial.getAbsolutePath();
            String os=System.getProperty("os.name");
            //En Windows las barras son \ y en Linux /.
            if (os.indexOf("Win")>=0) ruta=x+"\\Consultas\\";//Windows
            else ruta=x+"/Consultas/";                       //Linux
            log = new JTextField();
            log.setEditable(false);
            logruta = new JTextField();
            logruta.setEditable(false);
            //Crea el seleccionador de fichero (file chooser), abriendolo desde el directorio consultas(=ruta).
            fc = new JFileChooser(ruta);
            openButton = new JButton("Abrir un fichero...", createImageIcon("images/Open.gif"));
            openButton.addActionListener(this);
	}
 
	public void actionPerformed(ActionEvent e) {
		//Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(ElectorFicheros.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				fseleccionado=file;
				log.setText(" " + file.getName()); 	//Coge el nombre del fichero para abrir.
				logruta.setText(""+file.getAbsolutePath()); 	//Coge la ruta del fichero para abrir.
			} else {
				log.setText("");
				logruta.setText("");
			}
			log.setCaretPosition(log.getDocument().getLength());
			logruta.setCaretPosition(logruta.getDocument().getLength());
		} 
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = ElectorFicheros.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
