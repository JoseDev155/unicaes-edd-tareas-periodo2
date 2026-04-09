import java.util.*;

class Alumno {
    int id;
    String nombre;
    int edad;
    double nota;
    String materia;

    public Alumno(int id, String nombre, int edad, double nota, String materia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
        this.materia = materia;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | Nota: %.1f", id, nombre, nota);
    }
}

public class Ejercicio1 {
    private static List<Alumno> listaAlumnos = new ArrayList<>();
    private static Stack<List<Alumno>> historialUndo = new Stack<>(); // Pila para LIFO
    private static Queue<String> notificaciones = new LinkedList<>(); // Cola para FIFO

    public static void main(String[] args) {
        agregarAlumno(new Alumno(1, "Carlos", 20, 8.5, "Programación"));
        agregarAlumno(new Alumno(2, "Ana", 22, 9.0, "Bases de Datos"));
        agregarAlumno(new Alumno(3, "Luis", 19, 5.5, "Sistemas"));

        System.out.println("Promedio: " + calcularPromedio());
        
        // Simular deshacer
        System.out.println("\n--- Deshaciendo última adición ---");
        deshacer();
        
        // Procesar notificaciones
        System.out.println("\n--- Notificaciones Pendientes ---");
        while (!notificaciones.isEmpty()) {
            System.out.println("Mensaje: " + notificaciones.poll()); // poll() para FIFO
        }
    }

    public static void agregarAlumno(Alumno a) {
        // Guardar estado para deshacer
        historialUndo.push(new ArrayList<>(listaAlumnos)); // push() para LIFO
        listaAlumnos.add(a);
        notificaciones.offer("Se agregó al alumno: " + a.nombre); // offer() para FIFO
    }

    public static void deshacer() {
        if (!historialUndo.isEmpty()) {
            listaAlumnos = historialUndo.pop(); // pop() extrae la cima
            System.out.println("Estado restaurado.");
        }
    }

    public static double calcularPromedio() {
        return listaAlumnos.stream().mapToDouble(a -> a.nota).average().orElse(0.0);
    }
}