package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class searchproduct extends BasicPage {
	
	public searchproduct(ChromeDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Phones & PDAs')]") WebElement Search;

	@FindBy(xpath = "//a[normalize-space()='iPhone']") WebElement mbl;
	
	@FindBy (xpath = "//input[@id='input-quantity']") WebElement Quantity;
	
	@FindBy (xpath = "//button[@id='button-cart']") WebElement Addcart;
	
	@FindBy (xpath = "//span[@id='cart-total']") WebElement Cart;
	
	@FindBy (xpath = "//strong[normalize-space()='Checkout']") WebElement checkout;
	
	@FindBy (xpath = "//a[normalize-space()='Continue Shopping']") WebElement conti;
	
	public void product() {
		
		Search.click();;
	}
	
	
public void phone() {
		
		mbl.click();
	}

public void Quan(String num) {
	
	Quantity.sendKeys(num);
}

public void tocart() {
	
	Addcart.click();
}
public void cart() {
	
	Cart.click();
}

public void chkout() {
	
	checkout.click();
}

public void shopping() {
	
	conti.click();
}




	

}
