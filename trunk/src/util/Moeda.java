package util;
import java.text.DecimalFormat;
import java.util.Currency;

/**
 * @author Adriano Dadario
 */
public class Moeda {

    private static Currency currency = Currency.getInstance("BRL");
    private static DecimalFormat formato = new DecimalFormat("#,##0.00");
    private double valor;

    public Moeda(String valor) {
        this.valor = Double.parseDouble(valor.replaceAll("\\.", "").replaceAll(",", "."));
    }

    public Moeda(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return currency.getSymbol() + formato.format(valor);
    }

    public static void main(String[] args) {
        System.out.println(new Moeda(10.00));
        System.out.println(new Moeda("1.010,00"));
    }
}
