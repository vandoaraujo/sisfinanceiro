package visao;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

public class SobreTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabelSobre = null;
	private JLabel jLabelTitulo = null;

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
		this.setSize(470, 200);
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
			jLabelTitulo = new JLabel();
			jLabelTitulo.setBounds(new Rectangle(159, 21, 270, 24));
			jLabelTitulo.setText("SisFinanceiro");
			jLabelSobre = new JLabel();
			jLabelSobre.setBounds(new Rectangle(15, 55, 419, 104));
			jLabelSobre.setText("Construido por Luiz Perciliano, Fabio Correa, Geovana e Vando");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelSobre, null);
			jContentPane.add(jLabelTitulo, null);
		}
		return jContentPane;
	}
	
	public void configuraOuvinte(ActionListener controle){
		
	}


}  //  @jve:decl-index=0:visual-constraint="216,69"
