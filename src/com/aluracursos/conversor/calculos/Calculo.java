package com.aluracursos.conversor.calculos;

public class Calculo {

    private int cantidad;
    private int monedaUno;
    private int monedaDos;
    private double conversion;


    public Calculo(int monedaUno, int monedaDos, int cantidad){
        this.monedaUno = monedaUno;
        this.monedaDos = monedaDos;
        this.cantidad = cantidad;
    }

    public int getMonedaUno() {
        return monedaUno;
    }

    public int getMonedaDos() {
        return monedaDos;
    }

    public double getConversion() {
        return conversion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double conversion(int cantidadUno, int monedaUno, int monedaDos){
        int resUno = cantidadUno*monedaUno;
        return resUno*monedaDos;
    }
}
