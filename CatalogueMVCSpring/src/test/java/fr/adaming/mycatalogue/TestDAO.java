package fr.adaming.mycatalogue;

import static org.junit.Assert.*;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDAO {
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app =
					new ClassPathXmlApplicationContext("applicationContext.xml");
			assertTrue(true);
			app.close();
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(e.getMessage(),false);
		}
	}
	
}