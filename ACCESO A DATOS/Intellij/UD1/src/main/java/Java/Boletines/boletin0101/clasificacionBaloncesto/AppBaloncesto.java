package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.util.List;
import java.util.Scanner;

public class AppBaloncesto{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EquipoFileDao equipoFileDao= new EquipoFileDao("ClasificacionBaloncesto.txt");
        List<Equipo>equipos=null;

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Añadir equipo");
            System.out.println("2. Mostrar clasificación");
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

                    equipoFileDao.save(equipo);

                }
                case 2 -> {
                   if (equipos.size()==0){
                       System.out.println("No se encontraron equipos en el archivo");
                   }else {
                       for (Equipo e:equipos){
                           System.out.println(e);
                       }
                   }
                }
                case 3 -> {
                    equipoFileDao.saveAll(equipos);
                }
                case 4 -> {
                    equipos=equipoFileDao.getAll();
                    System.out.println("Clasificación cargada con éxito! \n Ahora ya se puede mostrar");
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