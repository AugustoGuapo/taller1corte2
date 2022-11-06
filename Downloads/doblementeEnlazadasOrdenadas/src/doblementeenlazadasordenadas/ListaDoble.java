package doblementeenlazadasordenadas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

class NodoLista {
	public int clave;
	public NodoLista sig, ant;
	public NodoLista (int x)	{
		clave = x;
		sig = null;
		ant = null;
	}
}

public class ListaDoble {
    public NodoLista inicio;
	public String nombre;
	public ListaDoble (String nombreLista) {
		inicio = null;
		nombre = nombreLista;
	}
	static boolean busqueda (NodoLista nodoLista, int x) {
		boolean resul = false;
		if (nodoLista != null)
			if (nodoLista.clave == x)
				resul = true;
			else if (nodoLista.clave < x)
					 resul = busqueda (nodoLista.sig, x);
		return resul;
	}
	public boolean busqueda (int x) {
		return busqueda (inicio, x);
	 }
	public void insertar (int clave) {
		NodoLista anterior, actual, nuevo;
		boolean encontrado = false;
	 
		anterior = inicio;
		actual = inicio;
		while ((actual != null) && !encontrado)
			if (actual.clave < clave) {
				anterior = actual;
				actual = actual.sig;
			 }
			else encontrado = true;
		if (actual == null) {
			nuevo = new NodoLista (clave);
			if (inicio == null) 
				inicio = nuevo;
			else {
				nuevo.ant = anterior;
				anterior.sig = nuevo;
			}
		}
		else if (actual.clave > clave) {
					nuevo = new NodoLista (clave);
					nuevo.sig = actual;
					nuevo.ant = actual.ant;
					actual.ant = nuevo;
					if (inicio != actual)
						anterior.sig = nuevo;
					else inicio  = nuevo;
				 }
		else System.out.println ("error, la clave ya existe");
	}
	public void eliminar (int clave) {
		NodoLista anterior, actual;
		boolean encontrado = false;
	 
		anterior= inicio;
		actual= inicio;
		while ((actual != null) && !encontrado)
			if (actual.clave < clave) {
				anterior = actual;
				actual = actual.sig;
			 }
			else encontrado = true;
		if (actual == null) 
			System.out.println ("Error, el elemento no existe");
		else if (actual.clave > clave) 
					System.out.println ("Error, el elemento no existe");
		else if (inicio == actual) {
				inicio = inicio.sig;
				inicio.ant = null;
			}
			else {
				anterior.sig = actual.sig;
				actual.sig.ant = anterior;
			}
	}
	public void cargarLista () throws NumberFormatException, IOException {
		int cantidad, i, x;
		BufferedReader lineaEntrada = new BufferedReader(new InputStreamReader(System.in));
		    
		inicio = null;
		        
		System.out.println ("Numero de elementos de la lista: ");
		cantidad = Integer.parseInt(lineaEntrada.readLine());
		for (i = 0; i < cantidad; i++) {
		    x = Integer.parseInt(lineaEntrada.readLine());
		    insertar (x);
		}
	}
        public void cargarLista2() {
            NodoLista aux2,ant = null;
            int aux;
            char siga = 'S';
            //String cad2 = "B";
            while (siga == 'S' || siga == 's'){
                  aux = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a insertar en la Lista")); 
                    
                    
                    aux2 = new NodoLista (aux);
		   insertar (aux);
                        
                   siga = JOptionPane.showInputDialog(null,"Quiere seguir metiendo datos (S/N)?").charAt(0);;
                            }
        }
	public void imprimirLista () {
		NodoLista aux;
		
		aux = inicio;
		System.out.print (nombre+": ");
		while (aux != null) {
			System.out.print (aux.clave + " ");
			aux = aux.sig;
		}
		System.out.println ("FIN");
	}
        public void invertirListaDoble() 
       {
 
       NodoLista aux = inicio; 
       NodoLista temp = null;

       while(aux!=null)
        { 
          temp=aux.ant; 
          aux.ant=aux.sig; 
          aux.sig=temp; 
          aux=aux.ant;
        }
        if (temp !=null)
        inicio = temp.ant;
       }
    public String toString () {
		NodoLista aux2 = null;
		String cad = "";
		aux2 = inicio;
		while (aux2 != null) {
			cad = cad + aux2.clave + "<->";
			aux2 = aux2.sig;
		}
		cad = cad +"FIN";
                return cad;
	}
}
