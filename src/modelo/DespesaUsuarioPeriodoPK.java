package modelo;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Embeddable
public class DespesaUsuarioPeriodoPK {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "despesa_id")
    @BatchSize(size=16)
    private Despesa despesa_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodo_id")
    @BatchSize(size=16)
    private Periodo periodo_id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @BatchSize(size=16) 
    private Usuario usuario_id;

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Despesa getDespesa_id() {
		return despesa_id;
	}

	public void setDespesa_id(Despesa despesa_id) {
		this.despesa_id = despesa_id;
	}

	public Periodo getPeriodo_id() {
		return periodo_id;
	}

	public void setPeriodo_id(Periodo periodo_id) {
		this.periodo_id = periodo_id;
	}
}
