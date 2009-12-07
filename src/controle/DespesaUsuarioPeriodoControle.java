package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Despesa;
import modelo.DespesaUsuarioPeriodo;
import modelo.DespesaUsuarioPeriodoPK;
import modelo.Periodo;
import modelo.Usuario;
import util.UsuarioPeriodoDespesaTO;
import visao.CadastroDespesaUsuarioPeriodoTela;
import dao.DespesaDao;
import dao.DespesaPertenceUsuarioEmPeriodoDao;
import dao.PeriodoDao;
import dao.UsuarioDao;

public class DespesaUsuarioPeriodoControle implements ActionListener {

	CadastroDespesaUsuarioPeriodoTela vc;
	
	private static DespesaUsuarioPeriodoControle singleton=null;
	
	public static DespesaUsuarioPeriodoControle getInstance(){
		if(singleton==null){
			singleton= new DespesaUsuarioPeriodoControle();
		}
			return singleton;
	}
		
	private DespesaUsuarioPeriodoControle() {
	}
	
	public void configuraTela(CadastroDespesaUsuarioPeriodoTela vc){
		//logger.isDebugEnabled();
		this.vc=vc;
		//vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vc.configuraOuvinte(this);	
		vc.setResizable(false);
		vc.setLocationRelativeTo(null);
	}
		
	public void habilita(){
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("cadastrar")))
		{
			Usuario usuarioIntance = UsuarioDao.getUsuarioLogado();
			
			UsuarioPeriodoDespesaTO toDespesa = vc.leDadosUsuario();
			
			Despesa desp = (Despesa) DespesaDao.getInstance().buscarDespesaNome(toDespesa.getDespesa());
			
			Periodo p =formataComboPeriodo(toDespesa.getPeriodo());
			
			DespesaUsuarioPeriodoPK rPK = new DespesaUsuarioPeriodoPK();
			rPK.setPeriodo_id(p);
			rPK.setUsuario_id(usuarioIntance);
			rPK.setDespesa_id(desp);
			
			DespesaUsuarioPeriodo rUP = new DespesaUsuarioPeriodo();
			rUP.setChaveComposta(rPK);
			rUP.setInformacao(toDespesa.getInfoArea());
			rUP.setValor(toDespesa.getValorDespesa());
			
			DespesaPertenceUsuarioEmPeriodoDao.getInstance().salvar(rUP);
			
		}
		else if(comando.equals("retornar"))
		{
			
		}
	}
	
	public void populaComboDespesas(List<Despesa> despesa) {
		
		vc.populaComboDespesa(despesa);
	
	}

	public void populaComboPeriodo(Periodo p) {
	
		vc.populaComboPeriodo(p);
	
	}

	private Periodo formataComboPeriodo(String periodo){
	
		String periodoAnoAjustado [] = periodo.split(" - ");
		
		String mes = periodoAnoAjustado[0];
		String ano = periodoAnoAjustado[1];
		//Busca no banco de dados
		Periodo p = PeriodoDao.getInstance().buscarPeriodoMesAno(Integer.valueOf(mes), Integer.valueOf(ano));
		return p;
	}

}
