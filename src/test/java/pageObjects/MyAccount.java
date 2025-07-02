package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasicPage {

	public MyAccount(ChromeDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement Heading;
	
	public boolean MyAccountPageExists() {
		return(Heading.isDisplayed());
	}
	
	@FindBy(xpath= "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Logout;
	
	public void logut() {
		Logout.click();
	}

}
