package com.irs.generalexamples.tad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de la clase tad.Pila
 *
 *  @author IRS
 *  @version 1.0.0
 */
class PilaTest {

    @Test
    public void testInsertar() {
        Object[] obj = {"Uno","Dos","Tres"};

        Pila p1 = new Pila();
        Pila p2 = new Pila(obj);

        assertTrue(p1.esVacia());
        assertFalse(p2.esVacia());

        p1.insertar("A");
        p1.insertar("B");

        assertFalse(p1.esVacia());

        assertEquals("B", (String) p1.getCima().getInformacion());
        assertEquals("A", (String) p1.getCima().getSiguiente().getInformacion());

        assertEquals(obj[2], (String) p2.getCima().getInformacion());
        assertEquals(obj[1], (String) p2.getCima().getSiguiente().getInformacion());
    }
}