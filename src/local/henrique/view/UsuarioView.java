package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.PerfilController;
import local.henrique.controller.UsuarioController;
import local.henrique.model.Perfil;
import local.henrique.model.Usuario;

import java.util.*;

@Path("/usuario")
public class UsuarioView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private UsuarioController usuarioController;
	
	@PostConstruct
	private void init() {
		usuarioController =  new UsuarioController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Usuario> listaUsuarios(){
		List<Usuario> lista =  null;
		
		try {
			lista = usuarioController.listaUsuarios();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String incluiUsuario(Usuario usuario) {
		String msg = "";
		
		try {
			usuarioController.incluir(usuario);
			
			msg = "Usuario adicionado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Usuario nao adicionado";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String alteraUsuario(Usuario usuario) {
		String msg = "";
		
		try {
			usuarioController.alterar(usuario);
			
			msg = "Usuario alterado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Usuario nao alterado";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public Usuario listaUsuario(@PathParam("id") int id) {
		Usuario usuario = null;
		try {
			usuario = usuarioController.listaUsuario(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String removeUsuario(@PathParam("id") int id) {
		String msg = "";
		
		try {
			usuarioController.remover(id);
			
			msg = "Usuario removido com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Usuario nao removido";
		}
		
		return msg;
		
	}
}
