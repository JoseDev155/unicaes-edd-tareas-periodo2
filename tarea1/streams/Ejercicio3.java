import java.util.Arrays;
import java.util.Comparator;

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
        Empleado[] empleados = {
            new Empleado("Ana", 25000), new Empleado("Luis", 32000),
            new Empleado("Maria", 28000), new Empleado("Carlos", 22000),
            new Empleado("Sofia", 35000)
        };

        // Encontrar max y min
        Empleado maxEmp = Arrays.stream(empleados)
                .max(Comparator.comparingDouble(e -> e.salario))
                .orElse(empleados[0]);

        Empleado minEmp = Arrays.stream(empleados)
                .min(Comparator.comparingDouble(e -> e.salario))
                .orElse(empleados[0]);

        System.out.println("Salario más alto: " + maxEmp.nombre + " ($" + maxEmp.salario + ")");
        System.out.println("Salario más bajo: " + minEmp.nombre + " ($" + minEmp.salario + ")");

        // Promedio y filtrado
        double promedio = Arrays.stream(empleados).mapToDouble(e -> e.salario).average().orElse(0);
        System.out.println("Promedio de salarios: $" + promedio);

        System.out.println("Ganan por encima del promedio:");
        Arrays.stream(empleados)
                .filter(e -> e.salario > promedio)
                .forEach(e -> System.out.println(e.nombre));
    }
}