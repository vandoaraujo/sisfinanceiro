package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import util.BimestreEnum;;



/**
 * Essa classe fornece métodos utilitários para traduzir datas entre o formato
 * americano (yyyy-MM-dd) armazenado no Banco de Dados e o formato brasileiro
 * (dd/MM/yyyy) compreensível pelos usuários do sistema.
*/
public final class DateUtil {

	/**
	 * Expressão regular que representa uma data no formato utilizado no Brasil.
	 */
	private static final String ER_DATA_BRASILEIRA = "\\d\\d?/\\d\\d?/\\d\\d\\d\\d";

	/**
	 * Locale utilizado no Brasil.
	 */
	private static final Locale LOCALE_BRASIL = new Locale("pt", "BR");

	/**
	 * Máscara que representa uma data no formato utilizado no Brasil.
	 */
	private static final String MASCARA_DATA_BRASILEIRA = "dd/MM/yyyy";

	/**
	 * Máscara que representa uma data no formato utilizado no Brasil.
	 */
	private static final String MASCARA_EXTENSION_DATA_BRASILEIRA = "dd 'de' MMMM 'de' yyyy"; //$NON-NLS-1$

	/**
	 * Não é permitido instânciar esta classe.
	 */

		private DateUtil() {
		// Sem implementação.
	}

	/**
	 * Este método retorna um {@link BimestreEnum} conforme a data passada como
	 * parâmetro. Pode retornar <code>null</code> caso seja criado um novo
	 * valor estático na enumeração.
	 * 
	 * @param data - {@link Date} em que se deseja verificar o seu {@link BimestreEnum}.
	 * @return {@link BimestreEnum} em que a data está.
	 */
	public static BimestreEnum getBimestreEnum(Date data) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(data);

