import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Crear una cola de tipo String para almacenar nombres de personas
        Queue<String> colaNombres = new LinkedList<>();

        // Encolar 4 nombres (ej. "Ana", "Luis", "Pedro", "María")
        colaNombres.offer("Ana");
        colaNombres.offer("Luis");
        colaNombres.offer("Pedro");
        colaNombres.offer("María");

        System.out.println("Cola: " + colaNombres);

        // Mostrar quién es el primero en la cola usando peek()
        System.out.println("peek(): " + colaNombres.peek());

        // Atender (poll) a la primera persona y muestra la cola fina
        System.out.println("poll(): " + colaNombres.poll());
        System.out.println("Cola final: " + colaNombres);
    }
}
