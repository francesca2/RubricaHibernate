package dao;

import hibernateUtil.HibernateUtil;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Rubrica;
import model.Voce;

public class RubricaDao {
	
	//Primo metodo-crea una nuova tebella rubrica
	public boolean creaRubrica(Rubrica r){

		boolean result=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(r);
		result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	
	public boolean creaRubrica(String nome)
	{
		boolean result=false;
		Rubrica r =new Rubrica();
		r.setNomeRubrica(nome);
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.persist(r);
		result=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}

	//Secondo metodo- legge una rubrica
	
	public Rubrica trovaRubricaConId(long idRubrica)
	{
		Rubrica r=null;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		r=session.get(Rubrica.class, idRubrica);
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	public Rubrica trovaRubricaConNome(String nome)
	{
		Rubrica r=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from Rubrica where nomeRubrica=:x");
		query.setString("x", nome);
		r=(Rubrica) query.uniqueResult();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return r;
		
	}
	
	//Aggiorna rubrica
	public boolean aggiornaRubrica(Rubrica r)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		session.update(r);
		result=true;
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
		
	}

public List<Voce> getVociRubrica(String nome)
{
	List<Voce> voci= new ArrayList<Voce>();
	Session session =HibernateUtil.openSession();
	Transaction tx=null;

	try{
	tx=session.getTransaction();
	tx.begin();

	Query query= session.createQuery("from Rubrica where nomeRubrica=:x");
	query.setString("x", nome);
	 voci=query.list();
	
	 tx.commit();
	}catch(Exception ex){
		tx.rollback();
	}finally{
		session.close();
	}
	return voci;
}

}
