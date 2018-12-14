package local.henrique.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import local.henrique.dao.ContratoDAO;
import local.henrique.model.Contrato;
import local.henrique.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class ContratoController implements ContratoDAO{
	
	public boolean incluir(Contrato o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Contrato> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Contrato ");
        
        List<Contrato> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(Contrato o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public Contrato recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Contrato o = (Contrato) session.load(Contrato.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Contrato o = (Contrato) session.load(Contrato.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}

}
