package fr.adaming.mycatalogue.dao;

import java.util.List;

import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.entity.Client;
import fr.adaming.mycatalogue.entity.Commande;
import fr.adaming.mycatalogue.entity.Panier;
import fr.adaming.mycatalogue.entity.Produit;
import fr.adaming.mycatalogue.entity.Role;
import fr.adaming.mycatalogue.entity.User;

public interface IBoutiqueDao {
	
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long idcat);
	public void modifierCategorie(Categorie c);

	
	
	public Long ajouterProduit(Produit p, Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	
	public void ajouterUser(User u);
	public void ajouterRole(Role r);	//TODO : Ajout
	public void attribuerRole(Role r,Long userID);
	
	public Commande enregistrerCommande(Panier p,Client c);
	
}