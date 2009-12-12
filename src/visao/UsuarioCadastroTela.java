package visao;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.Usuario;

public class UsuarioCadastroTela extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField nome = null;

	private JTextField login = null;

	private JPasswordField senha = null;

	private JPasswordField senhaNovamente = null;

	private JLabel jLabelCodigo = null;

	private JLabel jLabelTittulo = null;

	private JLabel jLabelgenero = null;

	private JLabel jLabelDuracao = null;

	private JButton cadastrar = null;

	private JButton retornar = null;

	/**
	 * This is the default constructor public Dvd(int codigo,String titulo,
	 * String genero, int duracaomin)
	 */
	public UsuarioCadastroTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(527, 263);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Usuários");
		this.setLocation(400, 350);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelDuracao = new JLabel();
			jLabelDuracao.setBounds(new Rectangle(10, 137, 107, 23));
			jLabelDuracao.setText("confirme a senha:");
			jLabelgenero = new JLabel();
			jLabelgenero.setBounds(new Rectangle(11, 108, 94, 19));
			jLabelgenero.setText("senha:");
			jLabelTittulo = new JLabel();
			jLabelTittulo.setBounds(new Rectangle(9, 76, 97, 23));
			jLabelTittulo.setText("login:");
			jLabelCodigo = new JLabel();
			jLabelCodigo.setBounds(new Rectangle(9, 42, 95, 23));
			jLabelCodigo.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getCodigo(), null);
			jContentPane.add(getNome(), null);
			jContentPane.add(getGenero(), null);
			jContentPane.add(getDuracao(), null);
			jContentPane.add(jLabelCodigo, null);
			jContentPane.add(jLabelTittulo, null);
			jContentPane.add(jLabelgenero, null);
			jContentPane.add(jLabelDuracao, null);
			jContentPane.add(getCadastrar(), null);
			jContentPane.add(getRetornar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes codigo
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getCodigo() {
		if (nome == null) {
			nome = new JTextField();
			nome.setBounds(new Rectangle(119, 45, 302, 20));
		}
		return nome;
	}

	/**
	 * This method initializes nome
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getNome() {
		if (login == null) {
			login = new JTextField();
			login.setBounds(new Rectangle(119, 77, 175, 21));
		}
		return login;
	}

	/**
	 * This method initializes genero
	 * 
	 * @return javax.swing.JTextField
	 */
	private JPasswordField getGenero() {
		if (senha == null) {
			senha = new JPasswordField();
			senha.setBounds(new Rectangle(119, 106, 173, 22));
		}
		return senha;
	}

	/**
	 * This method initializes duracao
	 * 
	 * @return javax.swing.JTextField
	 */
	private JPasswordField getDuracao() {
		if (senhaNovamente == null) {
			senhaNovamente = new JPasswordField();
			senhaNovamente.setBounds(new Rectangle(119, 136, 172, 23));
		}
		return senhaNovamente;
	}

	/**
	 * This method initializes cadastrar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCadastrar() {
		if (cadastrar == null) {
			cadastrar = new JButton();
			cadastrar.setBounds(new Rectangle(389, 121, 109, 35));
			cadastrar.setText("Cadastrar");
		}
		return cadastrar;
	}

	/**
	 * This method initializes retornar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getRetornar() {
		if (retornar == null) {
			retornar = new JButton();
			retornar.setBounds(new Rectangle(388, 174, 113, 31));
			retornar.setText("Retornar");
		}
		return retornar;
	}

	public void configuraOuvinte(ActionListener controle) {
		cadastrar.addActionListener(controle);
		cadastrar.setActionCommand("cadastrar");
		retornar.addActionListener(controle);
		retornar.setActionCommand("retornar");

	}

	public Usuario leDadosUsuario() {
		//getText Depecated - implementar array de caracteres
		Usuario usuario = null;
		String nomeUsuario = nome.getText();
		String loginUsuario = login.getText();
		String senhaUsu = new String(senha.getPassword());
		String confiSenha = new String (senhaNovamente.getPassword());
		
		// validando os campos vazios e senhas difirentes
		if (nomeUsuario.trim().equals("")
				|| loginUsuario.trim().equals("")
				|| senhaUsu.trim().equals("")
				|| confiSenha.trim().equals("")){
			return null;
			//
		}else if(!senhaUsu.equals(confiSenha)){
			return new Usuario();
		}
		
		else {
			usuario = new Usuario(nomeUsuario, loginUsuario, senhaUsu, new Date());
		}
		return usuario;
	}

	public void modofechado() {
		this.setVisible(false);
	}

} // @jve:decl-index=0:visual-constraint="177,6"
