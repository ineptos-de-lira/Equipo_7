import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ToDoListAppTest {

    @Test
    void agregarTarea_noPermiteVacia() {
        final List<String> tareas = new ArrayList<>();

        final boolean ok = ToDoListApp.agregarTarea(tareas, "   ");

        assertFalse(ok);
        assertEquals(0, tareas.size());
    }

    @Test
    void ordenarTareas_ordenaAlfabeticamenteSinImportarMayusculas() {
        final List<String> tareas = new ArrayList<>();
        tareas.add("zeta");
        tareas.add("Alfa");
        tareas.add("beta");

        ToDoListApp.ordenarTareas(tareas);

        assertEquals("Alfa", tareas.get(0));
        assertEquals("beta", tareas.get(1));
        assertEquals("zeta", tareas.get(2));
    }
    

    @Test
    void modificarTarea_modificaCorrectamente() {
        final List<String> tareas = new ArrayList<>();
        tareas.add("Barrer");
        tareas.add("Lavar");

        final boolean ok = ToDoListApp.modificarTarea(tareas, 2, "Cocinar");

        assertTrue(ok);
        assertEquals("Barrer", tareas.get(0));
        assertEquals("Cocinar", tareas.get(1));
    }

    @Test
    void modificarTarea_rechazaNumeroFueraDeRango() {
        final List<String> tareas = new ArrayList<>();
        tareas.add("Barrer");
        tareas.add("Lavar");

        final boolean ok = ToDoListApp.modificarTarea(tareas, 3, "Cocinar");

        assertFalse(ok);
        assertEquals("Barrer", tareas.get(0));
        assertEquals("Lavar", tareas.get(1));
    }
}