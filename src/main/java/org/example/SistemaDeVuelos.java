package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
//Clase de servicios, compuesta de los diferentes metodos para el menu
public class SistemaDeVuelos {
    private Map<String, Aeropuerto> aeropuertos;
    private Map<String, Vuelo> vuelos;

    public SistemaDeVuelos() {
        this.aeropuertos = new HashMap<>();
        this.vuelos = new HashMap<>();
    }

    public void agregarAeropuerto(Aeropuerto aeropuerto) {//Adiciona un nuevo aeropuerto a la lista existente
        aeropuertos.put(aeropuerto.getId(), aeropuerto);
    }

    public void eliminarAeropuerto(String id) {//Elimina un aeropuerto de la lista existente
        aeropuertos.remove(id);
    }

    public Aeropuerto obtenerAeropuerto(String id) {//Busca un aeropuerto de la lista segun el id
        return aeropuertos.get(id);
    }

    public List<Aeropuerto> listarAeropuertos() {//Imprime la lista con los aeropuertos
        return new ArrayList<>(aeropuertos.values());
    }

    public void agregarVuelo(Vuelo vuelo) {//Agrega un vuelo a lista existente
        vuelos.put(vuelo.getId(), vuelo);
    }

    public void eliminarVuelo(String id) {//Elimina un vuelo de la lista existente
        vuelos.remove(id);
    }

    public Vuelo obtenerVuelo(String id) {//Busca un vuelo segun el id
        return vuelos.get(id);
    }

    public List<Vuelo> listarVuelos() {//Imprime la lista de vuelos
        return new ArrayList<>(vuelos.values());
    }

    public void agregarRuta(String idOrigen, String idDestino, Ruta ruta) {//Adiciona una ruta a la lista existente
        Aeropuerto origen = aeropuertos.get(idOrigen);
        Aeropuerto destino = aeropuertos.get(idDestino);
        if (origen != null && destino != null) {
            origen.addConexion(destino, ruta);
        }
    }

    public List<Ruta> listarRutas() {//Imprime las rutas existentes en la lista
        List<Ruta> rutas = new ArrayList<>();
        for (Aeropuerto aeropuerto : aeropuertos.values()) {
            rutas.addAll(aeropuerto.getConexiones().values());
        }
        return rutas;
    }
}

