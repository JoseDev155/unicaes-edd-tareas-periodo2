import java.util.Arrays;

public class Ejercicio5 {
    static class Curso {
        String nombre;
        double nota;
        int creditos;

        public Curso(String nombre, double nota, int creditos) {
            this.nombre = nombre;
            this.nota = nota;
            this.creditos = creditos;
        }
    }
    
    public static void main(String[] args) {
        Curso[] cursos = {
            new Curso("Matemáticas", 9.0, 4), new Curso("Historia", 7.0, 2),
            new Curso("Programación", 10.0, 5), new Curso("Física", 5.5, 3)
        };

        double simple = Arrays.stream(cursos).mapToDouble(c -> c.nota).average().orElse(0);
        
        // Promedio ponderado con Streams
        double sumaPonderada = Arrays.stream(cursos).mapToDouble(c -> c.nota * c.creditos).sum();
        int totalCreditos = Arrays.stream(cursos).mapToInt(c -> c.creditos).sum();
        double ponderado = sumaPonderada / totalCreditos;

        System.out.println("Promedio Simple: " + simple);
        System.out.println("Promedio Ponderado: " + ponderado);
        System.out.println("Estado: " + (ponderado >= 6 ? "APRUEBA" : "REPRUEBA"));
    }
}