package org.example;
//Clase Ruta en la cual se tiene que distancias y tiempos toman los vuelos, que aerolineas y la frecuencia.
public class Ruta {
    private int distancia;
    private int tiempoEstimado;
    private String[] aerolineas;
    private int frecuenciaVuelos;

    public Ruta(int distancia, int tiempoEstimado, String[] aerolineas, int frecuenciaVuelos) {
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
        this.aerolineas = aerolineas;
        this.frecuenciaVuelos = frecuenciaVuelos;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public String[] getAerolineas() {
        return aerolineas;
    }

    public int getFrecuenciaVuelos() {
        return frecuenciaVuelos;
    }
}

