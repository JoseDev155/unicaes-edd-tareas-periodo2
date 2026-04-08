/*
* Crear una clase Curso con los atributos: nombre, nota y creditos.
* En el método main:
* 1. Crear un arreglo con al menos 4 cursos.
* 2. Calcular el promedio simple de notas.
* 3. Calcular el promedio ponderado de notas, tomando en cuenta los créditos.
* 4. Mostrar un mensaje indicando si el estudiante aprueba o reprueba (promedio ≥ 6).
*/

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
        // 1. Crear un arreglo con al menos 4 cursos
        Curso[] cursos = {
            new Curso("Matemáticas", 9.0, 4),
            new Curso("Historia", 7.0, 2),
            new Curso("Programación", 10.0, 5),
            new Curso("Física", 5.5, 3)
        };
        
        double sumaNotasSimples = 0;
        double sumaNotasPorCreditos = 0;
        int sumaCreditos = 0;
        
        for (Curso c : cursos) {
            sumaNotasSimples += c.nota;
            sumaNotasPorCreditos += c.nota * c.creditos;
            sumaCreditos += c.creditos;
        }

        // 2. Calcular promedio simple de notas
        double promedioSimple = sumaNotasSimples / cursos.length;

        // 3. Calcular el promedio ponderado de notas, tomando en cuenta los créditos
        double promedioPonderado = sumaNotasPorCreditos / sumaCreditos;

        System.out.println("Resultados Académicos:");
        System.out.println("- Promedio Simple: " + promedioSimple);
        System.out.println("- Promedio Ponderado: " + promedioPonderado);

        // 4. Mostrar un mensaje indicando si el estudiante aprueba o reprueba (promedio ≥ 6)
        if (promedioPonderado >= 6) {
            System.out.println("Estado: EL ESTUDIANTE APRUEBA");
        } else {
            System.out.println("Estado: EL ESTUDIANTE REPRUEBA");
        }
    }
}