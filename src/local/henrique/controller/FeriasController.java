package local.henrique.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import local.henrique.util.HibernateUtil;
import local.henrique.dao.FeriasDAO;
import local.henrique.model.Empresa;
import local.henrique.model.Ferias;

public class FeriasController implements FeriasDAO{
	
	public boolean incluir(Ferias o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public List<Ferias> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Ferias ");
        
        List<Ferias> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(Ferias o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public Ferias recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Ferias o = (Ferias) session.load(Ferias.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Ferias o = (Ferias) session.load(Ferias.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}
}
