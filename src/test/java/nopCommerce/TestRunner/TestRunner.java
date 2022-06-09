package nopCommerce.TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import nopCommerce.Utils.ProjectSpecifiedMethods;
@CucumberOptions(features="src/test/java/nopCommerce/Feature",
glue="nopCommerce.StepDefination",
monochrome=true)
public class TestRunner extends ProjectSpecifiedMethods {
	 @DataProvider(parallel=true)
	    public Object[][] scenarios() {
		 return super.scenarios();
	 }
	        
	

}
