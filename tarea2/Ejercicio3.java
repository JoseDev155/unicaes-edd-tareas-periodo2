import java.util.Stack;

// Crear una clase Libro con atributo título
class Libro {
    String titulo;

    Libro(String titulo) {
        this.titulo = titulo;
    }

    public String toString() {
        return titulo;
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        // Crear una pila y agrega 3 libros
        Stack<Libro> pilaLibros = new Stack<>();

        pilaLibros.push(new Libro("Luna de Plutón"));
        pilaLibros.push(new Libro("El Sembrador"));
        pilaLibros.push(new Libro("Harry Potter"));

        System.out.println("Pila: " + pilaLibros);
        
        // Mostrar el último libro agregado con peek()
        System.out.println("peek(): " + pilaLibros.peek());

        // Eliminar un libro con pop() y mostrar la pila final
        System.out.println("pop(): " + pilaLibros.pop());
        System.out.println("Pila final: " + pilaLibros);
    }
}
