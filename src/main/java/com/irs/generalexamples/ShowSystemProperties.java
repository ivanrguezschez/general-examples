package com.irs.generalexamples;

import java.util.Iterator;
import java.util.Properties;

/**
 * Clase que muestra las propiedades del sistema.
 *
 * @author IRS
 * @version 1.0.0, 08/05/2007
 */
public class ShowSystemProperties {

    public static void main(String[] args) {
        Properties p = System.getProperties();
        System.out.println("***************************************");
        p.list(System.out);
        System.out.println("***************************************");

        for (Iterator it = p.keySet().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            String value = p.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}
