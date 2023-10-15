import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Torneo {
    public static void main(String[] args) throws IOException {
        //Declaracion de variables a usar
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean continuar=true,continuarSubmenu;
        int menu, subMenu;
        File archivosTorneo = new File("jugadoresTorneo.csv");





        cargarArchivos(archivosTorneo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                    continuarSubmenu=true;
                    switch(subMenu){
                        case 1:
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR LIBERO");
                                
                                agregarDatos(jugadores, scan, "Libero");
                                
                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ");
                            
                            }
                            break;
                        case 2:
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR PASADOR");

                                agregarDatos(jugadores, scan, "Pasador");
                                
                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ");
                            }
                            break;
                        
                        case 3:
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR AUXILIAR");
                                
                                agregarDatos(jugadores, scan, "Auxiliar");

                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ");
                            }
                            break;
                        case 4:
                            while(continuarSubmenu){
                                
                                System.out.println("INFORMACION DE JUGADOR OPUESTO");

                                agregarDatos(jugadores, scan, "Opuesto");
                                
                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ");
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

                    //validacion si estan vacios los campos
                    if(jugadores.isEmpty()){
                        System.out.println("No hay jugadores en la lista.");
                    }else{
                        System.out.println("Jugadores existentes:");
                        for (Jugador jugador: jugadores) {
                            System.out.println("--> "+jugador.toString());
                        }
                    }

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
                    guardarDatos(archivosTorneo);

                    System.exit(0);

                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    
                    break;
            }
            
            continuar = volverAlMenu(scan," al menú? ");
            

        }
        scan.close();
    }

    private static void agregarDatos(ArrayList<Jugador> jugadores,Scanner scanner,String tipo){
        
        if(tipo.equals("Libero")){

            System.out.print("Por favor, introduce el nombre: ");
            String nombre = scanner.nextLine();
    
            System.out.print("Por favor, introduce el país: ");
            String pais = scanner.nextLine();
    
            System.out.print("Por favor, introduce la cantidad de errores: ");
            int errores = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de aces: ");
            int aces = scanner.nextInt();
    
            System.out.print("Por favor, introduce el total de servicios: ");
            int totalServicios = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de servicios recibidos efectivos: ");
            int recibidosEfectivos = scanner.nextInt();

            jugadores.add(new Libero(nombre, pais, errores, aces, totalServicios, recibidosEfectivos));
            
        }else if(tipo.equals("Pasador")){
            System.out.print("Por favor, introduce el nombre: ");
            String nombre = scanner.nextLine();
    
            System.out.print("Por favor, introduce el país: ");
            String pais = scanner.nextLine();
    
            System.out.print("Por favor, introduce la cantidad de errores: ");
            int errores = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de aces: ");
            int aces = scanner.nextInt();
    
            System.out.print("Por favor, introduce el total de servicios: ");
            int totalServicios = scanner.nextInt();

            System.out.print("Por favor, introduce la cantidad de pases: ");
            int pases = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de fintas efectivas: ");
            int fintasEfectivas = scanner.nextInt();


            jugadores.add(new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas));
            
    
        }else if(tipo.equals("Auxiliar")){
            System.out.print("Por favor, introduce el nombre: ");
            String nombre = scanner.nextLine();
    
            System.out.print("Por favor, introduce el país: ");
            String pais = scanner.nextLine();
    
            System.out.print("Por favor, introduce la cantidad de errores: ");
            int errores = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de aces: ");
            int aces = scanner.nextInt();
    
            System.out.print("Por favor, introduce el total de servicios: ");
            int totalServicios = scanner.nextInt();

            System.out.print("Por favor, introduce la cantidad de ataques: ");
            int ataques = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de bloqueos efectivos: ");
            int bloqueosEfectivos = scanner.nextInt();

            System.out.print("Por favor, introduce la cantidad de bloqueos fallidos: ");
            int bloqueosFallidos = scanner.nextInt();


            jugadores.add(new Auxiliar(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos));
            
        }else if(tipo.equals("Opuesto")){
            System.out.print("Por favor, introduce el nombre: ");
            String nombre = scanner.nextLine();
    
            System.out.print("Por favor, introduce el país: ");
            String pais = scanner.nextLine();
    
            System.out.print("Por favor, introduce la cantidad de errores: ");
            int errores = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de aces: ");
            int aces = scanner.nextInt();
    
            System.out.print("Por favor, introduce el total de servicios: ");
            int totalServicios = scanner.nextInt();

            System.out.print("Por favor, introduce la cantidad de ataques: ");
            int ataques = scanner.nextInt();
    
            System.out.print("Por favor, introduce la cantidad de bloqueos efectivos: ");
            int bloqueosEfectivos = scanner.nextInt();

            System.out.print("Por favor, introduce la cantidad de bloqueos fallidos: ");
            int bloqueosFallidos = scanner.nextInt();


            jugadores.add(new Opuesto(nombre, pais, errores, aces, totalServicios, ataques, bloqueosEfectivos, bloqueosFallidos));
            
        }else{
            System.out.println("Este tipo de jugador no existe");
        }

        
    }

    private static void guardarDatos(File archivosTorneo){
        
                StringBuilder contenidoExistente = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new FileReader(archivosTorneo))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        contenidoExistente.append(linea).append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                contenidoExistente.append("datosJugador").append("\n");

                try (PrintWriter writer = new PrintWriter(new FileWriter(archivosTorneo))) {
                    writer.print(contenidoExistente.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

    private static void cargarArchivos(File archivosTorneo) throws IOException{
        try {
            
            FileWriter escritor = new FileWriter(archivosTorneo, true);
            if(!archivosTorneo.exists()){
                escritor.write("Nombre,Pais,Tipo,Errores,Aces,Total Servicios,Recibos Efectivos,Pases,Fintas Efectivas,Ataques,Bloqueos Efectivos,Bloqueos Fallidos\n");
                        
                System.out.println("Archivo " + archivosTorneo + " cargado correctamente!!");
            }else{        
                System.out.println("Archivo " + archivosTorneo + " cargado correctamente!!");
            }
            escritor.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Upsi");
            e.printStackTrace();
        }
    }

    private static boolean volverAlMenu(Scanner scanner, String eleccion) {
        System.out.println("¿Desea volver"+ eleccion+" (1: Sí, 0: No): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 0) {
            if(eleccion.equals(" al menú? ")){
                System.out.println("Saliendo del programa....");
                //meter datos a csv con una función
                return false;
            }else{
                System.out.println("Saliendo de la opción.");
                return false;
            }
        } else {
            
            return true;
        }
        
    }
}