		if (calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.JANUARY || calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.FEBRUARY) {
			return BimestreEnum.janeiro_fevereiro;
		}
		else if (calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.MARCH || calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.APRIL) {
			return BimestreEnum.marco_abril;
		}
		else if (calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.MAY || calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.JUNE) {
			return BimestreEnum.maio_junho;
		}
		else if (calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.JULY || calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.AUGUST) {
			return BimestreEnum.julho_agosto;
		}
		else if (calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.SEPTEMBER || calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.OCTOBER) {
			return BimestreEnum.setembro_outubro;
		}
		else if (calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.NOVEMBER || calendar.get(GregorianCalendar.MONTH) == GregorianCalendar.DECEMBER) {
			return BimestreEnum.novembro_dezembro;
		}
		else {
			return null;
		}
	}
	
	/**
	 * Retorna a data atual de acordo com as configurações 
	 * locais.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getDataAtual() {
		return GregorianCalendar.getInstance(LOCALE_BRASIL).getTime();
	}
	
	/**
	 * Retorna o primeiro dia do mês atual.
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getDataInicioMes() {
		GregorianCalendar dtBase = (GregorianCalendar) GregorianCalendar.getInstance(LOCALE_BRASIL);
		dtBase.set(Calendar.DATE, 1);
		dtBase.set(Calendar.HOUR_OF_DAY, 0);
		dtBase.set(Calendar.MINUTE, 0);
		dtBase.set(Calendar.SECOND, 0);
		dtBase.set(Calendar.MILLISECOND, 0);
		return dtBase.getTime();
	}
	
	/**
	 * Método que verifica se uma data pertence a mesma competencia de um periodo.
	 * 
	 * @param dtAvaliada Data a ser comparada com o período
	 * @param dtIniComp Data inicial da competência
	 * @param dtFimComp Data Final da competência
	 * @return boolean retorna true se pertencer a competência avaliada
	 */
	public static boolean verificaDataNaCompetencia(Date dtAvaliada, Date dtIniComp, Date dtFimComp){
		
		boolean retorno = false;
		
		Calendar dataAvaliada = new GregorianCalendar();
		dataAvaliada.setTime(dtAvaliada);
		dataAvaliada.set(Calendar.DATE, 2);
		
		Calendar dataIniComp = new GregorianCalendar();
		dataIniComp.setTime(dtIniComp);
		dataIniComp.set(Calendar.DATE, 1);
		
		Calendar dataFimComp = new GregorianCalendar();
		dataFimComp.setTime(dtFimComp);
		dataFimComp.set(Calendar.DATE, 28);
		
		if ((dataAvaliada.after(dataIniComp)) && (dataAvaliada.before(dataFimComp)))  {
			retorno = true;
		}

		return retorno;
	}

	/**
	 * Retorna um objeto Calendar com a data atual sem considerar a hora.
	 * 
	 * @return instância de <code>Calendar</code>.
	 */
	public static Calendar getDataAtualSemHora(){
		
	    DateFormat formata = new SimpleDateFormat(MASCARA_DATA_BRASILEIRA, LOCALE_BRASIL);
		Calendar dataAtual = new GregorianCalendar();
		
		try {
			dataAtual.setTime(formata.parse(formata.format(new GregorianCalendar().getTime())));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dataAtual;
	}

	/**
	 * Esse método recebe um objeto <code>java.util.Date</code> que representa
	 * uma data e retorna a representação dessa data em String no formato de
	 * data utilizada no Brasil.
	 * 
	 * <BR />
	 * 
	 * <pre>
	 *  Ex.:
	 *  	18 de Janeiro de 2000
	 *  	27 de Dezembro de 2006
	 * </pre>
	 * 
	 * @return String representando a data no formato brasileiro [<b>dia</b>
	 *         de <b>mês</b> de <b>ano</b>]. Retorna <code>null</code> se a
	 *         data for <code>null</code>.
	 * @param data -
	 *            data a ser reformatada.
	 */
	public static String parseDate2ExtensionString(final Date data) {

		String retorno = null;
		if (data == null) {
			return retorno;
		}

		DateFormat df = new SimpleDateFormat(MASCARA_EXTENSION_DATA_BRASILEIRA, LOCALE_BRASIL);
		retorno = df.format(data);
		return retorno;
	}

	/**
	 * Esse método recebe um objeto <code>java.util.Date</code> representando
	 * uma data obtida no banco de dados e retorna a representação dessa data em
	 * String no formato de data utilizada no Brasil (dd/MM/yyyy).
	 * 
	 * @return String representando a data no formato brasileiro (dd/MM/yyyy).
	 *         Retorna <code>null</code> se a data for <code>null</code>.
	 * @param data -
	 *            data a ser reformatada.
	 */
	public static String parseDate2String(final Date data) {

		String retorno = null;

		if (data == null) {
			return retorno;
		}

		DateFormat df = new SimpleDateFormat(MASCARA_DATA_BRASILEIRA);
		retorno = df.format(data);

		return retorno;
	}

	/**
	 * Esse método recebe uma String representando uma data no formato utilizado
	 * no Brasil (dd/MM/yyyy) e retorna um objeto <code>java.util.Date</code>
	 * representativo dessa mesma data.
	 * 
	 * A informação de dia e mês pode conter um ou dois dígitos.
	 * 
	 * @return java.util.Date representando a data informada como String.
	 *         Retorna <code>null</code> se a data for <code>null</code>.
	 * @param data -
	 *            data a ser reformatada.
	 * @throw IllegalArgumentException - se a data não representar um formato de
	 *        datas utilizado no Brasil ou não representar uma data válida.
	 */
	public static Date parseString2Date(final String data) {

		Date retorno = null;

		if ((data == null) || (data.trim().equals(""))) {
			return retorno;
		}

		// validação do formato
		validarData(data);

		DateFormat df = new SimpleDateFormat(MASCARA_DATA_BRASILEIRA);
		df.setLenient(false);

		try {
			retorno = df.parse(data);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException("A data [" + data + "] não representa uma data válida!");
		}

		return retorno;
	}

	/**
	 * Esse método é utilizado para alterar uma data zerando suas horas, minutos
	 * e segundos. É útil quando se vai comparar datas sem levar em consideração
	 * as horas, minutos e segundos
	 * 
	 * @param calendario -
	 *            Intancia de <code>Calendar</code>.
	 * @return <code>Date</code> data com as horas zeradas.
	 */
	public static Date zeraHoras(final Calendar calendario) {

		calendario.set(Calendar.HOUR, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);

		Date data = calendario.getTime();

		return data;
	}

	/**
	 * Esse método verifica se a String representativa da data condiz com a
	 * expressão regular de datas no formato brasileiro (dd/MM/yyyy). As
	 * informações de dia e mês podem conter 1 ou 2 dígitos.
	 * 
	 * @param data -
	 *            data a ser validada.
	 * @throw IllegalArgumentException - se a data não representar um formato de
	 *        datas utilizado no Brasil.
	 */
	private static void validarData(final String data) {

		if (!Pattern.matches(ER_DATA_BRASILEIRA, data)) {
			throw new IllegalArgumentException("A data [" + data + "] não representa um formato válido!");
		}
	}
	
	/**
	 * retorna VERDADEIRO se "data1" for maior ou igual a "data2"
	 * caso a "data2" seja nula, então retornará FALSE
	 * caso a "data1" seja maior ou igual a "data2", então retornará FALSE
	 * 
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static Boolean maiorIgual(Date data1, Date data2){
		Boolean retorno = false;
		
		if (data1 == null) {
			return null;
		}
		if (data2 != null){
			String data1Str = parseDate2String(data1);
			String data2Str = parseDate2String(data2);
			
			data1=parseString2Date(data1Str);
			data2=parseString2Date(data2Str);
			
			if ( data1.equals(data2) || data1.after(data2)){
				retorno = true;
			}
		}
		
		return retorno;
		
	}
	
	/**
	 * retorna VERDADEIRO se "data1" for menor ou igual a "data2"
	 * caso a "data2" seja nula, então retornará FALSE
	 * caso a "data1" seja maior ou igual a "data2", então retornará FALSE
	 * 
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static Boolean menorIgual(Date data1, Date data2){
		Boolean retorno = false;
		
		if (data1 == null) {
			return null;
		}
		if (data2 != null){
			String data1Str = parseDate2String(data1);
			String data2Str = parseDate2String(data2);
			
			data1=parseString2Date(data1Str);
			data2=parseString2Date(data2Str);
			
			if ( data1.equals(data2) || data1.before(data2)){
				retorno = true;
			}
		}
		
		return retorno;
		
	}
	
	/**
	 * Retorna o primeiro dia do mês da data informada.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getDataPrimeiroDiaMesInformada(Date dtInformada) {
		
		GregorianCalendar dtBase = (GregorianCalendar) GregorianCalendar.getInstance(LOCALE_BRASIL);
		dtBase.setTime(dtInformada); 
		dtBase.set(Calendar.DATE, 1);
		
		return dtBase.getTime();
	}

	/**
	 * Retorna o primeiro dia do mês anterior da data informada.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 * 
	 * @author d331449 Eduardo Frtitzen
	 */
	public static Date getDataPrimeiroDiaMesAnteriorInformada(Date dtInformada) {
		
		GregorianCalendar dtBase = (GregorianCalendar) GregorianCalendar.getInstance(LOCALE_BRASIL);
		dtBase.setTime(dtInformada); 
		dtBase.set(Calendar.DATE, 1);
		dtBase.add(GregorianCalendar.MONTH, -1);
		
		return dtBase.getTime();
	}

	/**
	 * @author d331449 Eduardo Frtitzen
	 */
	public static boolean isDateBetween(Date dtEmQuestao, Date dtMin, Date dtMax) {			
		return dtEmQuestao.compareTo(dtMin) >= 0 && dtEmQuestao.compareTo(dtMax) <= 0;
	}
	
	
	/**
	 * Retorna o ultimo dia do mês da data informada.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	@SuppressWarnings("static-access")
	public static Date getDataUltimoDiaMesInformada(Date dtInformada) {
		
		GregorianCalendar dtBase = (GregorianCalendar) GregorianCalendar.getInstance(LOCALE_BRASIL);
		dtBase.setTime(dtInformada);
		dtBase.set(dtBase.DAY_OF_MONTH,1); // 1º dia do mes 01/07/09
		dtBase.add(dtBase.MONTH, 1); // incrimento de 1 mes 01/08/09
		dtBase.add(dtBase.DATE, -1); // decremento de um dia do mes 31/07/09
		dtBase.set(Calendar.HOUR, 0);
		dtBase.set(Calendar.MINUTE, 0);
		dtBase.set(Calendar.SECOND, 0);
		
		return dtBase.getTime();
	}

	/**
	 * Retorna o ultimo dia do mês anterior.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getDataUltimoDiaMesAnteriorInformado(Date dtInformada) {
		
		GregorianCalendar dtBase = (GregorianCalendar) GregorianCalendar.getInstance(LOCALE_BRASIL);
		dtBase.setTime(dtInformada);
		dtBase.set(Calendar.DATE, 1);
		dtBase.add(Calendar.DATE, -1);
		dtBase.set(Calendar.HOUR, 0);
		dtBase.set(Calendar.MINUTE, 0);
		dtBase.set(Calendar.SECOND, 0);
		
		return dtBase.getTime();
	}

	/**
	 * Retorna o ultimo dia do mês anterior.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getDataUltimoDiaMesAnterior() {
		
		GregorianCalendar dtBase = (GregorianCalendar) GregorianCalendar.getInstance(LOCALE_BRASIL);
		dtBase.set(Calendar.DATE, 1);
		dtBase.add(Calendar.DATE, -1);
		dtBase.set(Calendar.HOUR, 0);
		dtBase.set(Calendar.MINUTE, 0);
		dtBase.set(Calendar.SECOND, 0);
		
		return dtBase.getTime();
	}

	/**
	 * Retorna o primeiro dia do ano informado.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getPrimeiroDiaAno(Calendar dtBase) {

		GregorianCalendar dtResultado = (GregorianCalendar) dtBase;
		
		dtResultado.set(Calendar.DATE, 1);
		dtResultado.set(Calendar.MONTH, Calendar.JANUARY);
		dtResultado.set(Calendar.YEAR, dtBase.get(Calendar.YEAR));
		
		return dtResultado.getTime();

	}

	/**
	 * Retorna o último dia do ano informado.
	 * 
	 * @return objeto <code>Date</code> representando o valor da data.
	 */
	public static Date getUltimoDiaAno(Calendar dtBase) {

		GregorianCalendar dtResultado = (GregorianCalendar) dtBase;
		
		dtResultado.set(Calendar.DATE, 1);
		dtResultado.set(Calendar.MONTH, Calendar.DECEMBER);
		dtResultado.set(Calendar.YEAR, dtBase.get(Calendar.YEAR));
		return dtResultado.getTime();

	}
	/**
	 * Retorna o ano dia da data informada.
	 * 
	 * @return int 
	 */
	public static Integer getAno(Date dtInformada) {

		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(dtInformada);

		return calendar.get(Calendar.YEAR);
	}
	
	/**
	 * Retorna uma lista de anos dado uma data incial e final de um período
	 * 
	 * @return List<Integer> 
	 */
	public static List<Integer> getAnosPeriodo(Date dtInicialInformada, Date dtFinalInformada) {

		Calendar calendar1 = Calendar.getInstance();   
		Calendar calendar2 = Calendar.getInstance();   

		calendar1.setTime(dtInicialInformada);		
		calendar2.setTime(dtFinalInformada);
		
		int anoInicialPeriodo = calendar1.get(Calendar.YEAR);
		int anoFinalPerido = calendar2.get(Calendar.YEAR);
		
		List<Integer> anosPeriodo = new ArrayList<Integer>();
		
		for (int i = anoInicialPeriodo; i <= anoFinalPerido; i++) {
			anosPeriodo.add(i);
		}
		
		return anosPeriodo;
	}
	
	/**
	 * Retorna o mes da data informada.
	 * 
	 * @return int 
	 */
	public static Integer getMes(Date dtInformada) {

		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(dtInformada);

		return calendar.get(Calendar.MONTH);
	}
	
	/**
	 * Retorna o dia da data informada.
	 * 
	 * @return int 
	 */
	public static Integer getDia(Date dtInformada) {

		Calendar calendar = Calendar.getInstance();   
		calendar.setTime(dtInformada);

		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
}