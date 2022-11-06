/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller_1_corte_2;

import javax.swing.JOptionPane;
import static taller_1_corte_2.Taller_1_corte_2.mostrar;


/**
 *
 * @author Augusto
 */
public class ListaEnlazada {
       private Nodo inicio;
    private Nodo cabeza; //Se declara el atributo de la clase, cabeza primer nodo de la lista.
 //Método constructor de la clase ListaEnlazada.
    private boolean esPar;
 public ListaEnlazada(){
 cabeza = null; //Inicialmente la lista está vacía, la cabeza apunta a nulo.
 }
 //Implementación del método que asigna el primer nodo de la lista (nodo cabeza).
 public void setCabeza(Nodo cab){
 cabeza = cab;
 }
 //Implementación del método para obtener el primer nodo de la lista (nodo cabeza).
 public Nodo getCabeza(){
 return cabeza;
 }

//Método que recorre la lista y devuelve el último nodo de la lista.
 public Nodo ultimo(){
 Nodo temp = cabeza;
 while(temp != null){
 //Si temp apunta a nulo el nodo temporal (temp) es el último de la lista.
 if(temp.getSiguiente() == null){
 break; //Se rompe el ciclo.
 }else{
 //De lo contrario se pasa al siguiente nodo de la lista.
 temp = temp.getSiguiente();
 }
 }
 return temp;
 }

//Método que recorre la lista para contar cuantos nodos hay almacenados.
 public int contarNodos(){
 int contador = 0;
 Nodo temp = cabeza;
 while(temp != null){
 contador++;
 temp = temp.getSiguiente();
 }
 return contador;
 }

//Método para agregar un nuevo nodo en la lista, por el final.
 public void agregar(Nodo nuevo){
 if(cabeza == null){ //La lista está vacía, no hay nodos.
 setCabeza(nuevo); //Se asigna el primer nodo de la lista.
 }else{
 ultimo().setSiguiente(nuevo); //El ultimo nodo apuntara al nuevo nodo que se agregó.
 }
 }
//Implementación del método que busca un nodo dentro de la lista, pasando como parámetro de
//búsqueda el código del estudiante.
 Nodo buscar(int cod){
 Nodo temp = cabeza;
 while(temp != null){
 if(temp.getCodigo() == cod){
 break;
 }else{
 temp = temp.getSiguiente();
 }
 }
 return temp;
 }
//Implementación del método que elimina el nodo de la lista pasado como parámetro (nd) el nodo
//que se quiere eliminar.
 public void eliminar(Nodo nd){
 Nodo anterior;
 if(nd == cabeza){ //Si el nodo a eliminar en la lista es el primero entonces.
 cabeza = cabeza.getSiguiente();
 }else{ //De lo contrario, se busca el nodo anterior al que se quiere eliminar (nd).
 anterior = cabeza;
 while(anterior.getSiguiente() != nd){
 anterior = anterior.getSiguiente();
 }
//El siguiente de anterior será el nodo que le sigue al que se va a eliminar (nd).
 anterior.setSiguiente(nd.getSiguiente());
 }
 nd.setSiguiente(null); //El enlace del nodo a borrar, apuntara su siguiente a nulo.
 }
//Implementación del método que calcula el promedio de todas las notas definitivas almacenadas
//en la lista.
 public float promedioGeneral(){
 int cantidad = 0;
 float suma = 0;
 Nodo temp = cabeza;
 while(temp != null){
 cantidad++;
 suma = suma + temp.definitiva();
 temp = temp.getSiguiente();
 }
 if(cantidad > 0)
 return suma/cantidad;
 else
 return 0;
 }
//Implementación del método que devuelve la nota definitiva más alta de las almacenadas.
 public float maximaDefinitiva(){
 float def, max;
 max = 0;
 Nodo temp = cabeza;
 while(temp != null){
 def = temp.definitiva();
 if(def > max){
 max = def;
 }
 temp = temp.getSiguiente();
 }
 return max;
 }
 public void limpiar(){
 while(cabeza != null){
 eliminar(cabeza);
 }
 } 
 
 public void borrarMediaLista(int tam, Nodo inicial) {
     if(cabeza != null) {
         if(inicial.getSiguiente() != null) {
             
             borrarMediaLista(tam+1, inicial.getSiguiente());
             borrarSegunTipo(tam, inicial);
         }
         else {
             esPar = tam % 2 == 0;
             borrarSegunTipo(tam, inicial);
         }
     }
     else {
         JOptionPane.showMessageDialog(null, "La lista está vacía");
     }

    }
 
    public void agregarNodoAlPrincipio (Nodo aux) {
        
        aux.setSiguiente(cabeza);
	setCabeza(aux);
    }
    public void agregarEntreDosNodos(Nodo nd, Nodo nuevo){         
        nuevo.setSiguiente(nd.getSiguiente());      
        nd.setSiguiente(nuevo);    
 
    }
    
    private void borrarSegunTipo(int tam, Nodo inicial) {
        if(esPar) {
            if(tam%2 == 0)
                eliminar(inicial);
        }
        else {
            if(tam%2 != 0)
                eliminar(inicial);
        }
    }
    
    public void cambiar(Nodo nod1, Nodo nod2){
      Nodo temp2 = new Nodo();
      temp2.copiar(nod1);
      nod1.copiar(nod2);
      nod2.copiar(temp2);
    } 

    public void ordenarLista(){
      Nodo ni;
      Nodo nj;
      ni = cabeza;
      while(ni != null){
      nj = ni.getSiguiente();
      while(nj != null){
       if(ni.definitiva() < nj.definitiva()){
       cambiar(ni,nj);
        }
       nj = nj.getSiguiente();
       }
      ni = ni.getSiguiente();
      }
    } 
        
    public void invertirLista() {
        Nodo aux = cabeza;
        Nodo temp;

        while (aux.getSiguiente() != null) {

            temp = aux.getSiguiente();

            aux.setSiguiente(temp.getSiguiente());

            temp.setSiguiente(cabeza);

            cabeza = temp;

        }
    }
}
