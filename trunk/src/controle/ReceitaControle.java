package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.ReceitaTela;

public class ReceitaControle implements ActionListener{
	
	ReceitaTela vc;
	
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
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("alterarReceita")))
		{
			
		}
		else if(comando.equals("cadastrarReceita"))
		{
			
		}
	}
}
