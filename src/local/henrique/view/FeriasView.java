package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.EmpresaController;
import local.henrique.controller.FeriasController;
import local.henrique.model.Empresa;
import local.henrique.model.Ferias;

import java.util.*;

@Path("/ferias")
public class FeriasView {
	
private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private FeriasController controller;
	
	@PostConstruct
	private void init() {
		controller =  new FeriasController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Ferias> lista(){
		List<Ferias> lista =  null;
		
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
	public String inclui(Ferias o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Ferias adicionada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Ferias nao adicionada";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(Ferias o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Ferias alterada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Ferias nao alterada";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public Ferias recebe(@PathParam("id") int id) {
		Ferias o = null;
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
			
			msg = "Ferias removida com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Ferias nao removida";
		}
		
		return msg;
		
	}
}
