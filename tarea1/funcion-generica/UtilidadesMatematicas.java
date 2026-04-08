import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class UtilidadesMatematicas {

    /**
     * Clase interna para agrupar los resultados de las operaciones.
     */
    public static class Resultado {
        public double suma;
        public double promedio;
        public double maximo;
        public double minimo;

        @Override
        public String toString() {
            return String.format(
                "Estadísticas Generadas:\n" +
                "- Suma: %.2f\n" +
                "- Promedio: %.2f\n" +
                "- Máximo: %.2f\n" +
                "- Mínimo: %.2f", 
                suma, promedio, maximo, minimo
            );
        }
    }

    /**
     * Función genérica que recibe un arreglo de cualquier tipo numérico.
     * @param <T> Tipo que extiende de Number (Integer, Double, Long, etc.)
     * @param numeros Arreglo de elementos numéricos.
     * @return Objeto Resultado con los cálculos procesados.
     */
    public static <T extends Number> Resultado calcularTodo(T[] numeros) {
        Resultado res = new Resultado();

        if (numeros == null || numeros.length == 0) {
            return res;
        }

        // Usamos Streams para mapear a double y obtener estadísticas en un solo paso
        DoubleSummaryStatistics stats = Arrays.stream(numeros)
                .mapToDouble(Number::doubleValue)
                .summaryStatistics();

        // Asignación de valores basada en la lógica de los ejercicios anteriores
        res.suma = stats.getSum();           // Lógica de suma 
        res.promedio = stats.getAverage();   // Lógica de promedio 
        res.maximo = stats.getMax();         // Lógica de máximo
        res.minimo = stats.getMin();         // Lógica de mínimo

        return res;
    }

    public static void main(String[] args) {
        // Ejemplo 1: Arreglo de Enteros (Integer)
        Integer[] notas = {8, 10, 7, 9, 6};
        System.out.println("--- Procesando Integers ---");
        System.out.println(calcularTodo(notas));

        // Ejemplo 2: Arreglo de Decimales (Double)
        Double[] salarios = {1500.50, 2800.0, 1200.75, 3100.20};
        System.out.println("\n--- Procesando Doubles ---");
        System.out.println(calcularTodo(salarios));
    }
}