import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * - Clase que posee el método main, lo cual permite ser el archivo de arranque del programa.
 * - Sistema que permite gestionar un torneo deportivo de Voleibol, donde se podrán realizar las siguientes opciones:
 *      - 1. Insertar jugador.
 *      - 2. Jugadores inscritos en el torneo.
 *      - 3. Top 3 de los Líberos.
 *      - 4. Pasadores con más de un 80% de efectividad. 
 *      - 5. Salir
 *  - Es importante mencionar, que el programa cuenta con persistencia incluida, asimismo posee método de seguridad lo cuál permite que el usuario ingrese la información
 *    de manera correcta.
 * 
 * - @author Jose Ruiz
 * - @version 0.1
 * - @since 13/10/2023
 */

public class Principal{
    public static void main(String[] args) {
        // Variables de clase
        Scanner sc = new Scanner(System.in);
        boolean continue_program = true;
        int opcion = 0;

        //Instancias de clase
        Torneo torneo = new Torneo();

        // Se cargan los datos iniciales
        torneo.cargarData();

        // Loop que controla el flujo del programa
        while(continue_program){
            try {
                Menu();
                opcion = sc.nextInt();
    
                if (opcion == 1){ // 1. Insertar jugador.
                    torneo.agregarJugador();
    
                }else if (opcion == 2){ // 2. Jugadores inscritos en el torneo.
                    torneo.mostrarJugadores();
    
                }else if (opcion == 3){
                    torneo.mostrarTopLiberos(); // 3. Top 3 de los Líberos.
    
                }else if (opcion == 4){
                    torneo.mostrarCantidadPasadores(); // 4. Pasadores con más de un 80% de efectividad.
    
                }else if (opcion == 5){ // 5. Salir.
                    continue_program = false;
                    System.out.println("Gracias por usar el programa.");
                    torneo.guardarData();
    
                }else{
                    System.out.println("Entrada inválida, ingrese una opción correcta.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }
        }
        
    }

    /**
     * Método el cuál muestra las opciones del programa.
     */
    public static void Menu(){
        System.out.println();
        System.out.println("---------------BIENVENIDO---------------");
        System.out.println("1. Insertar jugador. ");
        System.out.println("2. Jugadores inscritos en el torneo. ");
        System.out.println("3. Top 3 de los Líberos. ");
        System.out.println("4. Pasadores con más de un 80% de efectividad. ");
        System.out.println("5. Salir. ");
    }
}