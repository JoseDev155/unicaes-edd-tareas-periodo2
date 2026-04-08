/*
 * Crear una clase Empleado con los atributos: nombre y salario.
 * En el método main:
 * 1. Crear un arreglo con al menos 5 empleados.
 * 2. Encontrar e imprimir:
 *  o El empleado con el salario más alto.
 *  o El empleado con el salario más bajo.
 * 3. Calcular el promedio de salarios.
 * 4. Mostrar los empleados que ganan por encima del promedio.
 */

class Empleado {
    String nombre;
    double salario;

    Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Empleado[] empleados = {
            new Empleado("Ana", 25000),
            new Empleado("Luis", 32000),
            new Empleado("Maria", 28000),
            new Empleado("Carlos", 22000),
            new Empleado("Sofia", 35000)
        };

        Empleado maxEmpleado = empleados[0];
        Empleado minEmpleado = empleados[0];
        
        for (Empleado e : empleados) {
            if (e.salario > maxEmpleado.salario) {
                maxEmpleado = e;
            }
            if (e.salario < minEmpleado.salario) {
                minEmpleado = e;
            }
        }
        
        System.out.println("Empleado con salario más alto: " + maxEmpleado.nombre + " ($" + maxEmpleado.salario + ")");
        System.out.println("Empleado con salario más bajo: " + minEmpleado.nombre + " ($" + minEmpleado.salario + ")");

        double sumaSalarios = 0;
        for (Empleado e : empleados) {
            sumaSalarios += e.salario;
        }

        double promedio = sumaSalarios / empleados.length;
        System.out.println("---------------");
        System.out.println("Promedio de salarios: $" + promedio);

        String resultadoMax = "Los empleados con salarios mayor al promedio son:";

        for (Empleado e : empleados) {
            if (e.salario > promedio) {
                resultadoMax += "\n" + e.nombre + " - $" + e.salario;
            }
        }

        System.out.println("---------------");
        System.out.println(resultadoMax);
    }
}
