package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import modelo.Periodo;
import visao.TrocarPeriodoTela;
import dao.PeriodoDao;

public class PeriodoTelaControle implements ActionListener {
	
	Logger log = Logger.getLogger(PeriodoTelaControle.class);

	TrocarPeriodoTela vc;
	
	static Periodo periodoAtualSelecionado = null;
	
	private static PeriodoTelaControle singleton=null;
	
	public static PeriodoTelaControle getInstance(){
		if(singleton==null){
			singleton= new PeriodoTelaControle();
			configuraPeriodoAtual();
		}
			return singleton;
	}
		
	private static void configuraPeriodoAtual() {
		
	    Periodo p = PeriodoDao.getInstance().listarUltimoPeriodo2();
		periodoAtualSelecionado = p;
		
	}

	private PeriodoTelaControle() {
	}
	
	public void configuraTela(TrocarPeriodoTela vc){
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
	
	public void populaComboVista(List<Periodo> p ){
		
		vc.populaComboPeriodos(p);
	}
			


	public void actionPerformed(ActionEvent eve) {
		// TODO Auto-generated method stub

		String comando = eve.getActionCommand();
		
		if(comando.equals(("carregarRelatorio")))
		{
			
		}
		else if(comando.equals("retornar"))
		{
			System.out.println("OUTRA FUNCIONALIDADE DO RELATORIO!");
		}
		else if(comando.equals("trocarPeriodoCorrente")){
			Periodo p = vc.leComboTrocandoPeriodo();
			//Define o per�odo que o usu�rio selecionou
			periodoAtualSelecionado = p;
			log.info("Ano ap�s ajuste " + periodoAtualSelecionado.getAno());
			log.info("M�s ap�s ajuste " + periodoAtualSelecionado.getMes());
			
		}
	}

	public static Periodo getPeriodoAtualSelecionado() {
		
		if(periodoAtualSelecionado != null)
			return periodoAtualSelecionado;
		else
			return periodoAtualSelecionado = (Periodo) PeriodoDao.getInstance().listarUltimoPeriodo2();
	}

}
