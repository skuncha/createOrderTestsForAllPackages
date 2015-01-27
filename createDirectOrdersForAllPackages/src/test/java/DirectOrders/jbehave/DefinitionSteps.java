package DirectOrders.jbehave;

import java.io.IOException;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import DirectOrders.steps.EndUserSteps;

/**
 * @author Srinivasa.Kuncha
 *
 */
public class DefinitionSteps {

    @Steps
    EndUserSteps salesUser;
    
    @Given("Sales rep is on the Salesforce home page")
    public void userIsOnTheSalesforceHomePage() {
        salesUser.is_this_home_page();
    }

    @When("Sales rep login to glue as Mail user by supplying $UserName and $Password")
    public void userSupplyLoginCredentials(String username, String password) {
        salesUser.supplyLoginCredientials(username, password);
    }

    @Then("Mail user should be able to login to glue successfully")
    public void userShouldSeeSalesforceHomePage() {
        salesUser.loginSuccessful();
    }
    
    @When("Mail user navigate to Accounts page and click on New button")
    public void accessNewAccountPage() {
    	 salesUser.accessNewAccountPage();
    }
    @When("Mail user search for an Account using $searchAccountName")
    public void searchForAnAccountUsingAccountName(String searchAccountName){
    	salesUser.searchForAnAccountUsingAccountName(searchAccountName);
    }
    
    @When("Mail user access New Account from search results section")
    public void accessNewAccountsPageviaSearchResults() {
    	salesUser.accessNewAccountsPageviaSearchResults();
    }
    
    @When("Mail user provides input data from CSV $file and create account")
    public void supplyInputToCreateNumberofUserAccounts(String file) throws IOException{
    	salesUser.read_csv_input(file);
    }
    
}