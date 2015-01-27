package DirectOrders.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SalesforceGlueHomePage extends PageObject {
	
	
	@FindBy(how = How.LINK_TEXT, using = "Accounts")
	private WebElement accounts;
	
	    
    public void type(String mytype) {
    	Select droplist = new Select(find(By.id("acc6")));   
    	droplist.selectByVisibleText(mytype);
    }
    
    public void AccountsTab() {
    	accounts.click();
    }
    
    public String verifyRelationship() {

    	WebElementFacade result = null;
    	result = element(By.xpath("//td/div[@id='Name_ileinner']"));	
    	return result.getText();  
    	
    }
   
}
	
	
	


