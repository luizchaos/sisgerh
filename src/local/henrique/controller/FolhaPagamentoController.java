package local.henrique.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import local.henrique.dao.FolhaPagamentoDAO;
import local.henrique.model.FolhaPagamento;
import local.henrique.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class FolhaPagamentoController implements FolhaPagamentoDAO{
	
	public boolean incluir(FolhaPagamento o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FolhaPagamento> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From FolhaPagamento ");
        
        List<FolhaPagamento> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(FolhaPagamento o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public FolhaPagamento recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		FolhaPagamento o = (FolhaPagamento) session.load(FolhaPagamento.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		FolhaPagamento o = (FolhaPagamento) session.load(FolhaPagamento.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}

}
