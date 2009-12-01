package visao;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class ReceitaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea jTextAreaReceita = null;
	private JTextField jTextFieldNovaReceita = null;
	private JLabel idJLabel = null;
	private JLabel nomeJLabel = null;
	private JLabel fixaJLabel = null;
	private JCheckBox fixaJCheckBox = null;
	private JLabel fixaLabelNovaReceita = null;
	private JLabel novaReceitaLabel = null;
	private JButton cadastrarReceita = null;
	private JButton alterarReceita = null;
	private Font f2;
	/**
	 * This is the default constructor
	 */
	public ReceitaTela() {
		super();
		initialize();
		f2 = new Font("Times New Roman", 1, 36);
		f2.isBold();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(540, 299);
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
			novaReceitaLabel = new JLabel();
			novaReceitaLabel.setBounds(new Rectangle(14, 10, 201, 25));
			novaReceitaLabel.setText("Digite abaixo uma nova Receita:");
			fixaLabelNovaReceita = new JLabel();
			fixaLabelNovaReceita.setBounds(new Rectangle(300, 46, 34, 23));
			fixaLabelNovaReceita.setText("Fixa:");
			fixaJLabel = new JLabel();
			fixaJLabel.setBounds(new Rectangle(298, 83, 70, 20));
			fixaJLabel.setText("fixa:");
			nomeJLabel = new JLabel();
			nomeJLabel.setBounds(new Rectangle(63, 82, 234, 21));
			nomeJLabel.setText("nome:");
			idJLabel = new JLabel();
			idJLabel.setBounds(new Rectangle(10, 82, 52, 21));
			idJLabel.setText("codigo:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextAreaDespesa(), null);
			jContentPane.add(getJTextFieldNovaDespesa(), null);
			jContentPane.add(idJLabel, null);
			jContentPane.add(nomeJLabel, null);
			jContentPane.add(fixaJLabel, null);
			jContentPane.add(getFixaJCheckBox(), null);
			jContentPane.add(fixaLabelNovaReceita, null);
			jContentPane.add(novaReceitaLabel, null);
			jContentPane.add(getCadastrarDespesa(), null);
			jContentPane.add(getCadastrarDespesa1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextAreaDespesa	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaDespesa() {
		if (jTextAreaReceita == null) {
			jTextAreaReceita = new JTextArea();
			jTextAreaReceita.setBounds(new Rectangle(10, 103, 356, 151));
			jTextAreaReceita.setEditable(false);
			jTextAreaReceita.setAlignmentY(50);
			jTextAreaReceita.setAlignmentX(50);
			jTextAreaReceita.setFont(f2);
			jTextAreaReceita.setBackground(Color.WHITE);
			JScrollPane jscroll=new JScrollPane(jTextAreaReceita);
		    jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
		}
		return jTextAreaReceita;
	}


	/**
	 * This method initializes jTextFieldNovaDespesa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNovaDespesa() {
		if (jTextFieldNovaReceita == null) {
			jTextFieldNovaReceita = new JTextField();
			jTextFieldNovaReceita.setBounds(new Rectangle(10, 45, 289, 27));
		}
		return jTextFieldNovaReceita;
	}

	/**
	 * This method initializes fixaJCheckBox	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getFixaJCheckBox() {
		if (fixaJCheckBox == null) {
			fixaJCheckBox = new JCheckBox();
			fixaJCheckBox.setBounds(new Rectangle(342, 48, 22, 17));
		}
		return fixaJCheckBox;
	}

	/**
	 * This method initializes cadastrarDespesa	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCadastrarDespesa() {
		if (cadastrarReceita == null) {
			cadastrarReceita = new JButton();
			cadastrarReceita.setBounds(new Rectangle(373, 42, 135, 35));
			cadastrarReceita.setText("nova Receita");
		}
		return cadastrarReceita;
	}

	/**
	 * This method initializes cadastrarDespesa1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCadastrarDespesa1() {
		if (alterarReceita == null) {
			alterarReceita = new JButton();
			alterarReceita.setBounds(new Rectangle(374, 87, 135, 36));
			alterarReceita.setText("alterar receita");
		}
		return alterarReceita;
	}
	
	public void veiculosEstacionados(String palavra){
		   jTextAreaReceita.setText("");
		   jTextAreaReceita.append(palavra);
	}

	public void configuraOuvinte(ActionListener controle){
			
			alterarReceita.addActionListener(controle);
			alterarReceita.setActionCommand("alterarReceita");
			cadastrarReceita.addActionListener(controle);
			cadastrarReceita.setActionCommand("cadastrarReceita");
		
	}



}  //  @jve:decl-index=0:visual-constraint="10,14"
