package fr.adaming.mycatalogue;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.metier.IAdminCategoriesMetier;

public class TestDAO {

	private ClassPathXmlApplicationContext context;
	private IAdminCategoriesMetier metier;
	private Long c1, c2;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		metier=(IAdminCategoriesMetier) context.getBean("metier");

	}

	@After
	public void tearDown() throws Exception {
		//supprimer de ma base : n'a pas l'air de fonctionner
		this.metier.supprimerCategorie(c1);
		this.metier.supprimerCategorie(c2);
		
		context.close();
	}

	@Test
	public void test() {
		try {
			List<Categorie> cats1=metier.listCategories();

			c1 = metier.ajouterCategorie(new Categorie("Ordinateurs", "Des Ordinateurs de qualité.", "", null));
			c2 = metier.ajouterCategorie(new Categorie("Imprimantes", "Des Imprimantes au top.", "", null));

			List<Categorie> cats2=metier.listCategories();

			assertTrue(cats2.size()==cats1.size()+2);

		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage(),false);
		}
	}

}