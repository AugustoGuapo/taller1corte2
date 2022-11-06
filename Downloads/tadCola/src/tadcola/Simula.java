/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadcola;

import java.util.*;
/**
 *
 * @author HP
 */
public class Simula {
    private static final int TIEMPO_TOTAL = 7*3600; // Horas a segundos
    private static final int TIEMPO_ENTRE_CLIENTES = 60; // En segundos
    private static final int OPERADORES = 3;
    //private static int TAM_MAX_COLA = 0;
public static void main(String[] args) throws ColaVacia {

    // Crea operarios y  asigna rangos de atencion a cada operario, en segundos
    // Este ejemplo es para operarios con  3, 3~6 y 4.5~15 minutos
    List<Operador> operadores = new ArrayList<Operador>(OPERADORES);
    operadores.add(new Operador(90, 150));
    operadores.add(new Operador(120, 300));
    operadores.add(new Operador(120, 240));

    int tiempo = 0; // Conteo en segundos
    int tiempoEspera = 0; // Guarda aqui el tiempo de espera para todos los clientes
    int clientes = 0; // Guarda aqui todos los clientes
    int TAM_MAX_COLA = 0;

    // Regitra todos los operarios libres
    ArrayList<Operador> operadoresLibres;

   TadCola estudiantes = new TadCola (); // cola de estudiantes

    // Itera hasta que cierra el proceso y todos los clientes se han atendido
    while (tiempo < TIEMPO_TOTAL || !estudiantes.colaVacia()) {
        // Nuevo cliente por atender
        if (tiempo < TIEMPO_TOTAL && tiempo%TIEMPO_ENTRE_CLIENTES == 0) {
            estudiantes.encolar(tiempo); // Registra inicio del tiempo de espera
            clientes++;
        }
        
        // Revisa por operarios libres cuando alguien este en cola
        if (!estudiantes.colaVacia()) {
             if (TAM_MAX_COLA < estudiantes.numElemCola()) TAM_MAX_COLA = estudiantes.numElemCola();
            operadoresLibres = new ArrayList<Operador>(OPERADORES);
            for (Operador c : operadores) {
                if (c.estaLibre(tiempo))
                    operadoresLibres.add(c);
            }

            if (!operadoresLibres.isEmpty()) {
                // Registra el tiempo gastado para atender un cliente
               
                tiempoEspera += tiempo - estudiantes.desencolar();

                // Elige aleatoriamente un operario que este libre
                Operador eligeOperadorAleatorio = operadoresLibres.get(Operador.RANDOM.nextInt(operadoresLibres.size()));

                // Guarda cuando el operario elegido aleat este libre de nuevo
                eligeOperadorAleatorio.atiendeClienteNuevo(tiempo);
            }
        }
        
        tiempo++; // Avanza un segundo
    }

    // Calculo de estadisticas
    int promEspera = tiempoEspera/clientes; // En segundos

    System.out.println("Tiempo espera promedio: " + formatoTiempo(promEspera));
    System.out.println("Total estudiantes atendidos: " + clientes);
    System.out.println("TamaÑo Maximo de la Cola: " + TAM_MAX_COLA);
}

private static String formatoTiempo(int tiemp) {
    StringBuilder resultado = new StringBuilder();
    if (tiemp > 60) {
        resultado.append(tiemp/60).append(" minutos");
        tiemp %= 60;
        if (tiemp > 0)
            resultado.append(" y ");
        else
            resultado.append(".");
    }
    if (tiemp > 0)
        resultado.append(tiemp).append(" segundos.");
    return resultado.toString();
}
}
