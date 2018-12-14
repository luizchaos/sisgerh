package local.henrique.dao;

import java.util.List;

import local.henrique.model.Contrato;

public interface ContratoDAO {
	
	public boolean incluir(Contrato o);
	public List<Contrato> lista();
	public boolean alterar(Contrato o);
	public Contrato recebe(long id);
	public boolean remover(long id);

}
