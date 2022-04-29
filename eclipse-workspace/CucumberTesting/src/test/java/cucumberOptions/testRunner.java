package cucumberOptions;

import org.junit.runner.RunWith;

public class testRunner {
	
	@RunWith(Cucumber.class)
	@CucumberOptions(  
		    features = "src/test/java/fetures",
		    glue="stepDefinitions")
	public class TestRunner  {

	}


}
