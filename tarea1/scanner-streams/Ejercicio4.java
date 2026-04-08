import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4 {
    static class Venta {
        String mes;
        double monto;

        public Venta(String mes, double monto) {
            this.mes = mes;
            this.monto = monto;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Venta[] ventas = new Venta[6]; // Forzamos 6 meses como pide el ejercicio

            for (int i = 0; i < 6; i++) {
                System.out.print("Mes " + (i + 1) + ": ");
                String mes = sc.next();
                System.out.print("Monto de venta: ");
                double monto = sc.nextDouble();
                ventas[i] = new Venta(mes, monto);
            }

            double sumaAltas = Arrays.stream(ventas)
                    .filter(v -> v.monto > 500)
                    .mapToDouble(v -> v.monto)
                    .sum();

            System.out.println("\nSuma total de ventas mayores a $500: $" + sumaAltas);
        }
    }
}