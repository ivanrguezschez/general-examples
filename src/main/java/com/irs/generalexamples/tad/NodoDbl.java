package com.irs.generalexamples.tad;

/**
 * NodoDbl representa un elemento en las estructuras de datos Listas Doblemente Enlazadas tanto lineales como
 * circulares y Arboles Binarios.
 *
 * @author IRS
 * @version 1.0.0, 28/07/2001
 */
public class NodoDbl {
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
    private NodoDbl siguiente;

    /**
     * Puntero (Referencia) al anterior elemento
     *
     */
    private NodoDbl anterior;

    /////////////////////////////////////////////////////////////////
    // METODOS
    /////////////////////////////////////////////////////////////////

    public NodoDbl() {
        this(null);
    }

    public NodoDbl(Object obj) {
        super();
        this.informacion = obj;
        this.siguiente = null;
        this.anterior = null;
    }

    public NodoDbl(Object obj, NodoDbl nodo) {
        super();
        this.informacion = obj;
        this.siguiente = nodo.siguiente;
        this.anterior = nodo.anterior;
    }

    /**
     * Obtiene el campo Información
     *
     * @return	Campo información
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
     * Obtiene el campo Anterior
     *
     * @return	Campo anterior
     */
    public NodoDbl getAnterior() {
        return this.anterior;
    }

    /**
     * Establece el campo Anterior
     *
     * @param   anterior
     */
    public void setAnterior(NodoDbl anterior) {
        this.anterior = anterior;
    }

    /**
     * Obtien el campo Siguiente
     *
     * @return	Campo Siguiente
     */
    public NodoDbl getSiguiente() {
        return this.siguiente;
    }

    /**
     * Establece el campo Siguiente
     *
     * @param   siguiente
     */
    public void setSiguiente(NodoDbl siguiente) {
        this.siguiente = siguiente;
    }
}
