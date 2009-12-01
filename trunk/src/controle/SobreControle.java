package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.SobreTela;

public class SobreControle implements ActionListener{

	
	SobreTela vc;
	
	private static SobreControle singleton=null;
	
	public static SobreControle getInstance(){
		if(singleton==null){
			singleton= new SobreControle();
		}
			return singleton;
	}
		
	private SobreControle() {
	}
	
	public void configuraTela(SobreTela vc){
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
		
		if(comando.equals(("")))
		{
			
		}
		else if(comando.equals(""))
		{
			
		}
	}

}
