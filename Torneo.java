// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.Scanner;

/**
 * Esta clase representa un programa que gestiona un campeonato de fútbol con jugadores extremos y porteros.
 */
public class Torneo {
    public static void main(String[] args) {
        // //Declaracion de variables a usar
        // ArrayList<Jugador> jugadores = new ArrayList<>();
        // ArrayList<Integer> efectividadExtremos = new ArrayList<>();
        // ArrayList<Integer> efectividadPorteros = new ArrayList<>();
        // Scanner scan = new Scanner(System.in);
        // boolean continuar=true,continuarSubmenu = true;
        // String nombre,pais;
        // int menu, opcion,subMenu,faltas, goles_directos,total_lanzamientos,pases,asistencias_efectivas,goles_recibidos,paradas_efectivas,x = 0;

        // //inicio del menu
        // while(continuar){
        //     System.out.println("***** Menú de Jugadores *****");
        //     System.out.println("1. Ingresar datos de jugador");
        //     System.out.println("2. Mostrar todos los jugadores");
        //     System.out.println("3. Los 3 mejores porteros");
        //     System.out.println("4. Extremos con más de un 85% de efectividad");
        //     System.out.println("5. Salir");
        //     System.out.print("Seleccione una opción: ");

        //     menu = scan.nextInt();
        //     scan.nextLine();

        //     switch (menu) {
        //         case 1:
        //             System.out.println("BIENVENIDO AL INGRESO DEL JUGADOR");
        //             System.out.println("Ingrese si es Extremo (1) o Portero (2) ");
        //             subMenu = scan.nextInt();
        //             scan.nextLine();

        //             switch(subMenu){
        //                 case 1:
        //                     continuarSubmenu = true;
        //                     x = 0;
        //                     while(continuarSubmenu){
        //                         //captura de datos del jugador extremo
        //                         System.out.println("INFORMACION DE JUGADOR EXTREMO");

        //                         System.out.print("Ingresa el nombre del jugador: ");
        //                         nombre = scan.nextLine();
                        
        //                         System.out.print("Ingresa el país del jugador: ");
        //                         pais = scan.nextLine();
                        
        //                         System.out.print("Ingresa el número de faltas cometidas: ");
        //                         faltas = scan.nextInt();scan.nextLine();
                        
        //                         System.out.print("Ingresa el número de goles directos anotados: ");
        //                         goles_directos = scan.nextInt();scan.nextLine();
                        
        //                         System.out.print("Ingresa el número total de lanzamientos realizados: ");
        //                         total_lanzamientos = scan.nextInt();scan.nextLine();
                        
        //                         System.out.print("Ingresa el número de pases realizados: ");
        //                         pases = scan.nextInt();scan.nextLine();
                        
        //                         System.out.print("Ingresa el número de asistencias efectivas: ");
        //                         asistencias_efectivas = scan.nextInt();scan.nextLine();

        //                         extremos.add(new Pasador(nombre, pais, faltas, goles_directos, total_lanzamientos, pases, asistencias_efectivas));
        //                         //calculo de la efectividad del jugador
        //                         extremos.get(x).calcularEfectividad(pases, asistencias_efectivas, goles_directos, total_lanzamientos, faltas);
        //                         efectividadExtremos.add(extremos.get(x).getEfectividad());
                               

        //                         System.out.println("La efectividad del jugador " + extremos.get(x).getNombre() + " es: " + extremos.get(x).getEfectividad());
        //                         x++;

        //                         System.out.println("Desea agregar otro jugador? 1)Si 2)No");
        //                         opcion = scan.nextInt();
        //                         scan.nextLine();
        //                         if(opcion==1){
        //                             continuarSubmenu=true;
        //                         }else if(opcion==2){
        //                             continuarSubmenu=false;
        //                             break;
        //                         }else{
        //                             System.out.println("opcion no valida");
        //                             continuarSubmenu=false;
        //                             break;
        //                         }
        //                     }
        //                     break;
        //                 case 2:
        //                     continuarSubmenu = true;
        //                     x = 0;
        //                     while(continuarSubmenu){
                                
        //                         //captura de datos del jugador portero
        //                         System.out.println("INFORMACION DE JUGADOR PORTERO");

                                
        //                         System.out.print("Ingresa el nombre del jugador: ");
        //                         nombre = scan.nextLine();

        //                         System.out.print("Ingresa el país del jugador: ");
        //                         pais = scan.nextLine();

        //                         System.out.print("Ingresa el número de faltas cometidas: ");
        //                         faltas = scan.nextInt();

        //                         System.out.print("Ingresa el número de goles directos anotados: ");
        //                         goles_directos = scan.nextInt();

        //                         System.out.print("Ingresa el número total de lanzamientos realizados: ");
        //                         total_lanzamientos = scan.nextInt();

        //                         System.out.print("Ingresa el número de paradas efectivas: ");
        //                         paradas_efectivas = scan.nextInt();

        //                         System.out.print("Ingresa el número de goles recibidos: ");
        //                         goles_recibidos = scan.nextInt();

        //                         porteros.add(new Libero(nombre, pais, faltas, goles_directos, total_lanzamientos, paradas_efectivas, goles_recibidos));
        //                         //calculo de la efectivdad del jugador
        //                         porteros.get(x).calcularEfectividad(paradas_efectivas, goles_recibidos, goles_directos, total_lanzamientos);
        //                         efectividadPorteros.add(porteros.get(x).getEfectividad());
                               

        //                         System.out.println("La efectividad del jugador " + porteros.get(x).getNombre() + " es: " + porteros.get(x).getEfectividad());
        //                         x++;

        //                         System.out.println("Desea agregar otro jugador? 1)Si 2)No");
        //                         opcion = scan.nextInt();
        //                         scan.nextLine();
        //                         if(opcion==1){
        //                             continuarSubmenu=true;
        //                         }else if(opcion==2){
        //                             continuarSubmenu=false;
        //                             break;
        //                         }else{
        //                             System.out.println("opcion no valida");
        //                             continuarSubmenu=false;
        //                             break;
        //                         }
        //                     }
        //                     break;
        //                 default:
        //                     System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        //                     break;
        //             }

        //             break;
        //         case 2:
        //             System.out.println("MOSTRAR TODOS LOS JUGADORES");
        //             System.out.println("============================:");
        //             //validacion si estan vacios los campos
        //             if(extremos.isEmpty() && porteros.isEmpty()){
        //                 System.out.println("No hay jugadores en la lista.");
        //             }else{
        //                 System.out.println("Jugador extremos:");
        //                 for (Pasador extremo : extremos) {
        //                     System.out.println("--> "+extremo.toString());
        //                 }
        //                 System.out.println("------------------------------------");
        //                 System.out.println("Jugador porteros:");

        //                 for (Libero portero : porteros) {
        //                     System.out.println("--> "+portero.toString());
        //                 }
        //             }
        //             break;
        //         case 3:
        //             System.out.println("TOP 3 MEJORES PORTEROS");

        //             if (porteros.isEmpty()) {
        //                 System.out.println("No hay porteros en la lista.");
        //             } else {
        //                 //Se usa este comparador de la lista para poder ordenar los porteros sin necesidad de usar otro arryalist
        //                 //Se conoce que no se ha aprendido a usar efectivamente este modelo y que no se pensó en el análisis, pero
        //                 //tras investigar como se hace se encontró que esta era la mejor solucion a como yo lo tenia planteado.
        //                 Comparator<Libero> comparadorEfectividad = Comparator.comparingInt(Libero::getEfectividad);

        //                 Collections.sort(porteros, comparadorEfectividad.reversed());

        //                 int numPorterosAMostrar = 3;
        //                 for (int i = 0; i < Math.min(numPorterosAMostrar, porteros.size()); i++) {
        //                     System.out.println("Top " + i+1 +": " + porteros.get(i).getNombre() + ", con efectividad de: " + porteros.get(i).getEfectividad());
        //                 }
        //             }   


        //             break;
        //         case 4:
        //             System.out.println("EXTREMOS CON MAS DE 85% DE EFECTIVIDAD");
                    
        //             if(extremos.isEmpty()){
        //                 System.out.println("No hay extremos en la lista.");
        //             }else{
        //                 for (Pasador extremo : extremos) {
        //                     if(extremo.getEfectividad()>=85){
        //                         System.out.println("--> "+extremo.getNombre() + ", con efectividad de: " + extremo.getEfectividad());
        //                     }
                                
        //                 }
        //             }
        //             break;
        //         case 5:
        //             System.out.println("Saliendo del programa.");
        //             continuar=false;
        //             break;
        //         default:
        //             System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    
        //             break;
        //     }
            
        //     System.out.println("Desea regresar al menu? 1)Si 2)No");
        //     opcion = scan.nextInt();
        //     scan.nextLine();
        //     if(opcion==1){
        //         continuar=true;
        //     }else if(opcion==2){
        //         System.out.println("Saliendo del programa....");
        //         continuar=false;
        //     }else{
        //         System.out.println("opcion no valida");
        //         continuar=false;
        //     }

        // }
        // scan.close();
    }
}

