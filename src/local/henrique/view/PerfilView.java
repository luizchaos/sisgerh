package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.*;

import local.henrique.controller.PerfilController;
import local.henrique.model.Perfil;

@Path("/perfil")
public class PerfilView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private PerfilController perfilController;
	
	@PostConstruct
	private void init() {
		perfilController =  new PerfilController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Perfil> listaPerfis(){
		List<Perfil> lista =  null;
		
		try {
			lista = perfilController.listaPerfis();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String incluiPerfil(Perfil perfil) {
		String msg = "";
		
		try {
			perfilController.incluir(perfil);
			
			msg = "Perfil adicionado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Perfil nao adicionado";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String alteraPerfil(Perfil perfil) {
		String msg = "";
		
		try {
			perfilController.alterar(perfil);
			
			msg = "Perfil alterado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Perfil nao alterado";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public Perfil listaPerfil(@PathParam("id") int id) {
		Perfil perfil = null;
		try {
			perfil = perfilController.listaPerfil(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return perfil;
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String removePerfil(@PathParam("id") int id) {
		String msg = "";
		
		try {
			perfilController.remover(id);
			
			msg = "Perfil removido com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Perfil nao removido";
		}
		
		return msg;
		
	}
	
}
