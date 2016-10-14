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
	
	public Rubrica trovaRubricaConId(String idRubrica)
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

		Query query= session.createQuery("from * Rubrica where nomeRubrica=:x");
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

	//
//	public boolean eliminaRubrica(String nome)
//	{
//		Connection con;
//		PreparedStatement pst=null;
//		boolean i=false;
//		long id=getIdRubrica(nome);
//		try {
//			con = DataSource.getInstance().getConnection();
//
//			String sql="Delete from rubrica2 where id_rubrica=?";
//
//			pst =con.prepareStatement(sql);
//			pst.setLong(1, id);
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
//

}
