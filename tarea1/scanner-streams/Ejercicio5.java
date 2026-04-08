import java.util.Arrays;
import java.util.Scanner;

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
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("¿Cuántos cursos desea registrar? ");
            int n = sc.nextInt();
            Curso[] cursos = new Curso[n];

            for (int i = 0; i < n; i++) {
                sc.nextLine();
                System.out.println("Curso " + (i + 1));
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Nota: ");
                double nota = sc.nextDouble();
                System.out.print("Créditos: ");
                int creditos = sc.nextInt();
                cursos[i] = new Curso(nombre, nota, creditos);
            }

            int totalCreditos = Arrays.stream(cursos).mapToInt(c -> c.creditos).sum();
            double sumaPonderada = Arrays.stream(cursos).mapToDouble(c -> c.nota * c.creditos).sum();
            double finalPonderado = sumaPonderada / totalCreditos;

            System.out.println("\nPromedio Ponderado Final: " + finalPonderado);
            System.out.println("Resultado: " + (finalPonderado >= 6 ? "APROBADO" : "REPROBADO"));
        }
    }
}