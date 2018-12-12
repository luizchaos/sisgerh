package local.henrique.dao;

import java.util.List;

import local.henrique.model.Perfil;

public interface PerfilDAO {
	
	public boolean incluir(Perfil perfil);
	public List<Perfil> listaPerfis();
	public boolean alterar(Perfil perfil);
	public Perfil listaPerfil(long id);
	public boolean remover(long id);
}