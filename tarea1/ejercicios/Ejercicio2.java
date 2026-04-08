/*
 * Crear una clase Estudiante con los atributos: nombre y nota.
 * En el método main:
 * 1. Crear un arreglo con al menos 6 estudiantes con notas entre 0 y 10.
 * 2. Calcular el promedio de las notas del grupo.
 * 3. Mostrar cuáles estudiantes tienen nota mayor al promedio.
 * 4. Indicar cuántos estudiantes reprobaron (nota < 6).
 */

class Estudiante {
    String nombre;
    double nota;

    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        Estudiante[] estudiantes = {
            new Estudiante("Ana", 8.0),
            new Estudiante("Luis", 5.0),
            new Estudiante("Maria", 9.0),
            new Estudiante("Carlos", 6.0),
            new Estudiante("Sofia", 7.0),
            new Estudiante("Pedro", 4.0)
        };

        double sumaNotas = 0;
        for (Estudiante e : estudiantes) {
            sumaNotas += e.nota;
        }

        double promedio = sumaNotas / estudiantes.length;

        System.out.println("Promedio de notas: " + promedio);
        
        int cantidadReprobados = 0;
        String resultadoMax = "Los estuadiantes con nota mayor al promedio son:";

        for (Estudiante e : estudiantes) {
            if (e.nota > promedio) {
                resultadoMax += "\n" + e.nombre + " - " + e.nota;
            } else if (e.nota < promedio) {
                cantidadReprobados += 1;
            }
        }

        System.out.println("---------------");
        System.out.println(resultadoMax);
        System.out.println("---------------");
        System.out.println("Cantidad de estudiantes reprobados: " + cantidadReprobados);
    }
}
