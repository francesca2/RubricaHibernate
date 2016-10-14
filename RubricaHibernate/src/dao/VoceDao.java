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

	public boolean aggiungiVoce(String nome, String cognome, String telefono,long idRubrica)
	{
		boolean b=false;
		Voce v= new Voce();
		v.setNome(nome);
		v.setCognome(cognome);
		v.setTelefono(telefono);
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("select listaVoci from Rubrica where id_Rubrica=:x");
		query.setLong("x", idRubrica);
		List <Voce> voci=query.list();
		voci.add(v);
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
	
//	public Voce trovaVoce(String nome, String cognome, long idRubrica)
//	{
//		Voce v=null;
//		
//		Session session =HibernateUtil.openSession();
//		Transaction tx=null;
//
//		try{
//		tx=session.getTransaction();
//		tx.begin();
//
//		Query query=session.createQuery("select listaVoci from Rubrica where id_Rubrica=:x");
//		query.setLong("x", idRubrica);
//		
//		session.persist(v);
//		 
//		 tx.commit();
//		}catch(Exception ex){
//			tx.rollback();
//		}finally{
//			session.close();
//		}
//	}
//
//	public Voce aggiornaVoce(String nome,String nuovoNome, String cognome,String nuovoCognome ,String telefono,long idRubrica)
//	{
//		Connection con;
//		PreparedStatement pst=null;
//		Voce v=null;
//		long id=getIdVoce(nome,cognome,idRubrica);
//		try {
//			con = DataSource.getInstance().getConnection();
//
//			String sql="Update voce set nome=?, cognome=?, telefono=? where id_voce=? and id_rubrica=?";
//
//			pst =con.prepareStatement(sql);
//			pst.setString(1, nuovoNome);
//			pst.setString(2, nuovoCognome);
//			pst.setString(3, telefono);
//			pst.setLong(4, id);
//			pst.setLong(5, idRubrica);
//
//			int n=pst.executeUpdate();
//
//			if(n>0){
//				v=new Voce(id,nome, cognome,telefono,idRubrica);
//			}
//
//		} catch (SQLException | IOException | PropertyVetoException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		return v;
//	}
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
