package dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

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

}
