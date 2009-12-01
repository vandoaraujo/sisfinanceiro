/**
 * 
 */
package util;

/**
 * Esta enumera��o armazena os meses do ano.
 * 
 * @author Italo Siqueira (italo.lima@previdencia.gov.br)
 *
 */
public enum MesEnum {

	
	/**
	 * M�s de Janeiro.
	 */
	janeiro(1, "Janeiro"),
	
	/**
	 * M�s de Fevereiro.
	 */
	fevereiro(2, "Fevereiro"),
	
	/**
	 * M�s de Mar�o.
	 */
	marco(3, "Mar�o"),
	
	/**
	 * M�s de Abril.
	 */
	abril(4, "Abril"),
	
	/**
	 * M�s de Maio.
	 */
	maio(5, "Maio"),
	
	/**
	 * M�s de Junho.
	 */
	junho(6, "Junho"),
	
	/**
	 * M�s de Julho.
	 */
	julho(7, "Julho"),
	
	/**
	 * M�s de Agosto.
	 */
	agosto(8, "Agosto"),
	
	/**
	 * M�s de Setembro.
	 */
	setembro(9, "Setembro"),
	
	/**
	 * M�s de Outubro.
	 */
	outubro(10, "Outubro"),
	
	/**
	 * M�s de Novembro.
	 */
	novembro(11, "Novembro"),
	
	/**
	 * M�s de Dezembro.
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
	 * Construtor padr�o tomando como par�metros um c�digo de identifica��o 
	 * e texto descritivo do m�s.
	 * 
	 * @param valor identificador num�rico do m�s.
	 * @param nome nome do m�s.
	 */
	private MesEnum(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}

	/**
	 * Recupera o c�digo de identifica��o do m�s.
	 * 
	 * @return c�digo num�rico do m�s.
	 */
	public int getValor(){
		return valor;
	}

	/**
	 * Recupera o texto descritivo do m�s.
	 * 
	 * @return <code>String</code> do m�s.
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Obt�m a inst�ncia de <code>MesEnum</code> 
	 * representanda pelo identificador especificado. Caso 
	 * o identificador n�o exista uma <code>IllegalArgumentException</code> 
	 * � disparada.
	 * 
	 * @param valor identificador num�rico do m�s.
	 * @return  inst�ncia de <code>MesEnum</code> com identificador igual a <code>valor</code>.
	 */
	public static MesEnum buscarPorValor(int valor){
		for (MesEnum mes : MesEnum.values()){
			if (mes.getValor() == valor){
				return mes;
			}
		}

		throw new IllegalArgumentException("A Enumera��o MesEnum n�o define esse valor!");
	}
	
}
