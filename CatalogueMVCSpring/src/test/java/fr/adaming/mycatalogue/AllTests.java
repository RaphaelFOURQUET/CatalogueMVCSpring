package fr.adaming.mycatalogue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestContext.class, TestDAO.class })
public class AllTests {

}
