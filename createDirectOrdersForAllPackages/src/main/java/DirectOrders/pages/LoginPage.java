package DirectOrders.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;


@DefaultUrl("https://test.salesforce.com/")
	public class LoginPage extends PageObject {
	
	private WebElementFacade username() { return element(By.id("username"));}
	private WebElementFacade password() { return element(By.id("password"));}
	private WebElementFacade loginbutton() { return element(By.id("Login"));}
	
    public void supplyLogin_Credientials(String username, String password) {
    	
    	username().type(username);
    	password().type(password);
    	
    }
    
    public void clickOnLogin(){
    	waitABit(1000);
    	loginbutton().click();
    }
    
}