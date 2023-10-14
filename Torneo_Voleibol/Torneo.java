import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Torneo {
    /**
     * Atributo que almacenará a los jugadores del torneo.
     */
    private ArrayList<Jugador> listaJugadores;

    /**
     * Metodo constructor que crea una instancia de la lista de jugadores.
     */
    public Torneo(){
        listaJugadores = new ArrayList<Jugador>();
    }

    /**
     * Método encargado de agregar un jugador a la lista polimórfica.
     */
    public void agregarJugador(){
        // Variables del método
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        // SELECCION DE OPCION 
        System.out.println("Seleccione el tipo de jugador que desea crear. ");
        System.out.println("1. Líbero");
        System.out.println("2. Pasador");
        System.out.println("3. Opuesto/Auxiliar");
        opcion = sc.nextInt();

        try {
            // DATOS GENERALES DE LOS JUGADORES
            sc.nextLine();
            System.out.println("Ingrese el nombre del jugador");
            String nombre = sc.nextLine();
            System.out.println("Ingrese el pais del jugador");
            String pais = sc.nextLine();
            System.out.println("Ingrese el número de errores del jugador: ");
            int errores = sc.nextInt();
            System.out.println("Ingrese el número de aces del jugador: ");
            int aces = sc.nextInt();
            System.out.println("Ingrese el total de servicios");
            int totalServicios = sc.nextInt();
    
            if (opcion == 1){
                // Solicitud de data Libero
                System.out.println("Ingrese los recibos efectivos: ");
                int recibosEfectivos = sc.nextInt();
                String tipo = "Libero";
    
                // Se crea la instancia de tipo libero
                Libero libero = new Libero(nombre, pais, errores, aces, totalServicios, 0 , tipo, recibosEfectivos);
                
                libero.setEfectividad(libero.calcularEfectividad());
                
                // Se agrega el libero a la lista polimófica
                listaJugadores.add(libero);
    
                System.out.println("¡LÍbero agregado correctamente!");
    
            }else if (opcion == 2){
                // Solicitud de data Pasador
                System.out.println("Ingrese el número de pases del jugador: ");
                int pases = sc.nextInt();
                System.out.println("Ingrese el número de fintas del jugador: ");
                int fintas = sc.nextInt();
                String tipo = "Pasador";
    
                // Se crea la instancia de tipo Pasador
                Pasador pasador = new Pasador(nombre, pais, errores, aces, totalServicios, 0, tipo, pases, fintas);
                pasador.setEfectividad(pasador.calcularEfectividad());
    
                // Se agrega el pasador a la lista polimófica
                listaJugadores.add(pasador);
    
                System.out.println("¡Pasador agregado correctamente!");
    
            }else if (opcion == 3){
                // Solicitud de data Opuesto/Auxiliar
                System.out.println("Ingrese el número de bloqueos efectivos del jugador: ");
                int bloqueosEfectivos = sc.nextInt();
                System.out.println("Ingrese el número de bloqueos fallidos del jugador: ");
                int bloqueosFallidos = sc.nextInt();
                System.out.println("Ingrese el número de ataques del jugador: ");
                int ataques = sc.nextInt();
    
                String tipo = "Opuesto/Auxiliar";
    
                // Se crea la instancia de tipo opuesto_Auxiliar
                Opuesto_Auxiliar opuesto_Auxiliar = new Opuesto_Auxiliar(nombre, pais, errores, aces, totalServicios, 0, tipo, bloqueosEfectivos, bloqueosFallidos, ataques);
                opuesto_Auxiliar.setEfectividad(opuesto_Auxiliar.calcularEfectividad());
    
                // Se agrega el opuesto_Auxiliar a la lista polimófica
                listaJugadores.add(opuesto_Auxiliar);
    
                System.out.println("Opuesto/Auxiliar agregado correctamente!");
    
            }else{
                System.out.println("Entrada inválida, ingrese una opción correcta.");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
    }

    /**
     * Método encargado de mostrar todos los jugadores del torneo.
     */
    public void mostrarJugadores(){
        // Se itera la lista polimorfica para mostrar la información correspondiente
        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).getTipo().equals("Libero")){
                System.out.println(listaJugadores.get(i).toString()); // objetos de tipo libero
            }else if (listaJugadores.get(i).getTipo().equals("Pasador")){
                System.out.println(listaJugadores.get(i).toString()); // objetos de tipo Pasador
            }else if (listaJugadores.get(i).getTipo().equals("Opuesto/Auxiliar")){
                System.out.println(listaJugadores.get(i).toString()); // objetos de tipo Opuesto/Auxiliar
            }
        }
    }

    /**
     * Método encargado de mostrar el top 3 de los líberos del torneo.
     */
    public void mostrarTopLiberos(){
        try {
            // Se define un Comparator esto con el fin de ordenar por efectividad de mayor a menor
            Comparator<Jugador> comparadorEfectividad = (jugador1, jugador2) ->
            Double.compare(jugador2.getEfectividad(), jugador1.getEfectividad());

            // Se ordena la lista polimórfica usando el Comparator
            Collections.sort(listaJugadores, comparadorEfectividad);

            // Se imprime los primeros 3 mejores líberos segun su efetividad.
            int contador = 0;
            // Se recorre la lista polimorfica
            for (Jugador jugador : listaJugadores) {
                // Se valida que el objeto que vaya en la iteración sea de tipo libero
                if (jugador instanceof Libero){
                    contador++;
                    // Validacion del contador
                    if (contador < 4){
                        System.out.println(((Libero)jugador).toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("¡Aún no puede visualizar el top 3 de los Líberos!");
        }
    }

    /**
     * Método el cual muestra el número de Pasadore
     */
    public void mostrarCantidadPasadores(){
        // Se crea un contador para saber cuantos pasadores con más de un 80% de efectividad hay en el sistema
        int contador = 0;
        // Se recorre la lista polimorfica
        for (Jugador jugador : listaJugadores) {
            // Se valida el objeto que va en la iteración sea de tipo Pasador
            if (jugador instanceof Pasador){
                // Se valida la efectividad 
                if (jugador.getEfectividad() > 80){
                    contador +=1; // se aumenta el contador
                }
            }
        }
        System.out.println("El número de pasadores con más de un 80% de efectividad es: " + contador);
    }

    public void guardarData(){
        String archivo = "jugadores.csv";
        // Se crea el archivo CSV
        File fichero = new File(archivo);
        try {
            // Creación del BufferedReader, el cuál permitirá escribir en el archivo indicado
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

            // Si el archivo esta vacío se crea su encabezado
            if (fichero.length() == 0){
                // Escribe las líneas en el archivo CSV
                bw.write("Nombre,Pais,Errores,Aces,TotalServicios,Efectividad,Tipo,RecibosEfectivos,Pases,Fintas,BloqueosEfectivos,BloqueosFallidos,Ataques"); // Encabezado
                bw.newLine(); // Nueva línea
            }

            // se recorre la lista para poder escribir el String en el CSV
            for (Jugador jugador : listaJugadores) {
                if (jugador.getTipo().equals("Libero")){ // Se valida si lo que se va a ingresar será un objeto de tipo libero
                    // Se crea el String a ingregar en el CSV
                    String lineaLibero = jugador.getNombre() + "," + jugador.getPais() + "," + 
                                         jugador.getErrores() + "," + String.valueOf(jugador.getAces()) + "," +
                                         String.valueOf(jugador.getTotalServicios()) + "," + String.valueOf(jugador.getEfectividad()) + "," +
                                         jugador.getTipo() + "," + String.valueOf(((Libero)jugador).getRecibosEfectivos()) + "," + "NA" + "," + 
                                         "NA" + "," + "NA" + "," + "NA" + "," + "NA";
                    
                    // Se escribe en el archivo CSV
                    bw.write(lineaLibero);
                    bw.newLine(); 

                }else if(jugador.getTipo().equals("Pasador")){ // Se valida si lo que se va a ingresar será un objeto de tipo Pasador
                    // Se crea el String a ingregar en el CSV
                    String lineaPasador = jugador.getNombre() + "," + jugador.getPais() + "," + 
                                          jugador.getErrores() + "," + String.valueOf(jugador.getAces()) + "," +
                                          String.valueOf(jugador.getTotalServicios()) + "," + String.valueOf(jugador.getEfectividad()) + "," +
                                          jugador.getTipo() + "," + "NA" + "," + String.valueOf(((Pasador)jugador).getPases()) + "," + 
                                          String.valueOf(((Pasador)jugador).getFintas()) + "," + "NA" + "," + "NA" + "," + "NA";
                    // Se escribe en el archivo CSV
                    bw.write(lineaPasador);
                    bw.newLine(); 

                }else if(jugador.getTipo().equals("Opuesto/Auxiliar")){// Se valida si lo que se va a ingresar será un objeto de tipo Opuesto/Auxiliar
                    // Se crea el String a ingregar en el CSV
                    String lineaOpuestoAuxiliar = jugador.getNombre() + "," + jugador.getPais() + "," + 
                                                  jugador.getErrores() + "," + String.valueOf(jugador.getAces()) + "," +
                                                  String.valueOf(jugador.getTotalServicios()) + "," + String.valueOf(jugador.getEfectividad()) + "," +
                                                  jugador.getTipo() + "," + "NA" + "," + "NA" + "," + 
                                                  "NA" + "," + String.valueOf(((Opuesto_Auxiliar)jugador).getBloqueosEfectivos()) + "," 
                                                  + String.valueOf(((Opuesto_Auxiliar)jugador).getBloqueosFallidos()) + "," +
                                                   String.valueOf(((Opuesto_Auxiliar)jugador).getAtaques());
                    // Se escribe en el archivo CSV
                    bw.write(lineaOpuestoAuxiliar);
                    bw.newLine();
                }
            }
            // Se cierra el BufferedWriter
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de cargar la data del archivo CSV a la lista polimorfica 
     */
    public void cargarData(){
        try {
            // Creación del BufferedReader, el cuál permitirá leer el archivo indicado
            BufferedReader br = new BufferedReader(new FileReader("jugadores.csv"));

            String linea;
            boolean primeraLinea = true; // Para saltar la línea de encabezado
            
            // Loop donde se recorrerá la archivo CSV y se cargará la data
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; // Se salta la línea de encabezado
                }
                
                String[] partes = linea.split(",");
                
                if (partes.length == 13) { // 13 Columnas en el CSV
                    String tipo = partes[6];
                    if (tipo.equals("Libero")){ // Se valida el String para convertir a objeto de tipo líbero
                        // Creación de objeto de tipo líbero
                        Libero libero = new Libero("", "", 0, 0, 
                                                    0, 0, partes[6], 0);
                        
                        // Se setea cada campo al objeto
                        libero.setNombre(partes[0]);
                        libero.setPais(partes[1]);
                        libero.setErrores(Integer.parseInt(partes[2]));
                        libero.setAces(Integer.parseInt(partes[3]));
                        libero.setTotalServicios(Integer.parseInt(partes[4]));
                        libero.setEfectividad(Double.parseDouble(partes[5]));
                        libero.setRecibosEfectivos(Integer.parseInt(partes[7]));

                        // Se agrega el objeto a la lista
                        listaJugadores.add(libero);


                    } else if (tipo.equals("Pasador")){// Se valida el String para convertir a objeto de tipo Pasador
                        // Creación de objeto de tipo líbero
                        Pasador pasador = new Pasador("", "", 0, 0, 
                                                        0, 0, partes[6], 0, 0);
                        // Se setea cada campo al objeto
                        pasador.setNombre(partes[0]);
                        pasador.setPais(partes[1]);
                        pasador.setErrores(Integer.parseInt(partes[2]));
                        pasador.setAces(Integer.parseInt(partes[3]));
                        pasador.setTotalServicios(Integer.parseInt(partes[4]));
                        pasador.setEfectividad(Double.parseDouble(partes[5]));
                        pasador.setPases(Integer.parseInt(partes[8]));
                        pasador.setFintas(Integer.parseInt(partes[9]));

                        // Se agrega el objeto a la lista
                        listaJugadores.add(pasador);

                    } else if (tipo.equals("Opuesto/Auxiliar")){ // Se valida el String para convertir a objeto de tipo Opuesto/Auxiliar
                        Opuesto_Auxiliar opuesto_Auxiliar = new Opuesto_Auxiliar("", "", 0, 0, 0, 
                                                                                    0, partes[6], 0, 0, 0);
                        // Se setea cada campo al objeto
                        opuesto_Auxiliar.setNombre(partes[0]);
                        opuesto_Auxiliar.setPais(partes[1]);
                        opuesto_Auxiliar.setErrores(Integer.parseInt(partes[2]));
                        opuesto_Auxiliar.setAces(Integer.parseInt(partes[3]));
                        opuesto_Auxiliar.setTotalServicios(Integer.parseInt(partes[4]));
                        opuesto_Auxiliar.setEfectividad(Double.parseDouble(partes[5]));
                        opuesto_Auxiliar.setBloqueosEfectivos(Integer.parseInt(partes[10]));
                        opuesto_Auxiliar.setBloqueosFallidos(Integer.parseInt(partes[11]));
                        opuesto_Auxiliar.setAtaques(Integer.parseInt(partes[12]));

                        // Se agrega el objeto a la lista
                        listaJugadores.add(opuesto_Auxiliar);
                    }
                } else {
                    System.out.println("Error al leer línea: " + linea);
                }
            }
        } catch (Exception e) { // Se lanza este error, cuando se corre el archivo por primera vez y no hay información para mostrar.
            System.out.println("¡Archico jugadores.csv se encuentra vacío!");
        }

    }
}