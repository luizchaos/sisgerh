package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.EmpresaController;
import local.henrique.controller.FuncionarioController;
import local.henrique.model.Empresa;
import local.henrique.model.Funcionario;

import java.util.*;

@Path("/funcionario")
public class FuncionarioView {
	
private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private FuncionarioController controller;
	
	@PostConstruct
	private void init() {
		controller =  new FuncionarioController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Funcionario> lista(){
		List<Funcionario> lista =  null;
		
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
	public String inclui(Funcionario o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Funcionario adicionado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Funcionario nao adicionada";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(Funcionario o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Funcionario alterado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Funcionario nao alterado";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public Funcionario recebe(@PathParam("id") int id) {
		Funcionario o = null;
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
			
			msg = "Funcionario removida com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Funcionario nao removida";
		}
		
		return msg;
		
	}
}
