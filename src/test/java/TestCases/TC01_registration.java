package TestCases;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.registrationpage;
 class TC01_registration extends BaseClass{
	
	
	@AfterClass()
	public void tearDown()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.close();
	}
	@Test(groups = { "Regression" , "Master"})
	public void acc_registration() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("****** Starting the browser");
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickmyaccount();
		
		logger.info("****** clicked on my account *****");
		hp.clickregistration();
		
		logger.info("****** clicked on registration *****");
		
		registrationpage regipag = new registrationpage(driver);
		logger.info("****** providing required details *****");
		regipag.Fname(randomly().toUpperCase());
		regipag.Sname("Manu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		regipag.Email(p.getProperty("EMAIL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		regipag.mobile(randomnum());
		
		regipag.Password(p.getProperty("PASSWORD"));
		regipag.ConPass(p.getProperty("PASSWORD"));
		regipag.confirm();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		regipag.BTN();
	}
		catch(Exception e) {
			logger.error("**** oh shut its failed");
		}
		logger.info("****** registration is done  *****");
	}

}
