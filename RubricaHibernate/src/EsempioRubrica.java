import dao.RubricaDao;
import model.*;
import servizi.Gestione;


public class EsempioRubrica {

	public static void main(String[] args) {

		Gestione g=new Gestione();
		
//		g.registraRubrica("Francesca");
		
		RubricaDao rdao= new RubricaDao();
		
//		Rubrica r= rdao.trovaRubricaConNome("Francesca");
		Rubrica r= rdao.trovaRubricaConId(1);
		
		System.out.println(r.getNomeRubrica());
//		
//		g.aggiungiVoce(r, "AAAAA", "bbbbb", "39281048");

	}

}
