import java.util.ArrayList;
import java.util.Collections;
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
                   
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                        break;
                    }

                    ordenarTareas(tareas);

                    System.out.println("\n--- TAREAS ---");
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println((i + 1) + ". " + tareas.get(i));
                    }

                    System.out.print("Ingresa el número de la tarea a modificar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Entrada inválida. Ingresa un número: ");
                        scanner.nextLine();
                    }
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero < 1 || numero > tareas.size()) {
                        System.out.println("Número de tarea fuera de rango.");
                        break;
                    }

                    System.out.print("Escribe el nuevo texto de la tarea: ");
                    String nuevoTexto = scanner.nextLine().trim();

                    if (nuevoTexto.isEmpty()) {
                        System.out.println("El texto no puede estar vacío.");
                        break;
                    }

                    tareas.set(numero - 1, nuevoTexto);
                    System.out.println("Tarea modificada correctamente.");
                    break;

                case 3:
                    break;

                case 4:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas registradas.");
                        break;
                    }

                    ordenarTareas(tareas);

                    System.out.println("\n--- TAREAS ---");
                    for (int i = 0; i < tareas.size(); i++) {
                        System.out.println((i + 1) + ". " + tareas.get(i));
                    }
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

    public static void sortTasksAlphabetically(List<String> tareas) {
        ordenarTareas(tareas);
    }

    static boolean agregarTarea(List<String> tareas, String tarea) {
        if (tarea == null || tarea.trim().isEmpty()) {
            return false;
        }

        tareas.add(tarea.trim());
        return true;
    }

    static void ordenarTareas(List<String> tareas) {
        Collections.sort(tareas, String.CASE_INSENSITIVE_ORDER);
    }

    public static boolean modificarTarea(List<String> tareas, int i, String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarTarea'");
    }
}