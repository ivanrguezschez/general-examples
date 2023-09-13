package com.irs.generalexamples.zip;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Clase que lee un archivo zip mostrando su información.
 * Recibe el nombre del archivo zip por linea de comandos.
 * Uso: java LeerZip &lt;zip_file&gt;
 *
 * @author IRS
 * @version 1.0.0, 18/06/2007
 */
public class LeerZip {

    public static void main(String[] args) {
        if (args.length == 0) {
            uso();
        }

        try {
            File file = new File(args[0]);
            ZipFile zipFile = new ZipFile(file);

            System.out.println("Contenido del archivo .zip " + zipFile.getName());

            double porcentaje = 0d;
            DecimalFormat df = new DecimalFormat();

            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();

                // Muestro los datos de la entrada
                System.out.println("\tArchivo: " + entry.getName());
                System.out.println("\t\tTamaño: " + entry.getSize());
                System.out.println("\t\tTamaño Comprimido: " + entry.getCompressedSize());
                porcentaje = 100.0 - (100D * entry.getCompressedSize() / entry.getSize());
                System.out.println("\t\tComprension: " + df.format(porcentaje) + "%");
                System.out.println("\t\tComentario: " + entry.getComment());
                System.out.println("\t\tCRC: " + entry.getCrc());
            }
            zipFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void uso() {
        System.out.println("uso: java LeerZip zip_file");
        System.exit(0);
    }
}
