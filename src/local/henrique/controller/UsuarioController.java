package local.henrique.controller;

import local.henrique.dao.UsuarioDAO;
import local.henrique.model.Usuario;
import local.henrique.util.*;

import java.util.List;

import org.hibernate.*;

public class UsuarioController implements UsuarioDAO{
	
	public boolean incluir(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
		return true;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public List<Usuario> listaUsuarios(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Usuario ");
        
        List<Usuario> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
		return true;		
	}
	
	public Usuario listaUsuario(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Usuario usuario = (Usuario) session.load(Usuario.class, new Long(id));
		
		return usuario;
		
	}

	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Usuario usuario = (Usuario) session.load(Usuario.class, new Long(id));
		
		if(null != usuario){
			session.delete(usuario);
			session.beginTransaction().commit();
		}

		return true;
		
	}
}
