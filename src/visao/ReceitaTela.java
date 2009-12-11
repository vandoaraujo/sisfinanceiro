package visao;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import modelo.Despesa;
import modelo.Receita;

import java.awt.event.ActionListener;
import java.util.List;

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
	private JButton excluirReceita = null;
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
			jContentPane.add(getJTextAreaReceita(), null);
			jContentPane.add(getJTextFieldNovaReceita(), null);
			jContentPane.add(idJLabel, null);
			jContentPane.add(nomeJLabel, null);
			jContentPane.add(fixaJLabel, null);
			jContentPane.add(getFixaJCheckBox(), null);
			jContentPane.add(fixaLabelNovaReceita, null);
			jContentPane.add(novaReceitaLabel, null);
			jContentPane.add(getCadastrarReceita(), null);
			jContentPane.add(getCadastrarReceita1(), null);
			jContentPane.add(getExcluirReceita(), null);
		}
		return jContentPane;
	}
	
	private void desabilitaBotao() {
		excluirReceita.setEnabled(false);
	}

	/**
	 * This method initializes jTextAreaReceita	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaReceita() {
		if (jTextAreaReceita == null) {
			jTextAreaReceita = new JTextArea();
			jTextAreaReceita.setBounds(new Rectangle(10, 103, 356, 151));
			jTextAreaReceita.setEditable(false);
			jTextAreaReceita.setAlignmentY(50);
			jTextAreaReceita.setAlignmentX(50);
			jTextAreaReceita.setFont(f2);
			jTextAreaReceita.setBackground(Color.YELLOW);
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
	private JTextField getJTextFieldNovaReceita() {
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
	private JButton getCadastrarReceita() {
		if (cadastrarReceita == null) {
			cadastrarReceita = new JButton();
			cadastrarReceita.setBounds(new Rectangle(373, 42, 135, 35));
			cadastrarReceita.setText("confirmar");
		}
		return cadastrarReceita;
	}

	/**
	 * This method initializes cadastrarDespesa1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCadastrarReceita1() {
		if (alterarReceita == null) {
			alterarReceita = new JButton();
			alterarReceita.setBounds(new Rectangle(374, 87, 135, 36));
			alterarReceita.setText("edicao");
		}
		return alterarReceita;
	}
	
	/**
	 * This method initializes excluirJButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExcluirReceita() {
		if (excluirReceita == null) {
			excluirReceita = new JButton();
			excluirReceita.setText("excluir");
			excluirReceita.setBounds(new Rectangle(374, 136, 133, 37));
		}
		return excluirReceita;
	}
	
	public void limpaReceitasArea(){
		   jTextAreaReceita.setText("");
	}

	public void configuraOuvinte(ActionListener controle){
			
			cadastrarReceita.addActionListener(controle);
			cadastrarReceita.setActionCommand("confirmar");
			alterarReceita.addActionListener(controle);
			alterarReceita.setActionCommand("edição");
			excluirReceita.addActionListener(controle);
			alterarReceita.setActionCommand("excluir");
		
	}
	
	public void carregaAreaReceitas(List<Receita> receitas) {
		StringBuilder s = new StringBuilder();
		for(Receita r: receitas){
			s.append(r.getId() + "\t\t     " + r.getNomeReceita() + "\n ");
		}
		
		String st = s.toString();
		jTextAreaReceita.append(st);
		
	}
	
	private boolean dadosObrigatorios() {
		String nomeDespesa = jTextFieldNovaReceita.getText();
		if(nomeDespesa.equals("")){
			return false;
		}
		
		return true;
	}
	
	public void populaCamposObjetoBanco(Receita r) {
		
		jTextFieldNovaReceita.setText(r.getNomeReceita());
		
		
	}
	
	public Receita leDadosTelaCadastro() {
		String fixaOuVariavel = "";
		
		//Antes de ler os dados, analisa se estao preenchidos o nome
		if(dadosObrigatorios()){
			
			String nomeReceita = jTextFieldNovaReceita.getText();
			boolean fixa = false;
			fixaOuVariavel = fixaJCheckBox.getText();
			System.out.println("TESTA CHECK " + fixaOuVariavel);
			
			if(!fixaOuVariavel.equals("")){
			
				fixa = true;
			}
			
			Receita rec = new Receita(nomeReceita);
			return rec;
		
		
		}else{
				JOptionPane.showMessageDialog(null, "Dados obrigatorios nao preenchidos!");
		}
			return null;
			
	}
	
	public void leDadosTelaCadastro(Receita r){
		
		String fixaOuVariavel = "";
		
		//Antes de ler os dados, analisa se estao preenchidos o nome
		if(dadosObrigatorios()){
			
			String nomeReceita = jTextFieldNovaReceita.getText();
			
			r.setNomeReceita(nomeReceita);
			
		
		}else{
				JOptionPane.showMessageDialog(null, "Dados obrigatorios nao preenchidos!");
		}
	}
	
	/**
	 * This method initializes excluirJButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExcluirButton() {
		if (excluirReceita == null) {
			excluirReceita = new JButton();
			excluirReceita.setBounds(new Rectangle(375, 148, 133, 37));
			excluirReceita.setText("excluir");
		}
		return excluirReceita;
	}



}  //  @jve:decl-index=0:visual-constraint="10,14"
