package local.henrique.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.ContratoController;
import local.henrique.model.Contrato;

@Path("/contrato")
public class ContratoView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private ContratoController controller;
	
	@PostConstruct
	private void init() {
		controller =  new ContratoController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Contrato> lista(){
		List<Contrato> lista =  null;
		
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
	public String inclui(Contrato o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Contrato adicionad com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Contrato nao adicionado";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(Contrato o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Contrato alterado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Contrato nao alterado";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public Contrato recebe(@PathParam("id") int id) {
		Contrato o = null;
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
			
			msg = "Contrato removido com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Contrato nao removido";
		}
		
		return msg;
		
	}

}
