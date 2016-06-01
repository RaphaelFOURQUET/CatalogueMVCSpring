package fr.adaming.mycatalogue.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import fr.adaming.mycatalogue.dao.IBoutiqueDao;
import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.entity.Client;
import fr.adaming.mycatalogue.entity.Commande;
import fr.adaming.mycatalogue.entity.Panier;
import fr.adaming.mycatalogue.entity.Produit;
import fr.adaming.mycatalogue.entity.Role;
import fr.adaming.mycatalogue.entity.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier {

	private IBoutiqueDao dao;
	
	public void setDao(IBoutiqueDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);

	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idcat) {
		dao.supprimerCategorie(idcat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
	}
	
	@Override
	public void ajouterRole(Role r) {
		dao.ajouterRole(r);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		dao.attribuerRole(r, userID);
	}

}
