package modelo;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReceitaUsuarioPeriodo {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceitaUsuarioPeriodo;
	
    @Embedded
    private ReceitaUsuarioPeriodoPK chaveComposta;
    
    private String informacao;
    
	private Double valor;
    
    public int getId() {
		return idReceitaUsuarioPeriodo;
	}

	public void setId(int id) {
		this.idReceitaUsuarioPeriodo = id;
	}

	public ReceitaUsuarioPeriodoPK getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(ReceitaUsuarioPeriodoPK chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getInformacao() {
		return informacao;
	}



}
