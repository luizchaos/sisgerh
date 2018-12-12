package local.henrique.dao;

import java.util.List;

import local.henrique.model.Empresa;

public interface EmpresaDAO {
	
	public boolean incluir(Empresa empresa);
	public List<Empresa> lista();
	public boolean alterar(Empresa empresa);
	public Empresa recebe(long id);
	public boolean remover(long id);
}
