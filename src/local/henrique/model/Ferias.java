package local.henrique.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
public class Ferias {
	
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
	
	@ManyToOne
	private Funcionario funcionario;
	
	private Date data_inicio;
	
	private Date data_fim;	
	
	public Ferias() {
		super();
	}

	public Ferias(Long id, Funcionario funcionario, Date data_inicio, Date data_fim) {
		super();
		this.id = id;
		this.funcionario = funcionario;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	
	

}
