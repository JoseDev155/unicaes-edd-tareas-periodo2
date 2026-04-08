/*
 * Crear una clase Venta con los atributos: mes y monto.
 * En el método main:
 * 1. Crear un arreglo con las ventas de al menos 6 meses.
 * 2. Calcular la suma total de ventas.
 * 3. Calcular la suma de ventas que superen los $500.
 * 4. Mostrar el mes con mayores ventas.
 */

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
        // 1. Crear un arreglo con las ventas de al menos 6 meses
        Venta[] ventas = {
            new Venta("Enero", 450.0),
            new Venta("Febrero", 620.0),
            new Venta("Marzo", 300.0),
            new Venta("Abril", 850.0),
            new Venta("Mayo", 150.0),
            new Venta("Junio", 720.0)
        };

        double sumaTotal = 0;
        double sumaMayores500 = 0;
        
        Venta maxVenta = ventas[0];
        
        for (Venta v : ventas) {
            // 2. Calcular la suma total de ventas
            sumaTotal += v.monto;

            // 3. Calcular la suma de ventas que superen los $500
            if (v.monto > 500) {
                sumaMayores500 += v.monto;
            }

            // 4. Mostrar el mes con mayores ventas
            if (v.monto > maxVenta.monto) {
                maxVenta = v;
            }
        }

        System.out.println("1. Suma total de ventas: $" + sumaTotal);
        System.out.println("2. Suma de ventas que superan los $500: $" + sumaMayores500);
        System.out.println("3. Mes con mayores ventas: " + maxVenta.mes + " ($" + maxVenta.monto + ")");
    }
}
