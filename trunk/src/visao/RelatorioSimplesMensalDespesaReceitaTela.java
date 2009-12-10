package visao;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.Despesa;
import modelo.DespesaUsuarioPeriodo;
import modelo.Periodo;
import modelo.ReceitaUsuarioPeriodo;
import dao.PeriodoDao;

public class RelatorioSimplesMensalDespesaReceitaTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox periodoCombo = null;
	private JButton acaoBotaoCarregaRelatorio = null;
	private JTextArea areaReceitas = null;
	private JTextArea areaDespesas = null;
	private JLabel receitasLabel = null;
	private JLabel despesasLabel = null;
	private JTextField totalReceitas = null;
	private JTextField totalDespesas = null;
	private JTextField saldoCampo = null;
	private JLabel saldojLabel = null;

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
		this.setSize(730, 478);
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
			saldojLabel = new JLabel();
			saldojLabel.setBounds(new Rectangle(570, 93, 131, 23));
			saldojLabel.setText("saldo:");
			despesasLabel = new JLabel();
			despesasLabel.setBounds(new Rectangle(358, 67, 108, 19));
			despesasLabel.setText("Despesas:");
			receitasLabel = new JLabel();
			receitasLabel.setBounds(new Rectangle(101, 66, 89, 20));
			receitasLabel.setText("Receitas:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPeriodoCombo(), null);
			jContentPane.add(getAcaoBotaoCarregaRelatorio(), null);
			jContentPane.add(getAreaReceitas(), null);
			jContentPane.add(getAreaDespesas(), null);
			jContentPane.add(receitasLabel, null);
			jContentPane.add(despesasLabel, null);
			jContentPane.add(getTotalReceitas(), null);
			jContentPane.add(getTotalDespesas(), null);
			jContentPane.add(getSaldoCampo(), null);
			jContentPane.add(saldojLabel, null);
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
	 * This method initializes areaReceitas	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAreaReceitas() {
		if (areaReceitas == null) {
			areaReceitas = new JTextArea();
			areaReceitas.setBounds(new Rectangle(14, 95, 259, 294));
		}
		return areaReceitas;
	}

	/**
	 * This method initializes areaDespesas	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAreaDespesas() {
		if (areaDespesas == null) {
			areaDespesas = new JTextArea();
			areaDespesas.setBounds(new Rectangle(282, 95, 260, 294));
		}
		return areaDespesas;
	}

	/**
	 * This method initializes totalReceitas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTotalReceitas() {
		if (totalReceitas == null) {
			totalReceitas = new JTextField();
			totalReceitas.setBounds(new Rectangle(15, 405, 260, 26));
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
			totalDespesas.setBounds(new Rectangle(281, 405, 261, 26));
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
			saldoCampo.setBounds(new Rectangle(570, 128, 135, 23));
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
		StringBuilder s = new StringBuilder();
		for(DespesaUsuarioPeriodo d: despesas){
			s.append(d.getChaveComposta().getDespesa_id().getNomeDespesa() + "\t " +  d.getValor());
		}
		
		String st = s.toString();
		areaDespesas.append(st);
		
	}
	
	public void carregaAreaReceitas(List<ReceitaUsuarioPeriodo> receitas) {
		StringBuilder s = new StringBuilder();
		for(ReceitaUsuarioPeriodo r: receitas){
			s.append(r.getChaveComposta().getReceita_id().getNomeReceita() + "\t " +  r.getValor());
		}
		
		String st = s.toString();
		areaReceitas.append(st);
		
	}
	
	public void modofechado(){
		this.setVisible(false);
	}
	
	private Periodo formataComboPeriodo(String periodo){
		
		String periodoAnoAjustado [] = periodo.split(" - ");
		
		String mes = periodoAnoAjustado[0];
		String ano = periodoAnoAjustado[1];
		//Busca no banco de dados
		Periodo p = PeriodoDao.getInstance().buscarPeriodoMesAno(Integer.valueOf(mes), Integer.valueOf(ano));
		return p;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
