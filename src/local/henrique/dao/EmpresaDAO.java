package local.henrique.dao;

import java.util.List;

import local.henrique.model.Empresa;

public interface EmpresaDAO {
	
	public boolean incluir(Empresa o);
	public List<Empresa> lista();
	public boolean alterar(Empresa o);
	public Empresa recebe(long id);
	public boolean remover(long id);
}
