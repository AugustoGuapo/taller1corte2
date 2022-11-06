/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderopetitamoi;

/**
 *
 * @author user
 */
public class GestionFacturas {
    Factura facturas[];
    int cantFacturas;
    
    public GestionFacturas(){}
    
    public GestionFacturas(int cantFacturas) {
        this.cantFacturas = cantFacturas;
        facturas = new Factura[cantFacturas];
    }
    
    public void setFacturas(int pos, Factura factura) {
        facturas[pos] = factura;
    }
    
    public Factura getFacturas(int pos) {
        return facturas[pos];
    }
    
    public void setCantFacturas(int cant) {
        cantFacturas = cant;
    }
    
    public int getCantFacturas() {
        return cantFacturas;
    }
    /**
     * método que llena automáticamente con facturas aleatorias el arreglo de facturas
     */
    public void llenarFacturas() {
        for (int i = 0; i < cantFacturas; i++) {
            setFacturas(i, new Factura().generarFactura());
        }
    }
    
    public void cambiar(int p1, int p2) {
        Factura aux = facturas[p1];
        setFacturas(p1,getFacturas(p2));
        setFacturas(p2, aux);
    }
    
    public void ordenarBurbuja() {
        for (int i = 0; i < getCantFacturas(); i++) {
            for (int j = 0; j < (getCantFacturas()-i)-1; j++) {
                if (getFacturas(j).getNroHoras() > getFacturas(j+1).getNroHoras()) {
                    cambiar(j,j+1);
                }
            }
        }
    }
    
    public void ordenarIntercambio() {
        for (int i = 0; i < getCantFacturas(); i++) {
            for (int j = i+1; j < getCantFacturas(); j++) {
                if (getFacturas(i).getNroHoras() > getFacturas(j).getNroHoras()) {
                    cambiar(i,j);
                }                
            }
        }
    }
    
    public void ordenarQuickSort(int primero, int ultimo){
        int i, j, centro;
        int pivote;
        centro = (primero+ultimo)/2;
        pivote = getFacturas(centro).getNroHoras();
        i = primero;
        j = ultimo;
        do{
            while((i <= j) && (getFacturas(i).getNroHoras() < pivote)){
                 i = i + 1;
        }
            while((i <= j) && (getFacturas(j).getNroHoras() > pivote)){
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

}
