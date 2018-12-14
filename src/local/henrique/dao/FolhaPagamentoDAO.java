package local.henrique.dao;

import java.util.List;

import local.henrique.model.FolhaPagamento;

public interface FolhaPagamentoDAO {
	
	public boolean incluir(FolhaPagamento o);
	public List<FolhaPagamento> lista();
	public boolean alterar(FolhaPagamento o);
	public FolhaPagamento recebe(long id);
	public boolean remover(long id);

}
