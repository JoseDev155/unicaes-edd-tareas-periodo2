import java.util.*;

class Libro {
    int id;
    String titulo;
    int anio;
    double rating;

    public Libro(int id, String titulo, int anio, double rating) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return titulo + " (" + anio + ") - Rating: " + rating;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Libro> catalogo = new ArrayList<>();
        catalogo.add(new Libro(1, "Cien años de soledad", 1967, 4.8));
        catalogo.add(new Libro(2, "Don Quijote", 1605, 4.5));
        catalogo.add(new Libro(3, "Rayuela", 1963, 4.2));

        // Ordenamiento por Rating Descendente
        catalogo.sort((l1, l2) -> Double.compare(l2.rating, l1.rating));

        // Estructuras
        Queue<Libro> colaPrestamos = new LinkedList<>(); // FIFO
        Stack<Libro> historialLectura = new Stack<>();   // LIFO

        // Simular flujo
        colaPrestamos.offer(catalogo.get(0));
        historialLectura.push(catalogo.get(1));

        System.out.println("Próximo préstamo: " + colaPrestamos.peek()); // peek() mira frente
        System.out.println("Último libro leído: " + historialLectura.peek()); // peek() mira cima
    }
}