package com.irs.generalexamples;

/**
 * Clase que muestra diversos metodos de ordenación y busqueda de un
 * array de enteros.
 *
 * @author IRS
 * @version 1.0.0, 08/05/2007
 */
public class SortArrayExamples {

    /** Numero de elementos del array. */
    public static final int NUM_ELEMENTOS = 10;

    /** Limite inferior para la generacion de los numeros del array. */
    public static final int LIMITE_INFERIOR = 1;

    /** Limite superior para la generacion de los numeros del array. */
    public static final int LIMITE_SUPERIROR = 100;

    /** Array a ordenar. */
    private static int[] v = new int[NUM_ELEMENTOS];

    /**
     * Metoto que inicializa el array a ordenar.
     */
    public static void init(){
        for (int i = 0; i < v.length; i++) {
            v[i] = (int)((LIMITE_SUPERIROR - LIMITE_INFERIOR + 1) * Math.random() + LIMITE_INFERIOR);
        }
    }

    /**
     * Metodo que muestra el array.
     */
    public static void show(){
        for (int i = 0; i < v.length; i++) {
            System.out.print("[" + v[i] + "]");
        }
        System.out.print("\n");
    }

    /**
     * Metodo que intercambia dos elementos del array.
     */
    public static void swap(int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    /**
     * Metodo de ordenación empleando el metodo de la burbuja.
     */
    public static void burbuja() {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - (i+1); j++) {
                if (v[j] > v[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * Metodo de ordenación empleando el metodo de seleccion.
     */
    public static void seleccion() {
        int pos_menor;
        int menor;
        for (int i = 0; i < v.length - 1; i++) {
            menor = v[i];
            pos_menor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < menor) {
                    menor = v[j];
                    pos_menor = j;
                }
            }
            v[pos_menor] = v[i];
            v[i] = menor;
        }
    }

    /**
     * Metodo de ordenación empleando el metodo de insercion.
     */
    public static void insercion(){
        int temp, j;
        for (int i = 1; i < v.length; i++) {
            temp = v[i];
            j = i - 1;
            while (j>=0 && v[j] > temp) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = temp;
        }
    }

    /**
     * Metodo de ordenación empleando el metodo de insercion binaria.
     */
    public static void insercionBinaria() {
        int temp, iz, de, medio;
        for (int i = 1; i < v.length; i++) {
            temp = v[i];
            iz = 0;
            de = i - 1;
            while (iz <= de) {
                medio = (iz+de)/2;
                if (temp < v[medio]) {
                    de = medio - 1;
                } else {
                    iz = medio + 1;
                }
            }
            for (int j = i-1; j < iz; j++) {
                v[j+1] = v[j];
            }
            v[iz] = temp;
        }
    }

    /**
     * Metodo de ordenación empleando el metodo QuickSort.
     */
    public static void quickSort(int inf, int sup) {
        int i = inf;
        int j = sup;
        int pivote = v[(inf+sup)/2];
        do {
            while (v[i] < pivote) i++;
            while (v[j] > pivote) j--;
            if (i <= j) {
                swap(i,j);
                i++;
                j--;
            }
        } while(i < j);
        if (j > inf) quickSort(inf,j);
        if (i < sup) quickSort(i,sup);
    }

    /**
     * Metodo de busqueda secuencial.
     */
    public static int busquedaSecuencial(int[] v, int elem_bus) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == elem_bus) return i;
        }

        return -1; //No encontrado
    }

    /**
     * Metodo de busqueda binaria. El array debe estar ordenado.
     */
    public static int busquedaBinaria(int[] v, int elem_bus) {
        int inf = 0;
        int sup = v.length;
        int mitad;
        do {
            mitad = (inf+sup)/2;
            if (v[mitad] > elem_bus) {
                sup = mitad - 1;
            } else {
                inf = mitad + 1;
            }
        } while(inf <= sup && v[mitad] != elem_bus);
        if (v[mitad] == elem_bus) return mitad;
        return -1;
    }


    public static void main(String[] args) {
        long start = 0L;
        long stop = 0L;

        System.out.println("BURBUJA **************************************");
        init();
        show();
        start = System.currentTimeMillis();
        burbuja();
        stop = System.currentTimeMillis();
        System.out.println("TIEMPO:" + (stop - start));
        show();
        System.out.println("##############################################");

        System.out.println("SELECCION ************************************");
        init();
        show();
        start = System.currentTimeMillis();
        seleccion();
        stop = System.currentTimeMillis();
        System.out.println("TIEMPO:" + (stop - start));
        show();
        System.out.println("##############################################");

        System.out.println("INSERCION ************************************");
        init();
        show();
        start = System.currentTimeMillis();
        insercion();
        stop = System.currentTimeMillis();
        System.out.println("TIEMPO:" + (stop - start));
        show();
        System.out.println("##############################################");

        System.out.println("INSERCION BINARIA ****************************");
        init();
        show();
        start = System.currentTimeMillis();
        insercionBinaria();
        stop = System.currentTimeMillis();
        System.out.println("TIEMPO:" + (stop - start));
        show();
        System.out.println("##############################################");

        System.out.println("QUICK SORT ***********************************");
        init();
        show();
        start = System.currentTimeMillis();
        quickSort(0, v.length - 1);
        stop = System.currentTimeMillis();
        System.out.println("TIEMPO:" + (stop - start));
        show();
        System.out.println("##############################################");

        System.out.println("BUSQUEDA SECUENCIAL **************************");
        System.out.println("Encontrado:" + busquedaSecuencial(v, 10));
        System.out.println("##############################################");

        System.out.println("BUSQUEDA BINARIA *****************************");
        System.out.println("Encontrado:" + busquedaBinaria(v, 10));
        System.out.println("##############################################");
    }
}
