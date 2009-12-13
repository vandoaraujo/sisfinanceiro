package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.jar.JarInputStream;

import javax.swing.JOptionPane;

import org.hibernate.ObjectNotFoundException;

import modelo.Despesa;
import visao.DespesaTela;
import dao.DespesaDao;
import dao.DespesaPertenceUsuarioEmPeriodoDao;

public class DespesaControle implements ActionListener {
	
	DespesaTela vc;
	Despesa despesaCorrente = null;
	
	private static DespesaControle singleton=null;
	
	public static DespesaControle getInstance(){
		if(singleton==null){
			singleton= new DespesaControle();
		}
			return singleton;
	}
		
	private DespesaControle() {
	}
	
	public void configuraTela(DespesaTela vc){
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
			despesaCorrente = alteraDespesa();
		}
		else if(comando.equals("confirmar"))
		{
			//Para o caso de salvar
			if(despesaCorrente == null){
				
				Despesa d = vc.leDadosTelaCadastro();
				DespesaDao.getInstance().salvar(d);
				vc.limpaDespesas();
				List<Despesa> novasDespesas = DespesaDao.getInstance().listar();
				vc.carregaAreaDespesas(novasDespesas);
			}
			//Para o caso de atualizar
			else{
				
				vc.leDadosTelaCadastroAtualizacao(despesaCorrente);
				DespesaDao.getInstance().atualizar(despesaCorrente);
				vc.limpaDespesas();
				List<Despesa> novasDespesas = DespesaDao.getInstance().listar();
				vc.carregaAreaDespesas(novasDespesas);
				despesaCorrente = null;
			}
			
		}
		
		else if(comando.equals("excluir")){
			
			if(despesaCorrente != null){
				if(validaUtilizacaoDespesa(despesaCorrente)){
					
						DespesaDao.getInstance().deletar(despesaCorrente);
						vc.limpaDespesas();
						List<Despesa> novasDespesas = DespesaDao.getInstance().listar();
						vc.carregaAreaDespesas(novasDespesas);
						JOptionPane.showMessageDialog(null,"Deletado com sucesso");
				}
				else{
					JOptionPane.showMessageDialog(null, "Esta despesa j� foi utilizada e n�o pode ser deletada!");
				}
			}
				despesaCorrente = null;
		}

	}

	private boolean validaUtilizacaoDespesa(Despesa despesaCorrente2) {
		List<Despesa> d = DespesaPertenceUsuarioEmPeriodoDao.getInstance().buscaDespesaId(despesaCorrente2.getId());
		if(d.size() == 0){
			return true;
		}
		return false;
	}

	private void analisaMudancaObjetoDespesa(Despesa d) {
		Despesa despesaTela = vc.leDadosTelaCadastro();
		if(despesaTela.getNomeDespesa().equals(d.getNomeDespesa()) || 
				(despesaTela.isDespesaFixa() == d.isDespesaFixa())) {
			
		}
		
	}

	private Despesa alteraDespesa() {
		
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo da Despesa"));
		Despesa d = null;
		try {
			try {
				d = DespesaDao.getInstance().BuscaDespesaId(codigo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (org.hibernate.ObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		vc.populaCamposObjetoBanco(d);
				
		return d;
		
	}
	
	public Despesa getDespesaCorrente() {
		return despesaCorrente;
	}

	public void setDespesaCorrente(Despesa despesaCorrente) {
		this.despesaCorrente = despesaCorrente;
	}
	
	

}
