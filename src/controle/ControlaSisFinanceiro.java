package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Despesa;
import modelo.Periodo;
import modelo.Receita;
import modelo.Usuario;
import visao.CadastroDespesaUsuarioPeriodoTela;
import visao.CadastroReceitaUsuarioPeriodoTela;
import visao.DespesaTela;
import visao.LoginTela;
import visao.ReceitaTela;
import visao.RelatorioSimplesMensalDespesaReceitaTela;
import visao.SobreTela;
import visao.TelaPrincipalSisFinanceiro;
import visao.TrocarPeriodoTela;
import visao.UsuarioCadastroTela;
import dao.DespesaDao;
import dao.PeriodoDao;
import dao.ReceitaDao;
import dao.UsuarioDao;

public class ControlaSisFinanceiro implements ActionListener {
	
	TelaPrincipalSisFinanceiro vc;
	
	LoginTela lt;

	private static ControlaSisFinanceiro singleton=null;
	
	public static ControlaSisFinanceiro getInstance(){
		if(singleton==null){
			singleton= new ControlaSisFinanceiro();
		}
			return singleton;
	}
		
	private ControlaSisFinanceiro() {
	}
	
	public void configuraTela(TelaPrincipalSisFinanceiro vc){
		//logger.isDebugEnabled();
		this.vc=vc;
		//vc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		vc.configuraOuvinte(this);	
		vc.setResizable(false);
		vc.setLocationRelativeTo(null);
	}
	
	public void habilita(){
		vc.setModal(true);
		vc.setVisible(true);
	}

	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("tabelaDespesas")))
		{
			DespesaTela visao =new DespesaTela();
			DespesaControle.getInstance().configuraTela(visao);
			List<Despesa> despesas =  DespesaDao.getInstance().listar();
			visao.carregaAreaDespesas(despesas);
			DespesaControle.getInstance().habilita();
			
		}
		else if(comando.equals("tabelaReceitas"))
		{
			ReceitaTela visao =new ReceitaTela();
			ReceitaControle.getInstance().configuraTela(visao);
			List<Receita> receita =  ReceitaDao.getInstance().listar();
			visao.carregaAreaReceitas(receita);
			ReceitaControle.getInstance().habilita();
			
		}
		else if(comando.equals("tabelaPeriodos"))
		{
			Periodo  per= criaNovoPeriodo();
			PeriodoDao.getInstance().salvar(per);
			JOptionPane.showMessageDialog(null, "Novo per�odo " + per.getMes() + "/" + per.getAno()+ " criado com sucesso!" );
		}
		else if(comando.equals("dadosUsuario")){
			
			UsuarioCadastroTela visao = new UsuarioCadastroTela();
			DadosControle.getInstance().configuraTela(visao);
			Usuario usuarioLogado = UsuarioDao.getUsuarioLogado();
			visao.populaCamposUsuario(usuarioLogado);
			DadosControle.getInstance().habilita();

		}
		else if(comando.equals("trocarPeriodo")){
			
			TrocarPeriodoTela visao = new TrocarPeriodoTela();
			PeriodoTelaControle.getInstance().configuraTela(visao);
			List<Periodo> p = PeriodoDao.getInstance().listar();
			PeriodoTelaControle.getInstance().populaComboVista(p);
			PeriodoTelaControle.getInstance().habilita();
		}
		else if(comando.equals("estatisticas")){
			
			RelatorioSimplesMensalDespesaReceitaTela rel = new RelatorioSimplesMensalDespesaReceitaTela();
			List<Periodo> p =PeriodoDao.getInstance().listar();
			RelatorioFinanceiroControle.getInstance().configuraTela(rel);
			RelatorioFinanceiroControle.getInstance().populaComboPeriodo(p);
			RelatorioFinanceiroControle.getInstance().habilita();
			
		}
		else if(comando.equals("despesasUsuario")){
			
			CadastroDespesaUsuarioPeriodoTela visao = new CadastroDespesaUsuarioPeriodoTela();
			DespesaUsuarioPeriodoControle.getInstance().configuraTela(visao);
			List<Despesa> despesa = DespesaDao.getInstance().listar();
			DespesaUsuarioPeriodoControle.getInstance().populaComboDespesas(despesa);
			Periodo p =PeriodoTelaControle.getInstance().getPeriodoAtualSelecionado();
			DespesaUsuarioPeriodoControle.getInstance().populaComboPeriodo(p);
			DespesaUsuarioPeriodoControle.getInstance().habilita();
		}
		else if(comando.equals("receitasUsuario")){
			
			CadastroReceitaUsuarioPeriodoTela visao = new CadastroReceitaUsuarioPeriodoTela();
			ReceitaUsuarioPeriodoControle.getInstance().configuraTela(visao);
			List<Receita> receita = ReceitaDao.getInstance().listar();
			ReceitaUsuarioPeriodoControle.getInstance().populaComboReceitas(receita);
			Periodo p =PeriodoTelaControle.getInstance().getPeriodoAtualSelecionado();
			ReceitaUsuarioPeriodoControle.getInstance().populaComboPeriodo(p);
			ReceitaUsuarioPeriodoControle.getInstance().habilita();
		}
		else if(comando.equals("sobre")){
			
			SobreTela visao = new SobreTela();
			SobreControle.getInstance().configuraTela(visao);
			SobreControle.getInstance().habilita();
			
		}
	}
	
	private Periodo criaNovoPeriodo() {
		
		Periodo p= PeriodoDao.getInstance().listarUltimoPeriodo2();
	    
	    System.out.println("MES " + p.getMes());
	    System.out.println("ano " + p.getAno());
	    
	    //analisa dezembro
	    if(p.getMes() == 12){
	    	p.setMes(1);
	    	p.setAno(p.getAno() + 1);
	    }
	    else{
	    	p.setMes(p.getMes() + 1);
	    }
	    
	    
	    System.out.println("MES " + p.getMes());
	    System.out.println("ano " + p.getAno());
	    
	    PeriodoTelaControle.getInstance().periodoAtualSelecionado = p;
	    
	    return p;
		
	}
	
	
}
