package com.irs.generalexamples.tad;

/**
 * Nodo representa un elemento en las estructuras de datos Pilas, Colas lineales y circulares y Listas Simplemente
 * Enlazadas tanto lineales como circulares.
 *
 * @author IRS
 * @version 1.0.0, 28/07/2001
 */
public class Nodo {
    /////////////////////////////////////////////////////////////////
    // ATRIBUTOS
    /////////////////////////////////////////////////////////////////

    /**
     * Campo Información
     *
     */
    private Object informacion;

    /**
     * Puntero (Referencia) al siguiente elemento
     *
     */
    private Nodo siguiente;


    /////////////////////////////////////////////////////////////////
    // METODOS
    /////////////////////////////////////////////////////////////////

    public Nodo() {
        this(null, null);

    }

    public Nodo(Object obj) {
        this(obj, null);
    }

    public Nodo(Object obj, Nodo sig) {
        super();
        this.informacion = obj;
        this.siguiente = sig;
    }

    /**
     * Obtiene el campo Información
     *
     * @return  Campo información
     */
    public Object getInformacion() {
        return this.informacion;
    }

    /**
     * Establece el campo Información
     *
     * @param   informacion
     */
    public void setInformacion(Object informacion) {
        this.informacion = informacion;
    }

    /**
     * Obtiene el campo Siguiente
     *
     * @return	Campo siguiente
     */
    public Nodo getSiguiente() {
        return this.siguiente;
    }

    /**
     * Establece el campo Siguiente
     *
     * @param   siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
