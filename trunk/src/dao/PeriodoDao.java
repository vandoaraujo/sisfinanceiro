package dao;

import java.util.Iterator;
import java.util.List;
import modelo.Periodo;
import modelo.Usuario;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PeriodoDao {
	
	    private static Session session;
	    private static PeriodoDao instance = null;
	    static Logger logger = Logger.getLogger(PeriodoDao.class);

	    public static PeriodoDao getInstance() {
	    	instance = new PeriodoDao();
	    	return instance;
	    }

	    private PeriodoDao() {
	    	session = HibernateUtil.getInstance().AbreUmaSession();
	    }

	    public void atualizar(Periodo periodo) {

			Transaction t = session.beginTransaction();
			session.update(periodo);
			t.commit();
			session.flush();
			session.close();
			logger.info("ATUALIZADO");
	    }
	    
	    public List<Periodo> buscarPeriodoAno(String ano) {

			List<Periodo> Periodo = session.createCriteria(Periodo.class).add(
				Restrictions.sqlRestriction("ano like '" + ano
					+ "%'")).list();
			return Periodo;
		}

	    public Periodo BuscaPeriodoId(Integer id) {

	    	Periodo d = (Periodo) session.load(Periodo.class, id);
	    	return d;
	    }

	    public void deletar(Periodo Periodo) {

			Transaction t = session.beginTransaction();
			session.delete(Periodo);
			t.commit();
			session.flush();
			session.close();
			logger.info("DELETADO");
		 }

	    public void fechaSession() {
		session.close();
	    }

	    public List<Periodo> listar() {
			List<Periodo> l = session.createQuery("from modelo.Periodo").list();
			return l;
	    }

	    public void salvar(Periodo Periodo) {

			Transaction t = session.beginTransaction();
			session.save(Periodo);
			t.commit();
			session.flush();
			session.close();
	    }
	    
	    public Periodo buscarPeriodoMesAno(Integer mes, Integer ano) {

	    	Periodo per = (Periodo) session
	    		.createQuery(
	    			"from modelo.Periodo u where u.mes=:mes and u.ano=:ano")
	    		.setInteger("mes", mes).setInteger("ano", ano)
	    		.uniqueResult();
	    	return per;
	   }
	    public Iterator listarUltimoPeriodo() {

	    	Iterator maxObject = session.createQuery(
	    		"select max(ano),max(mes) from modelo.Periodo").list().iterator();
	    	return maxObject;

	    }
	    
	/*	Iterator proxIdAtendimento = AtendimentoDao.getInstance()
		.listaUltimoId();
	
	    public Iterator listaUltimoId() {

	    	Iterator it =session.createQuery(
	    		"select atendimento_numero ,max(id) from Atendimento").list().iterator();
	    	return it;
	        }	
		
	if (proxIdAtendimento.hasNext() == false) {
	    maior=1;
	    logger.info("Setou o próximo atendimento como 1 ");
	    
	} else {
	    Object[] linhas = (Object[]) proxIdAtendimento.next();
	    numero = (Integer) linhas[0];
	    maior =(Integer) linhas[1];
	    anoUltimoAtendimento = Integer.toString(numero).substring(0, 4);
	    logger.info("Ano Ultimo Atendimento " + anoUltimoAtendimento);*/

}
