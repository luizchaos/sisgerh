package local.henrique.controller;

import local.henrique.dao.PerfilDAO;
import local.henrique.model.Perfil;
import local.henrique.util.*;

import java.util.List;

import org.hibernate.*;

public class PerfilController implements PerfilDAO{
	
	public boolean incluir(Perfil perfil) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(perfil);
        session.getTransaction().commit();
		return true;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public List<Perfil> listaPerfis(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Perfil ");
        
        List<Perfil> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(Perfil perfil) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(perfil);
        session.getTransaction().commit();
		return true;		
	}
	
	public Perfil listaPerfil(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Perfil perfil = (Perfil) session.load(Perfil.class, new Long(id));
		
		return perfil;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Perfil perfil = (Perfil) session.load(Perfil.class, new Long(id));
		
		if(null != perfil){
			session.delete(perfil);
			session.beginTransaction().commit();
		}

		return true;
		
	}

}
