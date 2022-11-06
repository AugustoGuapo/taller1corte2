/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadcola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class TadCola implements Cola {

    private NodoCola principio;
	private NodoCola fin;
	
	public TadCola () {
		principio = null;
		fin = null;
	}

	public boolean colaVacia () {
		return principio==null;	
	}
	public void eliminarCola () {
		principio = null;
		fin = null;
	}
	public int primero () throws ColaVacia {
    	if (colaVacia ())
    		throw new ColaVacia ("La cola está vacía");
    	return principio.dato;
	}
	public void encolar (int x) {
        NodoCola aux;
        aux = new NodoCola(x,null);
        if (principio == null) {
        	principio = aux;
        	fin = aux;
        }
        else {
        	fin.siguiente = aux;
        	fin = aux;
        }
	}
	public int desencolar () throws ColaVacia {
        int resultado;
        if (colaVacia ()) {  
          throw new ColaVacia ("Desencolar: La cola está vacía");
        }
        resultado = principio.dato;
        principio = principio.siguiente;
        if (principio == null)
        	fin = null;
        return resultado;
		
	}
	public void quitarPrimero () throws ColaVacia {
	    if (colaVacia ()) {  
	    	throw new ColaVacia ("Quitar primero: La cola está vacía");
	    }
	    principio = principio.siguiente;
	    if (principio == null)
	    	fin = null;
	}
	public void mostrarEstadoCola () {
		System.out.println("Estado de la cola:");
        System.out.println("Referencia al nodo (cola): "+principio+ "; Clave: "+principio.dato+"; Referencia al siguiente: "+principio.siguiente);
    }
	public void imprimirCola () {
        NodoCola aux;
        System.out.print ("Estado de la cola: ");
        aux = principio;
        while (aux != null) {
          System.out.print (aux.dato + " ");
          aux = aux.siguiente;
        }
        System.out.println ();
      }
	public void leerCola () throws NumberFormatException, IOException {
    	int cantidad, i, x;
        BufferedReader linea_entrada = new BufferedReader(new InputStreamReader(System.in));
    
        System.out.println ("Numero de elementos de la cola: ");
        cantidad = Integer.parseInt(linea_entrada.readLine());
        for (i = 0; i < cantidad; i++) {
           x = Integer.parseInt(linea_entrada.readLine());;
           encolar (x);
         }
    }
	public int numElemCola () {
        NodoCola aux;	
        int resul;
        
          aux = principio;
          resul = 0;
          while (aux != null) {
        	++resul;
        	aux = aux.siguiente;
          }
          return resul;
        }
	public void invertirCola () throws ColaVacia {
		int elem;
		if (!colaVacia()) {
			elem = desencolar();	
			invertirCola();
			encolar(elem);
		}
	}
        public void cargarCola() {
            NodoCola aux2,ant = null;
           
            int aux;
            char siga = 'S';
            //String cad2 = "B";
            while (siga == 'S' || siga == 's'){
                  aux = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a encolar --escriba 0 para terminar--")); 
                    
                    
                    aux2 = new NodoCola (aux, null);
			if (principio == null) {
				principio = aux2;
			    fin = aux2; 
			}   
			else {
				fin.siguiente = aux2;
				fin = aux2;
			}
                        
                   siga = JOptionPane.showInputDialog(null,"Quiere seguir encolando datos (S/N)?").charAt(0);;
                            }
        }
public String toString () {
		NodoCola aux2 = null;
		String cad = "";
		aux2 = principio;
		while (aux2 != null) {
			cad = cad + aux2.dato + "<-";
			aux2 = aux2.siguiente;
		}
		cad = cad +"FIN";
                return cad;
	}
}

