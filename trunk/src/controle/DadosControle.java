package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Usuario;
import dao.UsuarioDao;
import exceptions.LoginRepetidoException;
import exceptions.SenhaException;

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
		vc.setModal(true);
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("cadastrar")))
		{
			try {
				alteraDados();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(comando.equals("retornar"))
		{
			vc.setVisible(false);
			vc.dispose();
		}
	}
	
	private void alteraDados() throws Exception {

		Usuario usu = vc.leDadosUsuarioLogado(UsuarioDao.getUsuarioLogado());
		
		if (usu == null) {
			JOptionPane.showMessageDialog(null,
					"Dados invalidos, favor preencher todos os campos!");
			return;// para sair do método

		} 
		 else if (usu.getSenha().length() < 4){
			JOptionPane.showMessageDialog(null, "Senha dever ter no minimo 4 caracteres!");
			throw new SenhaException("Senha deve ter no minimo 4 caracteres!");   
		}
		else if (!validaCaracters(usu.getSenha())){
				JOptionPane.showMessageDialog(null,
				"Caracteres inválidos!");
			throw new SenhaException("Caracteres inválidos!! ");
		}
		try {
			verificaLoginRepetido(usu);
		} catch (LoginRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UsuarioDao.getInstance().atualizar(usu);
		// Inicia o usuario Logado
		UsuarioDao.getInstance().setUsuarioLogado(usu);
		// Inicia a tela principal/
		habilitaTelaPrincipal();
	}	
	
	private void habilitaTelaPrincipal() {
		vc.dispose();
	}
	
	private void verificaLoginRepetido(Usuario usu)
						throws LoginRepetidoException {

		Usuario usuarioRepetido = UsuarioDao.getInstance().listarLoginsIguais(
				usu.getLogin());

		if (usuarioRepetido != null) {
			throw new LoginRepetidoException();
		}
	}
	
	private boolean validaCaracters(String strSenha) {
		Pattern p = Pattern.compile("[^_^0-9^a-z^A-Z ^]");
		int x = strSenha.length();
		Matcher m = p.matcher(strSenha);
		for (int i = 0; i < x; i++) {
			if (m.find()) {
				return false;
			}
		}
		return true;
	}

}
