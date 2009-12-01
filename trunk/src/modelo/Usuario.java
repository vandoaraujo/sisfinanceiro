package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	private String login;
	
	private String nome;
	
	private String senha;
	
	private Date dataCadastro;
	
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public Usuario(){
		
	}
	
	public Usuario(String nome, String login, String senha, Date data){
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataCadastro = data;
	}

	public Usuario(String usuario, String senha2) {
		this.login = usuario;
		this.senha = senha2;
	}

	public int getId() {
		return idUsuario;
	}

	public void setId(int id) {
		this.idUsuario = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
