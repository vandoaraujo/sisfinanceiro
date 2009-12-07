package util;

import modelo.Receita;
import modelo.Usuario;

public class UsuarioPeriodoReceitaTO {
	
	private String receita;
	private double valorReceita;
	private String periodo;
	private String infoArea;
	
	
	public UsuarioPeriodoReceitaTO(double valorReceita,
			String receitaEscolhida, String periodo2, String infoArea2) {
		
		this.receita =receitaEscolhida;
		this.valorReceita = valorReceita;
		this.periodo = periodo2;
		this.infoArea = infoArea2;
		
	}
	
	public void setInfoArea(String infoArea) {
		this.infoArea = infoArea;
	}
	public String getInfoArea() {
		return infoArea;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
	public String getReceita() {
		return receita;
	}
	
	public Double getValorReceita() {
		return valorReceita;
	}

	public void setValorReceita(Double valorReceita) {
		this.valorReceita = valorReceita;
	}

}
