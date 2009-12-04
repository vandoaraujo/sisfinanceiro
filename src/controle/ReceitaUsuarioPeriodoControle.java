package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Periodo;
import modelo.Receita;
import modelo.ReceitaUsuarioPeriodo;
import modelo.ReceitaUsuarioPeriodoPK;
import modelo.Usuario;
import visao.CadastroReceitaUsuarioPeriodoTela;
import dao.PeriodoDao;
import dao.ReceitaDao;
import dao.ReceitaPertenceUsuarioEmPeriodoDao;
import dao.UsuarioDao;

public class ReceitaUsuarioPeriodoControle implements ActionListener {

	CadastroReceitaUsuarioPeriodoTela vc;
	
	private static ReceitaUsuarioPeriodoControle singleton=null;
	
	public static ReceitaUsuarioPeriodoControle getInstance(){
		if(singleton==null){
			singleton= new ReceitaUsuarioPeriodoControle();
		}
			return singleton;
	}
		
	private ReceitaUsuarioPeriodoControle() {
	}
	
	public void configuraTela(CadastroReceitaUsuarioPeriodoTela vc){
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
		
		String receitaEscolhida = null,infoArea = null, periodo = null;
		Double valorReceita = null;
		
		String comando = eve.getActionCommand();
		
		if(comando.equals(("cadastrar")))
		{
			Usuario usuarioIntance = UsuarioDao.getUsuarioLogado();
			vc.leDadosUsuario(valorReceita, receitaEscolhida, periodo, infoArea);
			
			Receita rec = (Receita) ReceitaDao.getInstance().buscarReceitaNome(receitaEscolhida);
			
			Periodo p =formataComboPeriodo(periodo);
			
			ReceitaUsuarioPeriodoPK rPK = new ReceitaUsuarioPeriodoPK();
			rPK.setPeriodo_id(p);
			rPK.setUsuario_id(usuarioIntance);
			rPK.setReceita_id(rec);
			
			ReceitaUsuarioPeriodo rUP = new ReceitaUsuarioPeriodo();
			rUP.setChaveComposta(rPK);
			rUP.setInformacao(infoArea);
			rUP.setValor(valorReceita);
			
			ReceitaPertenceUsuarioEmPeriodoDao.getInstance().salvar(rUP);
			
			
			
		}
		else if(comando.equals("retornar"))
		{
			
		}
	}

	public void populaComboReceitas(List<Receita> receita) {
		
			vc.populaComboReceitas(receita);
		
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
