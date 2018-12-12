package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.EmpresaController;
import local.henrique.controller.PerfilController;
import local.henrique.model.Empresa;
import local.henrique.model.Perfil;

import java.util.*;

@Path("/empresa")
public class EmpresaView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private EmpresaController controller;
	
	@PostConstruct
	private void init() {
		controller =  new EmpresaController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Empresa> lista(){
		List<Empresa> lista =  null;
		
		try {
			lista = controller.lista();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String inclui(Empresa o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Empresa adicionada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Empresa nao adicionada";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(Empresa o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Empresa alterada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Empresa nao alterada";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public Empresa recebe(@PathParam("id") int id) {
		Empresa o = null;
		try {
			o = controller.recebe(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String remove(@PathParam("id") int id) {
		String msg = "";
		
		try {
			controller.remover(id);
			
			msg = "Empresa removida com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Empresa nao removida";
		}
		
		return msg;
		
	}
}
