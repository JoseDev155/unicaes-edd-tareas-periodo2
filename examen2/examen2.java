import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * SECCION DE CLASES
 */

// Clase para registro de clientes
class Cliente {
    int id;
    String nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Método de presentación
    public String descripcion() {
        return nombre + " (ID " + id + ")";
    }
}

// Clase para manejo de prestamos
class Prestamo {
    Cliente cliente;
    Libro libro;
    LocalDate fechaSolicitud;

    public Prestamo(Cliente cliente, Libro libro) {
        this.cliente = cliente;
        this.libro = libro;
        this.fechaSolicitud = LocalDate.now();
    }

    // Método de presentación
    public String info() {
        return "\n -" + cliente.descripcion() + ", \"" + libro.titulo + "\" (" + fechaSolicitud + ")";
    }
}

// Clase para manejo del historial
class HistorialLectura {
    private Stack<Libro> pila = new Stack<>();

    // push
    public void leer(Libro l) {
        pila.push(l);
    }
    
    // peek
    public Libro ultimoLeido() {
        return pila.isEmpty() ? null : pila.peek();
    }
    
    // pop
    public Libro deshacerLectura() {
        return pila.isEmpty() ? null : pila.pop();
    }
    
    public boolean estaVacio() {
        return pila.isEmpty();
    }
    
    public int tamano() {
        return pila.size();
    }
}

class ColaPrestamos {
    private Queue<Prestamo> cola = new LinkedList<>();

    public void solicitarPrestamo(Cliente c, Libro l) {
        cola.offer(new Prestamo(c, l));
    }

    public Prestamo siguiente() {
        return cola.peek();
    }

    public Prestamo procesar() {
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public int tamano() {
        return cola.size();
    }
}

// Clase para manejo de libros
class Libro {
    int id;
    String titulo;
    int anio;
    double rating;
    String genero;
    int paginas;

    public Libro(int id, String titulo, int anio, double rating, String genero, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.rating = rating;
        this.genero = genero;
        this.paginas = paginas;
    }

    // Método de presentación
    public String descripcion() {
        return String.format("%02d - %s (%d) | rating=%.2f | genero=%s | paginas=%d",
                id, titulo, anio, rating, genero, paginas);
    }
}

/*
 * SECCION MAIN
 */

public class examen2 {
    // Ordenamiento por título, año, rating (asc/desc)
    public static void ordenar(Libro[] libros, String campo, boolean asc) {
        Comparator<Libro> comp;
        switch (campo.toLowerCase()) {
            case "titulo":
                comp = Comparator.comparing(l -> l.titulo.toLowerCase());
                break;
            case "anio":
            case "año":
                comp = Comparator.comparingInt(l -> l.anio);
                break;
            case "rating":
                comp = Comparator.comparingDouble(l -> l.rating);
                break;
            default:
                throw new IllegalArgumentException("Campo no soportado: " + campo);
        }
        if (!asc) comp = comp.reversed();
        Arrays.sort(libros, comp);
    }

