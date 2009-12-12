package visao;


import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UsuarioDao;

import modelo.Usuario;


public class LoginTela extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel usuario = null;

	private JLabel senha = null;

	private JTextField campoUsuario = null;

	private JPasswordField campoSenha = null;

	private JButton logIn = null;

	private JLabel info = null;

	private JButton semLogin = null;

	/**
	 * This is the default constructor
	 */
	public LoginTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(479, 263);
		this.setContentPane(getJContentPane());
		this.setTitle("Tela de Login - SisFinanceiro");
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			info = new JLabel();
			ImageIcon ima=new ImageIcon("images//cadeado.jpg");
			info.setBounds(new Rectangle(89, 11, 278, 24));
			info.setText("SisFinanceiro - Controle Financeiro Pessoal:");
			info.setIcon(ima);
			senha = new JLabel();
			senha.setBounds(new Rectangle(13, 115, 57, 26));
			senha.setText("Senha:");
			usuario = new JLabel();
			usuario.setBounds(new Rectangle(16, 72, 55, 27));
			usuario.setText("Usuário:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(usuario, null);
			jContentPane.add(senha, null);
			jContentPane.add(getCampoUsuario(), null);
			jContentPane.add(getCampoSenha(), null);
			jContentPane.add(getLogIn(), null);
			jContentPane.add(info, null);
			jContentPane.add(getSemLogin(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes campoUsuario	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoUsuario() {
		if (campoUsuario == null) {
			campoUsuario = new JTextField();
			campoUsuario.setBounds(new Rectangle(95, 73, 209, 25));
		}
		return campoUsuario;
	}

	/**
	 * This method initializes campoSenha	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getCampoSenha() {
		if (campoSenha == null) {
			campoSenha = new JPasswordField();
			campoSenha.setBounds(new Rectangle(97, 115, 205, 22));
		}
		return campoSenha;
	}

	/**
	 * This method initializes logIn	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getLogIn() {
		if (logIn == null) {
			logIn = new JButton();
			logIn.setBounds(new Rectangle(42, 180, 148, 28));
			logIn.setText("Entrar");
		}
		return logIn;
	}
	
	public Usuario leCredenciais()
	{
		// Recupera os valores dos campos
		String login = campoUsuario.getText();
		String senha=new String(campoSenha.getPassword());
		Usuario u = new Usuario(login,senha);
		return u;
	}
	
	public void limpaCredenciais()
	{
		campoUsuario.setText("");
		campoSenha.setText("");
	}
	
	
	public void configuraOuvinte(ActionListener controle){
		
		logIn.addActionListener(controle);
		logIn.setActionCommand("login");
		semLogin.addActionListener(controle);
		semLogin.setActionCommand("semLogin");
	
	}
	
	
	public void mostraMensagem(String s) {
		JOptionPane.showMessageDialog(null,s);
		
	}

	/**
	 * This method initializes semLogin	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getSemLogin() {
		if (semLogin == null) {
			semLogin = new JButton();
			semLogin.setBounds(new Rectangle(224, 180, 175, 28));
			semLogin.setText("Nao tenho Login");
		}
		return semLogin;
	}

}  //  @jve:decl-index=0:visual-constraint="170,55"
