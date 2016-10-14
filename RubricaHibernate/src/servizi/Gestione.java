package servizi;

import java.util.List;
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
	
	public boolean aggiornaVoce(Rubrica r,String nome, String nuovoNome, String cognome, String nuovoCognome, String telefono)
	{
		Voce v=vdao.trovaVoce(nome, cognome, r.getIdRubrica());
		v.setNome(nuovoNome);
		v.setCognome(nuovoCognome);
		v.setTelefono(telefono);
		boolean result=vdao.aggiornaVoce(v);
	
		return result;
	}

//metodo per prendere tutte le voci di rubrica
	public List<Voce> getVoci(Rubrica r)
	{
		List<Voce> voci= rdao.getVociRubrica(r.getNomeRubrica());
		
		return voci;
	}
	
	//metodo per eliminare una voce
	public boolean eliminaVoce(Rubrica r, String nome, String cognome)
	{
		Voce v=vdao.trovaVoce(nome, cognome, r.getIdRubrica());
		boolean result=vdao.eliminaVoce(v);
		return result;
	}
	
}
