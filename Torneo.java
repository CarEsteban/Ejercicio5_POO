import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
            System.out.println("3. Los 3 mejores líberos");
            System.out.println("4. Pasadores con más de un 80% de efectividad");
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
                                            
                                //meter datos a csv con una función
                                guardarDatos(jugadores,archivosTorneo);
                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ",jugadores,archivosTorneo);
                            
                            }
                            break;
                        case 2:
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR PASADOR");

                                agregarDatos(jugadores, scan, "Pasador");
                                //meter datos a csv con una función
                                guardarDatos(jugadores,archivosTorneo);
                                
                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ",jugadores,archivosTorneo);
                            }
                            break;
                        
                        case 3:
                            while(continuarSubmenu){
                                System.out.println("INFORMACION DE JUGADOR AUXILIAR");
                                
                                agregarDatos(jugadores, scan, "Auxiliar");
                                //meter datos a csv con una función
                                guardarDatos(jugadores,archivosTorneo);

                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ",jugadores,archivosTorneo);
                            }
                            break;
                        case 4:
                            while(continuarSubmenu){
                                
                                System.out.println("INFORMACION DE JUGADOR OPUESTO");

                                agregarDatos(jugadores, scan, "Opuesto");
                                //meter datos a csv con una función
                                guardarDatos(jugadores,archivosTorneo);
                                
                                continuarSubmenu = volverAlMenu(scan, " a ingresar un jugador? ",jugadores,archivosTorneo);
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


                    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivosTorneo), "UTF-8"))) {
                        String linea;
                        boolean esEncabezado = true;
                        String[] encabezado = null;
            
                        while ((linea = br.readLine()) != null) {
                            String[] campos = linea.split(",");
            
                            if (esEncabezado) {
                                encabezado = campos;
                                esEncabezado = false;
                            } else {
                                System.out.println("----------------------------------------");
                                for (int i = 0; i < campos.length; i++) {
                                    System.out.println(encabezado[i] + ": " + campos[i]);
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    System.out.println("TOP 3 MEJORES LÍBEROS");

                    jugadores.clear();

                    try (BufferedReader br = new BufferedReader(new FileReader(archivosTorneo))) {
                        String linea;
                        boolean esEncabezado = true;
            
                        while ((linea = br.readLine()) != null) {
                            String[] campos = linea.split(",");
                            
                            if (esEncabezado) {
                                esEncabezado = false;
                            } else if(campos != null) {
                                    if (campos[2].equals("Libero")) {
                                        // Asignar variables a cada campo
                                        String nombre = campos[0];
                                        String pais = campos[1];
                                        int errores = Integer.parseInt(campos[3]);
                                        int aces = Integer.parseInt(campos[4]);
                                        int totalServicios = Integer.parseInt(campos[5]);
                                        int recibidosEfectivos = Integer.parseInt(campos[6]);
                                        
                                        Jugador x = new Libero(nombre, pais, errores, aces, totalServicios, recibidosEfectivos);
                                        jugadores.add(x);
                                    }
                                
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    Comparator<Jugador> comparadorEfectividad = Comparator.comparingInt(Jugador::getEfectividad);

                    Collections.sort(jugadores, comparadorEfectividad.reversed());

                    int numLiberos = 3;
                    for (int i = 0; i < numLiberos; i++) {
                        System.out.println("Top " + (i+1) +": " + jugadores.get(i).getNombre() + ", con efectividad de: " + jugadores.get(i).getEfectividad());
                    }

                    break;
                case 4:
                    System.out.println("PASADORES CON MAS DE 80% DE EFECTIVIDAD");
                    jugadores.clear();

                    try (BufferedReader br = new BufferedReader(new FileReader(archivosTorneo))) {
                        String linea;
                        boolean esEncabezado = true;
            
                        while ((linea = br.readLine()) != null) {
                            String[] campos = linea.split(",");
                            
                            if (esEncabezado) {
                                esEncabezado = false;
                            } else if(campos != null) {
                                    if (campos[2].equals("Pasador")) {
                                        // Asignar variables a cada campo
                                        String nombre = campos[0];
                                        String pais = campos[1];
                                        int errores = Integer.parseInt(campos[3]);
                                        int aces = Integer.parseInt(campos[4]);
                                        int totalServicios = Integer.parseInt(campos[5]);
                                        int pases = Integer.parseInt(campos[7]);
                                        int fintasEfectivas = Integer.parseInt(campos[8]);
                                        
                                        Jugador x = new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintasEfectivas);
                                        jugadores.add(x);
                                    }
                                
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(jugadores.isEmpty()){
                        System.out.println("No hay pasadores en la lista.");
                    }else{
                        for (Jugador jugador : jugadores) {
                            if(jugador.getEfectividad()>=80){
                                System.out.println("--> "+jugador.getNombre() + ", con efectividad de: " + jugador.getEfectividad());
                            }else{
                                System.out.println("Ninguno de los jugadores tiene más del 80% de efectividad");
                            }
                                
                        }
                    }
                    
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");


                    System.exit(0);

                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    
                    break;
            }
            
            continuar = volverAlMenu(scan," al menú? ",jugadores,archivosTorneo);
            

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

    private static void guardarDatos(ArrayList<Jugador> jugadores,File archivosTorneo){
        
                StringBuilder contenidoExistente = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new FileReader(archivosTorneo))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        contenidoExistente.append(linea).append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for(int i=0; i<jugadores.size(); i++){
                    contenidoExistente.append(jugadores.get(i).toString()).append("\n");

                    try (PrintWriter writer = new PrintWriter(new FileWriter(archivosTorneo))) {
                        writer.print(contenidoExistente.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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

    private static boolean volverAlMenu(Scanner scanner, String eleccion,ArrayList<Jugador> jugadores,File archivosTorneo) {
        System.out.println("¿Desea volver"+ eleccion+" (1: Sí, 0: No): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 0) {
            if(eleccion.equals(" al menú? ")){
                System.out.println("Saliendo del programa....");
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
