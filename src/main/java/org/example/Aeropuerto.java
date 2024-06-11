package org.example;
import java.util.HashMap;
import java.util.Map;
//Clase Aeropuerto (creacion de objetos de aeropuertos)
public class Aeropuerto {
    private String id;
    private String nombre;
    private double latitud;
    private double longitud;
    private int capacidadPista;
    private String[] servicios;
    private String estado;
    private Map<Aeropuerto, Ruta> conexiones;

    public Aeropuerto(String id, String nombre, double latitud, double longitud, int capacidadPista, String[] servicios, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.capacidadPista = capacidadPista;
        this.servicios = servicios;
        this.estado = estado;
        this.conexiones = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public int getCapacidadPista() {
        return capacidadPista;
    }

    public String[] getServicios() {
        return servicios;
    }

    public String getEstado() {
        return estado;
    }

    public void addConexion(Aeropuerto destino, Ruta ruta) {
        conexiones.put(destino, ruta);
    }

    public Map<Aeropuerto, Ruta> getConexiones() {
        return conexiones;
    }
}
