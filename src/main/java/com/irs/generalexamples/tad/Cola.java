package com.irs.generalexamples.tad;

import java.util.Vector;

/**
 * Cola representa la estructura de datos dinamica cola con el funcionamiento FIFO (First Input First Output).
 *
 * @author IRS
 * @version 1.0.0, 28/07/2001
 */
public class Cola {
    /////////////////////////////////////////////////////////////////
    // ATRIBUTOS
    /////////////////////////////////////////////////////////////////

    /**
     * Campo que apunta al primer elemento de la cola
     *
     */
    private Nodo primero;

    /**
     * Campo que apunta al ultimo elemento de la cola
     *
     */
    private Nodo ultimo;

    /////////////////////////////////////////////////////////////////
    // METODOS
    /////////////////////////////////////////////////////////////////

    /**
     * Constructor por defecto
     *
     */
    public Cola() {
        super();
        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Constructor de copia
     *
     * @param   c
     */
    public Cola(Cola c) {
        super();
        this.primero = c.getPrimero();
        this.ultimo = c.getUltimo();
    }

    /**
     * Constructor a partir de un array de objetos
     *
     * @param   obj
     */
    public Cola(Object[] obj) {
        super();
        for(int i = 0; i < obj.length; i++) {
            insertar(obj[i]);
        }
    }

    /**
     * Constructor a partir de un vector
     *
     * @param   v
     */
    public Cola(Vector v) {
        super();
        for(int i = 0; i < v.size(); i++) {
            insertar(v.elementAt(i));
        }
    }

    /**
     * Determina si una cola esta vacia o no
     *
     * @return	true o false dependiendo de si la cola esta vacia o no
     */
    public boolean esVacia() {
        return this.primero == null;
    }


    /**
     * Inserta un elemento en la cola
     *
     * @param   info	Objeto a insertar
     */
    public void insertar(Object info) {
        Nodo temp = new Nodo(info);
        if (this.primero == null) {
            this.primero = temp;
        } else {
            this.ultimo.setSiguiente(temp);
        }
        this.ultimo = temp;
    }

    /**
     * Borra el elemento que se encuentra al principio de la cola
     *
     */
    public void borrar() {
        if (this.primero != null) {
            this.primero = this.primero.getSiguiente();
            if (this.primero == null) {
                this.ultimo = null;
            }
        }
    }

    /**
     * Obtiene el primer elemento de la cola
     *
     * @return	el primer elemento de la cola
     */
    public Nodo getPrimero() {
        return this.primero;
    }

    /**
     * Obtiene el ultimo elemento de la cola
     *
     * @return	el ultimo elemento de la cola
     */
    public Nodo getUltimo() {
        return this.ultimo;
    }

    /**
     * Obtiene una cadena con todos los elementos de la cola
     *
     * @return	una cadena con los elementos de la cola
     */
    public String toString() {
        StringBuffer temp = new StringBuffer();

        while (!esVacia()) {
            temp.append("[" + getPrimero().getInformacion() + "]");
            borrar();
        }

        return temp.toString();
    }
}
