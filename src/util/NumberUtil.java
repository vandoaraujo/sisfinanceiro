package util;

import java.math.BigDecimal;


public class NumberUtil {
	/**
	 * Retorna um {@link BigDecimal} com o valor truncado, de acordo com a
	 * precis�o informada no argumento <code>precisao</code>.
	 * 
	 * @param valor
	 *            valor a ser truncado.
	 * @param precisao
	 *            precis�o a ser aplicada.
	 * @return Um {@link BigDecimal} com o valor truncado.
	 */
	public static BigDecimal truncate(BigDecimal valor, int precisao) {
		if (valor != null) {
			return valor.setScale(precisao, BigDecimal.ROUND_FLOOR);
		}
		throw new IllegalArgumentException(
				"O argumento valor n�o pode ser nulo.");
	}

	/**
	 * Retorna um {@link BigDecimal} com o valor truncado, de acordo com a
	 * precis�o informada no argumento <code>precisao</code>.
	 * 
	 * @param valor
	 *            Valor a ser truncado, em double.
	 * @param precisao
	 *            precis�o a ser aplicada.
	 * @return
	 */
	public static BigDecimal truncate(Double valor, int precisao) {
		return truncate(new BigDecimal(valor), precisao);
	}
	/**
	 * Retorna um {@link Double} truncado, de acordo com a precis�o informada.
	 * @param precisao
	 * @param valor
	 * @return
	 */
	public static Double truncate(int precisao, Double valor){
		return truncate(valor, precisao).doubleValue();
	}

}
