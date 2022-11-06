/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimple;
import java.io.IOException;

/**
 *
 * @author HP
 */
public interface Lista {
    

    void crearNodo ();
	  /*Crea un nuevo nodo en el tadLista*/
	int devolverClave ();
	  /*Devuelve la clave contenida en el nodo del tadLista*/
	NodoLista devolverSiguiente ();
	  /*Devuelve una referencia al siguiente del tadLista*/
        
	void asignarClave (int dato);
	  /*Asigna el dato al primer nodo del TadLista*/
	void asignarReferencia (NodoLista referencia);
	  /*Hace que el primer nodo del TadLista apunte al mismo sitio que referencia*/
	void asignarReferenciaSiguiente (NodoLista referenciaNueva);
	  /*Hace que el siguiente del nodo actual apunte ahora al mismo sitio que referenciaNueva*/
	void asignarNulo ();
	  /*Hace que el tadLista tome el valor null*/
	boolean esNulo ();
	  /*Devuelve true si el inicio del TadLista tiene valor null; false en caso contrario*/
	boolean esIgual (NodoLista referencia);
	  /*Devuelve true si referencia apunta al mismo sitio que el tadLista, false en caso contrario*/
	//String imprimirLista ();
	void cargarTadLista() throws NumberFormatException, IOException;
        void cargarLista2();
        void invertirLista();
        void insertarDespues (TadLista l, int despues, int dato);
        void insertarAlFinal (TadLista l, int dato);
        void insertarAlPrincipio (TadLista lista, int dato);
        void eliminarPrimero (TadLista lista);
        NodoLista buscar(int cod);
        void eliminar(NodoLista nd);
}
