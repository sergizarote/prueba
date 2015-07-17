package skoa.views;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import skoa.views.EstanciaNueva;
import skoa.views.NuevoProyecto;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class Arbol {

    public static JScrollPane MOSTRAR_CONFIGURACION = new javax.swing.JScrollPane();

    /**
     * Metodo para generar el arbol xml
     */
    public static void generarArbol() {
        try {

            
            //referencia al archivo
            File aFile = new File(NuevoProyecto.archivo);
            
            //referencia para leer el arbol
            SAXReader xmlReader = new SAXReader();
            //xmlReader.setEncoding("UTF-8");
            xmlReader.setEncoding("iso-8859-1");

            //referencia apra recorrer el arbol
            Document doc = xmlReader.read(aFile);
            Element node = (Element) doc.selectSingleNode("//vivienda");



            Attribute atributo = node.attribute("name");
            String datos = atributo.getText();
            DefaultMutableTreeNode root = new DefaultMutableTreeNode(datos);
            JTree arbol = new javax.swing.JTree(root);

            //--------
            arbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            DefaultMutableTreeNode estancia, planta;

            Element node2;
            
            //recorremos el node principal
            for (Iterator i = node.elementIterator(); i.hasNext();) {
                node = (Element) i.next();
                
                //si es una nodo tipo planta
                if (node.getName().equals("planta") && !node.valueOf("@alias").equals("") ) {
                   
                    planta = new DefaultMutableTreeNode(node.valueOf("@alias"));
                    root.add(planta);


                    node2 = node;
                    for (Iterator i2 = node2.elementIterator(); i2.hasNext();) {
                        node2 = (Element) i2.next();
                        if (node2.getName().equals("estancia")) {
                        

                            estancia = new DefaultMutableTreeNode(node2.valueOf("@nombre"));
                            planta.add(estancia);

                        }
                    }//end for
                }//end if


            }//end for


            expandAll(arbol, true);

            MOSTRAR_CONFIGURACION.setViewportView(arbol);

        } catch (DocumentException e) {
            e.printStackTrace();
//                         (FileNotFoundException e) {
//					e.printStackTrace();
        }

//		 catch (DocumentException e) {
//			e.printStackTrace();
//		}

    }//end generar arbol

//-----------------------------------------------------------------------------------------
    public static void expandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();

        // Traverse tree from root
        expandAll(tree, new TreePath(root), expand);
    }

    private static void expandAll(JTree tree, TreePath parent, boolean expand) {
        // Traverse children
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements();) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }

        // Expansion or collapse must be done bottom-up
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

//----------------------------------------------------------------------
    public static void generarDesplegable() {
        try {
            EstanciaNueva.desplegable.removeAllItems();
            EstanciaNueva.desplegable.addItem("--Plantas--");

            // estancia_nueva.nombre_estancia.setColumns(0);
            EstanciaNueva.nombre_estancia.setCaretPosition(0);
            EstanciaNueva.nombre_estancia.setText("");
            // estancia_nueva.nombre_estancia.setSelectionEnd(-1);
            // estancia_nueva.nombre_estancia.setSelectionStart(-1);

            EstanciaNueva.imagen_estancia.setCaretPosition(0);
            EstanciaNueva.imagen_estancia.setText("");

            File aFile = new File(NuevoProyecto.archivo);
            SAXReader xmlReader = new SAXReader();

            //xmlReader.setEncoding("UTF-8");//******************************************
            xmlReader.setEncoding("iso-8859-1");//******************************************

            Document doc = xmlReader.read(aFile);
            Element node = (Element) doc.selectSingleNode("//vivienda");

            Attribute atributo = node.attribute("name");

            String datos = atributo.getText();//node.getName();

            for (Iterator i = node.elementIterator(); i.hasNext();) {
                node = (Element) i.next();
                if (node.getName().equals("planta") &&  !node.valueOf("@alias").equals("") ) {
             
                    
                    EstanciaNueva.desplegable.addItem( node.valueOf("@alias"));
                    
                }//end if
            }//end for




        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }//end generar desplegable
}