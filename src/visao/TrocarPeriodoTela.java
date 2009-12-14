package visao;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modelo.Periodo;

public class TrocarPeriodoTela extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JComboBox periodoCombo = null;
	private JButton trocarPeriodoBotao = null;
	private JLabel periodoLabel = null;
	/**
	 * This is the default constructor
	 */
	public TrocarPeriodoTela() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(570, 253);
		this.setContentPane(getJContentPane());
		this.setTitle("Troca de Período Corrente");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			periodoLabel = new JLabel("<html>Utilize a lista abaixo para trocar o período corrente, caso queira definir despesas ou receitas anteriores. Após isso cadastre sua despesa ou receita.</html>");
			periodoLabel.setBounds(new Rectangle(6, 8, 533, 52));
			periodoLabel.setBackground(new Color(0, 30, 218));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getPeriodoCombo(), null);
			jContentPane.add(getTrocarPeriodoBotao(), null);
			jContentPane.setBackground(new Color(0, 156, 218));
			jContentPane.add(periodoLabel, null);
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
			periodoCombo.setBounds(new Rectangle(113, 83, 308, 31));
			periodoCombo.setBackground(Color.YELLOW);

			
		}
		return periodoCombo;
	}

	/**
	 * This method initializes trocarPeriodoBotao	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getTrocarPeriodoBotao() {
		if (trocarPeriodoBotao == null) {
			trocarPeriodoBotao = new JButton();
			trocarPeriodoBotao.setBackground(Color.GREEN);
			trocarPeriodoBotao.setBounds(new Rectangle(207, 139, 133, 38));
			trocarPeriodoBotao.setText("OK!");
		}
		return trocarPeriodoBotao;
	}
	
	public void configuraOuvinte(ActionListener controle){
		trocarPeriodoBotao.addActionListener(controle);
		trocarPeriodoBotao.setActionCommand("trocarPeriodoCorrente");
				
	}
	
	public void populaComboPeriodos(List<Periodo> periodo){
		
		for(Periodo p : periodo){
			periodoCombo.addItem(p.getMes() + " - " +  p.getAno());
		}
		
	}
	
	public Periodo leComboTrocandoPeriodo(){
		String periodoAno = (String) periodoCombo.getSelectedItem();
		
		String periodoAnoAjustado [] = periodoAno.split(" - ");
		String mes = periodoAnoAjustado[0];
		String ano = periodoAnoAjustado[1];
		Periodo p = new Periodo();
		p.setMes(Integer.valueOf(mes));
		p.setAno(Integer.valueOf(ano));
		return p;
	}
	
	public void modofechado(){
		this.setVisible(false);
	}

}  //  @jve:decl-index=0:visual-constraint="93,50"
