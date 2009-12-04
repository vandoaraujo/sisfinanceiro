package visao;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import modelo.Periodo;
import modelo.Receita;

public class CadastroReceitaUsuarioPeriodoTela extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea areaTex = null;
	private JTextField valorText = null;
	private JComboBox receitaCombo = null;
	private JButton okCadastro = null;
	private JLabel despesaLabel = null;
	private JLabel valorLabel = null;
	private JLabel informacaoLabel = null;
	private JComboBox periodoCombo = null;
	private JLabel periodoLabel = null;
	private JButton voltarBotao = null;

	/**
	 * This is the default constructor
	 */
	public CadastroReceitaUsuarioPeriodoTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(596, 306);
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
			periodoLabel.setBounds(new Rectangle(17, 226, 124, 29));
			periodoLabel.setText("Período:");
			informacaoLabel = new JLabel();
			informacaoLabel.setBounds(new Rectangle(14, 118, 119, 24));
			informacaoLabel.setText("Informação:");
			valorLabel = new JLabel();
			valorLabel.setBounds(new Rectangle(15, 70, 121, 28));
			valorLabel.setText("Valor (R$) :");
			despesaLabel = new JLabel();
			despesaLabel.setBounds(new Rectangle(19, 17, 122, 29));
			despesaLabel.setText("Receita:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getAreaTex(), null);
			jContentPane.add(getValorText(), null);
			jContentPane.add(getDespesaCombo(), null);
			jContentPane.add(getOkCadastro(), null);
			jContentPane.add(despesaLabel, null);
			jContentPane.add(valorLabel, null);
			jContentPane.add(informacaoLabel, null);
			jContentPane.add(getPeriodoCombo(), null);
			jContentPane.add(periodoLabel, null);
			jContentPane.add(getVoltarBotao(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes areaTex	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAreaTex() {
		if (areaTex == null) {
			areaTex = new JTextArea();
			areaTex.setBounds(new Rectangle(155, 118, 265, 98));
		}
		return areaTex;
	}

	/**
	 * This method initializes valorText	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getValorText() {
		if (valorText == null) {
			valorText = new JTextField();
			valorText.setBounds(new Rectangle(153, 72, 145, 27));
		}
		return valorText;
	}

	/**
	 * This method initializes despesaCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getDespesaCombo() {
		if (receitaCombo == null) {
			receitaCombo = new JComboBox();
			receitaCombo.setBounds(new Rectangle(152, 18, 270, 29));
		}
		return receitaCombo;
	}

	/**
	 * This method initializes okCadastro	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOkCadastro() {
		if (okCadastro == null) {
			okCadastro = new JButton();
			okCadastro.setBounds(new Rectangle(460, 15, 112, 34));
			okCadastro.setText("Cadastro");
		}
		return okCadastro;
	}

	/**
	 * This method initializes periodoCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getPeriodoCombo() {
		if (periodoCombo == null) {
			periodoCombo = new JComboBox();
			periodoCombo.setBounds(new Rectangle(155, 228, 265, 30));
		}
		return periodoCombo;
	}

	/**
	 * This method initializes voltarBotao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getVoltarBotao() {
		if (voltarBotao == null) {
			voltarBotao = new JButton();
			voltarBotao.setBounds(new Rectangle(459, 68, 113, 34));
			voltarBotao.setText("Voltar");
		}
		return voltarBotao;
	}
	
	public void configuraOuvinte(ActionListener controle){
		okCadastro.addActionListener(controle);
		okCadastro.setActionCommand("cadastrar");
		voltarBotao.addActionListener(controle);
		voltarBotao.setActionCommand("retornar");
		
	}
	
	public void leDadosUsuario(Double valorReceita, String receitaEscolhida, String periodo,String infoArea){
		try{
			valorReceita= Double.parseDouble(valorText.getText());
			
			receitaEscolhida=(String)receitaCombo.getSelectedItem();
			
			periodo=(String)periodoCombo.getSelectedItem();
					
			infoArea= areaTex.getText();
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Dados invalidos!");
		}
	}
	
	public void modofechado(){
		this.setVisible(false);
	}
	
	public void populaComboReceitas(List<Receita> receita) {
		
		for(Receita r : receita){
			receitaCombo.addItem(r.getNomeReceita());
		}
		
	}

	public void populaComboPeriodo(Periodo p) {
		periodoCombo.addItem(p.getMes() + " - " +  p.getAno());
		
	}
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
