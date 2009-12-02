package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Despesa;

public class DespesaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea jTextAreaDespesa = null;
	private JTextField jTextFieldNovaDespesa = null;
	private JLabel idJLabel = null;
	private JLabel nomeJLabel = null;
	private JLabel fixaJLabel = null;
	private JCheckBox fixaJCheckBox = null;
	private JLabel fixaLabelNovaDespesa = null;
	private JLabel novaDespesaLabel = null;
	private JButton cadastrarDespesa = null;
	private JButton alterarDespesa = null;
	private Font f2;
	private JButton excluirJButton = null;
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
		this.setTitle("JFrame");
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
			jContentPane.add(fixaLabelNovaDespesa, null);
			jContentPane.add(novaDespesaLabel, null);
			jContentPane.add(getCadastrarDespesa(), null);
			jContentPane.add(getCadastrarDespesa1(), null);
			jContentPane.add(getExcluirJButton(), null);
			desabilitaBotao();

		}
		return jContentPane;
	}

	private void desabilitaBotao() {
		excluirJButton.setEnabled(false);
	}
	
	

	/**
	 * This method initializes jTextAreaDespesa	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaDespesa() {
		if (jTextAreaDespesa == null) {
			jTextAreaDespesa = new JTextArea();
			jTextAreaDespesa.setBounds(new Rectangle(10, 103, 356, 151));
			jTextAreaDespesa.setEditable(false);
			jTextAreaDespesa.setAlignmentY(50);
			jTextAreaDespesa.setAlignmentX(50);
			jTextAreaDespesa.setFont(f2);
			jTextAreaDespesa.setBackground(Color.YELLOW);
			JScrollPane jscroll=new JScrollPane(jTextAreaDespesa);
		    jscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jscroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
		}
		return jTextAreaDespesa;
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
	
	public void limpaDespesasArea(){
		   jTextAreaDespesa.setText("");
	}

	public void configuraOuvinte(ActionListener controle){
			
			alterarDespesa.addActionListener(controle);
			alterarDespesa.setActionCommand("edicao");
			cadastrarDespesa.addActionListener(controle);
			cadastrarDespesa.setActionCommand("confirmar");
			excluirJButton.addActionListener(controle);
			excluirJButton.setActionCommand("excluir");
			
	}

	public void carregaAreaDespesas(List<Despesa> despesas) {
		StringBuilder s = new StringBuilder();
		for(Despesa d: despesas){
			s.append(d.getId() + "\t\t     " + d.getNomeDespesa() + "\t\t   " +  d.isDespesaFixa() + "\n ");
		}
		
		String st = s.toString();
		jTextAreaDespesa.append(st);
		
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
	
	
	



}  //  @jve:decl-index=0:visual-constraint="10,14"
