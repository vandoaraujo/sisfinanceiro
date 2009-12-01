/**
 * 
 */
package util;

/**
 * Esta enumeração armazena os meses do ano.
 * 
 * @author Italo Siqueira (italo.lima@previdencia.gov.br)
 *
 */
public enum MesEnum {

	
	/**
	 * Mês de Janeiro.
	 */
	janeiro(1, "Janeiro"),
	
	/**
	 * Mês de Fevereiro.
	 */
	fevereiro(2, "Fevereiro"),
	
	/**
	 * Mês de Março.
	 */
	marco(3, "Março"),
	
	/**
	 * Mês de Abril.
	 */
	abril(4, "Abril"),
	
	/**
	 * Mês de Maio.
	 */
	maio(5, "Maio"),
	
	/**
	 * Mês de Junho.
	 */
	junho(6, "Junho"),
	
	/**
	 * Mês de Julho.
	 */
	julho(7, "Julho"),
	
	/**
	 * Mês de Agosto.
	 */
	agosto(8, "Agosto"),
	
	/**
	 * Mês de Setembro.
	 */
	setembro(9, "Setembro"),
	
	/**
	 * Mês de Outubro.
	 */
	outubro(10, "Outubro"),
	
	/**
	 * Mês de Novembro.
	 */
	novembro(11, "Novembro"),
	
	/**
	 * Mês de Dezembro.
	 */
	dezembro(12, "Dezembro");
	
	
	/**
	 * Representa o valor da enumeracao
	 */
	private final int valor;
	/**
	 * Representa o nome da enumeracao
	 */
	private final String nome;

	/**
	 * Construtor padrão tomando como parâmetros um código de identificação 
	 * e texto descritivo do mês.
	 * 
	 * @param valor identificador numérico do mês.
	 * @param nome nome do mês.
	 */
	private MesEnum(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}

	/**
	 * Recupera o código de identificação do mês.
	 * 
	 * @return código numérico do mês.
	 */
	public int getValor(){
		return valor;
	}

	/**
	 * Recupera o texto descritivo do mês.
	 * 
	 * @return <code>String</code> do mês.
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Obtém a instância de <code>MesEnum</code> 
	 * representanda pelo identificador especificado. Caso 
	 * o identificador não exista uma <code>IllegalArgumentException</code> 
	 * é disparada.
	 * 
	 * @param valor identificador numérico do mês.
	 * @return  instância de <code>MesEnum</code> com identificador igual a <code>valor</code>.
	 */
	public static MesEnum buscarPorValor(int valor){
		for (MesEnum mes : MesEnum.values()){
			if (mes.getValor() == valor){
				return mes;
			}
		}

		throw new IllegalArgumentException("A Enumeração MesEnum não define esse valor!");
	}
	
}
