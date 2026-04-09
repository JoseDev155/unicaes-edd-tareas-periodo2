package model;

public class Habitacion {
    private final int numero;
    private final String tipo;
    private final double precio;
    private final String estado; // "Disponible" o "Ocupada"

    public Habitacion(int numero, String tipo, double precio, String estado) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }
}