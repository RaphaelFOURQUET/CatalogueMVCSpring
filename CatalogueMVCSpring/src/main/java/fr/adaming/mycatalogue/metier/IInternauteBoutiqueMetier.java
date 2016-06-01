package fr.adaming.mycatalogue.metier;

import java.util.List;

import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.entity.Client;
import fr.adaming.mycatalogue.entity.Commande;
import fr.adaming.mycatalogue.entity.Panier;
import fr.adaming.mycatalogue.entity.Produit;

public interface IInternauteBoutiqueMetier {
	
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p, Client c);

}
