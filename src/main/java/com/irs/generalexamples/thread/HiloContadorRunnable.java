package com.irs.generalexamples.thread;

/**
 * Clase que implementa Runnable. Ejecutará una tarea en un hilo separado.
 *
 * @author IRS
 * @version 1.0.0, 22/08/2019
 */
public class HiloContadorRunnable implements Runnable {

    // Variable para identificar al hilo
    private String nombre;

    public HiloContadorRunnable(String nombre) {
        this.nombre = nombre;
    }

    // Implementamos el metodo run que ejecuta la tarea del hilo
    @Override
    public void run() {
        // Imprimimos los numeros del 1 al 100
        for (int i = 1; i <= 100; i++) {
            System.out.println(nombre + ": " + i);
        }
    }
}
