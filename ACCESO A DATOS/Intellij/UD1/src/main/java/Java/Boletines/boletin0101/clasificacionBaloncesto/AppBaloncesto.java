package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppBaloncesto{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EquipoFileDao equipoFileDao= new EquipoFileDao("ClasificacionBaloncesto.txt");
        List<Equipo>equipos= new ArrayList<>();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir equipo");
            System.out.println("2. Mostrar clasificación(Para realizar esta acción se requiere cargarla previamente)");
            System.out.println("3. Guardar clasificación");
            System.out.println("4. Cargar clasificación");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("Introduce nombre del equipo");
                    String eName= sc.nextLine();
                    System.out.println("Introduce la ciudad a la que pertenece el equipo");
                    String eCity= sc.nextLine();
                    System.out.println("Introduce número de victorias del equipo");
                    int numVic= sc.nextInt();
                    System.out.println("introduce número de derrotas del equipo");
                    int numDerr= sc.nextInt();
                    System.out.println("Introduce puntos a favor");
                    int puntFavor=sc.nextInt();
                    System.out.println("Introduce los puntos en contra");
                    int puntContra=sc.nextInt();

                    Equipo equipo= new Equipo(eName,eCity,numVic,numDerr,puntFavor,puntContra);
                    equipos.add(equipo);
                    equipoFileDao.save(equipo);

                }
                case 2 -> {
                    for (Equipo e:equipos){
                        System.out.println(e.toString());
                    }
                }
                case 3 -> {
                    equipoFileDao.saveAll(equipos);
                    if (equipoFileDao.saveAll(equipos)==true){
                        System.out.println("Equipos guardados con exito");
                    }else System.out.println("Error al guardar los equipos");
                }
                case 4 -> {
                    equipos=equipoFileDao.getAll();
                    if (equipos!=null){
                        System.out.println("Clasificación cargada con éxito! \n Ahora ya se puede mostrar");
                    }else System.out.println("No existen equipos");
                }
                case 5 -> {
                    System.out.println("Saliendo del programa...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida, por favor selecciona una opción válida.");
            }
        }
        sc.close();
    }
}