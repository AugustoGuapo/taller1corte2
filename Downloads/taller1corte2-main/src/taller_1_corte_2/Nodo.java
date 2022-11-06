/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller_1_corte_2;

/**
 *
 * @author Augusto
 */
public class Nodo {
    private int codigo;
    private String nombre;
    private float nota1;
    private float nota2;
    private float nota3;
    private Nodo siguiente;
    
     public void Nodo(){
        codigo = 0;
        nombre = "";
        nota1 = 0;
        nota2 = 0;
        nota3 = 0;
        siguiente = null;
     }
    public void setCodigo(int cod){
        codigo = cod;
    }
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setNota1(float n1){
        nota1 = n1;
    }
    public void setNota2(float n2){
        nota2 = n2;
    }
    public void setNota3(float n3){
        nota3 = n3;
    }
    public void setSiguiente(Nodo sig){
        siguiente = sig;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public float getNota1(){
        return nota1;
    }
    public float getNota2(){
        return nota2;
    }
    public float getNota3(){
        return nota3;
    }
    public float definitiva(){
        return (getNota1()+getNota2()+getNota3())/3;
    }
    public Nodo getSiguiente(){
        return siguiente;
    }
    
    public void copiar(Nodo nd){
    codigo = nd.getCodigo();
    nombre = nd.getNombre();
    nota1 = nd.getNota1();
    nota2 = nd.getNota2();
    nota3 = nd.getNota3();
   }
}


   
    

