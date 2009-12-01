package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.CadastroReceitaUsuarioPeriodoTela;

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

		String comando = eve.getActionCommand();
		
		if(comando.equals(("cadastrar")))
		{
			
		}
		else if(comando.equals("retornar"))
		{
			
		}
	}

}
