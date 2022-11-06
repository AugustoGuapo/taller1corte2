/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasimple;
import java.io.IOException;
import javax.swing.JOptionPane;
import static listasimple.TadLista.buscarMaximaDistancia;
/**
 *
 * @author HP
 */
public class PruebaTadLista {
    static int contar (TadLista lista) {
		TadLista aux = new TadLista ();
		int resul;

		if (!lista.esNulo ()) { 
			aux.asignarReferencia (lista.devolverSiguiente ());
			resul = 1 + contar (aux);
		}
		else resul = 0;
		return resul;
                
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		TadLista lista = new TadLista ();
                NodoLista aux2, ant, nd3;
		int aux, inserta, despues, buscar, distancia;
                 
                lista.cargarLista2();
                 
		JOptionPane.showMessageDialog(null, lista.toString());
		aux = contar (lista);
		JOptionPane.showMessageDialog(null, "El numero de elementos en la lista es: " +aux);
                inserta = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a insertar al final de la Lista:"));
                lista.insertarAlFinal(lista, inserta);
		JOptionPane.showMessageDialog(null, lista.toString());
                inserta = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a insertar al principio de la Lista:"));
                lista.insertarAlPrincipio(lista, inserta);
                JOptionPane.showMessageDialog(null, lista.toString());
                despues = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero despues del que va a insertar:"));
                inserta = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a insertar"));
                lista.insertarDespues(lista, despues, inserta);
                JOptionPane.showMessageDialog(null, lista.toString());
                lista.eliminarPrimero(lista);
                JOptionPane.showMessageDialog(null, lista.toString());
                buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar"));
                nd3 = lista.buscar(buscar);
                if (nd3 != null) {JOptionPane.showMessageDialog(null, "El nodo fue encontrado!");} 
                else {JOptionPane.showMessageDialog(null, "El nodo NO fue encontrado!");} 
                aux = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a Eliminar:"));
                aux2 = lista.buscar(aux);
                if(aux2 != null){
                   lista.eliminar(aux2);
                  JOptionPane.showMessageDialog(null, "El numero fue eliminado correctamente....");
                }
                else{
                  JOptionPane.showMessageDialog(null, "El numero NO EXISTE en la Lista");
                }
                 JOptionPane.showMessageDialog(null, lista.toString());
                 lista.invertirLista();
                 JOptionPane.showMessageDialog(null, "Acontinuación la lista invertida:");
                 JOptionPane.showMessageDialog(null, lista.toString());
                distancia = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a calcular Max distancia"));
                aux = lista.buscarDistancia(lista, distancia);
                
                JOptionPane.showMessageDialog(null, "La maxima distancia es: " +aux);
	}

}
