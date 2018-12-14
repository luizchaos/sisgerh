package local.henrique.dao;

import java.util.List;

import local.henrique.model.EmpresaTerceirizada;

public interface EmpresaTerceirizadaDAO {
	
	public boolean incluir(EmpresaTerceirizada o);
	public List<EmpresaTerceirizada> lista();
	public boolean alterar(EmpresaTerceirizada o);
	public EmpresaTerceirizada recebe(long id);
	public boolean remover(long id);

}
