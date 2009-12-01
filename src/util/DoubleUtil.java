package util;


@Deprecated
public class DoubleUtil {

	/**
	 * retorna valor Double truncado, definida precisão decimal
	 * 
	 * Ex.: Truncate(10.556, 2) = 10.55
	 * 
	 * @param valor
	 * @param precisao
	 * @return Double
	 */
	@Deprecated
	public static Double truncate(Double valor, int precisao) {

		return Math.floor(valor * Math.pow(10, precisao))
				/ Math.pow(10, precisao);

	}	


}
