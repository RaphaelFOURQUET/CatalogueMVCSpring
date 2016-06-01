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
	
	private String description;
	
	private double prix;
	
	private String photo;
	
	private int quantite;
	
	private boolean selectionne;
	
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	
	

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
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
	
	public Produit(String designation, String description, double prix, String photo, int quantite, boolean selectionne) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}

	public Produit(String designation, String description, double prix, String photo, int quantite, boolean selectionne,
			Categorie categorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.photo = photo;
		this.quantite = quantite;
		this.selectionne = selectionne;
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", prix=" + prix + ", quantite="
				+ quantite + ", categorie=" + categorie + "]";
	}
	
	
	
	
}