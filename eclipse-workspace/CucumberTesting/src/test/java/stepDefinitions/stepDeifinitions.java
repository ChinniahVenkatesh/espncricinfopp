package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import resource.Browser;

public class stepDeifinitions extends Browser{
	
	@Given("^Access the \"([^\"]*)\"$")
    public void access_the_something(String strArg1) throws Throwable {
 
		driver = browser();
		driver.get(strArg1);
    }

}
