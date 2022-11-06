/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller_1_corte_2;

import javax.swing.JOptionPane;

/**
 *
 * @author Augusto
 */
public class Taller_1_corte_2 {

    public static void llenar(Nodo nod){
 int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante: "));
 nod.setCodigo(cod);
 String nom = JOptionPane.showInputDialog("Digite NOMBRE del Estudiante: ");
 nod.setNombre(nom);
 float n1 = Float.parseFloat(JOptionPane.showInputDialog("Digite La NOTA 1:"));
 nod.setNota1(n1);
 float n2 = Float.parseFloat(JOptionPane.showInputDialog("Digite La NOTA 2:"));
 nod.setNota2(n2);
 float n3 = Float.parseFloat(JOptionPane.showInputDialog("Digite La NOTA 3:"));
 nod.setNota3(n3);
 }
//Método para obtener y mostrar los valores asignados a los atributos de la clase Nodo.
 public static void mostrar(Nodo nod){
 String datosNodo = "";
 datosNodo = datosNodo+String.valueOf(""+"CODIGO: "+nod.getCodigo()+"\n"+"NOMBRE:"+nod.getNombre()+"\n"+ "NOTA 1: "+nod.getNota1()+"\n"+"NOTA 2: "+nod.getNota2()+"\n"+"NOTA 3:"+nod.getNota3()+"\n"+ "Definitiva: "+nod.definitiva()+"\n \n");
 JOptionPane.showMessageDialog(null, "=========== INFORMACÓN DE LOS NODOS DE LA LISTA =========== \n"+ datosNodo);
 }
//Método para listar cada uno de los nodos de la lista y visualizarlos en pantalla.
 public static void listar(Nodo nod){
 Nodo temp = nod;
 
 while(temp != null){
 mostrar(temp);
 temp = temp.getSiguiente();
 }
 }
//Método para visualizar el menú de opciones y asignar la opción seleccionada.
 public static int menu(){
 int opcion = 0;
 do{
 opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                       =========== SELECCIONE UNA OPCI\u00d3N DEL MEN\u00da =========== 
                                                       1. Agregar un Nodo a la Lista 
                                                       2. Mostrar Nodos de la Lista 
                                                       3. Cantidad de Nodos de la Lista 
                                                       4. Buscar la Informaci\u00f3n de un estudiante 
                                                       5. Eliminar Nodo de la Lista 
                                                       6. Informe: Promedio General y M\u00e1xima Nota 
                                                       7. Borrar toda la Lista 
                                                       8. Agregar un Nodo por el inicio
                                                       9. Agregar un Nodo entre dos existentes
                                                       10. Ordena por promedio de mayor a menor la lista
                                                       11. Borrar posiciones pares o impares, según longitud de la lista
                                                       12. Invertir el orden actual de los nodos de la lista
                                                       0. Salir
                                                        
                                                        Seleccione una opci\u00f3n del 1 al 12: """));
 }while(opcion <= 0 || opcion > 8);
 return opcion;
 }
 public static void main(String[] args) {
 ListaEnlazada lis = new ListaEnlazada(); //Se crea el objeto lis de la clase ListaEnlazada.
 int opcion, cod;
 Nodo aux;
 do{
 opcion = menu();
 switch(opcion) {
 case 1:
 aux = new Nodo(); //Cuando se agrega un nodo se crea un nuevo objeto de la clase nodo.
 llenar(aux);
 lis.agregar(aux);
 break;
 case 2:
 if(lis.getCabeza() != null){
 listar(lis.getCabeza());
 }else{
 JOptionPane.showMessageDialog(null, "La Lista Está Vacía....");
 }

 break;
 case 3:
 JOptionPane.showMessageDialog(null, "========= NÚMERO DE NODOS DE LA LISTA=========\n"+lis.contarNodos()+
 " Nodos");
 break;
 case 4:
 cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante a Buscar:"));
 aux = lis.buscar(cod);
 if(aux != null){
 mostrar(aux);
 }else{
 JOptionPane.showMessageDialog(null, "La información del estudiante No se encuentra en la lista");
 }
 break;
 case 5:
 cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante a Eliminar: "));
 aux = lis.buscar(cod);
 if(aux != null){
 lis.eliminar(aux);
 JOptionPane.showMessageDialog(null, "La información fue eliminada correctamente....");
 }else{
 JOptionPane.showMessageDialog(null, "El código del estudiante NO EXISTE en la Lista");
 }
 break;
 case 6:
 JOptionPane.showMessageDialog(null, """
                                     ========= INFORME PROMEDIO GENERAL Y M\u00c1XIMA NOTA ========= 
                                     
                                     Promedio General: """+lis.promedioGeneral()+"\n y Máxima Nota: "+lis.maximaDefinitiva());
 break;
 case 7:
 lis.limpiar();
 JOptionPane.showMessageDialog(null, "La Lista Está Vacía....");
 break;
 
 case 8:
 Nodo cabezaNueva = new Nodo();
 llenar(cabezaNueva);
 lis.agregarNodoAlPrincipio(cabezaNueva);
 listar(lis.getCabeza());
 break;
 
 case 9:
 cod = Integer.parseInt(JOptionPane.showInputDialog("Digite CODIGO del Estudiante a Buscar:"));
 aux = lis.buscar(cod);
 if(aux != null){
 Nodo temp = new Nodo();
 llenar(temp);
 lis.agregarEntreDosNodos(aux,temp);
 }else{
 JOptionPane.showMessageDialog(null, "La información del estudiante No se encuentra en la lista");
 }
 break;
 
 case 10:
     lis.ordenarLista();
     listar(lis.getCabeza());
     
           
 case 11:
     lis.borrarMediaLista(1, lis.getCabeza());
     listar(lis.getCabeza());
 break; 
 
 case 12:
     if(lis.getCabeza() != null) {
         lis.invertirLista();
         listar(lis.getCabeza());
     } else {
         JOptionPane.showMessageDialog(null, "La Lista Está Vacía....");
     }
 }
 }while(opcion != 0);
 }


}
