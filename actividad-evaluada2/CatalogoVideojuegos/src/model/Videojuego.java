package model;

public class Videojuego {
    private final String titulo;
    private final String consola;
    private final double precio;
    private final int calificacion; // Escala 1 a 10

    public Videojuego(String titulo, String consola, double precio, int calificacion) {
        this.titulo = titulo;
        this.consola = consola;
        this.precio = precio;
        this.calificacion = Math.max(1, Math.min(10, calificacion));
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConsola() {
        return consola;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCalificacion() {
        return calificacion;
    }
}