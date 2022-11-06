/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueaderopetitamoi;

import java.util.Random;

/**
 *
 * @author user
 */
public class Factura {
    private final float VALOR_AUTO = 5000;
    private final float VALOR_CAMIONETA = 8000;
    private final float VALOR_BUS = 10000;
    
    private int codigo;
    private String cliente;
    private String vehiculo;
    private int nroHoras;
    private float valor;
    
    public Factura(){}
    
    public Factura(int codigo, String cliente, String vehiculo, int nroHoras) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        setNroHoras(nroHoras);
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vehiculo
     */
    public String getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the nroHoras
     */
    public int getNroHoras() {
        return nroHoras;
    }

    /**
     * @param nroHoras the nroHoras to set
     */
    public void setNroHoras(int nroHoras) {
        this.nroHoras = nroHoras;
        calcularValor();
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    /**
     * método que determina la tarifa y calcula el valor a pagar de la factura
     */
    private void calcularValor() {
        float _valor;
        if (getVehiculo().equalsIgnoreCase("Auto"))
            _valor = getNroHoras() * VALOR_AUTO;
        else if (getVehiculo().equalsIgnoreCase("Camioneta"))
            _valor = getNroHoras() * VALOR_CAMIONETA;
        else if (getVehiculo().equalsIgnoreCase("Bus"))
            _valor = getNroHoras() * VALOR_BUS;
        else
            _valor = 0;
        setValor(_valor);
    }
    /**
     * 
     * @return una factura aleatoria
     */
    
    public Factura generarFactura() {
        return GeneradorDeFacturas.generarFacturas();
    }
    
        /**
         * @class GeneradorDeFacturas
         * Clase interna de la clase factura que genera de forma aleatoria objetos factura
         */
        public class GeneradorDeFacturas {
        private static final String VEHICULOS[] = {"Auto","Camioneta","Bus"};
        private static final String NOMBRES[] = {"Mauricio", "Esteban", "Jhonathan", "Nabucodonosor", "David", "Sergio", "Carlos", "Daniel", "José"};
        
        public static Factura generarFacturas() {
            Random ran = new Random();
            Factura salida = new Factura(ran.nextInt(1,251), NOMBRES[ran.nextInt(9)], VEHICULOS[ran.nextInt(3)], ran.nextInt(1,25));
            return salida;
        }
        
    }
}
