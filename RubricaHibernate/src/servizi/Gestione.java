package servizi;

import java.util.Map;

import model.Rubrica;
import model.Voce;
import dao.RubricaDao;
import dao.VoceDao;

public class Gestione {
	
	private VoceDao vdao=new VoceDao();
	private RubricaDao rdao=new RubricaDao();
	
	//Aggiungi rubrica
	public boolean registraRubrica(String nome){
		boolean result=false;
		Rubrica r= new Rubrica(nome);
		
		boolean b=rdao.creaRubrica(r);
		
		if(b==true)
		{
			result=true;
		}
		
		return result;
	}
	
	
	//Registra una voce
	public boolean aggiungiVoce(Rubrica r,String nome, String cognome, String telefono)
	{
		boolean result=false;

		Voce v=new Voce(nome,cognome,telefono);
		v.setRubrica(r);		
		r.addVoce(v);
		boolean b=vdao.aggiungiVoce(v);
		rdao.aggiornaRubrica(r);
		
		if(b==true)
		{
			result =true;
		}
		
		return result;
		
	}
	
//	//metodo per aggiornare una voce
//	public Voce aggiornaVoce(Rubrica r,String nome, String nuovoNome, String cognome, String nuovoCognome, String telefono)
//	{
//		VoceDao vdao= new VoceDao();
//		Map<String,Voce> rubrica= vdao.getTutteLeVoce(r.getIdRubrica());
//		Voce v=vdao.aggiornaVoce(nome, nuovoNome, cognome, nuovoCognome, telefono, r.getIdRubrica());
//		return v;
//		
//	}
//	
//	public Voce trovaVoce(Rubrica r,String nome, String cognome)
//	{
//		VoceDao vdao=new VoceDao();
//		Map<String,Voce> rubrica= vdao.getTutteLeVoce(r.getIdRubrica());		
//		Voce v= vdao.trovaVoce(nome, cognome, r.getIdRubrica());
//		
//		return v;
//		
//	}
//
//	public boolean deleteVoce(Rubrica r,String nome, String cognome)
//	{
//		VoceDao vdao=new VoceDao();
//		Map<String,Voce> rubrica= vdao.getTutteLeVoce(r.getIdRubrica());
//		boolean b= vdao.eliminaVoce(nome, cognome, r.getIdRubrica());
//		
//		return b;
//		
//	}
	
}
