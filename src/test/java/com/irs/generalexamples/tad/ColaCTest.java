package com.irs.generalexamples.tad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de la clase tad.ColaC
 *
 *  @author IRS
 *  @version 1.0.0
 */
public class ColaCTest {

    @Test
    public void testInsertar() {
        Object[] obj = {"Uno","Dos","Tres"};

        ColaC cc1 = new ColaC();
        ColaC cc2 = new ColaC(obj);

        assertTrue(cc1.esVacia());
        assertFalse(cc2.esVacia());

        cc1.insertar("A");
        cc1.insertar("B");

        assertFalse(cc1.esVacia());

        assertEquals("A", (String) cc1.getPrimero().getSiguiente().getInformacion());

        assertEquals(obj[0], (String) cc2.getPrimero().getSiguiente().getInformacion());
    }
}
