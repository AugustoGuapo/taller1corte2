/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimple;

/**
 *
 * @author HP
 */
public class NodoLista {
    int clave;
	NodoLista sig;
	NodoLista (int x, NodoLista n) {
		clave = x;
		sig = n;
	}

}
