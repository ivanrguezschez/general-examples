package com.irs.generalexamples.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que ordena por diversos criterios un listado de provincias.
 * Empleando Java 5 en adelante para hacer uso de genéricos.
 *
 * @author IRS
 * @version 1.0.0
 */
public class ProvinciaSortV5 {

    static final Provincia[] PROVINCIAS = {
            new Provincia(29,"MALAGA"),
            new Provincia(39,"CANTABRIA"),
            new Provincia(49,"ZAMORA"),
            new Provincia(24,"LEON"),
            new Provincia(50,"ZARAGOZA"),
            new Provincia(23,"JAEN"),
            new Provincia(34,"PALENCIA"),
            new Provincia(30,"MURCIA"),
            new Provincia(18,"GRANADA"),
            new Provincia(20,"GUIPUZCOA"),
            new Provincia(42,"SORIA"),
            new Provincia(25,"LERIDA"),
            new Provincia(32,"ORENSE"),
            new Provincia(43,"TARRAGONA"),
            new Provincia(35,"LAS PALMAS"),
            new Provincia(13,"CIUDAD REAL"),
            new Provincia(26,"LA RIOJA"),
            new Provincia(44,"TERUEL"),
            new Provincia(9,"BURGOS"),
            new Provincia(19,"GUADALAJARA"),
            new Provincia(28,"MADRID"),
            new Provincia(3,"ALICANTE"),
            new Provincia(41,"SEVILLA"),
            new Provincia(27,"LUGO"),
            new Provincia(17,"GERONA"),
            new Provincia(14,"CORDOBA"),
            new Provincia(1,"ALAVA"),
            new Provincia(6,"BADAJOZ"),
            new Provincia(36,"PONTEVEDRA"),
            new Provincia(5,"AVILA"),
            new Provincia(16,"CUENCA"),
            new Provincia(46,"VALENCIA"),
            new Provincia(37,"SALAMANCA"),
            new Provincia(33,"ASTURIAS"),
            new Provincia(15,"LA CORUÑA"),
            new Provincia(11,"CADIZ"),
            new Provincia(4,"ALMERIA"),
            new Provincia(40,"SEGOVIA"),
            new Provincia(12,"CASTELLON"),
            new Provincia(45,"TOLEDO"),
            new Provincia(7,"BALEARES"),
            new Provincia(2,"ALBACETE"),
            new Provincia(38,"S.C. TENERIFE"),
            new Provincia(31,"NAVARRA"),
            new Provincia(47,"VALLADOLID"),
            new Provincia(21,"HUELVA"),
            new Provincia(48,"VIZCAYA"),
            new Provincia(10,"CACERES"),
            new Provincia(22,"HUESCA"),
            new Provincia(8, "BARCELONA") };

    static final Comparator<Provincia> PROVINCIA_CODIGO_ORDER_ASC = new Comparator<>() {
        public int compare(Provincia o1, Provincia o2) {
            return Integer.valueOf(o1.getCodigo()).compareTo(
                    Integer.valueOf(o2.getCodigo()));
        }
    };

    static final Comparator<Provincia> PROVINCIA_CODIGO_ORDER_DES = new Comparator<>() {
        public int compare(Provincia o1, Provincia o2) {
            return Integer.valueOf(o2.getCodigo()).compareTo(
                    Integer.valueOf(o1.getCodigo()));
        }
    };

    static final Comparator<Provincia> PROVINCIA_NOMBRE_ORDER_ASC = new Comparator<>() {
        public int compare(Provincia o1, Provincia o2) {
            return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        }
    };

    static final Comparator<Provincia> PROVINCIA_NOMBRE_ORDER_DES = new Comparator<>() {
        public int compare(Provincia o1, Provincia o2) {
            return o2.getNombre().compareToIgnoreCase(o1.getNombre());
        }
    };

    public static void main(String[] args) {
        List<Provincia> provincias = Arrays.asList(PROVINCIAS);
        //System.out.println(provincias);

        System.out.println("Provincias ordenadas por nombre mediante la implementacion de la interface Comparable.");
        Collections.sort(provincias);
        System.out.println(provincias);

        System.out.println("Provincias ordenadas por codigo ascendentemente.");
        Collections.sort(provincias, PROVINCIA_CODIGO_ORDER_ASC);
        System.out.println(provincias);

        System.out.println("Provincias ordenadas por codigo descendentemente.");
        Collections.sort(provincias, PROVINCIA_CODIGO_ORDER_DES);
        System.out.println(provincias);

        System.out.println("Provincias ordenadas por nombre ascendentemente.");
        Collections.sort(provincias, PROVINCIA_NOMBRE_ORDER_ASC);
        System.out.println(provincias);

        System.out.println("Provincias ordenadas por nombre descendentemente.");
        Collections.sort(provincias, PROVINCIA_NOMBRE_ORDER_DES);
        System.out.println(provincias);
    }
}
