package dao;

import hibernateUtil.HibernateUtil;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Voce;


public class VoceDao {
	
	public boolean aggiungiVoce(Voce v)
	{
		boolean b=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(v);
		
		 b=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return b;

	}
	
	public Voce trovaVoce(String nome, String cognome, long idRubrica)
	{
		Voce v=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from Voce where Rubrica_id_Rubrica=:x1 and nome=:x2 and cognome=:x3");
		query.setLong("x1", idRubrica);
		query.setString("x2", nome);
		query.setString("x3", cognome);
		
		v=(Voce) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return v;
	}

//	public boolean aggiornaVoce(String nome,String nuovoNome, String cognome,String nuovoCognome ,String telefono,long idRubrica)
//	{
//		boolean result=false;
//		Voce v=null;
//		Session session =HibernateUtil.openSession();
//		Transaction tx=null;
//
//		try{
//		tx=session.getTransaction();
//		tx.begin();
//
//		Query query=session.createQuery("from Voce where Rubrica_id_Rubrica=:x1 and nome=:x2 and cognome=:x3");
//		query.setLong("x1", idRubrica);
//		query.setString("x2", nome);
//		query.setString("x3", cognome);
//		
//		v=(Voce) query.uniqueResult();
//		
//		v.setNome(nuovoNome);
//		v.setCognome(nuovoCognome);
//		v.setTelefono(telefono);
//		
//		session.persist(v);
//		
//		result=true;
//		 
//		 tx.commit();
//		}catch(Exception ex){
//			tx.rollback();
//		}finally{
//			session.close();
//		}
//		
//		return result;
//	}
	
	public boolean aggiornaVoce(Voce v)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.update(v);
		result=true;
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	
//
//	public boolean eliminaVoce(String nome,String cognome,long idRubrica)
//	{
//		Connection con;
//		PreparedStatement pst=null;
//		boolean i=false;
//		long id=getIdVoce(nome,cognome, idRubrica);
//		try {
//			con = DataSource.getInstance().getConnection();
//
//			String sql="Delete from voce where id_voce=? and id_rubrica=?";
//
//			pst =con.prepareStatement(sql);
//			pst.setLong(1, id);
//			pst.setLong(2, idRubrica);
//
//			int n=pst.executeUpdate();
//
//			if(n>0){
//				i=true;
//			}
//
//		} catch (SQLException | IOException | PropertyVetoException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		return i;
//	}

}
