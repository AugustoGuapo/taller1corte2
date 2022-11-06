/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tadcola;

import java.io.*; 
import java.util.Random;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class NumerosSuerte {
    
public static void main(String [] a) throws ColaVacia  {   
 int n, n1, n2, i;   
 Integer nv;   
 TadCola q = new TadCola();   
 Random r = new Random();   
    
 // número inicial de elementos de la cola    
 n = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de numeros a encolar:"));     
 // se generan n números aleatorios    
 for (i = 1; i <= n; i++)    {     
  nv = new Integer(1+r.nextInt(101));     
  q.encolar(nv);    
 }     
 JOptionPane.showMessageDialog(null, "A continuación la cola original:");    
 JOptionPane.showMessageDialog(null, q.toString());
 // se genera aleatoriamente el intervalo n1     
 n1 = 1 + r.nextInt(11);     
 JOptionPane.showMessageDialog(null, "Nuestro primer n1 es: " +n1); 
 // se retiran de la cola elementos a distancia n1    
 //JOptionPane.showMessageDialog(null, "A continuación se quitan de la cola:");  
 while (n1 <= n)    {     
  int nt;     
  n2 = 0; // contador de elementos que quedan     
  for (i = 1; i <= n; i++)  {      
    nt = q.desencolar();      
    if (i % n1 == 1)      {  
     JOptionPane.showMessageDialog(null, "A continuación se quita de la cola:");
     JOptionPane.showMessageDialog(null, " " +nt);      
    }     
    else  {       
     q.encolar(nt); // se vuelve a meter en la cola      
     n2++;      
    }     
  }
  n = n2;     
  n1 = 1 + r.nextInt(11); 
  JOptionPane.showMessageDialog(null, "Ahora nuestro" +i+ " n1 es: " +n1);
 }
 JOptionPane.showMessageDialog(null, "A continuación los numeros de la suerte:");    
 JOptionPane.showMessageDialog(null, q.toString());    

}
}

  