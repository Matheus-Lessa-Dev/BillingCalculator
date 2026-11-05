import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        BillingCalculator calculator = new BillingCalculator();
        double resultado = calculator.calcular(1, new double[] {200.0, 100.0}, true);
        double esperado = 279.50;

        System.out.printf(Locale.US, "Valor retornado: %.2f%n", resultado);
        System.out.printf(Locale.US, "Valor esperado: %.2f%n", esperado);
        if (Math.abs(resultado - esperado) > 0.000001) {
            throw new AssertionError("O resultado difere do esperado.");
        }
        System.out.println("Resultado confere com o codigo legado.");
    }
}
