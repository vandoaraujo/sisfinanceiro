/**
 * 
 */
package util;

/**
 * Esta enumera��o armazena os bimestres do ano. O c�digo 
 * de identifica��o dos bimestres � indicado pela sua posi��o 
 * no calend�rio. Deste modo, o primeiro bimestre (Janeiro e 
 * Fevereiro) possui identificador <code>01</code>, e assim 
 * por diante, at� <code>06</code> (Novembro e Dezembro).
*/
public enum BimestreEnum {
	
	/**
	 * Bimestre Janeiro/Fevereiro.
	 */
	janeiro_fevereiro(1, "Janeiro/Fevereiro"), 
	
	/**
	 * Bimestre Mar�o/Abril.
	 */
	marco_abril(2, "Mar�o/Abril"),
	
	/**
	 * Bimestre Maio/Junho.
	 */
	maio_junho(3,"Maio/Junho"),
	
	/**
	 * Bimestre Julho/Agosto.
	 */
	julho_agosto(4,"Julho/Agosto"),
	
	/**
	 * Bimestre Setembro/Outubro.
	 */
	setembro_outubro(5,"Setembro/Outubro"),
	
	/**
	 * Bimestre Novembro/Dezembro.
	 */
	novembro_dezembro(6,"Novembro/Dezembro");
	
	/**
	 * Representa o valor da enumeracao.
	 */
	private final int valor;
	
	/**
	 * Representa o nome da enumeracao.
	 */
	private final String nome;

	/**
	 * Construtor padr�o tomando como par�metros um c�digo de identifica��o 
	 * e texto descritivo do bimestre. O c�digo 
	 * de identifica��o dos bimestres � indicado pela sua posi��o 
	 * no calend�rio. Deste modo, o primeiro bimestre (Janeiro e 
	 * Fevereiro) possui identificador <code>01</code>, e assim 
	 * por diante, at� <code>06</code> (Novembro e Dezembro).
	 * 
	 * @param valor identificador do bimestre.
	 * @param nome descri��o dos meses do bimestre.
	 */
	private BimestreEnum(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}
	
	/**
	 * Recupera o c�digo de identifica��o do bimestre.
	 * 
	 * @return c�digo de identifica��o do bimestre.
	 */
	public int getValor(){
		return valor;
	}

	/**
	 * Recupera o texto descritivo do bimestre. O texto consiste 
	 * simplesmente nos meses que comp�em o bimestre separados por 
	 * uma <code>/</code>.
	 * 
	 * @return <code>String</code> do m�s.
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Obt�m a inst�ncia de <code>BimestreEnum</code> 
	 * representanda pelo identificador especificado. Caso 
	 * o identificador n�o exista uma <code>IllegalArgumentException</code> 
	 * � disparada.
	 * 
	 * @param valor identificador num�rico do bimestre.
	 * @return  inst�ncia de <code>BimestreEnum</code> com identificador igual a <code>valor</code>.
	 */
	public static BimestreEnum buscarPorValor(int valor){
		for (BimestreEnum bimestre : BimestreEnum.values()){
			if (bimestre.getValor() == valor){
				return bimestre;
			}
		}

		throw new IllegalArgumentException("A Enumera��o BimestreEnum n�o define esse valor!");
	}

	/**
	 * Obt�m a inst�ncia de <code>BimestreEnum</code> a partir de um m�s especificado. Caso 
	 * o identificador n�o exista uma <code>IllegalArgumentException</code> � disparada.
	 * 
	 * @param mes Enumera��o do Mes que se deseja saber o bimestre
	 * @return  inst�ncia de <code>BimestreEnum</code> com identificador igual a <code>valor</code>.
	 */
	public static BimestreEnum buscarPorMes(MesEnum mes){
		
		return BimestreEnum.buscarPorValor(((mes.getValor()+1)/2));

	}
	
	/**
	 * Retorna os meses do bimestre - posi��o 0 mes1, posi��o 1 mes2
	 * 
	 * @return int[] 
	 */
	public int[] mesBimestre(){
		
		int[] resultados = new int[2];
		
		resultados[0] = (this.getValor()*2)-1;
		resultados[1] = this.getValor()*2;
			
		return resultados;
	}
	
	/**
	 * Retorna o M�s do bimestre selecionado
	 * @param bimestre bimestre a ser encontrado 
	 * @param ordem m�s do bimestre a ser encontrado
	 * @return String o nome do m�s de acordo com os parametros
	 */
	public static String mesBimestre(Long bimestre, int ordem){
		
		if (bimestre == 1){
			if (ordem == 1){
				return "Janeiro";
			}else{
				return "Fevereiro";
			}
		}
		if (bimestre == 2){
			if (ordem == 1){
				return "Mar�o";
			}else{
				return "Abril";
			}
		}
		if (bimestre == 3){
			if (ordem == 1){
				return "Maio";
			}else{
				return "Junho";
			}
		}
		if (bimestre == 4){
			if (ordem == 1){
				return "Julho";
			}else{
				return "Agosto";
			}
		}
		if (bimestre == 5){
			if (ordem == 1){
				return "Setembro";
			}else{
				return "Outubro";
			}
		}
		if (bimestre == 6){
			if (ordem == 1){
				return "Novembro";
			}else{
				return "Dezembro";
			}
		}

		return "";
	}
	
	

}
