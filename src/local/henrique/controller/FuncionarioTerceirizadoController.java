package local.henrique.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import local.henrique.dao.FuncionarioTerceirizadoDAO;
import local.henrique.model.FuncionarioTerceirizado;
import local.henrique.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class FuncionarioTerceirizadoController implements FuncionarioTerceirizadoDAO{
	
	public boolean incluir(FuncionarioTerceirizado o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<FuncionarioTerceirizado> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From FuncionarioTerceirizado ");
        
        List<FuncionarioTerceirizado> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(FuncionarioTerceirizado o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public FuncionarioTerceirizado recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		FuncionarioTerceirizado o = (FuncionarioTerceirizado) session.load(FuncionarioTerceirizado.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		FuncionarioTerceirizado o = (FuncionarioTerceirizado) session.load(FuncionarioTerceirizado.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}

}
