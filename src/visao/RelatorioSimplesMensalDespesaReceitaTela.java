package visao;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.DespesaUsuarioPeriodo;
import modelo.Periodo;
import modelo.ReceitaUsuarioPeriodo;
import dao.PeriodoDao;

public class RelatorioSimplesMensalDespesaReceitaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox periodoCombo = null;
	private JButton acaoBotaoCarregaRelatorio = null;
	private JLabel receitasLabel = null;
	private JLabel despesasLabel = null;
	private JTextField totalReceitas = null;
	private JTextField totalDespesas = null;
	private JTextField saldoCampo = null;
	private JLabel saldojLabel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTableDespesas = null;
	private JScrollPane jScrollPane1 = null;  //  @jve:decl-index=0:visual-constraint="45,155"
	private JTable jTableReceita = null;
	Vector column;

	/**
	 * This is the default constructor
	 */
	public RelatorioSimplesMensalDespesaReceitaTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(735, 478);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		column= new Vector();
		column.add("Nome");
		column.add("Valor");

		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			saldojLabel = new JLabel();
			saldojLabel.setBounds(new Rectangle(553, 151, 131, 23));
			saldojLabel.setText("saldo Final no Mês:");
			despesasLabel = new JLabel();
			despesasLabel.setBounds(new Rectangle(350, 74, 108, 19));
			despesasLabel.setText("Despesas:");
			receitasLabel = new JLabel();
			receitasLabel.setBounds(new Rectangle(91, 76, 89, 20));
			receitasLabel.setText("Receitas:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPeriodoCombo(), null);
			jContentPane.add(getAcaoBotaoCarregaRelatorio(), null);
			jContentPane.add(receitasLabel, null);
			jContentPane.add(despesasLabel, null);
			jContentPane.add(getTotalReceitas(), null);
			jContentPane.add(getTotalDespesas(), null);
			jContentPane.add(getSaldoCampo(), null);
			jContentPane.add(saldojLabel, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJScrollPane1(), null);
			saldoCampo.setEditable(false);
			totalDespesas.setEditable(false);
			totalReceitas.setEditable(false);
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
			periodoCombo.setBounds(new Rectangle(125, 23, 318, 27));
		}
		return periodoCombo;
	}

	/**
	 * This method initializes acaoBotaoCarregaRelatorio	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAcaoBotaoCarregaRelatorio() {
		if (acaoBotaoCarregaRelatorio == null) {
			acaoBotaoCarregaRelatorio = new JButton();
			acaoBotaoCarregaRelatorio.setBounds(new Rectangle(474, 21, 119, 30));
			acaoBotaoCarregaRelatorio.setText("Processar!");
		}
		return acaoBotaoCarregaRelatorio;
	}

	/**
	 * This method initializes totalReceitas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTotalReceitas() {
		if (totalReceitas == null) {
			totalReceitas = new JTextField();
			totalReceitas.setEditable(false);
			totalReceitas.setBounds(new Rectangle(37, 405, 207, 26));
		}
		return totalReceitas;
	}

	/**
	 * This method initializes totalDespesas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTotalDespesas() {
		if (totalDespesas == null) {
			totalDespesas = new JTextField();
			totalDespesas.setEditable(false);
			totalDespesas.setBounds(new Rectangle(294, 405, 218, 26));
		}
		return totalDespesas;
	}

	/**
	 * This method initializes saldoCampo	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getSaldoCampo() {
		if (saldoCampo == null) {
			saldoCampo = new JTextField();
			saldoCampo.setEditable(false);
			saldoCampo.setBounds(new Rectangle(552, 202, 135, 23));
		}
		return saldoCampo;
	}
	
	public void configuraOuvinte(ActionListener controle){
		acaoBotaoCarregaRelatorio.addActionListener(controle);
		acaoBotaoCarregaRelatorio.setActionCommand("carregarRelatorio");
	}
	
	public Periodo lePeriodo(){
		try{
			String periodo= (String)periodoCombo.getSelectedItem();
			
			Periodo p = formataComboPeriodo(periodo);
									
			return p;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Dados invalidos!");
		}
		return null;
	}
	
	public void populaComboPeriodos(List<Periodo> periodo){
		
		for(Periodo p : periodo){
			periodoCombo.addItem(p.getMes() + " - " +  p.getAno());
		}
		
	}

	public void carregaAreaDespesas(List<DespesaUsuarioPeriodo> despesas) {
		
		Vector dod = new Vector();
		Vector linha = new Vector();
		for(DespesaUsuarioPeriodo r: despesas){

			dod.add((r.getChaveComposta().getDespesa_id().getNomeDespesa()));
			dod.add((r.getValor()));
			linha.add(dod);
			dod = new Vector();
		
		}
		DefaultTableModel modelo = new DefaultTableModel(linha, column); 
		jTableDespesas.setModel(modelo);
		jTableDespesas.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTableDespesas.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		
	}
	
	public void carregaAreaReceitas(List<ReceitaUsuarioPeriodo> receitas) {
		
		Vector dod = new Vector();
		Vector linhaReceita = new Vector();
		for(ReceitaUsuarioPeriodo r: receitas){

			dod.add((r.getChaveComposta().getReceita_id().getNomeReceita()));
			dod.add((r.getValor().toString()));
			linhaReceita.add(dod);
			dod = new Vector();
		}

		DefaultTableModel modelo = new DefaultTableModel(linhaReceita, column); 
		jTableReceita.setModel(modelo);
		jTableReceita.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTableReceita.getColumnModel().getColumn(1).setPreferredWidth(50);
		
		
	}
	
	public void modofechado(){
		this.setVisible(false);
	}
	
	public void populaResultados(double totReceita, double totDespesa, double totSaldo){
		
		totalReceitas.setText(String.valueOf(totReceita));
		totalDespesas.setText(String.valueOf(totDespesa));
		saldoCampo.setText(String.valueOf(totSaldo));
	}
	
	private Periodo formataComboPeriodo(String periodo){
		
		String periodoAnoAjustado [] = periodo.split(" - ");
		
		String mes = periodoAnoAjustado[0];
		String ano = periodoAnoAjustado[1];
		//Busca no banco de dados
		Periodo p = PeriodoDao.getInstance().buscarPeriodoMesAno(Integer.valueOf(mes), Integer.valueOf(ano));
		return p;
	}

	public void limpaTela() {
		
		//areaDespesas.setText("");
		//areaReceitas.setText("");
		saldoCampo.setText("");
		totalDespesas.setText("");
		totalReceitas.setText("");
		
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(295, 110, 216, 261));
			jScrollPane.setViewportView(getJTableDespesas());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTableDespesas	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTableDespesas() {
		if (jTableDespesas == null) {
			jTableDespesas = new JTable();

		}
		return jTableDespesas;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setSize(new Dimension(206, 262));
			jScrollPane1.setViewportView(getJTableReceita());
			jScrollPane1.setLocation(new Point(38, 109));
		}
		return jScrollPane1;
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

}  //  @jve:decl-index=0:visual-constraint="10,10"
