package visao;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaPrincipalSisFinanceiro extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	
	private JMenuBar menuPrincipal = null;
	
	private JMenu menuSobre = null;
	
	private JMenu menuCadastro = null;
	
	private JMenu menuFinancasUsuario = null;
	
	private JMenu menuEstatisticasRelatorio = null;
	
	private JMenuItem subMenuCadastroReceita = null;  //  @jve:decl-index=0:visual-constraint="811,11"
	
	private JMenuItem subMenuCadastroDespesa = null;
	
	private JMenuItem subMenuPeriodos = null;
	
	private JMenuItem subMenuDadosUsuario = null;
	
	private JMenuItem subMenuEstatisticasPeriodo = null;
	
	private JMenuItem subMenuEstatisticasRelatorio = null;
	
	private JMenuItem subMenuDespesasUsuarioItem = null;
	
	private JMenuItem subMenuReceitasUsuarioItem = null;
	
	private JMenuItem sobre = null;

	private JLabel jLabelImagem = null;

	/**
	 * This is the default constructor
	 */
	public TelaPrincipalSisFinanceiro() {
		super();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		this.setSize(568, 405);
		this.setJMenuBar(getPrincipalMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("SisFinanceiro - Controle Financeiro Pessoal");
		this.setLocationRelativeTo(null);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelImagem = new JLabel();
			jLabelImagem.setBounds(new Rectangle(2, 1, 563, 344));
			jLabelImagem.setText("");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(0, 156, 218));
			jContentPane.add(jLabelImagem, null);
			jLabelImagem.setIcon(new ImageIcon("..\\sisfinanceiro\\src\\images\\imagem.jpg"));
			

		}
		return jContentPane;
	}
	
	private JMenuBar getPrincipalMenuBar(){
		if(menuPrincipal==null){
			menuPrincipal=new JMenuBar();
			menuPrincipal.add(getCadastrar());
			menuPrincipal.add(getMenuInformacoesFinanceirasUsuario());
			menuPrincipal.add(getMenuEstatisticasRelatorios());
			menuPrincipal.add(getSobre());
			
		}
		return menuPrincipal;
	}
		
	private JMenu getCadastrar(){
		if(menuCadastro==null){
			menuCadastro=new JMenu();
			menuCadastro.setText("Cadastros");
			menuCadastro.add(getDespesa());
			menuCadastro.add(getReceita());
			menuCadastro.add(getPeriodo());
			menuCadastro.add(getDadosUsuario());
		}
		
		return menuCadastro;
	}
	
	private JMenu getMenuInformacoesFinanceirasUsuario(){
		if(menuFinancasUsuario==null){
			menuFinancasUsuario=new JMenu();
			menuFinancasUsuario.setText("Ganhos e Gastos");
			menuFinancasUsuario.add(getMenuDespesasUsuario());
			menuFinancasUsuario.add(getMenuReceitasUsuario());
		}
		
		return menuFinancasUsuario;
	}
	
	private JMenu getMenuEstatisticasRelatorios(){
		if(menuEstatisticasRelatorio==null){
			menuEstatisticasRelatorio=new JMenu();
			menuEstatisticasRelatorio.setText("Estatísticas");
			menuEstatisticasRelatorio.add(getMenuTrocarPeriodoCorrente());
			menuEstatisticasRelatorio.add(getMenuAnaliseRelatorio());
		}
		
		return menuEstatisticasRelatorio;
	}
	
	private JMenuItem getMenuTrocarPeriodoCorrente(){
		if(subMenuEstatisticasPeriodo==null){
			subMenuEstatisticasPeriodo=new JMenuItem();
			subMenuEstatisticasPeriodo.setText("Trocar Período");
			subMenuEstatisticasPeriodo.setMnemonic(KeyEvent.VK_P);
		}
		return subMenuEstatisticasPeriodo;
	}
	
	private JMenuItem getMenuAnaliseRelatorio(){
		if(subMenuEstatisticasRelatorio==null){
			subMenuEstatisticasRelatorio=new JMenuItem();
			subMenuEstatisticasRelatorio.setText("Relatórios");
			subMenuEstatisticasRelatorio.setMnemonic(KeyEvent.VK_R);
		}
		return subMenuEstatisticasRelatorio;
	}
	
	
	private JMenu getSobre(){
		if(menuSobre==null){
			menuSobre=new JMenu();
			menuSobre.setText("Sobre");
			menuSobre.add(getSobreSisFinanceiro());
		}
		
		return menuSobre;
	}
	
   	private JMenuItem getDespesa(){
		if(subMenuCadastroDespesa==null){
			subMenuCadastroDespesa=new JMenuItem();
			subMenuCadastroDespesa.setText("Tabela Despesas");
			subMenuCadastroDespesa.setMnemonic(KeyEvent.VK_N);
		}
		return subMenuCadastroDespesa;
	}
	
	private JMenuItem getReceita(){
		if(subMenuCadastroReceita==null){
			subMenuCadastroReceita=new JMenuItem();
			subMenuCadastroReceita.setText("Tabela Receitas");
			subMenuCadastroReceita.setMnemonic(KeyEvent.VK_A);
		}
		return subMenuCadastroReceita;
	}
	
	private JMenuItem getMenuDespesasUsuario(){
		if(subMenuDespesasUsuarioItem==null){
			subMenuDespesasUsuarioItem=new JMenuItem();
			subMenuDespesasUsuarioItem.setText("Despesas...");

		}
		return subMenuDespesasUsuarioItem;
	}
	
	private JMenuItem getMenuReceitasUsuario(){
		if(subMenuReceitasUsuarioItem==null){
			subMenuReceitasUsuarioItem=new JMenuItem();
			subMenuReceitasUsuarioItem.setText("Receitas...");

		}
		return subMenuReceitasUsuarioItem;
	}
	
	private JMenuItem getPeriodo(){
		if(subMenuPeriodos==null){
			subMenuPeriodos=new JMenuItem();
			subMenuPeriodos.setText("Tabela Períodos...");
			subMenuPeriodos.setMnemonic(KeyEvent.VK_O);
		}
		return subMenuPeriodos;
	}
	
	private JMenuItem getDadosUsuario(){
		if(subMenuDadosUsuario==null){
			subMenuDadosUsuario=new JMenuItem();
			subMenuDadosUsuario.setText("Meus dados");
			subMenuDadosUsuario.setMnemonic(KeyEvent.VK_U);
		}
		return subMenuDadosUsuario;
	}
	
	private JMenuItem getSobreSisFinanceiro(){
		if(sobre==null){
			sobre=new JMenuItem();
			sobre.setText("Sobre o SisFinanceiro...");
			sobre.setMnemonic(KeyEvent.VK_F);
		}
		return sobre;
	}
	
	public void configuraOuvinte(ActionListener controle)
	{
		subMenuCadastroDespesa.addActionListener(controle);
		subMenuCadastroDespesa.setActionCommand("tabelaDespesas");
		subMenuCadastroReceita.addActionListener(controle);
		subMenuCadastroReceita.setActionCommand("tabelaReceitas");
		subMenuPeriodos.addActionListener(controle);
		subMenuPeriodos.setActionCommand("tabelaPeriodos");
		subMenuDadosUsuario.addActionListener(controle);
		subMenuDadosUsuario.setActionCommand("dadosUsuario");
		subMenuEstatisticasPeriodo.addActionListener(controle);
		subMenuEstatisticasPeriodo.setActionCommand("trocarPeriodo");
		subMenuEstatisticasRelatorio.addActionListener(controle);
		subMenuEstatisticasRelatorio.setActionCommand("estatisticas");
		subMenuDespesasUsuarioItem.addActionListener(controle);
		subMenuDespesasUsuarioItem.setActionCommand("despesasUsuario");
		subMenuReceitasUsuarioItem.addActionListener(controle);
		subMenuReceitasUsuarioItem.setActionCommand("receitasUsuario");
		sobre.addActionListener(controle);
		sobre.setActionCommand("sobre");
		
	}
	
}  //  @jve:decl-index=0:visual-constraint="143,44"
