package com.irs.generalexamples.zip;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Clase que descomprime un archivo zip en un directorio con el mismo nombre que el archivo zip.
 * Recibe el nombre del archivo zip por linea de comandos.
 * Uso: java DescomprimirZip &lt;zip_file&gt;
 *
 * @author IRS
 * @version 1.0.0, 18/06/2007
 */
public class DescomprimirZip {

    public static void main(String[] args) {
        if (args.length == 0) {
            uso();
        }

        try {
            String fileName = args[0].substring(args[0].lastIndexOf("/") + 1, args[0].lastIndexOf(".zip"));

            File file = new File(args[0]);
            ZipFile zipFile = new ZipFile(file);

            // Creamos un directorio con el mismo nombre que el archivo .zip en
            // el mismo directorio que el archivo .zip
            File zipDir = new File(file.getParentFile(), fileName);
            zipDir.mkdir();

            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();

                String name = entry.getName();
                System.out.println("Descomprimiendo " + name);
                File entryDestination = new File(zipDir, name);

                // Dentro del archivo .zip pueden venir subcarpetas
                // Esta sentencia se asegura que las carpetas padre son creadas
                entryDestination.getParentFile().mkdirs();

                // Los directorios son incluidos como entradas separadas en
                // el archivo .zip
                if (!entry.isDirectory()) {
                    generateFile(entryDestination, entry, zipFile);
                }
            }
            System.out.println("Descompresion finalizada.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void generateFile(File destination, ZipEntry entry, ZipFile owner) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            InputStream rawIn = owner.getInputStream(entry);
            in = new BufferedInputStream(rawIn);

            FileOutputStream rawOut = new FileOutputStream(destination);
            out = new BufferedOutputStream(rawOut);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public static void uso() {
        System.out.println("uso: java DescomprimirZip zip_file");
        System.exit(0);
    }
}
