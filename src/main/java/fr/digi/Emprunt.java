package fr.digi;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
@Table(name="EMPRUNT")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DATE_DEBUT", nullable=false)
	private String date_debut;
	
	@Column(name="DATE_FIN", nullable=true)
	private String date_fin;

	@Column(name="DELAI", nullable=true)
	private String delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client id_client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
}
