package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import modelo.DespesaUsuarioPeriodo;
import modelo.Periodo;
import modelo.ReceitaUsuarioPeriodo;
import modelo.Usuario;
import util.NumberUtil;
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
		vc.setVisible(true);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("carregarRelatorio")))
		{
			Usuario usuarioInstance = UsuarioDao.getUsuarioLogado();
			
			Periodo p = vc.lePeriodo();
			
			List<DespesaUsuarioPeriodo> despesasUsuarioPeriodo = PeriodoDao.getInstance().buscaDespesasPeriodo(p,usuarioInstance);
			
			List<ReceitaUsuarioPeriodo> receitasUsuarioPeriodo = PeriodoDao.getInstance().buscaReceitasPeriodo(p,usuarioInstance);
			
			vc.carregaAreaDespesas(despesasUsuarioPeriodo);
			vc.carregaAreaReceitas(receitasUsuarioPeriodo);
			
			double totalR = totalizaReceitas(receitasUsuarioPeriodo);
			double totalD = totalizaDespesas(despesasUsuarioPeriodo);
			
			double valorFinal = calculaDiferenca(totalR,totalD);
			
			System.out.println("VALOR FINAL " + NumberUtil.truncate(2, valorFinal));
			
			//Periodo p =formataComboPeriodo(toReceita.getPeriodo());
		}
		else if(comando.equals("retornar"))
		{
			System.out.println("OUTRA FUNCIONALIDADE DO RELATORIO!");
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
