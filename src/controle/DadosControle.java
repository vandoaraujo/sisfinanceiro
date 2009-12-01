package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import visao.UsuarioCadastroTela;

public class DadosControle implements ActionListener{

	UsuarioCadastroTela vc;
	
	private static DadosControle singleton=null;
	
	public static DadosControle getInstance(){
		if(singleton==null){
			singleton= new DadosControle();
		}
			return singleton;
	}
		
	private DadosControle() {
	}
	
	public void configuraTela(UsuarioCadastroTela vc){
		//logger.isDebugEnabled();
		this.vc=vc;
		//vc.setDefaultCloseOperation(JFrame.);
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
