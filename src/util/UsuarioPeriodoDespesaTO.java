package util;

public class UsuarioPeriodoDespesaTO {
	
	private String despesa;
	private double valorDespesa;
	private String periodo;
	private String infoArea;
	
	public String getDespesa() {
		return despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public double getValorDespesa() {
		return valorDespesa;
	}

	public void setValorDespesa(double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getInfoArea() {
		return infoArea;
	}

	public void setInfoArea(String infoArea) {
		this.infoArea = infoArea;
	}

	public UsuarioPeriodoDespesaTO(double valorDespesa,
			String despesaEscolhida, String periodo, String infoArea) {
		this.despesa = despesaEscolhida;
		this.valorDespesa = valorDespesa;
		this.periodo = periodo;
		this.infoArea = infoArea;
		
	}

}
