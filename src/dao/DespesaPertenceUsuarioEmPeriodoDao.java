package dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

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

}
