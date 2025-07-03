package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.searchproduct;

public class TC03_product extends BaseClass{
	
	
	@Test(groups = "Sanity")
	public void products() {
		
		
HomePage hp = new HomePage(driver);
		
		hp.clickmyaccount();
		hp.login();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
searchproduct sp = new searchproduct(driver);

sp.product();

sp.phone();
sp.Quan("2");
sp.tocart();
sp.cart();
sp.chkout();
sp.shopping();
				
				
	}
	
	

}
