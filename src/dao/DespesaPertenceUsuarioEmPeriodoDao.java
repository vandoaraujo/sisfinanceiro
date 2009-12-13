package dao;

import java.util.List;

import modelo.Despesa;
import modelo.DespesaUsuarioPeriodo;
import modelo.OBM;
import modelo.Periodo;
import modelo.Usuario;

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
    
	public List<Despesa> buscaDespesaId(Integer id) {

    	List<Despesa> des = session
		.createQuery(
			"from modelo.DespesaUsuarioPeriodo d where d.chaveComposta.despesa_id=:idDespesa")
			.setInteger("idDespesa", id).list();
		return des;
	}

}
