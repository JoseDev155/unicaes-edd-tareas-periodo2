import java.util.Arrays;

// La clase Producto se mantiene igual
public class Ejercicio1 {
    static class Producto {
        String nombre;
        double precio;
        int cantidad;

        public Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
    }

    public static void main(String[] args) {
        Producto[] productos = {
            new Producto("Manzanas", 1.5, 10),
            new Producto("Bananas", 0.8, 20),
            new Producto("Naranjas", 1.2, 15),
            new Producto("Peras", 1.3, 12),
            new Producto("Uvas", 2.0, 8)
        };

        // Uso de Streams para el cálculo total
        double inventario = Arrays.stream(productos)
                .mapToDouble(p -> p.precio * p.cantidad)
                .sum();

        System.out.println("Valor total del inventario: $" + inventario);

        // Agregar producto (Mangos)
        Producto[] nuevosProductos = Arrays.copyOf(productos, productos.length + 1);
        nuevosProductos[nuevosProductos.length - 1] = new Producto("Mangos", 2.5, 5);

        double nuevoInventario = Arrays.stream(nuevosProductos)
                .mapToDouble(p -> p.precio * p.cantidad)
                .sum();

        System.out.println("Valor total del nuevo inventario: $" + nuevoInventario);
    }
}