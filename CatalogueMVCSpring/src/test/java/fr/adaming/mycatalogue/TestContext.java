package fr.adaming.mycatalogue;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContext {

	@Test
	public void test() {	//Teste l'acces et la vaidite de notre applicationContext.xml
		try {
			ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
			assertTrue(true);
			app.close();
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
	}

}
