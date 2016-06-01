package fr.adaming.mycatalogue.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Commande implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCommande;
	
	private Date dateCommande;
	
	@ManyToOne @JoinColumn(name="idClient")
	private Client client;
	
	@OneToMany @JoinColumn(name="idCommande")
	private Collection<LigneCommande> ligneCommandes;

	
	//ACCESSEURS
	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(Collection<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Long getIdCommande() {
		return idCommande;
	}
	
	

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	//CONSTRUCTEURS
	public Commande() {
		
	}
	
	public Commande(Date dateCommande, Client client, Collection<LigneCommande> ligneCommandes) {
		super();
		this.dateCommande = dateCommande;
		this.client = client;
		this.ligneCommandes = ligneCommandes;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateCommande=" + dateCommande + ", client=" + client + ", ligneCommandes=" +ligneCommandes + "]";
	}
	
	
	
}