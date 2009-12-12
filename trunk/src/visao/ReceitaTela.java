package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.DespesaUsuarioPeriodo;
import modelo.Receita;
import javax.swing.JTable;

public class ReceitaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextFieldNovaReceita = null;
	private JLabel novaReceitaLabel = null;
	private JButton cadastrarReceita = null;
	private JButton alterarReceita = null;
	private JButton excluirReceita = null;
	private Font f2;
	private Vector column;
	private JScrollPane jScrollPaneReceita = null;
	private JTable jTableReceita = null;
	
	
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
		this.setTitle("Edição de Receitas");
		column= new Vector();
		column.add("Codigo");
		column.add("Nome");
		
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
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldNovaReceita(), null);
			jContentPane.add(novaReceitaLabel, null);
			jContentPane.add(getCadastrarReceita(), null);
			jContentPane.add(getCadastrarReceita1(), null);
			jContentPane.add(getExcluirReceita(), null);
			jContentPane.add(getJScrollPaneReceita(), null);
			desabilitaBotao();
		}
		return jContentPane;
	}
	
	private void desabilitaBotao() {
		excluirReceita.setEnabled(false);
	}

	/**
	 * This method initializes jTextFieldNovaDespesa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNovaReceita() {
		if (jTextFieldNovaReceita == null) {
			jTextFieldNovaReceita = new JTextField();
			jTextFieldNovaReceita.setBounds(new Rectangle(10, 45, 352, 27));
		}
		return jTextFieldNovaReceita;
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
	
	public void limpaReceitas(){
		   jTableReceita.clearSelection();
		   jTableReceita.removeAll();
	}

	public void carregaAreaReceitas(List<Receita> receita) {
		
		Vector dod = new Vector();
		Vector linha = new Vector();
		for(Receita r: receita){

			dod.add((r.getId()));
			dod.add((r.getNomeReceita()));
			linha.add(dod);
			dod = new Vector();
		
		}
		DefaultTableModel modelo = new DefaultTableModel(linha, column); 
		jTableReceita.setModel(modelo);
		jTableReceita.getColumnModel().getColumn(0).setPreferredWidth(50);
		jTableReceita.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		
	}

	public void configuraOuvinte(ActionListener controle){
			
			alterarReceita.addActionListener(controle);
			alterarReceita.setActionCommand("edicao");
			cadastrarReceita.addActionListener(controle);
			cadastrarReceita.setActionCommand("confirmar");
			excluirReceita.addActionListener(controle);
			excluirReceita.setActionCommand("excluir");
		
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
		excluirReceita.setEnabled(true);
	}
	
	public Receita leDadosTelaCadastro() {
		
		//Antes de ler os dados, analisa se estao preenchidos o nome
		if(dadosObrigatorios()){
			
			String nomeReceita = jTextFieldNovaReceita.getText();
			Receita rec = new Receita(nomeReceita);
			return rec;
		
		}else{
				JOptionPane.showMessageDialog(null, "Dados obrigatorios nao preenchidos!");
		}
			return null;
			
	}
	
	public void leDadosTelaCadastro(Receita r){
		
		//Antes de ler os dados, analisa se estao preenchidos o nome
		if(dadosObrigatorios()){
			
			String nomeReceita = jTextFieldNovaReceita.getText();
			r.setNomeReceita(nomeReceita);
			
		}else{
				JOptionPane.showMessageDialog(null, "Dados obrigatorios nao preenchidos!");
		}
	}
	
	/**
	 * This method initializes jScrollPaneReceita	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneReceita() {
		if (jScrollPaneReceita == null) {
			jScrollPaneReceita = new JScrollPane();
			jScrollPaneReceita.setBounds(new Rectangle(14, 97, 351, 147));
			jScrollPaneReceita.setViewportView(getJTableReceita());
		}
		return jScrollPaneReceita;
	}

	/**
	 * This method initializes jTableReceita	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableReceita() {
		if (jTableReceita == null) {
			jTableReceita = new JTable();
		}
		return jTableReceita;
	}



}  //  @jve:decl-index=0:visual-constraint="10,14"
