package local.henrique.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Contrato {
	
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
	private Empresa empresa;
	
	@ManyToOne
	private EmpresaTerceirizada empresa_terceirizada;
		
	public Contrato() {
		super();
	}

	public Contrato(Long id, Empresa empresa, EmpresaTerceirizada empresa_terceirizada) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.empresa_terceirizada = empresa_terceirizada;
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

	public EmpresaTerceirizada getEmpresa_terceirizada() {
		return empresa_terceirizada;
	}

	public void setEmpresa_terceirizada(EmpresaTerceirizada empresa_terceirizada) {
		this.empresa_terceirizada = empresa_terceirizada;
	}
	
	
}
