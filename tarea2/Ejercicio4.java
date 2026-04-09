import java.util.Stack;

// Crear una clase Pagina con atributos url y titulo
class Pagina {
    private String url;
    private String titulo;

    public Pagina(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Pagina{titulo='" + titulo + "', url='" + url + "'}";
    }
}

public class Ejercicio4 {
    public static void main(String[] args) {
        // Usar una pila para almacenar el historial de navegación
        Stack<Pagina> historial = new Stack<>();

        System.out.println("--- SIMULACIÓN DE NAVEGADOR ---");

        // Agregar 4 páginas visitadas con push() 
        historial.push(new Pagina("google.com", "Buscador"));
        historial.push(new Pagina("wikipedia.org", "Wikipedia"));
        historial.push(new Pagina("github.com", "GitHub"));
        historial.push(new Pagina("youtube.com", "YouTube"));
        
        System.out.println("Historial actual: " + historial);

        // Mostrar la página actual (peek())
        // peek() consulta el último elemento sin eliminarlo
        System.out.println("\nPagina actual (peek): " + historial.peek());

        // Permitir retroceder con pop() y mostrar la nueva página actual
        // pop() extrae y devuelve el objeto en la cima [cite: 63, 180]
        Pagina eliminada = historial.pop();
        System.out.println("\nRetrocediendo... Se cerró: " + eliminada);
        
        System.out.println("Nueva página actual: " + historial.peek());

        // Mostrar el estado del historial después de cada operación
        System.out.println("\nEstado final del historial: " + historial);
        System.out.println("Cantidad de páginas en historial: " + historial.size());
    }
}