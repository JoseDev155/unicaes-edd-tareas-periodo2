import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    static class Estudiante {
        String nombre;
        double nota;

        public Estudiante(String nombre, double nota) {
            this.nombre = nombre;
            this.nota = nota;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Cantidad de estudiantes: ");
            int n = sc.nextInt();
            Estudiante[] estudiantes = new Estudiante[n];

            for (int i = 0; i < n; i++) {
                sc.nextLine();
                System.out.print("Nombre del estudiante " + (i + 1) + ": ");
                String nombre = sc.nextLine();
                System.out.print("Nota (0-10): ");
                double nota = sc.nextDouble();
                estudiantes[i] = new Estudiante(nombre, nota);
            }

            double promedio = Arrays.stream(estudiantes).mapToDouble(e -> e.nota).average().orElse(0);
            System.out.println("\nPromedio general: " + promedio);

            System.out.println("Estudiantes por encima del promedio:");
            Arrays.stream(estudiantes)
                    .filter(e -> e.nota > promedio)
                    .forEach(e -> System.out.println("- " + e.nombre + ": " + e.nota));
        }
    }
}