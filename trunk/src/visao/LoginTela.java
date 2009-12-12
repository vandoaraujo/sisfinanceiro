package visao;


import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Usuario;


public class LoginTela extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel usuario = null;

	private JLabel senha = null;

	private JTextField campoUsuario = null;

	private JPasswordField campoSenha = null;

	private JButton logIn = null;

	private JLabel info = null;

	private JButton semLogin = null;

	private JLabel jLabelCadeado = null;

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
			jLabelCadeado = new JLabel();
			jLabelCadeado.setBounds(new Rectangle(348, 72, 102, 66));
			jLabelCadeado.setText("");
			info = new JLabel();
			info.setBounds(new Rectangle(89, 11, 278, 24));
			info.setText("SisFinanceiro - Controle Financeiro Pessoal:");
			senha = new JLabel();
			senha.setBounds(new Rectangle(13, 115, 57, 26));
			senha.setText("Senha:");
			usuario = new JLabel();
			usuario.setBounds(new Rectangle(16, 72, 55, 27));
			usuario.setText("Usuário:");
			jContentPane = new JPanel();
			jContentPane.setBackground(new Color(0, 156, 218));
			jContentPane.setLayout(null);
			jContentPane.add(usuario, null);
			jContentPane.add(senha, null);
			jContentPane.add(getCampoUsuario(), null);
			jContentPane.add(getCampoSenha(), null);
			jContentPane.add(getLogIn(), null);
			jContentPane.add(info, null);
			jContentPane.add(getSemLogin(), null);
			jContentPane.add(jLabelCadeado, null);
			jLabelCadeado.setIcon(new ImageIcon("..\\sisfinanceiro\\src\\images\\cadeado.jpg"));
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
			campoUsuario.setBounds(new Rectangle(95, 73, 230, 25));
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
			campoSenha.setBounds(new Rectangle(97, 115, 227, 22));
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
			logIn.setBackground(Color.GREEN);
			logIn.setBounds(new Rectangle(53, 175, 148, 34));
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
			semLogin.setBackground(Color.LIGHT_GRAY);
			semLogin.setBounds(new Rectangle(264, 176, 175, 33));
			semLogin.setText("Nao tenho Login!");
		}
		return semLogin;
	}

}  //  @jve:decl-index=0:visual-constraint="170,55"
