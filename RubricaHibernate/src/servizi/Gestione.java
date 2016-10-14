package servizi;

import java.util.Map;

import model.Rubrica;
import model.Voce;
import dao.VoceDao;

public class Gestione {
	
	//Primo metodo per registrate una voce
	public Voce aggiungiVoce(Rubrica r,String nome, String cognome, String telefono)
	{
		Voce v=new Voce();
		v.setNome(nome);
		v.setCognome(cognome);
		v.setTelefono(telefono);
		
		r.addVoce(v);
		
		return v;
		
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
