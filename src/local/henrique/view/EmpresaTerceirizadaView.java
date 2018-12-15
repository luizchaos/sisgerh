package local.henrique.view;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import local.henrique.controller.EmpresaTerceirizadaController;
import local.henrique.model.Contrato;
import local.henrique.model.EmpresaTerceirizada;

import java.util.*;

@Path("/empresaterceirizada")
public class EmpresaTerceirizadaView {
	
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private EmpresaTerceirizadaController controller;
	
	@PostConstruct
	private void init() {
		controller =  new EmpresaTerceirizadaController();
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<EmpresaTerceirizada> lista(){
		List<EmpresaTerceirizada> lista =  null;
		
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
	public String inclui(EmpresaTerceirizada o) {
		String msg = "";
		
		try {
			controller.incluir(o);
			
			msg = "Empresa Terceirizada adicionada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Empresa Terceirizada nao adicionada";
		}
		
		return msg;
	}
	
	@POST
	@Path("/edit/")
	@Consumes(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN+CHARSET_UTF8)
	public String altera(EmpresaTerceirizada o) {
		String msg = "";
		
		try {
			controller.alterar(o);
			
			msg = "Empresa Terceirizada alterada com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Empresa Terceirizada nao alterada";
		}
		
		return msg;
	}
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public EmpresaTerceirizada recebe(@PathParam("id") int id) {
		EmpresaTerceirizada o = null;
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
			
			msg = "Empresa Terceirizada removida com sucesso";
		}catch(Exception e) {
			e.printStackTrace();
			
			msg = "Empresa Terceirizada nao removida";
		}
		
		return msg;
		
	}
	
	@GET
	@Path("/retornacontratos/{id}")
	@Produces(MediaType.APPLICATION_JSON+CHARSET_UTF8)
	public List<Contrato> retornaContratos(@PathParam("id") int id) {
		List<Contrato> o = null;
		try {
			o = controller.retornaContratos(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return o;
	}

}
