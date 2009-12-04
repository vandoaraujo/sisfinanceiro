package dao;

import modelo.ReceitaUsuarioPeriodo;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReceitaPertenceUsuarioEmPeriodoDao {
	
  	private static Session session;
    private static ReceitaPertenceUsuarioEmPeriodoDao instance = null;
    static Logger logger = Logger.getLogger(ReceitaPertenceUsuarioEmPeriodoDao.class);

    public static ReceitaPertenceUsuarioEmPeriodoDao getInstance() {
    	instance = new ReceitaPertenceUsuarioEmPeriodoDao();
    	return instance;
    }

    private ReceitaPertenceUsuarioEmPeriodoDao() {
    	session = HibernateUtil.getInstance().AbreUmaSession();
    }
    
    public void salvar(ReceitaUsuarioPeriodo receitaUsuarioPeriodo) {

    	Transaction t = session.beginTransaction();
    	session.save(receitaUsuarioPeriodo);
    	t.commit();
    	session.flush();
    	session.close();

    }


}
