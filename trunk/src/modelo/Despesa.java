package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Despesa {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDespesa;
	
	private String nomeDespesa;
	
	private boolean despesaFixa;
	
	public Despesa(boolean b, String nomeDespesa){
		this.despesaFixa = b;
		this.nomeDespesa = nomeDespesa;
	}
	
	public Despesa(){
		
	}

	public int getId() {
		return idDespesa;
	}

	public void setId(int id) {
		this.idDespesa = id;
	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}

	public void setDespesaFixa(boolean despesaFixa) {
		this.despesaFixa = despesaFixa;
	}

	public boolean isDespesaFixa() {
		return despesaFixa;
	}

}
