package controle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.DespesaUsuarioPeriodo;
import modelo.Periodo;
import modelo.ReceitaUsuarioPeriodo;
import modelo.Usuario;
import visao.RelatorioSimplesMensalDespesaReceitaTela;
import dao.PeriodoDao;
import dao.UsuarioDao;

public class RelatorioFinanceiroControle implements ActionListener {

	RelatorioSimplesMensalDespesaReceitaTela vc;
	
	private static RelatorioFinanceiroControle singleton=null;
	
	public static RelatorioFinanceiroControle getInstance(){
		if(singleton==null){
			singleton= new RelatorioFinanceiroControle();
		}
			return singleton;
	}
		
	private RelatorioFinanceiroControle() {
	}
	
	public void configuraTela(RelatorioSimplesMensalDespesaReceitaTela vc){
		//logger.isDebugEnabled();
		this.vc=vc;
		//vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vc.configuraOuvinte(this);	
		vc.setResizable(false);
		vc.setLocationRelativeTo(null);
	}
		
	public void habilita(){
		vc.setModal(true);
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("carregarRelatorio")))
		{
			efetuaLogica(vc);
			
			//Periodo p =formataComboPeriodo(toReceita.getPeriodo());
		}
		else if(comando.equals("retornar"))
		{
			System.out.println("OUTRA FUNCIONALIDADE DO RELATORIO!");
		}
	}
	
	private void efetuaLogica(RelatorioSimplesMensalDespesaReceitaTela vc2) {
		
		Usuario usuarioInstance = UsuarioDao.getUsuarioLogado();
		
		Periodo p = vc.lePeriodo();
		
		List<DespesaUsuarioPeriodo> despesasUsuarioPeriodo = PeriodoDao.getInstance().buscaDespesasPeriodo(p,usuarioInstance);
		
		List<ReceitaUsuarioPeriodo> receitasUsuarioPeriodo = PeriodoDao.getInstance().buscaReceitasPeriodo(p,usuarioInstance);
		
		avaliaPeriodo(despesasUsuarioPeriodo, receitasUsuarioPeriodo);

		
	}

	private void avaliaPeriodo(
			List<DespesaUsuarioPeriodo> despesasUsuarioPeriodo,
			List<ReceitaUsuarioPeriodo> receitasUsuarioPeriodo) {
		
		if(despesasUsuarioPeriodo.size() != 0 || receitasUsuarioPeriodo.size() != 0){
			
			vc.limpaTela();
			double totalR = totalizaReceitas(receitasUsuarioPeriodo);
			double totalD = totalizaDespesas(despesasUsuarioPeriodo);
			double valorFinal = calculaDiferenca(totalR,totalD);
			
			vc.carregaAreaDespesas(despesasUsuarioPeriodo);
			vc.carregaAreaReceitas(receitasUsuarioPeriodo);
			vc.populaResultados(totalR, totalD, valorFinal);
			
			//efetuaTrocaCor
			preencheCorConformeSaldo(valorFinal);

		}
		else{
			vc.limpaTela();
			JOptionPane.showMessageDialog(null,"Não há registros no período informado!" );
		}
		
		
	}

	private void preencheCorConformeSaldo(double valorFinal) {
		
		JTextField campoSaldo = vc.trocaCorSaldo();
		if(valorFinal > 0){
			campoSaldo.setBackground(Color.GREEN);
			JOptionPane.showMessageDialog(null, "Parabéns, você está com saldo!!!");
		}
		else{
			campoSaldo.setBackground(Color.RED);
			JOptionPane.showMessageDialog(null, "Cuidado, você está com prejuízo!!!");
		}
		
	}

	private double calculaDiferenca(double totalR, double totalD) {
		
		BigDecimal subtracao;
		//double totalReceitas = 0;
		subtracao = new BigDecimal(0.0);
		subtracao.setScale(2, RoundingMode.FLOOR);
		subtracao = subtracao.add(new BigDecimal(totalR));
		subtracao = subtracao.subtract(new BigDecimal(totalD));
		System.out.println("TESTE COM BIGDECIMAL "  + subtracao);
		System.out.println("TESTE COM DOUBLE " + subtracao.doubleValue());
		return subtracao.doubleValue();
		
	}

	private double totalizaDespesas(
			List<DespesaUsuarioPeriodo> despesasUsuarioPeriodo) {
		
		BigDecimal soma;
		//double totalReceitas = 0;
		soma = new BigDecimal(0.0);
		soma.setScale(2, RoundingMode.FLOOR);
		for(DespesaUsuarioPeriodo d : despesasUsuarioPeriodo){
			soma =  soma.add(new BigDecimal(d.getValor()));
		}
		 
		System.out.println("TOTAL DESPESA " + soma.doubleValue());
		
		return soma.doubleValue();
	}

	private double totalizaReceitas(
			List<ReceitaUsuarioPeriodo> receitasUsuarioPeriodo) {
		
		BigDecimal soma;
		//double totalReceitas = 0;
		soma = new BigDecimal(0.0);
		soma.setScale(2, RoundingMode.FLOOR);
		for(ReceitaUsuarioPeriodo r : receitasUsuarioPeriodo){
			soma =  soma.add(new BigDecimal(r.getValor()));
		}
		
		System.out.println("TOTAL RECEITA " + soma.doubleValue());
		
		return soma.doubleValue();

	}

	public void populaComboPeriodo(List<Periodo> p) {
		
		vc.populaComboPeriodos(p);
	
	}

}
