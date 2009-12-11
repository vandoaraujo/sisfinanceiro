package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceita;
	
	private String nomeReceita;
	
	public Receita(String nomeDespesa){
		
		this.nomeReceita = nomeReceita;
	}

	public int getId() {
		return idReceita;
	}

	public void setId(int id) {
		this.idReceita = id;
	}

	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

}
