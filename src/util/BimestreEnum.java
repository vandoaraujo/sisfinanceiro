/**
 * 
 */
package util;

/**
 * Esta enumeração armazena os bimestres do ano. O código 
 * de identificação dos bimestres é indicado pela sua posição 
 * no calendário. Deste modo, o primeiro bimestre (Janeiro e 
 * Fevereiro) possui identificador <code>01</code>, e assim 
 * por diante, até <code>06</code> (Novembro e Dezembro).
*/
public enum BimestreEnum {
	
	/**
	 * Bimestre Janeiro/Fevereiro.
	 */
	janeiro_fevereiro(1, "Janeiro/Fevereiro"), 
	
	/**
	 * Bimestre Março/Abril.
	 */
	marco_abril(2, "Março/Abril"),
	
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
	 * Construtor padrão tomando como parâmetros um código de identificação 
	 * e texto descritivo do bimestre. O código 
	 * de identificação dos bimestres é indicado pela sua posição 
	 * no calendário. Deste modo, o primeiro bimestre (Janeiro e 
	 * Fevereiro) possui identificador <code>01</code>, e assim 
	 * por diante, até <code>06</code> (Novembro e Dezembro).
	 * 
	 * @param valor identificador do bimestre.
	 * @param nome descrição dos meses do bimestre.
	 */
	private BimestreEnum(int valor, String nome){
		this.valor = valor;
		this.nome = nome;
	}
	
	/**
	 * Recupera o código de identificação do bimestre.
	 * 
	 * @return código de identificação do bimestre.
	 */
	public int getValor(){
		return valor;
	}

	/**
	 * Recupera o texto descritivo do bimestre. O texto consiste 
	 * simplesmente nos meses que compõem o bimestre separados por 
	 * uma <code>/</code>.
	 * 
	 * @return <code>String</code> do mês.
	 */
	public String getNome(){
		return nome;
	}

	/**
	 * Obtém a instância de <code>BimestreEnum</code> 
	 * representanda pelo identificador especificado. Caso 
	 * o identificador não exista uma <code>IllegalArgumentException</code> 
	 * é disparada.
	 * 
	 * @param valor identificador numérico do bimestre.
	 * @return  instância de <code>BimestreEnum</code> com identificador igual a <code>valor</code>.
	 */
	public static BimestreEnum buscarPorValor(int valor){
		for (BimestreEnum bimestre : BimestreEnum.values()){
			if (bimestre.getValor() == valor){
				return bimestre;
			}
		}

		throw new IllegalArgumentException("A Enumeração BimestreEnum não define esse valor!");
	}

	/**
	 * Obtém a instância de <code>BimestreEnum</code> a partir de um mês especificado. Caso 
	 * o identificador não exista uma <code>IllegalArgumentException</code> é disparada.
	 * 
	 * @param mes Enumeração do Mes que se deseja saber o bimestre
	 * @return  instância de <code>BimestreEnum</code> com identificador igual a <code>valor</code>.
	 */
	public static BimestreEnum buscarPorMes(MesEnum mes){
		
		return BimestreEnum.buscarPorValor(((mes.getValor()+1)/2));

	}
	
	/**
	 * Retorna os meses do bimestre - posição 0 mes1, posição 1 mes2
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
	 * Retorna o Mês do bimestre selecionado
	 * @param bimestre bimestre a ser encontrado 
	 * @param ordem mês do bimestre a ser encontrado
	 * @return String o nome do mês de acordo com os parametros
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
				return "Março";
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
