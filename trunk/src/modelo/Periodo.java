package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Periodo {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPeriodo;
	
	private int ano;
	
	private int mes;

	public int getId() {
		return idPeriodo;
	}

	public void setId(int id) {
		this.idPeriodo = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

}
