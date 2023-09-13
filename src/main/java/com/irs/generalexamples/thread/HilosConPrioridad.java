package com.irs.generalexamples.thread;

/**
 * Clase de hilos que emplean la clase Thread y prioridad.
 *
 * @author IRS
 * @version 1.0.0, 22/08/2019
 */
public class HilosConPrioridad {

    public static void main(String[] args) {
        // Creamos dos instancias de HiloContadorThread
        HiloContadorThread hilo1 = new HiloContadorThread("Hilo 1");
        HiloContadorThread hilo2 = new HiloContadorThread("Hilo 2");
        HiloContadorThread hilo3 = new HiloContadorThread("Hilo 3");
        HiloContadorThread hilo4 = new HiloContadorThread("Hilo 4");
        HiloContadorThread hilo5 = new HiloContadorThread("Hilo 5");

        // Establecemos la prioridad de cada hilo
        // El planificador tiene mas en cuenta a los hilos con mayor prioridad
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.MAX_PRIORITY / 2);
        hilo3.setPriority(Thread.MAX_PRIORITY);
        hilo4.setPriority(Thread.MIN_PRIORITY);
        hilo5.setPriority(Thread.NORM_PRIORITY);

        // Comienza la ejecucion de hilo1 llamando a start()
        // Esto crea un segundo hilo separado del actual
        hilo1.start();

        // Comienza la ejecucion de hilo2 llamando a start()
        // Esto crea un tercer hilo separado del actual
        hilo2.start();

        // Comienza la ejecucion de hilo3 llamando a start()
        // Esto crea un cuarto hilo separado del actual
        hilo3.start();

        // Comienza la ejecucion de hilo4 llamando a start()
        // Esto crea un quinto hilo separado del actual
        hilo4.start();

        // Comienza la ejecucion de hilo5 llamando a start()
        // Esto crea un sexto hilo separado del actual
        hilo5.start();
    }
}