package local.henrique.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Funcionario {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@ManyToOne
	private Empresa empresa;
	
	private String nome;
	
	private String cpf;
	
	

	public Funcionario() {
		super();
	}

	public Funcionario(Long id, Empresa empresa, String nome, String cpf) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
		
}
