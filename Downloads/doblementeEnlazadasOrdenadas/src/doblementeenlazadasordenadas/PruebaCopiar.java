/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doblementeenlazadasordenadas;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PruebaCopiar {
    static ListaDoble copiarLista (ListaDoble origen) {
			NodoLista aux;
			ListaDoble resul = new ListaDoble ("copia");
			
			aux = origen.inicio;
			while (aux != null) {
		 	  resul.insertar(aux.clave);
		 	  aux = aux.sig;
			}  
			return resul;
		}
		static void escribirLista (ListaDoble lista) {
			NodoLista aux;
			
			aux = lista.inicio;
			System.out.print(lista.nombre+" ");
			while (aux != null) {
					System.out.print(aux.clave+" ");
					aux = aux.sig;
			}
			System.out.println (" FIN");
		}
		public static void main(String[] args) {
			ListaDoble lista1 = new ListaDoble ("lista1");
			ListaDoble lista2 = new ListaDoble ("lista2");
			lista1.insertar (1);
			lista1.insertar (5);
			lista1.insertar (4);
			lista1.eliminar(4);
			lista1.insertar (4);
			lista1.insertar (7);
			lista1.insertar (6);
			System.out.println ("probemos el método escribirLista:");
			escribirLista(lista1);
			lista1.insertar (9);
			lista1.eliminar (7);
                        JOptionPane.showMessageDialog(null, "probemos el método copiarLista:");
			
			ListaDoble copia= copiarLista (lista1);
			JOptionPane.showMessageDialog(null, copia.toString());
                        JOptionPane.showMessageDialog(null, "Copia de lista1 después de insertar 7: ");
                        
                        copia.insertar(7);
			JOptionPane.showMessageDialog(null, copia.toString());
                        JOptionPane.showMessageDialog(null, "probemos el método invertirListaDoble:");
                        
                        lista1.invertirListaDoble();
                        JOptionPane.showMessageDialog(null, lista1.toString());
                        lista2.cargarLista2();
                        JOptionPane.showMessageDialog(null, lista2.toString());
                       
		}
	}


