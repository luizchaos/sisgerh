package local.henrique.dao;

import java.util.List;

import local.henrique.model.Usuario;

public interface UsuarioDAO {
	
	public boolean incluir(Usuario usuario);
	public List<Usuario> listaUsuarios();
	public boolean alterar(Usuario usuario);
	public Usuario listaUsuario(long id);
	public boolean remover(long id);

}
