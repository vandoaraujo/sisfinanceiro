package dao;

import java.util.Iterator;
import java.util.List;

import modelo.DespesaUsuarioPeriodo;
import modelo.Periodo;
import modelo.ReceitaUsuarioPeriodo;
import modelo.Usuario;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
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
			List<Periodo> l = session.createQuery("from modelo.Periodo order by ano, mes").list();
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
	    		"select max(ano),max(mes) from modelo.Periodo group by ano,mes").list().iterator();
	    	return maxObject;

	    }
	    
	    public Periodo listarUltimoPeriodo2(){
	    	
	    	Integer pAno = (Integer) session.createQuery(
    		"select max(ano) from modelo.Periodo").uniqueResult();
	    	
	    	Integer p =(Integer) session.createSQLQuery(
    		"select max(p.mes) from Periodo p where p.ano=:ano"). 
    		setInteger("ano", pAno).uniqueResult();
	    	
	    	System.out.println("ANO " + p.intValue());
	    	System.out.println("MES " + pAno.intValue());
	    	
	    	Periodo periodo = new Periodo();
	    	periodo.setMes(p.intValue());
	    	periodo.setAno(pAno.intValue());
	    	
	    	return periodo;
	    }

		public List<DespesaUsuarioPeriodo> buscaDespesasPeriodo(Periodo p,Usuario usu) {

	    	List<DespesaUsuarioPeriodo> des = session
    		.createQuery(
    			"from modelo.DespesaUsuarioPeriodo d where d.chaveComposta.periodo_id=:idPeriodo and d.chaveComposta.usuario_id=:idUsuario")
    			.setInteger("idPeriodo", p.getId()).setInteger("idUsuario", usu.getId()).list();
    		return des;
		}
		
		public List<ReceitaUsuarioPeriodo> buscaReceitasPeriodo(Periodo p,Usuario usu) {

	    	List<ReceitaUsuarioPeriodo> rec =  session
    		.createQuery(
    			"from modelo.ReceitaUsuarioPeriodo d where d.chaveComposta.periodo_id=:idPeriodo and d.chaveComposta.usuario_id=:idUsuario")
    			.setInteger("idPeriodo", p.getId()).setInteger("idUsuario", usu.getId()).list();
    		return rec;
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
	    logger.info("Setou o pr�ximo atendimento como 1 ");
	    
	} else {
	    Object[] linhas = (Object[]) proxIdAtendimento.next();
	    numero = (Integer) linhas[0];
	    maior =(Integer) linhas[1];
	    anoUltimoAtendimento = Integer.toString(numero).substring(0, 4);
	    logger.info("Ano Ultimo Atendimento " + anoUltimoAtendimento);*/

}
