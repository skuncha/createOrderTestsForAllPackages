package DirectOrders.pages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class SalesforceGlueContactsPage extends PageObject {
	
	
	private WebElementFacade salutation() { return element(By.id("j_id0:j_id1:i:f:pb:d:Salutation.input"));}
	private WebElementFacade firstName() { return element(By.id("j_id0:j_id1:i:f:pb:d:FirstName.input"));}
	private WebElementFacade lastName() { return element(By.id("j_id0:j_id1:i:f:pb:d:LastName.input"));}
	private WebElementFacade emailAddress() { return element(By.id("j_id0:j_id1:i:f:pb:d:EmailAddress.input"));}
	private WebElementFacade phonenumebr() { return element(By.id("j_id0:j_id1:i:f:pb:d:Phone.input"));}
	private WebElementFacade accountType() { return element(By.id("j_id0:j_id1:i:f:pb:d:Account4Contact.input"));}
	private WebElementFacade contactNext() { return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));}
	private WebElementFacade finish() { return element(By.cssSelector("input[value='Finish']"));}
	

/**
 * This method is used to supply end user contact information while creating an order
 */
	public void supplyCustomerContactInformation(Map<String, String> contactMandValues){
		
		try {

			waitABit(1000);
			salutation().selectByVisibleText(contactMandValues.get("salutation"));
			firstName().type(contactMandValues.get("firstname"));
			lastName().type(contactMandValues.get("lastname"));
			emailAddress().type(contactMandValues.get("emailaddress"));
			phonenumebr().type(contactMandValues.get("phoneNumber"));
			waitABit(1000);
		  }
	    	catch (Exception e) { e.printStackTrace();}
	    }
	    
	public void selectAccountNameForContacts(List<String> accountName){
		
		String endUseraccount = accountName.get(0);
		accountType().selectByVisibleText(endUseraccount);
		waitABit(1000);
		contactNext().click();
		waitABit(3000);
		finish().click();
		waitABit(8000);
//	    getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
}
   
 

