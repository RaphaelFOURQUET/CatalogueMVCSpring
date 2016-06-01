package fr.adaming.mycatalogue.metier;

import fr.adaming.mycatalogue.entity.Produit;

public interface IAdminProduitMetier extends IInternauteBoutiqueMetier {
	
	public Long ajouterProduit(Produit p, Long idCat);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	
}