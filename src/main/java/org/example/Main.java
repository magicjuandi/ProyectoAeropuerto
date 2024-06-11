package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeVuelos sistema = new SistemaDeVuelos();
        precargarDatos(sistema);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        //Menú básico
        while (!salir) {
            System.out.println("----- Sistema de Gestión de Vuelos -----");
            System.out.println("1. Agregar Aeropuerto");
            System.out.println("2. Eliminar Aeropuerto");
            System.out.println("3. Consultar Aeropuerto");
            System.out.println("4. Listar Aeropuertos");
            System.out.println("5. Agregar Ruta");
            System.out.println("6. Listar Rutas");
            System.out.println("7. Agregar Vuelo");
            System.out.println("8. Eliminar Vuelo");
            System.out.println("9. Consultar Vuelo");
            System.out.println("10. Listar Vuelos");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {//Llamada de metodos segun el input del scanner
                case 1:
                    agregarAeropuerto(sistema, scanner);
                    break;
                case 2:
                    eliminarAeropuerto(sistema, scanner);
                    break;
                case 3:
                    consultarAeropuerto(sistema, scanner);
                    break;
                case 4:
                    listarAeropuertos(sistema);
                    break;
                case 5:
                    agregarRuta(sistema, scanner);
                    break;
                case 6:
                    listarRutas(sistema);
                    break;
                case 7:
                    agregarVuelo(sistema, scanner);
                    break;
                case 8:
                    eliminarVuelo(sistema, scanner);
                    break;
                case 9:
                    consultarVuelo(sistema, scanner);
                    break;
                case 10:
                    listarVuelos(sistema);
                    break;
                case 11:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void precargarDatos(SistemaDeVuelos sistema) {//Adiciona datos quemados a las diferentes listas
        // Aeropuertos
        String[] servicios = {"WiFi", "Restaurante", "Tienda Duty Free"};
        Aeropuerto aeropuerto1 = new Aeropuerto("1", "Ciudad del Sol", 34.0522, -118.2437, 3000, servicios, "Activo");
        Aeropuerto aeropuerto2 = new Aeropuerto("2", "Nuevo Horizonte", 40.7128, -74.0060, 2500, servicios, "Activo");
        Aeropuerto aeropuerto3 = new Aeropuerto("3", "Estrella del Norte", 51.5074, -0.1278, 3500, servicios, "Activo");

        sistema.agregarAeropuerto(aeropuerto1);
        sistema.agregarAeropuerto(aeropuerto2);
        sistema.agregarAeropuerto(aeropuerto3);

        // Rutas
        String[] aerolineas1 = {"Airline A", "Airline B"};
        Ruta ruta1 = new Ruta(40, 60, aerolineas1, 5);
        sistema.agregarRuta("1", "2", ruta1);

        String[] aerolineas2 = {"Airline C", "Airline D"};
        Ruta ruta2 = new Ruta(50, 70, aerolineas2, 3);
        sistema.agregarRuta("2", "3", ruta2);

        String[] aerolineas3 = {"Airline E"};
        Ruta ruta3 = new Ruta(90, 120, aerolineas3, 2);
        sistema.agregarRuta("1", "3", ruta3);

        // Vuelos
        Vuelo vuelo1 = new Vuelo("A1", "Airline A", aeropuerto1, aeropuerto2, "08:00", "09:00", "Boeing 737", "Programado", "En tiempo");
        Vuelo vuelo2 = new Vuelo("A2", "Airline B", aeropuerto2, aeropuerto3, "10:00", "11:00", "Airbus A320", "Programado", "En tiempo");

        sistema.agregarVuelo(vuelo1);
        sistema.agregarVuelo(vuelo2);
    }

    private static void agregarAeropuerto(SistemaDeVuelos sistema, Scanner scanner) {//Indica los campos para adicionar un aeropuerto
        System.out.print("Ingrese el ID del aeropuerto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del aeropuerto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la latitud: ");
        double latitud = scanner.nextDouble();
        System.out.print("Ingrese la longitud: ");
        double longitud = scanner.nextDouble();
        System.out.print("Ingrese la capacidad de la pista: ");
        int capacidadPista = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese los servicios disponibles (separados por comas): ");
        String[] servicios = scanner.nextLine().split(",");
        System.out.print("Ingrese el estado del aeropuerto: ");
        String estado = scanner.nextLine();

        Aeropuerto aeropuerto = new Aeropuerto(id, nombre, latitud, longitud, capacidadPista, servicios, estado);
        sistema.agregarAeropuerto(aeropuerto);
        System.out.println("Aeropuerto agregado exitosamente.");
    }

    private static void eliminarAeropuerto(SistemaDeVuelos sistema, Scanner scanner) {//Elimina segun el id
        System.out.print("Ingrese el ID del aeropuerto a eliminar: ");
        String id = scanner.nextLine();
        sistema.eliminarAeropuerto(id);
        System.out.println("Aeropuerto eliminado exitosamente.");
    }

    private static void consultarAeropuerto(SistemaDeVuelos sistema, Scanner scanner) {//Busca el aeropuerto segun el id
        System.out.print("Ingrese el ID del aeropuerto a consultar: ");
        String id = scanner.nextLine();
        Aeropuerto aeropuerto = sistema.obtenerAeropuerto(id);
        if (aeropuerto != null) {
            System.out.println("Aeropuerto: " + aeropuerto.getNombre());
            System.out.println("Latitud: " + aeropuerto.getLatitud());
            System.out.println("Longitud: " + aeropuerto.getLongitud());
            System.out.println("Capacidad de la pista: " + aeropuerto.getCapacidadPista());
            System.out.println("Servicios: " + String.join(", ", aeropuerto.getServicios()));
            System.out.println("Estado: " + aeropuerto.getEstado());
        } else {
            System.out.println("Aeropuerto no encontrado.");
        }
    }

    private static void listarAeropuertos(SistemaDeVuelos sistema) {//Lista los aeropuertos existentes
        System.out.println("----- Listado de Aeropuertos -----");
        for (Aeropuerto aeropuerto : sistema.listarAeropuertos()) {
            System.out.println("ID: " + aeropuerto.getId() + ", Nombre: " + aeropuerto.getNombre() +
                    ", Latitud: " + aeropuerto.getLatitud() + ", Longitud: " + aeropuerto.getLongitud() +
                    ", Capacidad de la pista: " + aeropuerto.getCapacidadPista() +
                    ", Servicios: " + String.join(", ", aeropuerto.getServicios()) +
                    ", Estado: " + aeropuerto.getEstado());
        }
    }

    private static void agregarRuta(SistemaDeVuelos sistema, Scanner scanner) {//Indica los campos para agregar una ruta
        System.out.print("Ingrese el ID del aeropuerto de origen: ");
        String idOrigen = scanner.nextLine();
        System.out.print("Ingrese el ID del aeropuerto de destino: ");
        String idDestino = scanner.nextLine();
        System.out.print("Ingrese la distancia (km): ");
        int distancia = scanner.nextInt();
        System.out.print("Ingrese el tiempo estimado de vuelo (minutos): ");
        int tiempoEstimado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese las aerolíneas que operan la ruta (separadas por comas): ");
        String[] aerolineas = scanner.nextLine().split(",");
        System.out.print("Ingrese la frecuencia de vuelos (número de vuelos por día): ");
        int frecuenciaVuelos = scanner.nextInt();

        Ruta ruta = new Ruta(distancia, tiempoEstimado, aerolineas, frecuenciaVuelos);
        sistema.agregarRuta(idOrigen, idDestino, ruta);
        System.out.println("Ruta agregada exitosamente.");
    }

    private static void listarRutas(SistemaDeVuelos sistema) {//Imprime las rutas de la lista
        System.out.println("----- Listado de Rutas -----");
        for (Ruta ruta : sistema.listarRutas()) {
            // Obtener los aeropuertos de origen y destino de la ruta desde el sistema
            Aeropuerto origen = null;
            Aeropuerto destino = null;
            for (Aeropuerto aeropuerto : sistema.listarAeropuertos()) {
                if (aeropuerto.getConexiones().containsValue(ruta)) {
                    for (Map.Entry<Aeropuerto, Ruta> entry : aeropuerto.getConexiones().entrySet()) {
                        if (entry.getValue().equals(ruta)) {
                            origen = aeropuerto;
                            destino = entry.getKey();
                            break;
                        }
                    }
                    if (origen != null && destino != null) {
                        break;
                    }
                }
            }
            if (origen != null && destino != null) {
                System.out.println("Origen: " + origen.getNombre() + ", Destino: " + destino.getNombre() +
                        ", Distancia: " + ruta.getDistancia() + " km, Tiempo estimado: " + ruta.getTiempoEstimado() +
                        " minutos, Aerolíneas: " + String.join(", ", ruta.getAerolineas()) +
                        ", Frecuencia de vuelos: " + ruta.getFrecuenciaVuelos() + " vuelos/día");
            }
        }
    }


    private static void agregarVuelo(SistemaDeVuelos sistema, Scanner scanner) {//Indica los campos para adicionar un vuelo
        System.out.print("Ingrese el ID del vuelo: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese la aerolínea: ");
        String aerolinea = scanner.nextLine();
        System.out.print("Ingrese el ID del aeropuerto de origen: ");
        String idOrigen = scanner.nextLine();
        System.out.print("Ingrese el ID del aeropuerto de destino: ");
        String idDestino = scanner.nextLine();
        System.out.print("Ingrese el horario de salida (HH:MM): ");
        String horarioSalida = scanner.nextLine();
        System.out.print("Ingrese el horario de llegada (HH:MM): ");
        String horarioLlegada = scanner.nextLine();
        System.out.print("Ingrese el tipo de avión: ");
        String tipoAvion = scanner.nextLine();
        System.out.print("Ingrese el estado del vuelo: ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese el progreso del vuelo: ");
        String progreso = scanner.nextLine();

        Aeropuerto origen = sistema.obtenerAeropuerto(idOrigen);
        Aeropuerto destino = sistema.obtenerAeropuerto(idDestino);
        if (origen != null && destino != null) {
            Vuelo vuelo = new Vuelo(id, aerolinea, origen, destino, horarioSalida, horarioLlegada, tipoAvion, estado, progreso);
            sistema.agregarVuelo(vuelo);
            System.out.println("Vuelo agregado exitosamente.");
        } else {
            System.out.println("Error: Aeropuerto de origen o destino no encontrado.");
        }
    }

    private static void eliminarVuelo(SistemaDeVuelos sistema, Scanner scanner) {//Elimina un vuelo segun el id
        System.out.print("Ingrese el ID del vuelo a eliminar: ");
        String id = scanner.nextLine();
        sistema.eliminarVuelo(id);
        System.out.println("Vuelo eliminado exitosamente.");
    }

    private static void consultarVuelo(SistemaDeVuelos sistema, Scanner scanner) {//Busca un vuelo según el id
        System.out.print("Ingrese el ID del vuelo a consultar: ");
        String id = scanner.nextLine();
        Vuelo vuelo = sistema.obtenerVuelo(id);
        if (vuelo != null) {
            System.out.println("Vuelo: " + vuelo.getId());
            System.out.println("Aerolínea: " + vuelo.getAerolinea());
            System.out.println("Origen: " + vuelo.getOrigen().getNombre());
            System.out.println("Destino: " + vuelo.getDestino().getNombre());
            System.out.println("Horario de salida: " + vuelo.getHorarioSalida());
            System.out.println("Horario de llegada: " + vuelo.getHorarioLlegada());
            System.out.println("Tipo de avión: " + vuelo.getTipoAvion());
            System.out.println("Estado: " + vuelo.getEstado());
            System.out.println("Progreso: " + vuelo.getProgreso());
        } else {
            System.out.println("Vuelo no encontrado.");
        }
    }

    private static void listarVuelos(SistemaDeVuelos sistema) {//Lista los diferentes vuelos existentes
        System.out.println("----- Listado de Vuelos -----");
        for (Vuelo vuelo : sistema.listarVuelos()) {
            System.out.println("ID: " + vuelo.getId() + ", Aerolínea: " + vuelo.getAerolinea() +
                    ", Origen: " + vuelo.getOrigen().getNombre() + ", Destino: " + vuelo.getDestino().getNombre() +
                    ", Horario de salida: " + vuelo.getHorarioSalida() + ", Horario de llegada: " + vuelo.getHorarioLlegada() +
                    ", Tipo de avión: " + vuelo.getTipoAvion() + ", Estado: " + vuelo.getEstado() +
                    ", Progreso: " + vuelo.getProgreso());
        }
    }
}

