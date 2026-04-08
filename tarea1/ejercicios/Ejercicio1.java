/*
 * Crear una clase Producto con los atributos: nombre, precio y cantidad
 * En el método main:
 * 1. Crear un arreglo con al menos 5 productos
 * 2. Calcular y mostrar:
 *  o El valor total de cada producto (precio * cantidad)
 *  o El valor total del inventario (suma de todos los productos)
 * 3. Agregar un producto nuevo al arreglo y vuelve a calcular el total. 
 */

import java.util.Arrays;

class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}


public class Ejercicio1 {
    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Manzanas", 1.5, 10),
            new Producto("Bananas", 0.8, 20),
            new Producto("Naranjas", 1.2, 15),
            new Producto("Peras", 1.3, 12),
            new Producto("Uvas", 2.0, 8)
        };

        double inventario = 0;

        for (Producto p : productos) {
            inventario += p.precio * p.cantidad;
        }

        System.out.println("Valor total del inventario: $" + inventario);

        Producto[] nuevosProductos = Arrays.copyOf(
            productos, productos.length + 1
            );
        nuevosProductos[nuevosProductos.length - 1] = new Producto("Mangos", 2.5, 5);

        double nuevoInventario = 0;
        for (Producto p : nuevosProductos) {
            nuevoInventario += p.precio * p.cantidad;
        }

        System.out.println("Valor total del nuevo inventario: $" + nuevoInventario);
    }
}