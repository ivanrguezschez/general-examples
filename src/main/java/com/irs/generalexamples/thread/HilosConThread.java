package com.irs.generalexamples.thread;

/**
 * Clase de hilos que emplean la clase Thread.
 *
 * @author IRS
 * @version 1.0.0, 22/08/2019
 */
public class HilosConThread {

    public static void main(String[] args) {
        // Creamos dos instancias de HiloContadorThread
        HiloContadorThread hilo1 = new HiloContadorThread("Hilo 1");
        HiloContadorThread hilo2 = new HiloContadorThread("Hilo 2");

        // Comienza la ejecucion de hilo1 llamando a start()
        // Esto crea un segundo hilo separado del actual
        hilo1.start();

        // Comienza la ejecucion de hilo2 llamando a start()
        // Esto crea un tercer hilo separado del actual
        hilo2.start();
    }
}

