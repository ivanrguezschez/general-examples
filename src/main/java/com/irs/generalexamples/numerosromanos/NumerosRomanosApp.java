package com.irs.generalexamples.numerosromanos;

/**
 * Clase main para usar la clase NumerosRomanos
 *
 * @author IRS
 * @version 1.0.0
 */
public class NumerosRomanosApp {

    public static void main(String[] args) {
        try {
            NumerosRomanos nr = new NumerosRomanos();

            long start = System.currentTimeMillis();

            // De 1 a 3999
            for (int i = 1; i <= 3999; i++) {
                System.out.format("%1$d=%2$s\n", i, nr.convetir(i));
            }
            long end = System.currentTimeMillis();
            System.out.format("Tiempo: %1$d", (end - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}