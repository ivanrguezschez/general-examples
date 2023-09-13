package com.irs.generalexamples.tad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de la clase tad.Cola
 *
 *  @author IRS
 *  @version 1.0.0
 */
public class ColaTest {

    @Test
    public void testInsertar() {
        Object[] obj = {"Uno","Dos","Tres"};

        Cola c1 = new Cola();
        Cola c2 = new Cola(obj);

        assertTrue(c1.esVacia());
        assertFalse(c2.esVacia());

        c1.insertar("A");
        c1.insertar("B");

        assertFalse(c1.esVacia());

        assertEquals("A", (String) c1.getPrimero().getInformacion());
        assertEquals("B", (String) c1.getUltimo().getInformacion());

        assertEquals(obj[0], (String) c2.getPrimero().getInformacion());
        assertEquals(obj[2], (String) c2.getUltimo().getInformacion());
    }
}
