package local.henrique.dao;

import java.util.List;

import local.henrique.model.Funcionario;

public interface FuncionarioDAO {
	
	public boolean incluir(Funcionario o);
	public List<Funcionario> lista();
	public boolean alterar(Funcionario o);
	public Funcionario recebe(long id);
	public boolean remover(long id);
	
}
