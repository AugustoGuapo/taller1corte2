/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicioneocds;

/**
 *
 * @author Virez
 */
public class CD {
    private String titulo;
    private int CantPistas;
    private float Valor;
    private char clasificacion;

    public CD(String titulo, int CantPistas, float Valor, char clasificacion) {
        this.titulo = titulo;
        this.CantPistas = CantPistas;
        this.Valor = Valor;
        this.clasificacion = clasificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantPistas() {
        return CantPistas;
    }

    public void setCantPistas(int CantPistas) {
        this.CantPistas = CantPistas;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public char getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(char clasificacion) {
        this.clasificacion = clasificacion;
    }
}
