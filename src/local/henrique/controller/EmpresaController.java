package local.henrique.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import local.henrique.dao.EmpresaDAO;
import local.henrique.model.Empresa;
import local.henrique.model.Perfil;
import local.henrique.util.HibernateUtil;

public class EmpresaController implements EmpresaDAO{
	
	public boolean incluir(Empresa o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public List<Empresa> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Empresa ");
        
        List<Empresa> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(Empresa o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public Empresa recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Empresa o = (Empresa) session.load(Empresa.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Empresa o = (Empresa) session.load(Empresa.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}
}
