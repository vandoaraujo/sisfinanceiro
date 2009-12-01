package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.jar.JarInputStream;

import javax.swing.JOptionPane;

import modelo.Despesa;
import visao.DespesaTela;
import dao.DespesaDao;

public class DespesaControle implements ActionListener {
	
	DespesaTela vc;
	
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
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("alterarDespesa")))
		{
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, null, "Digite o codigo da Despesa"));
			Despesa d = DespesaDao.getInstance().BuscaDespesaId(codigo);
			vc.populaCamposObjetoBanco(d);
		}
		else if(comando.equals("cadastrarDespesa"))
		{
			Despesa d = vc.leDadosTela();
			DespesaDao.getInstance().salvar(d);
			vc.limpaDespesasArea();
			List<Despesa> novasDespesas = DespesaDao.getInstance().listar();
			vc.carregaAreaDespesas(novasDespesas);
		}
		
		else if(comando.equals("confirmarAlteracao")){
			Despesa d = vc.leDadosTela();
			DespesaDao.getInstance().atualizar(d);
			JOptionPane.showMessageDialog(null,"ATUALIZADO COM SUCESSO");
			
		}
	}
	
	

}
