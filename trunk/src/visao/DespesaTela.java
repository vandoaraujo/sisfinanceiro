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

import modelo.Despesa;
import modelo.Receita;
import javax.swing.JTable;

public class DespesaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextField jTextFieldNovaDespesa = null;
	private JCheckBox fixaJCheckBox = null;
	private JLabel fixaLabelNovaDespesa = null;
	private JLabel novaDespesaLabel = null;
	private JButton cadastrarDespesa = null;
	private JButton alterarDespesa = null;
	private Font f2;
	private JButton excluirJButton = null;
	private JScrollPane jScrollPaneDespesa = null;
	private JTable jTableDespesa = null;
	private Vector column;

	/**
	 * This is the default constructor
	 */
	public DespesaTela() {
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
		this.setTitle("Edição de Despesas");
		column= new Vector();
		column.add("Codigo");
		column.add("Nome");
		column.add("Fixa");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			novaDespesaLabel = new JLabel();
			novaDespesaLabel.setBounds(new Rectangle(14, 10, 201, 25));
			novaDespesaLabel.setText("Digite abaixo uma nova Despesa:");
			fixaLabelNovaDespesa = new JLabel();
			fixaLabelNovaDespesa.setBounds(new Rectangle(300, 46, 34, 23));
			fixaLabelNovaDespesa.setText("Fixa:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldNovaDespesa(), null);
			jContentPane.add(getFixaJCheckBox(), null);
			jContentPane.add(fixaLabelNovaDespesa, null);
			jContentPane.add(novaDespesaLabel, null);
			jContentPane.add(getCadastrarDespesa(), null);
			jContentPane.add(getCadastrarDespesa1(), null);
			jContentPane.add(getExcluirJButton(), null);
			jContentPane.add(getJScrollPaneDespesa(), null);
			desabilitaBotao();

		}
		return jContentPane;
	}

	private void desabilitaBotao() {
		excluirJButton.setEnabled(false);
	}
	
	public void limpaDespesas(){
		   jTableDespesa.clearSelection();
		   jTableDespesa.removeAll();
	}



	/**
	 * This method initializes jTextFieldNovaDespesa	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNovaDespesa() {
		if (jTextFieldNovaDespesa == null) {
			jTextFieldNovaDespesa = new JTextField();
			jTextFieldNovaDespesa.setBounds(new Rectangle(10, 45, 289, 27));
		}
		return jTextFieldNovaDespesa;
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
		if (cadastrarDespesa == null) {
			cadastrarDespesa = new JButton();
			cadastrarDespesa.setBounds(new Rectangle(373, 42, 135, 35));
			cadastrarDespesa.setText("confirmar");
		}
		return cadastrarDespesa;
	}

	/**
	 * This method initializes cadastrarDespesa1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCadastrarDespesa1() {
		if (alterarDespesa == null) {
			alterarDespesa = new JButton();
			alterarDespesa.setBounds(new Rectangle(374, 96, 135, 36));
			alterarDespesa.setText("edição");
		}
		return alterarDespesa;
	}

	public void configuraOuvinte(ActionListener controle){
			
			alterarDespesa.addActionListener(controle);
			alterarDespesa.setActionCommand("edicao");
			cadastrarDespesa.addActionListener(controle);
			cadastrarDespesa.setActionCommand("confirmar");
			excluirJButton.addActionListener(controle);
			excluirJButton.setActionCommand("excluir");
			
	}


	public void carregaAreaDespesas(List<Despesa> despesa) {
		
		Vector dod = new Vector();
		Vector linha = new Vector();
		for(Despesa r: despesa){

			dod.add((r.getId()));
			dod.add((r.getNomeDespesa()));
			dod.add(r.isDespesaFixa());
			linha.add(dod);
			dod = new Vector();
		
		}
		DefaultTableModel modelo = new DefaultTableModel(linha, column); 
		jTableDespesa.setModel(modelo);
		jTableDespesa.getColumnModel().getColumn(0).setPreferredWidth(50);
		jTableDespesa.getColumnModel().getColumn(1).setPreferredWidth(100);
		jTableDespesa.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		
	}

	public Despesa leDadosTelaCadastro() {
		String fixaOuVariavel = "";
		
		//Antes de ler os dados, analisa se estao preenchidos o nome
		if(dadosObrigatorios()){
			
			String nomeDespesa = jTextFieldNovaDespesa.getText();
			boolean fixa = false;
			fixaOuVariavel = fixaJCheckBox.getText();
			System.out.println("TESTA CHECK " + fixaOuVariavel);
			
			if(!fixaOuVariavel.equals("")){
			
				fixa = true;
			}
			
			Despesa desp = new Despesa(fixa,nomeDespesa);
			return desp;
		
		
		}else{
				JOptionPane.showMessageDialog(null, "Dados obrigatorios nao preenchidos!");
		}
			return null;
			
	}
	
	public void leDadosTelaCadastro(Despesa d){
		
		String fixaOuVariavel = "";
		
		//Antes de ler os dados, analisa se estao preenchidos o nome
		if(dadosObrigatorios()){
			
			String nomeDespesa = jTextFieldNovaDespesa.getText();
			boolean fixa = false;
			fixaOuVariavel = fixaJCheckBox.getText();
			
			if(!fixaOuVariavel.equals("")){
			
				fixa = true;
			}
			d.setNomeDespesa(nomeDespesa);
			d.setDespesaFixa(fixa);
		
		}else{
				JOptionPane.showMessageDialog(null, "Dados obrigatorios nao preenchidos!");
		}
	}

	private boolean dadosObrigatorios() {
		String nomeDespesa = jTextFieldNovaDespesa.getText();
		if(nomeDespesa.equals("")){
			return false;
		}
		
		return true;
	}

	public void populaCamposObjetoBanco(Despesa d) {
		
		jTextFieldNovaDespesa.setText(d.getNomeDespesa());
		if(d.isDespesaFixa()){
			fixaJCheckBox.setEnabled(true);
		}
		
		excluirJButton.setEnabled(true);
		
	}

	/**
	 * This method initializes excluirJButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExcluirJButton() {
		if (excluirJButton == null) {
			excluirJButton = new JButton();
			excluirJButton.setBounds(new Rectangle(375, 148, 133, 37));
			excluirJButton.setText("excluir");
		}
		return excluirJButton;
	}

	/**
	 * This method initializes jScrollPaneDespesa	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPaneDespesa() {
		if (jScrollPaneDespesa == null) {
			jScrollPaneDespesa = new JScrollPane();
			jScrollPaneDespesa.setBounds(new Rectangle(13, 99, 341, 146));
			jScrollPaneDespesa.setViewportView(getJTableDespesa());
		}
		return jScrollPaneDespesa;
	}

	/**
	 * This method initializes jTableDespesa	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDespesa() {
		if (jTableDespesa == null) {
			jTableDespesa = new JTable();
		}
		return jTableDespesa;
	}
	
	
	



}  //  @jve:decl-index=0:visual-constraint="10,14"
