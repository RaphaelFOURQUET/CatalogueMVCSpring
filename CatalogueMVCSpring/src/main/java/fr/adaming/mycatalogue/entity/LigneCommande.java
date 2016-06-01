package fr.adaming.mycatalogue.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class LigneCommande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne @JoinColumn(name="idproduit")
	private Produit produit;
	
	private int quantite;
	
	private double prix;

	//ACCESSEURS
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}
	
	

	public void setId(Long id) {
		this.id = id;
	}

	//CONSTRUCTEURS
	public LigneCommande() {
		
	}
	
	public LigneCommande(Produit produit, int quantite, double prix) {
		super();
		this.produit = produit;
		this.quantite = quantite;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", produit=" + produit + ", quantite=" + quantite + ", prix=" + prix + "]";
	}
	
	
}