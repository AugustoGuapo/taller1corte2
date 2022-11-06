/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioneocds;

import java.util.Arrays;

/**
 *
 * @author Virez
 */
public class BibliotecaCDS {
    private int tam;
    private CD disco[];
    private int contador;

    public BibliotecaCDS() {
        tam = 12;
        contador = 0;
        disco = new CD [tam];
        
    disco[0] = new CD("Hollywood's bleeding", 17, 105000,'E');
    disco[1] = new CD("x100pre", 15, 100000,'E');
    disco[2] = new CD("More life", 22, 98000,'E');
    disco[3] = new CD("Avida dollars", 9, 90000,'E');
    disco[4] = new CD("Justice (deluxe)", 22, 80000,'A');
    disco[5] = new CD("Famouz", 11, 107000,'E');
    disco[6] = new CD("After hours", 23, 115000,'E');
    disco[7] = new CD("Eterno", 12, 111000,'C');
    disco[8] = new CD("V", 10, 105000,'E');
    disco[9] = new CD("Bahía ducati", 8, 102000,'E');
    disco[10] = new CD("Lust for life", 18, 127000,'E');
    disco[11] = new CD("Aztlan", 16, 130000,'B');
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public CD getDisco(int p) {
        return disco[p];
    }

    public void setDisco(int p, CD info) {
        disco[p] = info;
    }
    
    public void incrementarDatos(){
            CD[] ArregloAux = Arrays.copyOf(disco, getTam()+1);
            disco = ArregloAux;
            setTam(getTam()+1);  
    }
    
    public void agregarDisco(int p, String titulo, int cantPistas, Float valor, char clasificacion){
    disco[p] = new CD(titulo, cantPistas, valor, clasificacion);
    }
    
    public void cambiar(int p1, int p2){
    CD aux;
    
    aux = getDisco(p1);
    setDisco(p1, getDisco(p2));
    setDisco(p2,aux);
    }
    
    public void ordenarBurbuja() {
        int i, j;
        for (i = 0; i <= getTam() - 1; i++) {
            for (j = 0; j <= (getTam() - i) - 2; j++) {
                if (getDisco(j).getCantPistas() > getDisco(j+1).getCantPistas()) {
                    cambiar(j,j+1);
                }
            }
        }
     }
    
    public void ordenarIntercambio(){
        int i, j;
        for (i=0; i<=getTam()-1; i++){ 
            for (j=i+1; j<=getTam()-1; j++){ 
                if (getDisco(i).getCantPistas() > getDisco(j).getCantPistas()){ 
                    cambiar(i, j);
                } 
            } 
        } 
    }
    
    public void ordenarIntercambio2(){
        int i, j;
        for (i=0; i<=getTam()-1; i++){ 
            for (j=i+1; j<=getTam()-1; j++){ 
                if (getDisco(i).getValor() > getDisco(j).getValor()){ 
                    cambiar(i, j);
                } 
            } 
        } 
    }
    
    public void OrdenarShell() {
        int i, n, cont;
        n = (getTam()-1)/2;
        while (n != 0) {
            cont = 1;
            while (cont != 0) {
                cont = 0;
                for (i = n; i <=(getTam()-1); i++) {
                    if ((getDisco(n-1).getCantPistas()) > (getDisco(i).getCantPistas())) {
                        cambiar(i,i-n);
                cont = cont + 1;
                    }
                }
            }
            n = n / 2;
        }
    }
    
     public void ordenarQuickSort(int primero, int ultimo){
        int i, j, centro; 
        int pivote; 
        centro = (primero+ultimo)/2; 
        pivote = getDisco(centro).getCantPistas(); 
        i = primero; 
        j = ultimo; 
        do{ 
            while((i <= j) && (getDisco(i).getCantPistas() < pivote)){ 
                i = i + 1; 
            } 
            while((i <= j) && (getDisco(j).getCantPistas() > pivote)){ 
                j = j - 1; 
            } 
            if(i <= j){
                cambiar(i, j);
                i = i + 1; 
                j = j - 1; 
            } 
        }while(i <= j); 
        if(primero < j){ 
            ordenarQuickSort(primero, j); 
        } 
        if(i < ultimo){ 
            ordenarQuickSort(i, ultimo); 
        } 
    }
     
      public int busquedaLineal(Float dato) {
        int i, posicion;
        posicion = -1;
        i = 0;
        while ((i <= getTam() - 1) && (posicion == -1)) {
            if (getDisco(i).getValor() == dato) {
                posicion = i;
            } else {
                i += 1;
            }
        }
        return posicion;
    }
      
      public int busquedaBinaria(Float dato) {
        int posicion, izq, der, centro;
        izq = 0;
        der = getTam() - 1;
        posicion = -1;

        while ((izq <= der) && (posicion == -1)) {

            centro = (izq + der) / 2;

            if (dato == getDisco(centro).getValor()) {
                posicion = centro;
            } else {
                if (dato < (getDisco(centro).getValor())) {
                    der = centro - 1;
                } else {
                    izq = centro + 1;
                }
            }
        }
        return posicion;
    }
     
     public String mostrarDatos(){
     String datosVector="";
        for (int i = 0; i <= getTam()-1; i++) {
            datosVector = datosVector + String.valueOf("Poscicion "+i+":"+"\n"
                +"Titulo: "+getDisco(i).getTitulo()+"\n"
                +"Cantidad de pistas: "+getDisco(i).getCantPistas()+"\n"
                +"Valor: "+getDisco(i).getValor()+"\n"
                +"Clasificación: "+getDisco(i).getClasificacion()+"\n"+"\n");
        }
        return datosVector;
     }
              
}
