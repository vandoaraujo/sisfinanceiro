package modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DespesaUsuarioPeriodo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDespesaUsuarioPeriodo;

	@Embedded
    private DespesaUsuarioPeriodoPK chaveComposta;
    
    private double valor;
    
    private String informacao;

	public DespesaUsuarioPeriodoPK getChaveComposta() {
		return chaveComposta;
	}

	public void setChaveComposta(DespesaUsuarioPeriodoPK chaveComposta) {
		this.chaveComposta = chaveComposta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
		
    public int getId() {
		return idDespesaUsuarioPeriodo;
	}

	public void setId(int id) {
		this.idDespesaUsuarioPeriodo = id;
	}

	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}

	public String getInformacao() {
		return informacao;
	}

    
    

}
