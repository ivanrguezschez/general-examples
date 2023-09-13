package com.irs.generalexamples;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

import static java.lang.System.out;

/**
 * Clase que muestra información del juego de caracteres (Charset).
 *
 * @author IRS
 * @version 1.0.0, 22/08/2019
 */
public class CharsetDemo {

    public static void main(String[] args) {
        out.println("Default Locale:   " + Locale.getDefault());
        out.println("Default Charset:   " + Charset.defaultCharset());
        out.println("file.encoding:   " + System.getProperty("file.encoding"));
        out.println("sun.jnu.encoding:   " + System.getProperty("sun.jnu.encoding"));
        out.println("Default Encoding:   " + getEncoding());
    }

    public static String getEncoding() {
        final byte[] bytes = { 'D' };
        final InputStream inputStream = new ByteArrayInputStream(bytes);
        final InputStreamReader reader = new InputStreamReader(inputStream);
        final String encoding = reader.getEncoding();
        return encoding;
    }
}
