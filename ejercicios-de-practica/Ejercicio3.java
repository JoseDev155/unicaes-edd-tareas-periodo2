import java.util.*;

class Paciente {
    int id;
    String nombre;
    int edad;
    int esperaMin;

    public Paciente(int id, String nombre, int edad, int esperaMin) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.esperaMin = esperaMin;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s (Espera: %d min)", id, nombre, esperaMin);
    }
}

public class Ejercicio3 {
    private static LinkedList<Paciente> colaPacientes = new LinkedList<>(); 
    private static Stack<String> historialAcciones = new Stack<>();

    public static void main(String[] args) {
        llegadaPaciente(new Paciente(101, "Roberto", 45, 20));
        llegadaPaciente(new Paciente(102, "Lucía", 30, 15));
        
        atenderPaciente();
        
        System.out.println("Estado de la cola: " + colaPacientes);
        deshacerAccion();
        System.out.println("Tras deshacer: " + colaPacientes);
    }

    public static void llegadaPaciente(Paciente p) {
        colaPacientes.offer(p); // Encolar
        historialAcciones.push("LLEGADA:" + p.id);
    }

    public static void atenderPaciente() {
        if (!colaPacientes.isEmpty()) {
            Paciente atendido = colaPacientes.poll(); // Desencolar
            System.out.println("Atendiendo a: " + atendido.nombre);
            historialAcciones.push("ATENCION:" + atendido.id);
        }
    }

    public static void deshacerAccion() {
        if (!historialAcciones.isEmpty()) {
            String ultima = historialAcciones.pop(); // Sacar última acción
            System.out.println("Deshaciendo: " + ultima);
            // Aquí se implementaría la lógica específica para devolver el paciente a la cola
        }
    }
}