import java.util.Arrays;
import java.util.Scanner;

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
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("¿Cuántos productos desea ingresar? ");
            int n = sc.nextInt();
            Producto[] productos = new Producto[n];

            for (int i = 0; i < n; i++) {
                sc.nextLine(); // Limpiar buffer
                System.out.println("Producto " + (i + 1));
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Precio: ");
                double precio = sc.nextDouble();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                productos[i] = new Producto(nombre, precio, cantidad);
            }

            double inventario = Arrays.stream(productos)
                    .mapToDouble(p -> p.precio * p.cantidad)
                    .sum();

            System.out.println("\nValor total del inventario: $" + inventario);
        }
    }
}