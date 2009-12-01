package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.CadastroDespesaUsuarioPeriodoTela;
import visao.DespesaTela;

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
			
		}
		else if(comando.equals("retornar"))
		{
			
		}
	}

}
