package visao;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;

public class TrocarPeriodoTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox periodoCombo = null;
	private JButton trocarPeriodoBotao = null;
	private JLabel periodoLabel = null;
	/**
	 * This is the default constructor
	 */
	public TrocarPeriodoTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(570, 253);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			periodoLabel = new JLabel();
			periodoLabel.setBounds(new Rectangle(6, 8, 533, 52));
			periodoLabel.setText("Utilize a lista abaixo para trocar o período corrente, caso queira definir despesas ou receitas anteriores.");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPeriodoCombo(), null);
			jContentPane.add(getTrocarPeriodoBotao(), null);
			jContentPane.add(periodoLabel, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes periodoCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getPeriodoCombo() {
		if (periodoCombo == null) {
			periodoCombo = new JComboBox();
			periodoCombo.setBounds(new Rectangle(113, 83, 308, 31));
		}
		return periodoCombo;
	}

	/**
	 * This method initializes trocarPeriodoBotao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getTrocarPeriodoBotao() {
		if (trocarPeriodoBotao == null) {
			trocarPeriodoBotao = new JButton();
			trocarPeriodoBotao.setBounds(new Rectangle(226, 129, 101, 28));
			trocarPeriodoBotao.setText("OK!");
		}
		return trocarPeriodoBotao;
	}
	
	public void configuraOuvinte(ActionListener controle){
		trocarPeriodoBotao.addActionListener(controle);
		trocarPeriodoBotao.setActionCommand("cadastrar");
				
	}
	
	/*public Usuario leDadosUsuario(){
		try{
			String nomeUsuario= nome.getText();
			
			String loginUsuario=login.getText();
			
			String senhaUsu=new String(senha.getPassword());
			
			Usuario usuario=new Usuario(nomeUsuario,loginUsuario,senhaUsu,new Date());
			
			return usuario;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Dados invalidos!");
		}
		return null;
	}*/
	
	public void modofechado(){
		this.setVisible(false);
	}

}  //  @jve:decl-index=0:visual-constraint="93,50"
