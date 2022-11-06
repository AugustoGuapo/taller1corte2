/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadcola;
import java.util.Random;
/**
 *
 * @author HP
 */
public class Operador {
    public static final Random RANDOM = new Random();

    private int minTiempoAtencion, maxTiempoAtencion, TiempoFin;

    /**
     * Construye un nuevo Operario con un rango de atencion en segundos
     * @param minTiempoAtencion en segundos
     * @param maxTiempoAtencion en segundos
     */
    public Operador(int minTiempoAtencion, int maxTiempoAtencion) {
        this.minTiempoAtencion = minTiempoAtencion;
        this.maxTiempoAtencion = maxTiempoAtencion;
        TiempoFin= 0;
    }

    /**
     * Registra en tiempo final con un tiempo aleatorio en el rango.
     * @param currentTime el tiempo actual en segundos
     */
    public void atiendeClienteNuevo(int currentTime) {
        TiempoFin = currentTime + numeroAleatorioEnRango(minTiempoAtencion, maxTiempoAtencion);
    }

    /**
     * Devuelve si el operario esta libre
     * @param currentTime el tiempo actual en segundos
     * @devuelve verdadero si el operario esta libre, falso de otro modo
     * **/
    public boolean estaLibre(int currentTime) {
        return currentTime >= TiempoFin;
    }

    /**
     * Devuelve un aleatorio en el rango [min, max]
     * @param min el minimo numero inclusive
     * @param max el maximo numero inclusive
     */
    private int numeroAleatorioEnRango(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public String toString() {
        return String.valueOf(TiempoFin);
    }
}
