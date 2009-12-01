package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import modelo.Usuario;
import visao.LoginTela;
import visao.UsuarioCadastroTela;
import dao.UsuarioDao;
import exceptions.LoginRepetidoException;


public class LoginControle implements ActionListener{

	private static LoginControle singleton=null;
	private LoginTela telaL;
	private UsuarioCadastroTela telaUsuario;
	private ControlaSisFinanceiro ce=ControlaSisFinanceiro.getInstance();
	
	public static LoginControle getInstance(){
		if(singleton==null)
			 singleton=new LoginControle();
		return singleton;
	}
	
	private LoginControle(){
		
	}
	
	public void configuraTela(LoginTela telaL){
		
		this.telaL = telaL;
		//telaL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaL.configuraOuvinte(this);
		// Proíbe Redimensionamento
		telaL.setResizable(false);
		telaL.setLocationRelativeTo(null);
		
	}
	
	private void configuraTela(UsuarioCadastroTela usuTela) {

		this.telaUsuario = usuTela;
		telaUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaUsuario.configuraOuvinte(this);
		// Proíbe Redimensionamento
		telaUsuario.setResizable(false);
		telaUsuario.setLocationRelativeTo(null);
	}
	
	public void habilitaTelaLogin(){
		telaL.setVisible(true);
		telaL.limpaCredenciais();
	    
	}
	
	public void habilitaTelaCadastroUsuario(){
		telaUsuario.setVisible(true);
	    
	}
	
	public void actionPerformed(ActionEvent eve) {
		
		
		String comando = eve.getActionCommand();
		
		if(comando.equals(("login")))
		{
			logicaBotaoLogin();
		}
		else if(comando.equals("semLogin"))
		{
			iniciaTelaCadastroUsuario();
		}
		if(comando.equals(("cadastrar")))
		{
			salvaUsuario();
		}
		else if(comando.equals("retornar"))
		{
			retornaTelaLogin();
		}
		
		

	}

	private void salvaUsuario() {
		
		try{
			Usuario usu = telaUsuario.leDadosUsuario();
			
			verificaLoginRepetido(usu);
			
			UsuarioDao.getInstance().salvar(usu);
			//Inicia o usuario Logado
			UsuarioDao.getInstance().setUsuarioLogado(usu);
			//Inicia a tela principal/
			habilitaTelaPrincipal();
			
		}
		catch(Exception e){
			e.getCause();
		}
		
		
	}

	private void verificaLoginRepetido(Usuario usu) throws LoginRepetidoException {
		
		Usuario usuarioRepetido = UsuarioDao.getInstance().listarLoginsIguais(usu.getLogin());
		
		if(usuarioRepetido != null){
			throw new LoginRepetidoException();
		}
		
	}

	private void iniciaTelaCadastroUsuario() {
		
		UsuarioCadastroTela usuTela = new UsuarioCadastroTela();
		LoginControle.getInstance().configuraTela(usuTela);
		LoginControle.getInstance().habilitaTelaCadastroUsuario();
	}

	private void retornaTelaLogin() {
		System.out.println("IMPLEMENTAR!!!");
		
	}

	private void logicaBotaoLogin() {
		
		
		Usuario usuario=telaL.leCredenciais();
		
		Usuario usu  = UsuarioDao.getInstance().buscarUsuario(usuario.getLogin(),usuario.getSenha());
		
		//Se usuario for nulo, query retornou nada
	    if(usu != null){ 
	    		
	    	habilitaTelaPrincipal();
	    }
	    else{
	    	telaL.mostraMensagem("Não foi possível entrar! \nNome de usuário ou senha incorretos! ");
	    }
		
	}
	
	private void habilitaTelaPrincipal(){
		
    	telaL.dispose();
    	ce.habilita();
		
	}

}
