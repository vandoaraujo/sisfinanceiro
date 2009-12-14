package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.DespesaDao;
import dao.DespesaPertenceUsuarioEmPeriodoDao;
import dao.ReceitaDao;
import dao.ReceitaPertenceUsuarioEmPeriodoDao;

import modelo.Despesa;
import modelo.DespesaUsuarioPeriodo;
import modelo.Receita;
import modelo.ReceitaUsuarioPeriodo;

import visao.ReceitaTela;

public class ReceitaControle implements ActionListener{
	
	ReceitaTela vc;
	Receita receitaCorrente = null;
	
	private static ReceitaControle singleton=null;
	
	public static ReceitaControle getInstance(){
		if(singleton==null){
			singleton= new ReceitaControle();
		}
			return singleton;
	}
		
	private ReceitaControle() {
	}
	
	public void configuraTela(ReceitaTela vc){
		//logger.isDebugEnabled();
		this.vc=vc;
		//vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		if(comando.equals(("edicao")))
		{
			receitaCorrente = alteraReceita();
			
		}
		else if(comando.equals("confirmar"))
		{
			//Para o caso de salvar
			if(receitaCorrente == null){
				
				Receita r = vc.leDadosTelaCadastro();
				ReceitaDao.getInstance().salvar(r);
				vc.limpaReceitas();
				List<Receita> novasReceitas = ReceitaDao.getInstance().listar();
				vc.carregaAreaReceitas(novasReceitas);
				JOptionPane.showMessageDialog(null,"Receita inserida com sucesso!");

			}
			//Para o caso de atualizar
			else{
				
				vc.leDadosTelaCadastro(receitaCorrente);
				ReceitaDao.getInstance().atualizar(receitaCorrente);
				vc.limpaReceitas();
				List<Receita> novasReceitas = ReceitaDao.getInstance().listar();
				vc.carregaAreaReceitas(novasReceitas);
				receitaCorrente = null;
				JOptionPane.showMessageDialog(null,"Receita atualizada com sucesso!");

			}
			
		}
		
		else if(comando.equals("excluir")){
			
			if(receitaCorrente != null){
				if(validaUtilizacaoReceita(receitaCorrente)){
					ReceitaDao.getInstance().deletar(receitaCorrente);
					vc.limpaReceitas();
					List<Receita> novasReceitas = ReceitaDao.getInstance().listar();
					vc.carregaAreaReceitas(novasReceitas);
					JOptionPane.showMessageDialog(null,"Receita excluída com sucesso!");
					
				}else{
					JOptionPane.showMessageDialog(null,"Esta receita já foi utilizada e não pode ser excluida!");

				}
				
			}
				receitaCorrente = null;
		}
	}
	
	private boolean validaUtilizacaoReceita(Receita receitaCorrente) {
		List<ReceitaUsuarioPeriodo> r = ReceitaPertenceUsuarioEmPeriodoDao.getInstance().buscaReceitaId(receitaCorrente.getId());
		if(r.size() == 0){
			return true;
		}
		return false;
	}
	
	private Receita alteraReceita() {
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da Receita"));
		Receita r = null;
		try {
			r = ReceitaDao.getInstance().BuscaReceitaId(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vc.populaCamposObjetoBanco(r);
		
		return r;
		
	}
	
	public Receita getReceitaCorrente() {
		return receitaCorrente;
	}

	public void setReceitaCorrente(Receita receitaCorrente) {
		this.receitaCorrente = receitaCorrente;
	}
}
