package com.irs.generalexamples.tad;

import java.util.Vector;

/**
 * Pila representa la estructura de datos dinamica pila con el funcionamiento LIFO (Last Input First Output).
 *
 * @author IRS
 * @version 1.0.0, 28/07/2001
 */
public class Pila {
    /////////////////////////////////////////////////////////////////
    // ATRIBUTOS
    /////////////////////////////////////////////////////////////////

    /**
     * Campo que apunta a la cima de la pila
     *
     */
    private Nodo cima;


    /////////////////////////////////////////////////////////////////
    // METODOS
    /////////////////////////////////////////////////////////////////

    /**
     * Constructor por defecto
     *
     */
    public Pila() {
        super();
        this.cima = null;
    }


    /**
     * Constructor de copia
     *
     * @param   p
     */
    public Pila(Pila p) {
        super();
        this.cima = p.getCima();
    }


    /**
     * Constructor a partir de un array de objetos
     *
     * @param   obj
     */
    public Pila(Object[] obj) {
        super();
        for (int i = 0; i < obj.length; i++) {
            insertar(obj[i]);
        }
    }


    /**
     * Constructor a partir de un vector
     *
     * @param   v
     */
    public Pila(Vector v) {
        super();
        for(int i = 0; i < v.size(); i++) {
            insertar(v.elementAt(i));
        }
    }

    /**
     * Determina si una pila esta vacia o no
     *
     * @return	true o false dependiendo de si la pila esta vacia o no
     */
    public boolean esVacia() {
        return this.cima == null;
    }


    /**
     * Inserta un elemento en la pila
     *
     * @param   info	Objeto a insertar
     */
    public void insertar(Object info) {
        Nodo temp = new Nodo(info);
        temp.setSiguiente(this.cima);
        this.cima = temp;
    }


    /**
     * Borra el elemento que se encuentra en la cima de la pila
     *
     */
    public void borrar() {
        if (this.cima != null) {
            this.cima = cima.getSiguiente();
        }
    }


    /**
     * Obtiene el elemento de la cima de la pila
     *
     * @return	el elemento cima de la pila
     */
    public Nodo getCima() {
        return this.cima;
    }


    /**
     * Obtiene una cadena con todos los elementos de la pila
     *
     * @return	una cadena con los elementos de la pila
     */
    public String toString() {
        StringBuffer temp = new StringBuffer();

        while (!esVacia()) {
            temp.append("[" + getCima().getInformacion() + "]");
            borrar();
        }
        return temp.toString();
    }
}
