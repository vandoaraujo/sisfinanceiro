package modelo;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class DespesaUsuarioPeriodoPK {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "despesa_id")
    private Despesa despesa_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "periodo_id")
    private Periodo periodo_id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Periodo usuario_id;

	public Periodo getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Periodo usuario_id) {
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
