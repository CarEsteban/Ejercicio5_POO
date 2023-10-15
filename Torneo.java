import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Torneo {
    public static void main(String[] args) {
        //Declaracion de variables a usar
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean continuar=true,continuarSubmenu = true;
        int menu, subMenu;
        //inicio del menu
        while(continuar){
            System.out.println("***** Menú de Jugadores *****");
            System.out.println("1. Ingresar datos de jugador");
            System.out.println("2. Mostrar todos los jugadores");
            System.out.println("3. Los 3 mejores porteros");
            System.out.println("4. Extremos con más de un 80% de efectividad");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            menu = scan.nextInt();
            scan.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("BIENVENIDO AL INGRESO DEL JUGADOR");
                    System.out.println("Ingrese si es:\n1) Libero\n2) Pasador\n3) Auxiliar\n4) Opueso");
                    subMenu = scan.nextInt();
                    scan.nextLine();

                    switch(subMenu){
                        case 1:
                            continuarSubmenu = true;
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR LIBERO");
                                

                                continuarSubmenu = volverAlMenu(scan);
                            }
                            break;
                        case 2:
                            while(continuarSubmenu){
                                
                                //captura de datos del jugador portero
                                System.out.println("INFORMACION DE JUGADOR PASADOR");

                                
                                continuarSubmenu = volverAlMenu(scan);
                            }
                            break;
                        
                        case 3:
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR AUXILIAR");
                                

                                continuarSubmenu = volverAlMenu(scan);
                            }
                            break;
                        case 4:
                            while(continuarSubmenu){
                                
                                System.out.println("INFORMACION DE JUGADOR OPUESTO");

                                
                                continuarSubmenu = volverAlMenu(scan);
                            }
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }

                    break;
                case 2:
                    System.out.println("MOSTRAR TODOS LOS JUGADORES");
                    System.out.println("============================:");
                    

                    break;
                case 3:
                    System.out.println("TOP 3 MEJORES PORTEROS");

                    if (jugadores.isEmpty()) {
                        System.out.println("No hay porteros en la lista.");
                    } else {
                        Comparator<Jugador> comparadorEfectividad = Comparator.comparingInt(Jugador::getEfectividad);

                        Collections.sort(jugadores, comparadorEfectividad.reversed());

                        int numPorterosAMostrar = 3;
                        for (int i = 0; i < Math.min(numPorterosAMostrar, jugadores.size()); i++) {
                            System.out.println("Top " + i+1 +": " + jugadores.get(i).getNombre() + ", con efectividad de: " + jugadores.get(i).getEfectividad());
                        }
                    }   


                    break;
                case 4:
                    System.out.println("EXTREMOS CON MAS DE 85% DE EFECTIVIDAD");
                    
                    if(jugadores.isEmpty()){
                        System.out.println("No hay extremos en la lista.");
                    }else{
                        for (Jugador extremo : jugadores) {
                            if(extremo.getEfectividad()>=85){
                                System.out.println("--> "+extremo.getNombre() + ", con efectividad de: " + extremo.getEfectividad());
                            }
                                
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");

                    //meter datos a csv con una función



                    continuar=false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    
                    break;
            }
            
            continuar = volverAlMenu(scan);

        }
        scan.close();
    }

    private static boolean volverAlMenu(Scanner scanner) {
        System.out.println("¿Desea volver al menú? (1: Sí, 0: No): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 0) {
            System.out.println("Saliendo del programa.");
            //meter datos a csv con una función
            return false;
        } else {
            
            return true;
        }
        
    }
}
