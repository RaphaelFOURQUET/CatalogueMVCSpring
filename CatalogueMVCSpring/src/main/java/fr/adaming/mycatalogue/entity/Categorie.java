package fr.adaming.mycatalogue.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categorie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long idCategorie;
	
	@NotEmpty @Size(min=4,max=20)
	private String nomCategorie;
	
	private String description;
	
	private String nomPhoto;
	
	@Lob
	private byte[] photo;
	
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits=new ArrayList<Produit>();

	//ACCESSEURS
	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomPhoto() {
		return nomPhoto;
	}

	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Collection<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}
	
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	//CONSTRUCTEURS
	public Categorie() {
		
	}
	
	public Categorie(String nomCategorie, String description, String nomPhoto, byte[] photo) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.nomPhoto = nomPhoto;
		this.photo = photo;
	}

	public Categorie(String nomCategorie, String description, Collection<Produit> produits) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.produits = produits;
	}

	public Categorie(String nomCategorie, String description, String nomPhoto, byte[] photo,
			Collection<Produit> produits) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.nomPhoto = nomPhoto;
		this.photo = photo;
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description="
				+ description + ", nomPhoto=" + nomPhoto + "]";
	}
	
	
	
}