package local.henrique.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.FuncionarioTerceirizadoController;
import local.henrique.model.FuncionarioTerceirizado;

@Path("/funcionarioterceirizado")
public class FuncionarioTerceirizadoView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private FuncionarioTerceirizadoController controller;
	
	@PostConstruct
	private void init() {
		controller =  new FuncionarioTerceirizadoController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<FuncionarioTerceirizado> lista(){
		List<FuncionarioTerceirizado> lista =  null;
		
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
	public String inclui(FuncionarioTerceirizado o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Funcionario Terceirizado adicionado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Funcionario Terceirizado nao adicionado";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(FuncionarioTerceirizado o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Funcionario Terceirizado alterado com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Funcionario Terceirizado nao alterado";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public FuncionarioTerceirizado recebe(@PathParam("id") int id) {
		FuncionarioTerceirizado o = null;
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
			
			msg = "Funcionario Terceirizado removido com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Funcionario Terceirizado nao removido";
		}
		
		return msg;
		
	}

}
