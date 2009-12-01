package dao;

import java.util.List;

import modelo.Despesa;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DespesaDao {
	
	  	private static Session session;
	    private static DespesaDao instance = null;
	    static Logger logger = Logger.getLogger(DespesaDao.class);

	    public static DespesaDao getInstance() {
	    	instance = new DespesaDao();
	    	return instance;
	    }

	    private DespesaDao() {
	    	session = HibernateUtil.getInstance().AbreUmaSession();
	    }

	    public void atualizar(Despesa despesa) {

			Transaction t = session.beginTransaction();
			session.update(despesa);
			t.commit();
			session.flush();
			session.close();
			logger.info("ATUALIZADO");
	    }
	    
	    public List<Despesa> buscarDespesaNome(String nome) {

			List<Despesa> despesa = session.createCriteria(Despesa.class).add(
				Restrictions.sqlRestriction("nome like '" + nome
					+ "%'")).list();
			return despesa;
		}

	    public Despesa BuscaDespesaId(Integer id) {

	    	Despesa d = (Despesa) session.load(Despesa.class, id);
	    	return d;
	    }

	    public void deletar(Despesa despesa) {

			Transaction t = session.beginTransaction();
			session.delete(despesa);
			t.commit();
			session.flush();
			session.close();
			logger.info("DELETADO");
		 }

	    public void fechaSession() {
		session.close();
	    }

	    public List<Despesa> listar() {
			List<Despesa> l = session.createQuery("from modelo.Despesa").list();
			return l;
	    }

	    public void salvar(Despesa despesa) {

			Transaction t = session.beginTransaction();
			session.save(despesa);
			t.commit();
			session.flush();
			session.close();
	    }

}
