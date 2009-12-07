package dao;

import modelo.DespesaUsuarioPeriodo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DespesaPertenceUsuarioEmPeriodoDao {
	
	
  	private static Session session;
    private static DespesaPertenceUsuarioEmPeriodoDao instance = null;
    static Logger logger = Logger.getLogger(DespesaPertenceUsuarioEmPeriodoDao.class);

    public static DespesaPertenceUsuarioEmPeriodoDao getInstance() {
    	instance = new DespesaPertenceUsuarioEmPeriodoDao();
    	return instance;
    }

    private DespesaPertenceUsuarioEmPeriodoDao() {
    	session = HibernateUtil.getInstance().AbreUmaSession();
    }
    
    public void salvar(DespesaUsuarioPeriodo despesaUsuarioPeriodo) {

    	Transaction t = session.beginTransaction();
    	session.save(despesaUsuarioPeriodo);
    	t.commit();
    	session.flush();
    	session.close();

    }

}
