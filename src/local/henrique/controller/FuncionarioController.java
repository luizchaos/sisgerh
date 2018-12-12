package local.henrique.controller;

import local.henrique.dao.FuncionarioDAO;
import local.henrique.model.Empresa;
import local.henrique.model.Funcionario;
import local.henrique.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class FuncionarioController implements FuncionarioDAO{
	
	public boolean incluir(Funcionario o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public List<Funcionario> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Funcionario ");
        
        List<Funcionario> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(Funcionario o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public Funcionario recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Funcionario o = (Funcionario) session.load(Funcionario.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Funcionario o = (Funcionario) session.load(Funcionario.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}
}
