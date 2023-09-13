package com.irs.generalexamples.task;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de ejemplo de tareas (Task) planificadas empleando la api de Java.
 *
 * @author IRS
 * @version 1.0.0, 22/08/2019
 */
public class TimerTaskExample {

    public static void main(String[] args) {
        Timer server = new Timer();

        // Creo una tarea para correr un escaneo de disco completo;
        TimerTask scaneoCompleto = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.print("Ejecutando Scaneo de Disco");
                    Runtime.getRuntime().exec("chkdsk /F /R");
                } catch (IOException ex) {
                    Logger.getLogger(TimerTaskExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        // Creo una tarea para correr un escaneo de disco parcial;
        TimerTask scaneoParcial = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.print("Ejecutando Scaneo de Disco");
                    Runtime.getRuntime().exec("chkdsk /I");
                } catch (IOException ex) {
                    Logger.getLogger(TimerTaskExample.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        // Una semana en milisegundos
        long semanal = 1000 * 60 * 60 * 24 * 7;

        // Una hora en milisegundos
        long hora = 1000 * 60 * 60;

        // Ejecuta el scaneo parcial de disco en el momento y vuelve a ejecutar la tarea cada semana.
        server.schedule(scaneoParcial, 0, semanal);

        // Ejecuta el scaneo completo de disco en una hora y vuelve a ejecutar la tarea cada semana.
        server.schedule(scaneoCompleto, hora, semanal);
    }
}
