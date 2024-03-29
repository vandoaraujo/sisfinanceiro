package dao;

import java.util.List;

import modelo.Despesa;
import modelo.Receita;

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
			session.merge(despesa);
			t.commit();
			session.flush();
			session.close();
			logger.info("ATUALIZADO");
	    }
	    
	    public Despesa buscarDespesaNome(String nome) {

	    	Despesa despesa = (Despesa) session.createQuery(
	    		"from modelo.Despesa r where r.nomeDespesa=:nome").setString("nome", nome)
	    		.uniqueResult();
	    	return despesa;

	    }

	    public Despesa BuscaDespesaId(Integer codigo) throws Exception {
	    	
	    	Despesa d = (Despesa) session.load(Despesa.class, codigo);
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
			List<Despesa> l = session.createQuery("from modelo.Despesa order by nomeDespesa").list();
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
