package fr.adaming.mycatalogue.entity;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Produit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	
	@NotEmpty
	private String designation;
	
	private double prix;
	
	private int quantite;
	
	@ManyToOne @JoinColumn(name="ID_CAT")
	private Categorie categorie;

	
	//ACCESSEURS
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Long getIdProduit() {
		return idProduit;
	}
	
	//CONSTRUCTEURS
	public Produit() {
		
	}
	
	public Produit(String designation, double prix, int quantite, Categorie categorie) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", prix=" + prix + ", quantite="
				+ quantite + ", categorie=" + categorie + "]";
	}
	
	
	
	
}