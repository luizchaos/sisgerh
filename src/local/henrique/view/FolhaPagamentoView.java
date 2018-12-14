package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.FolhaPagamentoController;
import local.henrique.model.FolhaPagamento;

import java.util.*;

@Path("/folhapagamento")
public class FolhaPagamentoView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private FolhaPagamentoController controller;
	
	@PostConstruct
	private void init() {
		controller =  new FolhaPagamentoController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<FolhaPagamento> lista(){
		List<FolhaPagamento> lista =  null;
		
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
	public String inclui(FolhaPagamento o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Folha de Pagamento adicionada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Folha de Pagamento nao adicionada";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(FolhaPagamento o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Folha de Pagamento alterada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Folha de Pagamento nao alterada";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public FolhaPagamento recebe(@PathParam("id") int id) {
		FolhaPagamento o = null;
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
			
			msg = "Folha de Pagamento removida com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Folha de Pagamento nao removida";
		}
		
		return msg;
		
	}
}
