import java.util.LinkedList;
import java.util.Queue;

// Crear una clase Cliente con atributos nombre y turno
class Cliente {
    private String nombre;
    private int turno;

    public Cliente(String nombre, int turno) {
        this.nombre = nombre;
        this.turno = turno;
    }

    // toString para mostrar los datos del cliente fácilmente
    @Override
    public String toString() {
        return "Cliente{turno=" + turno + ", nombre='" + nombre + "'}";
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        // Usar una cola para almacenar los clientes en espera
        Queue<Cliente> colaBanco = new LinkedList<>();

        // Encolar 5 clientes con sus turnos
        colaBanco.offer(new Cliente("Ana", 1));
        colaBanco.offer(new Cliente("Luis", 2));
        colaBanco.offer(new Cliente("María", 3));
        colaBanco.offer(new Cliente("Carlos", 4));
        colaBanco.offer(new Cliente("Elena", 5));

        System.out.println("=== ESTADO INICIAL DE LA COLA ===");
        System.out.println(colaBanco);

        // Mostrar el primer cliente en la cola (peek())
        System.out.println("\n--- Consultando el frente ---");
        System.out.println("Siguiente en ser atendido (peek): " + colaBanco.peek());

        // Atender (poll) a los clientes uno por uno hasta que la cola esté vacía
        System.out.println("\n--- Iniciando atención (FIFO) ---");
        
        while (!colaBanco.isEmpty()) {
            // poll() extrae y devuelve el elemento al frente
            Cliente atendido = colaBanco.poll();
            
            System.out.println("Atendiendo a: " + atendido);
            // Mostrar en consola a cada cliente atendido y la cola después de cada atención
            System.out.println("Cola actual: " + (colaBanco.isEmpty() ? "VACÍA" : colaBanco));
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Atención finalizada. Todos los clientes han sido despachados.");
    }
}