    public static void main(String[] args) {
        Libro[] libros = {
            new Libro(1, "Cien años de soledad", 1967, 4.9, "Realismo mágico", 471),
            new Libro(2, "Don Quijote de la Mancha", 1605, 4.8, "Aventura", 863),
            new Libro(3, "El señor de los anillos", 1954, 4.7, "Fantasía", 1178),
            new Libro(4, "1984", 1949, 4.6, "Distopía", 328),
            new Libro(5, "Crimen y castigo", 1866, 4.5, "Drama", 671),
            new Libro(6, "Harry Potter y la piedra filosofal", 1997, 4.9, "Fantasía", 309),
            new Libro(7, "Los juegos del hambre", 2008, 4.3, "Ciencia ficción", 374),
            new Libro(8, "El código Da Vinci", 2003, 4.2, "Misterio", 489),
            new Libro(9, "It", 1986, 4.4, "Terror", 1138),
            new Libro(10, "Orgullo y prejuicio", 1813, 4.7, "Romance", 432)
        };

        // Calcular promedio de rating
        double sumaRatings = 0;
        for (Libro l : libros) {
            sumaRatings += l.rating;
        }
        double promedioRating = sumaRatings / libros.length;

        // Mostrar resultado
        System.out.println("Promedio general de rating: " + String.format("%.2f", promedioRating));

        // Buscar libro con rating máximo y mínimo
        Libro maxLibro = libros[0];
        Libro minLibro = libros[0];

        for (Libro l : libros) {
            if (l.rating > maxLibro.rating) {
                maxLibro = l;
            }
            if (l.rating < minLibro.rating) {
                minLibro = l;
            }
        }

        // Mostrar resultados
        System.out.println("--------------------------------------------");
        System.out.println("Libro con mayor rating:");
        System.out.println(maxLibro.descripcion());

        System.out.println("\nLibro con menor rating:");
        System.out.println(minLibro.descripcion());

        // Sumar páginas por género
        int totalFantasia = 0, totalDrama = 0, totalTerror = 0, totalAventura = 0,
        totalRomance = 0, totalMisterio = 0, totalDistopia = 0, totalCienciaFiccion = 0, totalRealismoMagico = 0;

        for (Libro l : libros) {
            switch (l.genero) {
                case "Fantasía":
                    totalFantasia += l.paginas;
                    break;
                case "Drama":
                    totalDrama += l.paginas;
                    break;
                case "Terror":
                    totalTerror += l.paginas;
                    break;
                case "Aventura":
                    totalAventura += l.paginas;
                    break;
                case "Romance":
                    totalRomance += l.paginas;
                    break;
                case "Misterio":
                    totalMisterio += l.paginas;
                    break;
                case "Distopía":
                    totalDistopia += l.paginas;
                    break;
                case "Ciencia ficción":
                    totalCienciaFiccion += l.paginas;
                    break;
                case "Realismo mágico":
                    totalRealismoMagico += l.paginas;
                    break;
            }
        }

        // Mostrar resultados
        System.out.println("--------------------------------------------");
        System.out.println("Total de páginas por género:");
        System.out.println("Realismo mágico: " + totalRealismoMagico);
        System.out.println("Aventura: " + totalAventura);
        System.out.println("Fantasía: " + totalFantasia);
        System.out.println("Distopía: " + totalDistopia);
        System.out.println("Drama: " + totalDrama);
        System.out.println("Ciencia ficción: " + totalCienciaFiccion);
        System.out.println("Misterio: " + totalMisterio);
        System.out.println("Terror: " + totalTerror);
        System.out.println("Romance: " + totalRomance);

        System.out.println("--------------------------------------------");
        System.out.println("Orden por título (ASC)");
        ordenar(libros, "titulo", true);
        for (Libro l : libros) {
            System.out.println(l.descripcion());
        }

        System.out.println("\nOrden por rating (DESC)");
        ordenar(libros, "rating", false);
        for (Libro l : libros) {
            System.out.println(l.descripcion());
        }

        // Cola de préstamos
        ColaPrestamos cola = new ColaPrestamos();
        Cliente ana = new Cliente(1, "Ana");
        Cliente bob = new Cliente(2, "Bob");
        cola.solicitarPrestamo(ana, libros[0]);
        cola.solicitarPrestamo(bob, libros[1]);

        System.out.println("--------------------------------------------");
        System.out.println("\nCola de préstamos");
        System.out.println("Pendientes: " + cola.tamano());
        Prestamo p1 = cola.siguiente();
        System.out.println("Siguiente: " + (p1 != null ? p1.info() : "Ninguno"));
        Prestamo pProc = cola.procesar();
        System.out.println("Procesando: " + (pProc != null ? pProc.info() : "Ninguno"));
        Prestamo p2 = cola.siguiente();
        System.out.println("Siguiente: " + (p2 != null ? p2.info() : "Ninguno"));
        System.out.println("Pendientes: " + cola.tamano());

        // Pila de historial de lectura
        HistorialLectura historial = new HistorialLectura();
        historial.leer(libros[2]);
        historial.leer(libros[4]);
        historial.leer(libros[6]);

        System.out.println("--------------------------------------------");
        System.out.println("\nHistorial de lectura (pila)");
        Libro u1 = historial.ultimoLeido();
        System.out.println("Último leído: " + (u1 != null ? u1.descripcion() : "Ninguno"));
        Libro desh = historial.deshacerLectura();
        System.out.println("Deshacer lectura: " + (desh != null ? desh.descripcion() : "Ninguno"));
        Libro u2 = historial.ultimoLeido();
        System.out.println("Último leído: " + (u2 != null ? u2.descripcion() : "Ninguno"));
        System.out.println("Items en historial: " + historial.tamano());
    }
}