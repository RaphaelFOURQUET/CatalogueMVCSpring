package fr.adaming.mycatalogue;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstTest {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app= new ClassPathXmlApplicationContext("applicationContext.xml");
			assertTrue(true);
			app.close();
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
	}

}
