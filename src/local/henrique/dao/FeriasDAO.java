package local.henrique.dao;

import java.util.List;

import local.henrique.model.Ferias;

public interface FeriasDAO {
	
	public boolean incluir(Ferias o);
	public List<Ferias> lista();
	public boolean alterar(Ferias o);
	public Ferias recebe(long id);
	public boolean remover(long id);
}
