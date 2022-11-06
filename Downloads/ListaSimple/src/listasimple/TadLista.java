/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimple;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class TadLista implements Lista {
    private NodoLista inicio;
	public TadLista () {
		inicio = null;
	}

	public void crearNodo () {
		/*Crea un nuevo nodo en el TadLista al principio de la lista*/
		inicio = new NodoLista (0, inicio);
	}	
	public int devolverClave () {
		/*Devuelve la clave contenida en el nodo del tadLista*/
		return inicio.clave;
	}	
	public NodoLista devolverSiguiente () {
		/*Devuelve una referencia al siguiente del TadLista*/
		return inicio.sig;
	}	
	public NodoLista devolverReferencia () {
			/*Devuelve una referencia al primer nodo del TadLista*/
			return inicio;
		}	
	public void asignarClave (int dato) {
		/*Asigna el dato al primer nodo del TadLista*/
		inicio.clave = dato;
	}	
	public void asignarReferencia (NodoLista referencia) {
		/*Hace que el inicio del TadLista apunte al mismo sitio que referencia*/
		inicio = referencia;
	}	
	public void asignarReferenciaSiguiente (NodoLista referenciaNueva) {
		/*Hace que el siguiente del nodo inicio apunte ahora al mismo sitio que referenciaNueva*/
		inicio.sig = referenciaNueva;
	}	
	public void asignarNulo () {
		/*Hace que el inicio del TadLista tome el valor null*/
		inicio = null;
	}	
	public boolean esNulo () {
		/*Devuelve true si el inicio del TadLista tiene valor null; false en caso contrario*/
		return inicio == null;
	}	
	public boolean esIgual (NodoLista referencia) {
		/*Devuelve true si referencia apunta al mismo sitio que el inicio del TadLista, false en caso contrario*/
		return inicio == referencia;
	}	
	public void cargarTadLista() throws NumberFormatException, IOException {
		int cantidad, i, x;
		NodoLista aux,ant = null;
		BufferedReader linea_entrada = new BufferedReader(new InputStreamReader(System.in));
			    
		inicio = null;
			        
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a insertar al final de la Lista:"));

		for (i = 0; i < cantidad; i++) {
		    x = Integer.parseInt(linea_entrada.readLine());
		    aux = new NodoLista (x, null);
			if (inicio == null) {
				inicio = aux;
			    ant = aux; 
			}   
			else {
				ant.sig = aux;
				ant = aux;
			}
		}
	}
 public void invertirLista() {

  NodoLista aux = inicio, temp = null;

  while (aux.sig != null) {

      temp = aux.sig;

      aux.sig = temp.sig;

      temp.sig = inicio;

      inicio = temp;

   }
 }
        public void cargarLista2() {
            NodoLista aux2,ant = null;
            int aux;
            char siga = 'S';
            //String cad2 = "B";
            while (siga == 'S' || siga == 's'){
                  aux = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a insertar al final de la Lista --escriba 0 para terminar--")); 
                    
                    
                    aux2 = new NodoLista (aux, null);
			if (inicio == null) {
				inicio = aux2;
			    ant = aux2; 
			}   
			else {
				ant.sig = aux2;
				ant = aux2;
			}
                        
                   siga = JOptionPane.showInputDialog(null,"Quiere seguir metiendo datos (S/N)?").charAt(0);;
                            }
        }
	public String toString () {
		NodoLista aux2 = null;
		String cad = "";
		aux2 = inicio;
		while (aux2 != null) {
			cad = cad + aux2.clave + "->";
			aux2 = aux2.sig;
		}
		cad = cad +"FIN";
                return cad;
	}
        static NodoLista insertarAlFinal (NodoLista nodoLista, int dato) {
	NodoLista resul = nodoLista;
	if (nodoLista != null)
			nodoLista.sig = insertarAlFinal (nodoLista.sig, dato);
			else {
				resul = new NodoLista (dato,null);
				//resul.sig = nodoLista; (Innecesario, ya es null)
			}
	return resul;
}

public void insertarAlFinal (TadLista l, int dato) {
	//¡ATENCION! No  se verifica la introduccion de claves repetidas.
	l.inicio = insertarAlFinal (l.inicio, dato);
}
public void  insertarDespues (TadLista l, int despues, int dato) {
    NodoLista temp = l.inicio;
    NodoLista aux;
    int encontrado = -1;
    while(temp != null & encontrado == -1){
        if(temp.clave == despues){
            aux = new NodoLista (dato, temp.sig);
            temp.sig = aux;
            encontrado = 1;
          }
        else{
            temp = temp.sig;
 }
 }
    if (encontrado == -1) System.out.println ("Error, no hay despues de donde insertar");
}

public void insertarAlPrincipio (TadLista lista, int dato) {
//¡ATENCION! No  se verifica la introducción de claves repetidas.
	NodoLista aux;
	aux = new NodoLista (dato,null);
	aux.sig = lista.inicio;
	lista.inicio = aux;
}
public void eliminarPrimero (TadLista lista) {
	if (lista.inicio != null) 		
			lista.inicio = lista.inicio.sig;
	else System.out.println ("Error, lista vacia");
}

public NodoLista buscar(int cod){
 NodoLista temp = inicio;
 int encontrado = -1;
 while(temp != null & encontrado == -1){
 if(temp.clave == cod){
 encontrado = 1;
 }else{
 temp = temp.sig;
 }
 }
 return temp;
 }
public void eliminar(NodoLista nd){
 NodoLista anterior;
 if(nd == inicio){ //Si el nodo a eliminar en la lista es el primero entonces.
 inicio= inicio.sig;
 }
 else{ //De lo contrario, se busca el nodo anterior al que se quiere eliminar (nd).
   anterior = inicio;
   while(anterior.sig != nd){
         anterior = anterior.sig;
   }
   anterior.sig = nd.sig;
 }
 nd.sig = null; 
}
static int buscarMaximaDistancia (NodoLista nodoLista, int n, int distancia, int maximaDistancia) {
		int resul;
		if (nodoLista != null) {
			if (distancia == 0) {
				if (nodoLista.clave == n)
					distancia=1;
			}
			else if (nodoLista.clave != n)
					distancia++;
				 else {
					if (distancia > maximaDistancia)
						maximaDistancia=distancia;
					distancia=1;
				 }
			resul = buscarMaximaDistancia(nodoLista.sig,n,distancia,maximaDistancia);
		}
		else resul = maximaDistancia;
		return resul;
	}
	public int buscarDistancia (TadLista lista, int n) {
		return buscarMaximaDistancia (lista.inicio, n, 0, 0);
	}

}
