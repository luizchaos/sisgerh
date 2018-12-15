package local.henrique.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import local.henrique.dao.EmpresaTerceirizadaDAO;
import local.henrique.model.Contrato;
import local.henrique.model.EmpresaTerceirizada;
import local.henrique.util.HibernateUtil;

@SuppressWarnings("deprecation")
public class EmpresaTerceirizadaController implements EmpresaTerceirizadaDAO{
	
	public boolean incluir(EmpresaTerceirizada o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
		return true;		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EmpresaTerceirizada> lista(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From EmpresaTerceirizada ");
        
        List<EmpresaTerceirizada> resultList = q.list();
        
		return resultList;
		
	}
	
	public boolean alterar(EmpresaTerceirizada o) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
		return true;		
	}
	
	public EmpresaTerceirizada recebe(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		EmpresaTerceirizada o = (EmpresaTerceirizada) session.load(EmpresaTerceirizada.class, new Long(id));
		
		return o;
		
	}
	
	public boolean remover(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		EmpresaTerceirizada o = (EmpresaTerceirizada) session.load(EmpresaTerceirizada.class, new Long(id));
		
		if(null != o){
			session.delete(o);
			session.beginTransaction().commit();
		}

		return true;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Contrato> retornaContratos(long id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		  
        session.beginTransaction();
        
        Query q = session.createQuery("From Contrato Where 	empresa_terceirizada_id = :id ").setParameter("id", id);
        
        List<Contrato> resultList = q.list();
        
		return resultList;
		
	}

}
