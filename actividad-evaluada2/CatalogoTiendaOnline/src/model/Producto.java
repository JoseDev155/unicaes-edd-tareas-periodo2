package model;

/**
 * Representa un producto en la tienda online.
 */
public class Producto {
    private final String nombre;
    private final double precio;
    private final int valoracion; // De 1 a 5
    private final String categoria;

    public Producto(String nombre, double precio, int valoracion, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.valoracion = Math.max(1, Math.min(5, valoracion)); // Asegura rango 1-5
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getValoracion() {
        return valoracion;
    }

    public String getCategoria() {
        return categoria;
    }
}
