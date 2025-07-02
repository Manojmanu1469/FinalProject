package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasicPage{
	public LoginPage(ChromeDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath = "//input[@id='input-email']") WebElement Email;
	
	@FindBy(xpath = "//input[@id='input-password']") WebElement Password;
	
	@FindBy(xpath = "//input[@value='Login']") WebElement Loginbtn;
	
	public void mail(String email) {
		
		Email.sendKeys(email);
	}
	
public void Pass(String pass) {
		
		Password.sendKeys(pass);
	}

public void Lbtn() {
	
	Loginbtn.click();;
}
	
	

}
