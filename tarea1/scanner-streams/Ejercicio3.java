import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ejercicio3 {
    static class Empleado {
        String nombre;
        double salario;

        public Empleado(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Número de empleados: ");
            int n = sc.nextInt();
            Empleado[] empleados = new Empleado[n];

            for (int i = 0; i < n; i++) {
                sc.nextLine();
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Salario: ");
                double salario = sc.nextDouble();
                empleados[i] = new Empleado(nombre, salario);
            }

            Empleado max = Arrays.stream(empleados).max(Comparator.comparingDouble(e -> e.salario)).get();
            Empleado min = Arrays.stream(empleados).min(Comparator.comparingDouble(e -> e.salario)).get();

            System.out.println("\nEmpleado con mayor sueldo: " + max.nombre + " ($" + max.salario + ")");
            System.out.println("Empleado con menor sueldo: " + min.nombre + " ($" + min.salario + ")");
        }
    }
}