package dao;

import java.util.List;

import modelo.Receita;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class ReceitaDao {
	
	    private static Session session;
	    private static ReceitaDao instance = null;
	    static Logger logger = Logger.getLogger(ReceitaDao.class);

	    public static ReceitaDao getInstance() {
	    	instance = new ReceitaDao();
	    	return instance;
	    }

	    private ReceitaDao() {
	    	session = HibernateUtil.getInstance().AbreUmaSession();
	    }

	    public void atualizar(Receita receita) {

			Transaction t = session.beginTransaction();
			session.update(receita);
			t.commit();
			session.flush();
			session.close();
			logger.info("ATUALIZADO");
	    }
	    
	    public List<Receita> buscarReceitasNome(String nome) {

			List<Receita> Receita = session.createCriteria(Receita.class).add(
				Restrictions.sqlRestriction("nome like '" + nome
					+ "%'")).list();
			return Receita;
		}
	    
	    
	    public Receita buscarReceitaNome(String nome) {

			 Receita r = (Receita) session.createCriteria(Receita.class).add(
				Restrictions.sqlRestriction("nomereceita like '" + nome
					+ "%'")).uniqueResult();
			return r;
		}

	    public Receita BuscaReceitaId(Integer id) {

	    	Receita d = (Receita) session.load(Receita.class, id);
	    	return d;
	    }

	    public void deletar(Receita receita) {

			Transaction t = session.beginTransaction();
			session.delete(receita);
			t.commit();
			session.flush();
			session.close();
			logger.info("DELETADO");
		 }

	    public void fechaSession() {
		session.close();
	    }

	    public List<Receita> listar() {
			List<Receita> l = session.createQuery("from modelo.Receita order by nomereceita").list();
			return l;
	    }

	    public void salvar(Receita receita) {

			Transaction t = session.beginTransaction();
			session.save(receita);
			t.commit();
			session.flush();
			session.close();
	    }

}

