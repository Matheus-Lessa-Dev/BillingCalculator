public class BillingCalculator {
    private static final int CONVENIO = 1;
    private static final int PARTICULAR = 2;
    private static final double DESCONTO_CONVENIO = 0.12;
    private static final double DESCONTO_PARTICULAR = 0.05;
    private static final double LIMITE_DESCONTO_PARTICULAR = 500.00;
    private static final double TAXA_EXTRA = 15.50;

    public double calcular(int tipoConsulta, double[] valoresProcedimentos,
                           boolean aplicarTaxaExtra) {
        double subtotal = somarProcedimentos(valoresProcedimentos);

        if (tipoConsulta == CONVENIO) {
            return calcularConvenio(subtotal, aplicarTaxaExtra);
        }
        if (tipoConsulta == PARTICULAR) {
            return calcularParticular(subtotal);
        }
        return subtotal;
    }

    private double somarProcedimentos(double[] valoresProcedimentos) {
        double soma = 0;
        for (double valor : valoresProcedimentos) {
            soma += valor;
        }
        return soma;
    }

    private double calcularConvenio(double subtotal, boolean aplicarTaxaExtra) {
        double total = subtotal - (subtotal * DESCONTO_CONVENIO);
        if (aplicarTaxaExtra) {
            total += TAXA_EXTRA;
        }
        return total;
    }

    private double calcularParticular(double subtotal) {
        if (subtotal > LIMITE_DESCONTO_PARTICULAR) {
            return subtotal - (subtotal * DESCONTO_PARTICULAR);
        }
        return subtotal;
    }
}