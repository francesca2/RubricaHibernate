package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Rubrica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Rubrica;
	
	private String nomeRubrica;
	@OneToMany(mappedBy="rubrica",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Voce> listaVoci= new HashSet<Voce>();

	public Rubrica() {

	}
	
	public Rubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public long getIdRubrica() {
		return id_Rubrica;
	}

	public void setIdRubrica(long idRubrica) {
		this.id_Rubrica = idRubrica;
	}
	
	public Set<Voce> getListaVoci() {
		return listaVoci;
	}

	public void setListaVoci(Set<Voce> listaVoci) {
		this.listaVoci = listaVoci;
	}

	public void addVoce(Voce v){
		this.listaVoci.add(v);
	}

}
