package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasicPage{
	
	public HomePage(ChromeDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myaccount; 
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement register;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement Login;
	
public void clickmyaccount()	{                         // action method
	
	myaccount.click();
	
}

public void clickregistration()	{
	register.click();
	
}
public void login () {
	Login.click();
}

}
