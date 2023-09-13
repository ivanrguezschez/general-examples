package com.irs.generalexamples;

import java.io.*;

/**
 * Clase que muestra el rendimiento de copiar un archivo en otro mediante buffer y sin buffer.
 *
 * @author IRS
 * @version 1.0.0
 */
public class RendimientoCopyFile {

    public static void copy(String from, String to) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(from);
            out = new FileOutputStream(to);
            while (true) {
                int data = in.read();
                if (data == -1) {
                    break;
                }
                out.write(data);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void copyBuffer(String from, String to) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            InputStream inFile = new FileInputStream(from);
            in = new BufferedInputStream(inFile);
            OutputStream outFile = new FileOutputStream(to);
            out = new BufferedOutputStream(outFile);
            while (true) {
                int data = in.read();
                if (data == -1) {
                    break;
                }
                out.write(data);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void main(String args[]) {
        long start = 0;
        long end = 0;

        String from = "./target/classes/ficheros.zip";
        String to = "./target/classes/ficheros2.zip";
        try {
            start = System.currentTimeMillis();
            copy(from, to);
            end = System.currentTimeMillis();
            System.out.println("copy = " + (end - start));

            start = System.currentTimeMillis();
            copyBuffer(from, to);
            end = System.currentTimeMillis();
            System.out.println("copyBuffer = " + (end - start));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
