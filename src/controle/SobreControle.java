package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		vc.setModal(true);
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("mais")))
		{
			JOptionPane.showMessageDialog(null, " Sistema Controle Financeiro \n\n \n Sistema desenvolvido utilizando os seguintes conceitos:\t \n * o pattern DAO \n * conceitos de 3 Camadas \n * aplicação de singleton \n * \n * implementação de login \n * utilização de Hibernate");

		}
		else if(comando.equals("contato"))
		{
			JOptionPane.showMessageDialog(null, "Para bugs, melhorias, novas versões: \n e-mail: vandoaraujo@hotmail.com ");
		}
	}

}
