package com.irs.generalexamples;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Locale;

/**
 * Clase que muestra las localidades disponibles.
 *
 * @author IRS
 * @version 1.0.0, 09/05/2007
 */
public final class LocalesAvailables {

    public static void main(String[] args) {
        Locale[] list = DateFormat.getAvailableLocales();
        for (Locale l : list) {
            System.out.printf("Language: %s, Country: %s, Display Country: %s\n", l.getLanguage(), l.getCountry(), l.getDisplayCountry());
        }
    }
}
