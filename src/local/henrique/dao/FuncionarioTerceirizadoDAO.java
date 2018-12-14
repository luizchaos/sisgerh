package local.henrique.dao;

import java.util.List;

import local.henrique.model.FuncionarioTerceirizado;

public interface FuncionarioTerceirizadoDAO {
	
	public boolean incluir(FuncionarioTerceirizado o);
	public List<FuncionarioTerceirizado> lista();
	public boolean alterar(FuncionarioTerceirizado o);
	public FuncionarioTerceirizado recebe(long id);
	public boolean remover(long id);

}
