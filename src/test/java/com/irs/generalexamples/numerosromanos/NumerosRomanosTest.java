package com.irs.generalexamples.numerosromanos;

import com.irs.generalexamples.NumberToText;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de la clase NumerosRomanos
 *
 *  @author IRS
 *  @version 1.0.0
 */
class NumerosRomanosTest {

    @Test
    public void testConvertir() throws Exception {
        NumerosRomanos nr = new NumerosRomanos();

        assertThrows(Exception.class, () -> nr.convetir(4000));
        assertEquals("I", nr.convetir(1));
        assertEquals("MMMCMXXXV", nr.convetir(3935));
        assertEquals("MMMCMXCIX", nr.convetir(3999));
    }
}