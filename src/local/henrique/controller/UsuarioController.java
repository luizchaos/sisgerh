package local.henrique.controller;

import local.henrique.model.Usuario;
import local.henrique.util.*;

import java.util.List;

import org.hibernate.*;

public class UsuarioController {
	
	public boolean incluir(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(usuario);
		return true;		
	}
	
	public List<Usuario> listaPerfis(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Usuario ");
        
        List<Usuario> resultList = q.list();
        
		return resultList;
		
	}
	
}
