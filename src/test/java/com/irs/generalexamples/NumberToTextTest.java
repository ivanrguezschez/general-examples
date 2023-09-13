package com.irs.generalexamples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitario de la clase NumberToText
 *
 *  @author IRS
 *  @version 1.0.0
 */
class NumberToTextTest {

    @Test
    public void testTransform() {
        assertEquals("un millon", NumberToText.transform(Integer.valueOf(1000000), false));
        assertEquals("un millon un", NumberToText.transform(Integer.valueOf(1000001), false));
        assertEquals("cero euros con cero centimos", NumberToText.transform(Double.valueOf(0), true) );
        assertEquals("un euro con cero centimos",NumberToText.transform(Double.valueOf(1), true));
        assertEquals("cero euros con veintiun centimos", NumberToText.transform(Double.valueOf(0.21), true));
        assertEquals("ciento veintitres mil cuatrocientos euros con noventa y nueve centimos", NumberToText.transform(Double.valueOf(123400.99), true));
        assertEquals("cuatrocientos euros", NumberToText.transform(Integer.valueOf(400), true));
        assertEquals("ciento veintitres mil cuatrocientos euros", NumberToText.transform(Integer.valueOf(123400), true));
        assertEquals("un euro con un centimo", NumberToText.transform(Double.valueOf(1.01), true));
        assertEquals("un euro con dos centimos", NumberToText.transform(Double.valueOf(1.02), true));
        assertEquals("un euro con doce centimos", NumberToText.transform(Double.valueOf(1.12), true));
        assertEquals("un euro con cero centimos", NumberToText.transform(Double.valueOf(1.00), true));
    }
}