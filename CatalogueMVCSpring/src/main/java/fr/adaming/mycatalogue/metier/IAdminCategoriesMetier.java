package fr.adaming.mycatalogue.metier;

import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.entity.Role;
import fr.adaming.mycatalogue.entity.User;

public interface IAdminCategoriesMetier extends IAdminProduitMetier {
	
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void ajouterRole(Role r);
	public void attribuerRole(Role r,Long userID);
	
}