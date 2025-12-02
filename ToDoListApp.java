import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListApp {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final List<String> tareas = new ArrayList<>();

        int opcion = -1;

        do {
            System.out.println("\n=========================");
            System.out.println("        TO-DO LIST         ");
            System.out.println("===========================");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Modificar tarea");
            System.out.println("3. Eliminar tarea ");
            System.out.println("4. Mostrar tareas");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.print("Entrada inválida. Ingresa un número (0-4): ");
                    scanner.nextLine();
                    continue;
                }

                opcion = scanner.nextInt();

                if (opcion < 0 || opcion > 4) {
                    System.out.print("Opción fuera de rango. Ingresa un número (0-4): ");
                    continue;
                }

                break;
            }

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Escribe la nueva tarea: ");
                    String nuevaTarea = scanner.nextLine().trim();

                    if (nuevaTarea.isEmpty()) {
                        System.out.println("No puedes agregar una tarea vacía.");
                    } else {
                        tareas.add(nuevaTarea);
                        System.out.println("Tarea agregada: " + nuevaTarea);
                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 0:
                    System.out.println("Saliendo del sistema. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }

        } while (opcion != 0);

        scanner.close();
    }
}
