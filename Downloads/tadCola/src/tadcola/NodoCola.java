/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadcola;

/**
 *
 * @author HP
 */
public class NodoCola {
    // Constructores

	NodoCola (int elemento, NodoCola n)
	{ 
		dato = elemento; 
		siguiente = n; 
	}
	
  // Atributos accesibles desde otras rutinas del paquete
	int dato;
	NodoCola siguiente;
}
