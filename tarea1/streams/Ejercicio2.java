import java.util.Arrays;

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
        Estudiante[] estudiantes = {
            new Estudiante("Ana", 8.0), new Estudiante("Luis", 5.0),
            new Estudiante("Maria", 9.0), new Estudiante("Carlos", 6.0),
            new Estudiante("Sofia", 7.0), new Estudiante("Pedro", 4.0)
        };

        // Calcular promedio con average()
        double promedio = Arrays.stream(estudiantes)
                .mapToDouble(e -> e.nota)
                .average()
                .orElse(0.0);

        System.out.println("Promedio de notas: " + promedio);

        // Filtrar estudiantes por encima del promedio
        System.out.println("Estudiantes con nota mayor al promedio:");
        Arrays.stream(estudiantes)
                .filter(e -> e.nota > promedio)
                .forEach(e -> System.out.println(e.nombre + " - " + e.nota));

        // Contar reprobados (< 6)
        long reprobados = Arrays.stream(estudiantes)
                .filter(e -> e.nota < 6)
                .count();

        System.out.println("Cantidad de estudiantes reprobados: " + reprobados);
    }
}