package com.irs.generalexamples.comparator;

/**
 * Clase que representa una provincia, usada para realizar ordenaciones
 * tanto por codigo como por nombre de provincia.
 *
 * @author IRS
 * @version 1.0.0, 20/02/2004
 */
public class Provincia implements Comparable {

    private int codigo;
    private String nombre;

    public Provincia() {
        this(0, null);
    }

    public Provincia(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "[codigo=" + codigo + ", nombre=" + nombre + "]";
    }

    //Metodo del interface Comparable
    public int compareTo(Object o) {
        Provincia p = (Provincia) o;
        return this.getNombre().compareToIgnoreCase(p.getNombre());
    }
}
