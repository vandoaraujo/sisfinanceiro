package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.RelatorioSimplesMensalDespesaReceitaTela;
import visao.TrocarPeriodoTela;

public class PeriodoTelaControle implements ActionListener {

	TrocarPeriodoTela vc;
	
	private static PeriodoTelaControle singleton=null;
	
	public static PeriodoTelaControle getInstance(){
		if(singleton==null){
			singleton= new PeriodoTelaControle();
		}
			return singleton;
	}
		
	private PeriodoTelaControle() {
	}
	
	public void configuraTela(TrocarPeriodoTela vc){
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
