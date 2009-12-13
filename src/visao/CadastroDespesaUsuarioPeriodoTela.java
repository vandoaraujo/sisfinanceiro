package visao;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Despesa;
import modelo.Periodo;
import util.UsuarioPeriodoDespesaTO;

public class CadastroDespesaUsuarioPeriodoTela extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea areaTex = null;
	private JTextField valorText = null;
	private JComboBox despesaCombo = null;
	private JButton okCadastro = null;
	private JLabel despesaLabel = null;
	private JLabel valorLabel = null;
	private JLabel informacaoLabel = null;
	private JComboBox periodoCombo = null;
	private JLabel periodoLabel = null;
	private JButton voltarBotao = null;
	private JLabel jLabelFormato = null;
	/**
	 * This is the default constructor
	 */
	public CadastroDespesaUsuarioPeriodoTela() {
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
		this.setTitle("Cadastro de Despesas em um Período Corrente");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelFormato = new JLabel();
			jLabelFormato.setBounds(new Rectangle(366, 73, 68, 26));
			jLabelFormato.setText("Ex:  50.56");
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
			despesaLabel.setText("Despesa:");
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
			jContentPane.add(jLabelFormato, null);
			jContentPane.setBackground(new Color(0, 156, 218));
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
			areaTex.setBackground(Color.YELLOW);
			areaTex.setBounds(new Rectangle(155, 118, 265, 98));
			JScrollPane jscroll=new JScrollPane(areaTex);
		    jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
			valorText.setBounds(new Rectangle(153, 72, 206, 27));
		}
		return valorText;
	}

	/**
	 * This method initializes despesaCombo	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getDespesaCombo() {
		if (despesaCombo == null) {
			despesaCombo = new JComboBox();
			despesaCombo.setBounds(new Rectangle(152, 18, 270, 29));
		}
		return despesaCombo;
	}

	/**
	 * This method initializes okCadastro	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOkCadastro() {
		if (okCadastro == null) {
			//ImageIcon imageBotao = new ImageIcon("..\\sisfinanceiro\\src\\images\\cadastrar.jpg");
			okCadastro = new JButton();
			okCadastro.setBackground(Color.GREEN);
			okCadastro.setBounds(new Rectangle(460, 15, 115, 34));
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
			voltarBotao.setBackground(Color.LIGHT_GRAY);
			voltarBotao.setBounds(new Rectangle(459, 68, 113, 34));
			voltarBotao.setText("Voltar");
			voltarBotao.setBackground(Color.GRAY);

		}
		return voltarBotao;
	}
	
	
	public void configuraOuvinte(ActionListener controle){
		okCadastro.addActionListener(controle);
		okCadastro.setActionCommand("cadastrar");
		voltarBotao.addActionListener(controle);
		voltarBotao.setActionCommand("retornar");
		
	}
	
	public UsuarioPeriodoDespesaTO leDadosUsuario(){
		try{
			System.out.println("Antes de ocorrer o null pointer");
			
			String valor = valorText.getText();
			
			double valorReceita = Double.parseDouble(valor);
			
			validaValorNegativo(valorReceita);
			
			System.out.println(valorReceita);
			
			String receitaEscolhida=(String)despesaCombo.getSelectedItem();
			
			System.out.println(receitaEscolhida);
			
			String periodo=(String)periodoCombo.getSelectedItem();
			
			System.out.println(periodo);
					
			String infoArea= areaTex.getText();
			
			System.out.println(infoArea);
			
			UsuarioPeriodoDespesaTO to = new UsuarioPeriodoDespesaTO(valorReceita,receitaEscolhida,periodo,infoArea);
			
			return to;
			
		}

		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "O campo valor aceita apenas valores numéricos no formato R$ 10.00");
		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "O campo valor deve ser preenchido no formato R$ 0.00");
		}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "O campo valor deve ser maior que R$ 0.00");

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro obtendo dados da tela!");
		}
			return null;
	}
	
	private void validaValorNegativo(double valorReceita) {
		
		if(valorReceita <= 0){
			throw new IllegalArgumentException("A receita está com uma valor menor que R$ 0.01");
		}
		if(valorReceita <= 0.0){
			throw new IllegalArgumentException("A receita está com uma valor menor que R$ 0.01");

		}
		
	}

	public void populaComboDespesa(List<Despesa> despesa) {
		
		for(Despesa r : despesa){
			despesaCombo.addItem(r.getNomeDespesa());
		}
		
	}

	public void populaComboPeriodo(Periodo p) {
		periodoCombo.addItem(p.getMes() + " - " +  p.getAno());
		
	}
	
	public void modofechado(){
		this.setVisible(false);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
