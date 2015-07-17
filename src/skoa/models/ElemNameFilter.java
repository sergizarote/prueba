/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package skoa.models;

import org.jdom.filter.Filter;
import org.jdom.Element;
/**
 *
 * @author 
 */
// Esta clase nos servirá para utilizar un filtro de búsqueda en el fichero XML
public class ElemNameFilter implements Filter {

    String name;

    public ElemNameFilter(String name) {
        this.name = name;
    }

    public boolean matches(Object o) {

        if (o instanceof Element) {
            Element e = (Element) o;
            if (e.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}