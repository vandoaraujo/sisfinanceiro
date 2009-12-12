package visao;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SobreTela extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelSobre = null;
	private JLabel jLabelTitulo = null;
	private JLabel jLabelImagem = null;
	private JButton maisJButton = null;
	private JButton jButtonContato = null;
	/**
	 * This is the default constructor
	 */
	public SobreTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(660, 338);
		this.setContentPane(getJContentPane());
		this.setTitle("Sobre o sistema");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelImagem = new JLabel();
			jLabelImagem.setBounds(new Rectangle(3, 24, 499, 280));
			jLabelImagem.setText("JLabel");
			jLabelTitulo = new JLabel();
			jLabelTitulo.setBounds(new Rectangle(132, 1, 341, 24));
			jLabelTitulo.setText("SisFinanceiro - Versão 1.0 - Projeto Final Curso TBDS - PUC");
			jLabelSobre = new JLabel();
			jLabelSobre.setBounds(new Rectangle(516, 43, 129, 114));
			jLabelSobre.setText("<html><div> Contruído por:<br><br> Vando Araujo<br>Luiz Perciliano<br>Fabio Correa<br>Geovana</html>");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelSobre, null);
			jContentPane.add(jLabelTitulo, null);
			jContentPane.setBackground(new Color(0, 156, 218));
			jContentPane.add(jLabelImagem, null);
			jContentPane.add(getMaisJButton(), null);
			jContentPane.add(getJButtonContato(), null);
			jLabelImagem.setIcon(new ImageIcon("..\\sisfinanceiro\\src\\images\\tesouroCeu.jpg"));

		}
		return jContentPane;
	}
	
	public void configuraOuvinte(ActionListener controle){
		maisJButton.addActionListener(controle);
		maisJButton.setActionCommand("mais");
		jButtonContato.addActionListener(controle);
		jButtonContato.setActionCommand("contato");
	}

	/**
	 * This method initializes maisJButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getMaisJButton() {
		if (maisJButton == null) {
			maisJButton = new JButton();
			maisJButton.setBounds(new Rectangle(517, 180, 125, 37));
			maisJButton.setText("Mais...");
			maisJButton.setBackground(Color.GREEN);

		}
		return maisJButton;
	}

	/**
	 * This method initializes jButtonContato	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonContato() {
		if (jButtonContato == null) {
			jButtonContato = new JButton();
			jButtonContato.setBounds(new Rectangle(518, 238, 125, 36));
			jButtonContato.setText("Contato");
			maisJButton.setBackground(Color.YELLOW);
		}
		return jButtonContato;
	}


}  //  @jve:decl-index=0:visual-constraint="123,50"
