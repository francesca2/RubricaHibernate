package model;

import javax.persistence.*;

@Entity
public class Voce {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_Voce;
	private String nome;
	private String cognome;
	private String telefono;
	
	@ManyToOne
	private Rubrica r;

	public Voce() {

	}

	public Voce(long idVoce, String nome, String cognome, String telefono) {
		this.id_Voce = idVoce;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public long getIdVoce() {
		return id_Voce;
	}

	public void setIdVoce(long idVoce) {
		this.id_Voce = idVoce;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rubrica getR() {
		return r;
	}

	public void setR(Rubrica r) {
		this.r = r;
	}
	

}
