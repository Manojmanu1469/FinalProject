package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class registrationpage extends BasicPage {

	public registrationpage(ChromeDriver driver) {
		
		super(driver);
	}
	
@FindBy(xpath = "//input[@id='input-firstname']") WebElement firstname;
@FindBy(xpath = "//input[@id='input-lastname']") WebElement lastname;

@FindBy(xpath = "//input[@id='input-email']") WebElement email;

@FindBy(xpath = "//input[@id='input-telephone']") WebElement phone;

@FindBy(xpath = "//input[@id='input-password']") WebElement password;

@FindBy(xpath = "//input[@id='input-confirm']") WebElement confirmpassword;

@FindBy(xpath = "//input[@value='Continue']") WebElement continuebtn;
@FindBy(xpath = "//input[@name='agree']") WebElement checkbx;


public void Fname(String name1) {
	firstname.sendKeys(name1);
}

public void Sname(String name2) {
	lastname.sendKeys(name2);
	
}

public void Email(String mail) {
	email.sendKeys(mail);
	
}

public void mobile(String cell) {
	phone.sendKeys(cell);
	
}

public void Password(String pswrd) {
	password.sendKeys(pswrd);
	
}

public void ConPass(String CPass) {
	confirmpassword.sendKeys(CPass);
	
}

public void confirm() {
checkbx.click();
}

public void BTN() {
	continuebtn.click()
	;
	
}
	
}
