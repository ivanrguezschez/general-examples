package com.irs.generalexamples.tad;

import java.util.Vector;

/**
 * ColaC representa la estructura de datos dinamica cola circular con el funcionamiento FIFO (First Input First Output),
 * en la que el ultimo elemento apunta al primer elemento y el puntero externo apunta al último elemento.
 *
 * @author IRS
 * @version 1.0.0, 28/07/2001
 */
public class ColaC {
    /////////////////////////////////////////////////////////////////
    // ATRIBUTOS
    /////////////////////////////////////////////////////////////////

    /**
     * Campo que apunta al ultimo elemento de la cola y este es
     * el que apunta al primer elemento de la cola circular
     */
    private Nodo q;


    /////////////////////////////////////////////////////////////////
    // METODOS
    /////////////////////////////////////////////////////////////////

    /**
     * Constructor por defecto
     *
     */
    public ColaC() {
        super();
        this.q = null;
    }


    /**
     * Constructor de copia
     *
     * @param   c
     */
    public ColaC(ColaC cc) {
        super();
        this.q = cc.getPrimero();
        // getPrimero en realidad me devuelve el puntero al ultimo
        // elemento de la cola circular
    }


    /**
     * Constructor a partir de un array de objetos
     *
     * @param   obj
     */
    public ColaC(Object[] obj) {
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
    public ColaC(Vector v) {
        super();
        for (int i = 0; i < v.size(); i++) {
            insertar(v.elementAt(i));
        }
    }

    /**
     * Determina si una cola circular esta vacia o no
     *
     * @return	true o false dependiendo de si la cola circular esta vacia o no
     */
    public boolean esVacia() {
        return this.q == null;
    }

    /**
     * Inserta un elemento en la cola circular, siempre por el final
     *
     * @param   info	Objeto a insertar
     */
    public void insertar(Object info) {
        Nodo temp = new Nodo(info);

        if (this.q == null) {
            temp.setSiguiente(temp);
        } else {
            temp.setSiguiente(this.q.getSiguiente());
            this.q.setSiguiente(temp);
        }
        this.q = temp;
    }

    /**
     * Borra el elemento que se encuentra al principio de la cola circular
     *
     */
    public void borrar() {
        if (this.q != null) {
            if (this.q == this.q.getSiguiente()) {
                this.q = null;
            } else {
                this.q.setSiguiente((this.q.getSiguiente()).getSiguiente());
            }
        }
    }

    /**
     * Obtiene el primer elemento de la cola circular
     *
     * @return	el primer elemento de la cola circular
     */
    public Nodo getPrimero() {
        return this.q;
    }

    /**
     * Obtiene una cadena con todos los elementos de la cola circular
     *
     * @return	una cadena con los elementos de la cola circular
     */
    public String toString() {
        StringBuffer temp = new StringBuffer();

        while (!esVacia()) {
            temp.append("[" + (getPrimero().getSiguiente()).getInformacion() + "]");
            borrar();
        }
        return temp.toString();
    }
}
