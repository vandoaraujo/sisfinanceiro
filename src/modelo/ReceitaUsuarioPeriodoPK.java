package modelo;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.BatchSize;

@Embeddable
public class ReceitaUsuarioPeriodoPK {
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "receita_id")
    @BatchSize(size=16)
    private Receita receita_id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "periodo_id")
    @BatchSize(size=16)
    private Periodo periodo_id;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @BatchSize(size=16)
    private Usuario usuario_id;
    
	public Receita getReceita_id() {
		return receita_id;
	}

	public void setReceita_id(Receita receita_id) {
		this.receita_id = receita_id;
	}

	public Periodo getPeriodo_id() {
		return periodo_id;
	}

	public void setPeriodo_id(Periodo periodo_id) {
		this.periodo_id = periodo_id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}


}
