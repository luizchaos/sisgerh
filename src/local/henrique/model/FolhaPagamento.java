package local.henrique.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class FolhaPagamento {
	
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
	
	private Double valor;
	
	@ManyToOne
	private Funcionario funcionario;
	
	private Date data_referencia;
	
	private Date data_criacao;
	
	public FolhaPagamento() {
		super();
	}

	public FolhaPagamento(Long id, Double valor, Funcionario funcionario, Date data_referencia, Date data_criacao) {
		super();
		this.id = id;
		this.valor = valor;
		this.funcionario = funcionario;
		this.data_referencia = data_referencia;
		this.data_criacao = data_criacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getData_referencia() {
		return data_referencia;
	}

	public void setData_referencia(Date data_referencia) {
		this.data_referencia = data_referencia;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

}
