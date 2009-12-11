package dao;

import java.util.List;

import modelo.Usuario;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UsuarioDao{

    private static Session session;
    private static UsuarioDao instance = null;
    private static Usuario usuarioLogado;
    static Logger logger = Logger.getLogger(UsuarioDao.class);

    public static UsuarioDao getInstance() {
    	instance = new UsuarioDao();
    	return instance;
    }

    public static Usuario getUsuarioLogado() {
    	return usuarioLogado;
    }

    private UsuarioDao() {
    	session = HibernateUtil.getInstance().AbreUmaSession();
    }
    

    public void atualizar(Usuario usuario) {

		Transaction t = session.beginTransaction();
		session.update(usuario);
		t.commit();
		session.flush();
		session.close();
		logger.info("ATUALIZADO");

    }

    public Usuario buscarUsuario(String login, String senha) {

	Usuario usu = (Usuario) session
		.createQuery(
			"from modelo.Usuario u where u.login=:login and u.senha=:senha")
		.setString("login", login).setString("senha", senha)
		.uniqueResult();
	usuarioLogado = usu;
	return usu;
    }

    public List<Usuario> buscarUsuariosNumRegistro(String nome) {

	List<Usuario> usuario = session.createCriteria(Usuario.class).add(
		Restrictions.sqlRestriction("nome like '" + nome
			+ "%'")).list();
	return usuario;
    }

    public Usuario BuscaUsuarioId(Integer id) {

    	Usuario u = (Usuario) session.load(Usuario.class, id);
    	return u;
    }

    public void deletar(Usuario usuario) {

		Transaction t = session.beginTransaction();
		session.delete(usuario);
		t.commit();
		session.flush();
		session.close();
		logger.info("DELETADO");
	 }

    public void fechaSession() {
	session.close();
    }

    public List<Usuario> listar() {
		List<Usuario> l = session.createQuery("from modelo.Usuario").list();
		return l;
    }

    public Usuario listarUsuariosNome(String nome) {

	Usuario usu = (Usuario) session.createQuery(
		"from modelo.Usuario u where u.nome=:nome").setString("nome",
		nome).uniqueResult();
	return usu;

    }
    
    
    public Usuario listarLoginsIguais(String login) {

    	Usuario usu = (Usuario) session.createQuery(
    		"from modelo.Usuario u where u.login=:login").setString("login",
    		login).uniqueResult();
    	return usu;

        }

    public void salvar(Usuario usuario) {

		Transaction t = session.beginTransaction();
		session.save(usuario);
		t.commit();
		session.flush();
		session.close();
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
    	UsuarioDao.usuarioLogado = usuarioLogado;
    }

}
