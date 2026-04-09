import java.util.Stack;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Crear una pila de enteros donde el usuario agregue 5 números
        Stack<Integer> pilaNumeros = new Stack<>();

        pilaNumeros.push(1);
        pilaNumeros.push(2);
        pilaNumeros.push(3);
        pilaNumeros.push(4);
        pilaNumeros.push(5);

        // Mostrar el contenido completo de la pila
        System.out.println("Pila: " + pilaNumeros);

        // Extraer (pop) el último número y muéstralo
        System.out.println("pop(): " + pilaNumeros.pop());

        // Luego mostrar cómo queda la pila
        System.out.println("Pila final: " + pilaNumeros);
    }
}