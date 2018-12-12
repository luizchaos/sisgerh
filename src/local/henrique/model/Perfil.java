package local.henrique.model;

import javax.persistence.*;

@Entity
@Table
public class Perfil {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String name;

	
	public Perfil() {
		super();
	}

	public Perfil(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
