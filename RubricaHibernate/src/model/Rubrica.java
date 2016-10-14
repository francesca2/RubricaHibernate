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
	private long idRubrica;
	
	private String nomeRubrica;
	@OneToMany(mappedBy="persona",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Voce> listaVoci= new HashSet<Voce>();

	public Rubrica() {

	}
	
	public Rubrica(long idRubrica ,String nomeRubrica) {
		super();
		this.nomeRubrica = nomeRubrica;
		this.idRubrica = idRubrica;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public long getIdRubrica() {
		return idRubrica;
	}

	public void setIdRubrica(long idRubrica) {
		this.idRubrica = idRubrica;
	}

}
