package com.irs.generalexamples.comparator;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Clase que obtiene el listado de ficheros de un directorio y los ordena
 * usando para ello el criterio de la fecha de modificacion haciendo uso
 * de la interface java.util.Comparator y del tipo de coleccion TreeSet.
 *
 * @author IRS
 * @version 1.0.0, 09/02/2003
 */
public class FileSortList {

    static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static final Comparator FILE_DATE_COMPARATOR = new Comparator() {
        public int compare(Object o1, Object o2) {
            if (o1 == null || o2 == null) {
                return 0;
            }
            File f1 = (File) o1;
            File f2 = (File) o2;

            if (f1.lastModified() == f2.lastModified()) {
                return 0;
            } else if (f1.lastModified() > f2.lastModified()) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    static final Comparator FILE_NAME_COMPARATOR = new Comparator() {
        public int compare(Object o1, Object o2) {
            if (o1 == null || o2 == null) {
                return 0;
            }
            File f1 = (File) o1;
            File f2 = (File) o2;

            return f1.getAbsolutePath().compareTo(f2.getAbsolutePath());
        }
    };

    public static void main(String[] args) {
        // Por defecto utiliza el directorio actual
        String showFolder = ".";
        if (args.length > 0) {
            showFolder = args[0];
        }

        File folder = new File(showFolder);
        if (folder == null || !folder.isDirectory()) {
            System.err.println(showFolder + " no existe o no es un directorio.");
            System.exit(1);
        }
        String[] folderList = folder.list();

        TreeSet sortedFolders = new TreeSet(FILE_DATE_COMPARATOR);
        for (int i = 0; folderList != null && i < folderList.length; i++) {
            sortedFolders.add(new File(showFolder, folderList[i]));
        }
        System.out.println("Listado de archivos de la carpeta " + showFolder
                + " ordenados por la fecha de última modificación.");
        printFolders(sortedFolders);

        sortedFolders = new TreeSet(FILE_NAME_COMPARATOR);
        for (int i = 0; folderList != null && i < folderList.length; i++) {
            sortedFolders.add(new File(showFolder, folderList[i]));
        }
        System.out.println("Listado de archivos de la carpeta " + showFolder
                + " ordenados por nombre de archivo.");
        printFolders(sortedFolders);
    }


    private static void printFolders(TreeSet folders) {
        for (Iterator it = folders.iterator(); it.hasNext(); ) {
            File file = (File) it.next();
            System.out.println(DATE_FORMAT.format(new Date(file.lastModified())) +
                    " " + file.getName());
        }
    }
}
