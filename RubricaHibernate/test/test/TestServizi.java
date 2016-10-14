package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Rubrica;
import model.Voce;

import org.junit.Test;

import dao.RubricaDao;
import dao.VoceDao;
import servizi.Gestione;

public class TestServizi {

//	@Test
//	public void test_1_AggiungiRubrica() {
//		
//		Gestione g=new Gestione();
//		boolean b=g.registraRubrica("Francesca");
//		
//		assertTrue(b);
//	}
	
	@Test
	public void test_2_TrovaRubrica() {
		
		Gestione g=new Gestione();
		RubricaDao rdao= new RubricaDao();
		
		Rubrica r1= rdao.trovaRubricaConNome("Francesca");
		Rubrica r2= rdao.trovaRubricaConId(1);
		
		assertEquals(r1.getIdRubrica(),1);
	}
	
	@Test
	public void test_3_AggiungiVoce() {

		Gestione g=new Gestione();
		RubricaDao rdao= new RubricaDao();
		
		Rubrica r= rdao.trovaRubricaConNome("Francesca");
		boolean b=g.aggiungiVoce(r, "aaaaa", "AAAAA", "391048461");
		
		assertTrue(b);
			
	}
	
	@Test
	public void test_4_TrovaVoce() {

		Gestione g=new Gestione();
		RubricaDao rdao= new RubricaDao();
		VoceDao vdao = new VoceDao();
		
		Rubrica r= rdao.trovaRubricaConNome("Francesca");
		
		Voce v= vdao.trovaVoce("aaaaa", "AAAAA", r.getIdRubrica());
		
		assertNotNull(v);
		assertEquals(v.getNome(),"aaaaa");
		assertEquals(v.getCognome(),"AAAAA");
			
	}
	
	@Test
	public void test_5_AggiornaVoce() {

		Gestione g=new Gestione();
		RubricaDao rdao= new RubricaDao();
		VoceDao vdao = new VoceDao();
		
		Rubrica r= rdao.trovaRubricaConNome("Francesca");
		
		boolean b=g.aggiornaVoce(r,"aaaaa","Paolino","AAAAA","Paperino","479276491");
		
		assertTrue(b);
			
	}
	
	@Test
	public void test_6_TutteLeVoci() {
		
		Gestione g=new Gestione();
		RubricaDao rdao= new RubricaDao();
		Rubrica r=rdao.trovaRubricaConNome("Francesca");
		List<Voce> lista=new ArrayList<Voce>();
		lista=g.getVoci(r);
		
		assertEquals(lista.size(),1);
		
	}
	
	@Test
	public void test_7_EliminaVoce() {
		
		Gestione g=new Gestione();
		RubricaDao rdao= new RubricaDao();
		Rubrica r=rdao.trovaRubricaConNome("Francesca");
		VoceDao vdao = new VoceDao();
		g.eliminaVoce(r,"Paolino" , "Paperino");
		List<Voce> lista=new ArrayList<Voce>();
		lista=g.getVoci(r);
		
		assertEquals(lista.size(),1);
		
	}

}
