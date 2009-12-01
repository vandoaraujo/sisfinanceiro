package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.CadastroReceitaUsuarioPeriodoTela;
import visao.RelatorioSimplesMensalDespesaReceitaTela;

public class RelatorioFinanceiroControle implements ActionListener {

	RelatorioSimplesMensalDespesaReceitaTela vc;
	
	private static RelatorioFinanceiroControle singleton=null;
	
	public static RelatorioFinanceiroControle getInstance(){
		if(singleton==null){
			singleton= new RelatorioFinanceiroControle();
		}
			return singleton;
	}
		
	private RelatorioFinanceiroControle() {
	}
	
	public void configuraTela(RelatorioSimplesMensalDespesaReceitaTela vc){
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
		
		if(comando.equals(("carregarRelatorio")))
		{
			
		}
		else if(comando.equals("retornar"))
		{
			System.out.println("OUTRA FUNCIONALIDADE DO RELATORIO!");
		}
	}

}
