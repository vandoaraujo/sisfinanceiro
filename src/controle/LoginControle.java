package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Usuario;
import visao.LoginTela;
import visao.TelaPrincipalSisFinanceiro;
import visao.UsuarioCadastroTela;
import dao.UsuarioDao;
import exceptions.LoginRepetidoException;

public class LoginControle implements ActionListener {

	private static LoginControle singleton = null;
	private LoginTela telaL;
	private UsuarioCadastroTela telaUsuario;
	private ControlaSisFinanceiro ce = ControlaSisFinanceiro.getInstance();

	public static LoginControle getInstance() {
		if (singleton == null)
			singleton = new LoginControle();
		return singleton;
	}

	private LoginControle() {

	}

	public void configuraTela(LoginTela telaL) {

		this.telaL = telaL;
		this.telaL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaL.configuraOuvinte(this);
		// Proíbe Redimensionamento
		this.telaL.setResizable(false);
		this.telaL.setLocationRelativeTo(null);

	}

	private void configuraTela(UsuarioCadastroTela usuTela) {

		this.telaUsuario = usuTela;
		//telaUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		telaUsuario.configuraOuvinte(this);
		// Proíbe Redimensionamento
		telaUsuario.setResizable(false);
		telaUsuario.setLocationRelativeTo(null);
	}

	public void habilitaTelaLogin() {
		
		telaL.setVisible(true);
		telaL.limpaCredenciais();

	}

	public void habilitaTelaCadastroUsuario() {
		telaUsuario.setVisible(true);

	}

	public void actionPerformed(ActionEvent eve) {

		String comando = eve.getActionCommand();

		if (comando.equals(("login"))) {
			logicaBotaoLogin();
		} else if (comando.equals("semLogin")) {
			iniciaTelaCadastroUsuario();
		}
		if (comando.equals(("cadastrar"))) {
			salvaUsuario();
		} else if (comando.equals("retornar")) {
			retornaTelaLogin();
		}

	}

	private void salvaUsuario() {

		Usuario usu = telaUsuario.leDadosUsuario();

		if (usu == null) {
			JOptionPane.showMessageDialog(null,
					"Dados invalidos, favor preencher todos os campos!");
			return;// para sair do método

		} else if (usu.getSenha() == null) {
			JOptionPane.showMessageDialog(null, "As senhas não coincidem!!!");
			return;// para sair do método
		}
		
		else if (!validaCaracters(usu.getSenha())){
			JOptionPane.showMessageDialog(null,
			"Caracteres inválidos!");
			return;// para sair do método
		
		}else if (usu.getSenha().length() < 4){
			JOptionPane.showMessageDialog(null, "Senha dever ter no minimo 4");
			   return;
		}

		try {
			verificaLoginRepetido(usu);
		} catch (LoginRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UsuarioDao.getInstance().salvar(usu);
		// Inicia o usuario Logado
		UsuarioDao.getInstance().setUsuarioLogado(usu);
		// Inicia a tela principal/
		habilitaTelaPrincipal();
	}

	private void verificaLoginRepetido(Usuario usu)
			throws LoginRepetidoException {

		Usuario usuarioRepetido = UsuarioDao.getInstance().listarLoginsIguais(
				usu.getLogin());

		if (usuarioRepetido != null) {
			throw new LoginRepetidoException();
		}
	}

	private void iniciaTelaCadastroUsuario() {
		UsuarioCadastroTela usuTela = new UsuarioCadastroTela();
		LoginControle.getInstance().configuraTela(usuTela);
		LoginControle.getInstance().habilitaTelaCadastroUsuario();
	}

	private void retornaTelaLogin() {

		telaUsuario.setVisible(false);
		telaUsuario.dispose();
		telaL.setVisible(true);
		//TelaPrincipalSisFinanceiro visao =new TelaPrincipalSisFinanceiro();
		//ControlaSisFinanceiro.getInstance().configuraTela(visao); 
        //LoginControle.getInstance().configuraTela(lt);


	}

	private void logicaBotaoLogin() {
		Usuario usuario = telaL.leCredenciais();
		Usuario usu = UsuarioDao.getInstance().buscarUsuario(
				usuario.getLogin(), usuario.getSenha());

		// Se usuario for nulo, query retornou nada
		if (usu != null) {

			habilitaTelaPrincipal();
		} else {
			telaL
					.mostraMensagem("Não foi possível entrar! \nNome de usuário ou senha incorretos! ");
		}
	}

	private void habilitaTelaPrincipal() {
		telaL.dispose();
		ce.habilita();
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