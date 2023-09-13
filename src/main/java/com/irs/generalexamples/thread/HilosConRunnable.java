package com.irs.generalexamples.thread;

/**
 * Clase de hilos que emplean la interfaz Runnable.
 *
 * @author IRS
 * @version 1.0.0, 22/08/2019
 */
public class HilosConRunnable {

    public static void main(String[] args) {
        // Creamos dos instancias de HiloContadorRunnable
        HiloContadorRunnable hilo1 = new HiloContadorRunnable("Hilo 1");
        HiloContadorRunnable hilo2 = new HiloContadorRunnable("Hilo 2");

        // Creamos los Threads
        Thread thread1 = new Thread(hilo1);
        Thread thread2 = new Thread(hilo2);

        // Comienza la ejecucion de thread1 llamando a start()
        // Esto crea un segundo hilo separado del actual
        thread1.start();

        // Comienza la ejecucion de thread2 llamando a start()
        // Esto crea un tercer hilo separado del actual
        thread2.start();
    }
}
