package TestCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TestCase02_loginpage extends BaseClass {
	
	@Test(groups ="Sanity")
	public void login() {
		
		logger.info("**** logging test");
		HomePage hp = new HomePage(driver);
		
		hp.clickmyaccount();
		hp.login();
		
	
	LoginPage LP = new LoginPage(driver);
	
	LP.mail(p.getProperty("EMAIL"));
	LP.Pass(p.getProperty("PASSWORD"));
	LP.Lbtn();
	MyAccount myacc= new MyAccount(driver);
	myacc.MyAccountPageExists();
	myacc.logut();

}
}
