package util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class MoedaUtil {
    private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

	public static String format(Double valor){
		String valueStr = currencyFormatter.format(valor);
		
		DecimalFormat decimalCurrencyFormatter = null;
		
		if(currencyFormatter instanceof DecimalFormat) {
			decimalCurrencyFormatter = (DecimalFormat) currencyFormatter;
		}
		
		final String currencySymbolStr = 
			decimalCurrencyFormatter.getDecimalFormatSymbols().getCurrencySymbol();
		            
        return valueStr.split(Pattern.quote(currencySymbolStr))[1].trim();
	}
}
