package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import visao.LoginTela;
import visao.TelaAberturaJWindow;
import visao.TelaPrincipalSisFinanceiro;
import controle.ControlaSisFinanceiro;
import controle.LoginControle;
import dao.HibernateUtil;

public class SisFinanceiroMain {

	private static TelaAberturaJWindow sp;
	private static HibernateUtil dbClass;
    static Logger logger = Logger.getLogger(SisFinanceiroMain.class);

	public static void criarExibirInterface() {

		//Inicializa objetos de vista e controle
		LoginTela lt = new LoginTela();
		lt.setVisible(true);
		TelaPrincipalSisFinanceiro visao =new TelaPrincipalSisFinanceiro();
		ControlaSisFinanceiro.getInstance().configuraTela(visao); 
        LoginControle.getInstance().configuraTela(lt);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error("Ocorreu um erro no processo da thread");
		}
		
		sp.setDisplayString(100, "Instanciando objetos de interface e controle...");
		sp.hideSplash();
	}

	public static void main(String[] args) {

		String lookAndFeel = UIManager.getSystemLookAndFeelClassName();

		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (Exception e) {
			logger.error("Não foi possível setar o LookAndFeel\n" + e);
		}

		sp = new TelaAberturaJWindow("/visao/financas2.png");
		sp.showSplash();
		sp.setProgressMaxMin(0, 100);
		sp.setDisplayString(50, "Conectando ao banco de dados...");

		try {
			dbClass= HibernateUtil.getInstance();
		} catch (HibernateException e) {
			logger.info("Não foi possível conectar ao banco de dados\n" + e.getCause());
			JFrame frame = new JFrame();
			sp.hideSplash();
			JOptionPane.showMessageDialog(frame, "Não foi possível conectar ao banco de dados.", "Erro na conexão",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		sp.setDisplayString(80, "Carregando interface...");

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				criarExibirInterface();
			}
		});
	}
}
