/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadcola;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PruebaTadCola {
    public static void main(String[] args) throws NumberFormatException, IOException, ColaVacia {
		TadCola cola = new TadCola ();
                TadCola cola2 = new TadCola ();
                NodoCola aux2;
		int aux;
                cola.encolar(0);
                cola.encolar(5);
                cola.encolar(1);
                cola.encolar(3);
                
              //  System.out.println(lista2.toString());
                JOptionPane.showMessageDialog(null, cola.toString());
                //lista.cargarLista2();
		//JOptionPane.showMessageDialog(null, lista.toString());
		aux = cola.numElemCola();
		JOptionPane.showMessageDialog(null, "El numero de elementos en la cola es: " +aux);
                cola.desencolar();
                cola.desencolar();
                
                
                 JOptionPane.showMessageDialog(null, cola.toString());
                 cola2.leerCola();
                 JOptionPane.showMessageDialog(null, cola2.toString());
                 cola2.cargarCola();
                  JOptionPane.showMessageDialog(null, cola2.toString());
                  cola2.invertirCola();
                  JOptionPane.showMessageDialog(null, cola2.toString());
	}
}
