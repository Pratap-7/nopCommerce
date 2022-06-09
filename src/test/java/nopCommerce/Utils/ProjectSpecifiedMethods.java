package nopCommerce.Utils;

import org.testng.annotations.*;

import nopCommerce.Base.SelenuimBase;

public class ProjectSpecifiedMethods extends SelenuimBase {
	@BeforeMethod
	public void precondition() {
		launchApp("edge","http://leaftaps.com/opentaps/control/login", false);
		//launchApp("http://leaftaps.com/opentaps/control/login", false);
	}
	
	public void postCondition() {
		getDriver().close();
	}
 
}
