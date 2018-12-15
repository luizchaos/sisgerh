package local.henrique.model;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Usuario {
	@Id
	@GenericGenerator(
	        name = "sequence", 
	        strategy = "sequence", 
	        parameters = {
	            @org.hibernate.annotations.Parameter(
	                name = "sequence", 
	                value = "sequence"
	            )
	 
	    })
	@GeneratedValue(generator = "sequence")
    private Long id;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	@ManyToOne
	private Perfil perfil;
	
	

	public Usuario() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
}
