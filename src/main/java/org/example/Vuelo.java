package org.example;
//Clase Vuelo para la creación de objetos de vuelo.
public class Vuelo {
    private String id;
    private String aerolinea;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String horarioSalida;
    private String horarioLlegada;
    private String tipoAvion;
    private String estado;
    private String progreso;

    public Vuelo(String id, String aerolinea, Aeropuerto origen, Aeropuerto destino, String horarioSalida, String horarioLlegada, String tipoAvion, String estado, String progreso) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.tipoAvion = tipoAvion;
        this.estado = estado;
        this.progreso = progreso;
    }

    public String getId() {
        return id;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public String getHorarioLlegada() {
        return horarioLlegada;
    }

    public String getTipoAvion() {
        return tipoAvion;
    }

    public String getEstado() {
        return estado;
    }

    public String getProgreso() {
        return progreso;
    }
}

