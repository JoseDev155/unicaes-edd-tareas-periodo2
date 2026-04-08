import java.util.Arrays;
import java.util.Comparator;

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
        Venta[] ventas = {
            new Venta("Enero", 450.0), new Venta("Febrero", 620.0),
            new Venta("Marzo", 300.0), new Venta("Abril", 850.0),
            new Venta("Mayo", 150.0), new Venta("Junio", 720.0)
        };

        double total = Arrays.stream(ventas).mapToDouble(v -> v.monto).sum();
        
        // Suma filtrada
        double sumaAltas = Arrays.stream(ventas)
                .filter(v -> v.monto > 500)
                .mapToDouble(v -> v.monto)
                .sum();

        Venta maxVenta = Arrays.stream(ventas)
                .max(Comparator.comparingDouble(v -> v.monto))
                .get();

        System.out.println("Total: $" + total);
        System.out.println("Suma ventas > $500: $" + sumaAltas);
        System.out.println("Mes con mayor venta: " + maxVenta.mes);
    }
}