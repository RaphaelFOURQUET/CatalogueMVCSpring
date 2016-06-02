package fr.adaming.mycatalogue.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.entity.Client;
import fr.adaming.mycatalogue.entity.Commande;
import fr.adaming.mycatalogue.entity.LigneCommande;
import fr.adaming.mycatalogue.entity.Panier;
import fr.adaming.mycatalogue.entity.Produit;
import fr.adaming.mycatalogue.entity.Role;
import fr.adaming.mycatalogue.entity.User;

public class BoutiqueDaoImpl implements IBoutiqueDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getIdCategorie();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> listCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		em.remove(getCategorie(idCat));
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		//Retrouver la categorie
		Categorie c = getCategorie(idCat);
		//Affecter categorie au produit
		p.setCategorie(c);
		//persist
		em.persist(p);
		
		return p.getIdProduit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> listproduits() {
		Query req=em.createQuery("select p from Produit p");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsParMotCle(String mc) {
		//Renvoie les produits dont le nom ou la description contiennent le mot cle ...
		Query req=em.createQuery("select p from Produit p where p.designation like:x or p.description like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req=em.createQuery("select p from Produit p where p.categorie.idCategorie=:id");
		req.setParameter("id", idCat);
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> produitsSelectionnes() {
		Query req=em.createQuery("select p from Produit p where p.selectionne=true");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		return em.find(Produit.class, idP);
	}

	@Override
	public void supprimerProduit(Long idP) {
		em.remove(getProduit(idP));
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
	}
	
	@Override
	public void ajouterRole(Role r) {
		em.persist(r);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		User u=em.find(User.class, userID);
		u.getRoles().add(r);
		em.merge(u);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		em.persist(c);
		Commande cmd=new Commande();
		cmd.setClient(c);
		cmd.setDateCommande(new Date());
		cmd.setLigneCommandes(p.getItems());
		for(LigneCommande lc : p.getItems()) {
			em.persist(lc);
		}
		em.persist(cmd);
		return cmd;
	}
	
}