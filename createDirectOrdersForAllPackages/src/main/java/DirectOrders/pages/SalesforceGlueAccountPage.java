package DirectOrders.pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import net.thucydides.core.Thucydides;
import net.thucydides.core.csv.CSVTestDataSource;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Srinivasa.Kuncha
 * @see CreateDirectOrders
 */
public class SalesforceGlueAccountPage  extends PageObject {
//	int i=0;
	int j=0;
	int synctimeforSOPID = 5;
	String ref, financeID,clientURL,customerUniqueID, rowNum;
	ArrayList<String> arraylist = new ArrayList<String>(); 

/***********************************************************************WEB ELEMENTS************************************************************************************/
	
	private WebElementFacade accounts() 		 { return element(By.linkText("Accounts"));								}
	private WebElementFacade salutation() 		 { return element(By.id("00ND0000005jggD"));							}
	private WebElementFacade firstname() 		 { return element(By.id("00ND0000005jgg9"));							}
	private WebElementFacade parentAccount()     { return element(By.cssSelector("#acc3"));								}
	private WebElementFacade phoneNumber()       { return element(By.cssSelector("#acc10"));							}
	private WebElementFacade accountName()       { return element(By.cssSelector("#acc2"));								}
	private WebElementFacade selectAccountType() { return element(By.id("p3")); 										}
	private WebElementFacade selectTypeOfAccount() { return element(By.id("acc6")); 									}
	private WebElementFacade billingStreet()     { return element(By.cssSelector("#acc17street"));       				}
	private WebElementFacade billingPostCode()   { return element(By.cssSelector("#acc17zip"));							}
	private WebElementFacade newButton() 		 { return element(By.cssSelector("input[value=' New ']"));				}
	private WebElementFacade readAccountName()   { return element(By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2"));  }
	private WebElementFacade mainCate()           { return element(By.name("j_id0:j_id1:j_id27:j_id36"));				}
	private WebElementFacade subCate()            { return element(By.name("j_id0:j_id1:j_id27:subcategory"));			}
	private WebElementFacade minorCate()          { return element(By.name("j_id0:j_id1:j_id27:minor"));				}
	private WebElementFacade saveIndCate()        { return element(By.name("j_id0:j_id1:j_id27:j_id28:j_id29"));		}
	private WebElementFacade newAccountButtonChild() { return element(By.cssSelector("input[value='New Account']"));	}
	private WebElementFacade continueButt()          { return element(By.cssSelector("input[value='Continue']")); 		}
	private WebElementFacade type() 				{ return element(By.xpath("//div[@id='ep']/div[2]/div[3]/table/tbody/tr/td[4]/div/span/select/option[2]"));  }
	private WebElementFacade searchCustomerName() 	{ return element(By.xpath("//td[contains(label,'Customer Name or Aliases')]/input"));		}
	private WebElementFacade createDirectOrder() 	{ return element(By.cssSelector("input[value='Create Direct Order']"));						}
	/*private WebElementFacade billingSelection() 	{ return element(By.id("j_id0:j_id32:i:f:pb:d:Billing_Selection.input"));					}*/  //prodmirror
	private WebElementFacade billingSelection() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Selection.input"));					}   //system Test
	private WebElementFacade billingOption() 	    { return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Options.input"));						}
	/*private WebElementFacade billingSelectionNext() { return element(By.id("j_id0:j_id32:i:f:pb:pbb:bottom:next"));							}*/   //prodmirror
	private WebElementFacade billingSelectionNext() { return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));								}    //system Test
	private WebElementFacade finish() 				{ return element(By.cssSelector("input[value='Finish']"));									}
	private WebElementFacade CCICustomerMail()      { return element(By.cssSelector("input[value='Create CCI Customer-Mail']"));				}
	private WebElementFacade accountType() 			{ return element(By.id("j_id0:j_id1:i:f:pb:d:Account4Contact.input"));		}
	private WebElementFacade emailAddress() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:EmailAddress.input"));			}
	private WebElementFacade contactNext() 			{ return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));				}
	private WebElementFacade conSalutation() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Salutation.input"));			}
	private WebElementFacade conFirstName() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:FirstName.input"));			}
	private WebElementFacade conLastName() 			{ return element(By.id("j_id0:j_id1:i:f:pb:d:LastName.input"));				}
	private WebElementFacade conPhonenumebr() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Phone.input"));				}
	
	@FindBy(how = How.XPATH, using = "//div[@class='pbBottomButtons']//input[@value='Search']")
	private WebElement customerSearchButton;
	@FindBy(how = How.CSS, using = "input[value=' Save ']")
	private WebElement saveButton;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "AM-")
	private WebElement accountMapping;
	/*private WebElementFacade customerRef()        { return element(By.xpath("//*[@id='00ND0000005WVcQ_ileinner']"));		}
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "-Mail Advertising")*/
	private WebElementFacade customerRef()        { return element(By.xpath("//*[@id='00ND0000005WVcQ_ileinner']"));		}
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "- Mail")
	private WebElement financeAccount;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "W8 5TT")
	private WebElement privateAdvFinanceAccount;
	private WebElementFacade CCIMailCustomerID() { return element(By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[4]/td[2]"));}
	private WebElementFacade SOPID() 			 { return element(By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr[4]/td[4]"));}
	@FindBy(how = How.XPATH, using = "//input[@title='New Relationship']")
	private WebElement newRelationship;
	private WebElementFacade accountB_Name() 	 { return element(By.id("CF00ND0000003g0n9"));							}
	private WebElementFacade billing() 			 { return element(By.id("00ND0000003g0nB"));							}
	@FindBy(how = How.XPATH, using = "//td[@id='bottomButtonRow']/input[@title='Save']")
	private WebElement saveRelationship;
	private WebElementFacade billingRef()        { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Billing_AgenciesList.input']/option[1]"));}
	private WebElementFacade selectBillingRef()  { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Account4Contact.input']/option[1]"));		}
	private WebElementFacade busyIntegrating() 	 { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Msg']"));				                    }
	private WebElementFacade syncNext() 		 { return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));				                        }
	private WebElementFacade searchGlue() 		 { return element(By.id("phSearchButton"));				                         	 				}
	private WebElementFacade orderlink() 		 { return element(By.xpath("//*[@id='Order_body']/table/tbody/tr[2]/th/a"));						}
	private WebElementFacade orderID() 			 { return element(By.xpath("//*[@id='ep']/div[2]/div[2]/table/tbody/tr[10]/td[2]"));                }
    private WebElementFacade searchTerms()		 { return element(By.xpath("//div/input"));                 										}
    private WebElementFacade orderPurchaseNo()   { return element(By.id("Order.Identification:order.purchaseOrderNo"));								}
    private WebElementFacade orderNote()         { return element(By.id("Order.Identification:order.note"));					   					}
    private WebElementFacade orderUrgentNote()   { return element(By.id("Order.Identification:order.message"));										}
    private WebElementFacade orderSalesRepId()   { return element(By.id("Order.SalesTerritory:order.primarySalesRep.id"));							}
    private WebElementFacade addPackage()   	 { return element(By.xpath("//fieldset/div/div/div/h4/a/span"));									}
    private WebElementFacade title() 			 { return element(By.id("Order.Schedule:sched.titleCode"));											}
    private WebElementFacade selectPublication() { return element(By.id("Order.Schedule:sched.publicationCode"));									}
    private WebElementFacade webSiteCategory()   { return element(By.id("Order.Schedule:sched.webSiteCategoryCode"));								}
    private WebElementFacade selectSection()     { return element(By.id("Order.Schedule:sched.sectionCode"));										}
    private WebElementFacade webSite()   		 { return element(By.id("Order.Schedule:sched.webSiteCode"));										}
    private WebElementFacade selectSubSection()  { return element(By.id("Order.Schedule:sched.subSectionCode"));									}
    private WebElementFacade selectZone()   	 { return element(By.id("Order.Schedule:"));														}
    private WebElementFacade distribution()   	 { return element(By.id("Order.Schedule:sched.distributionCode"));									}
    private WebElementFacade noOfInserts()   	 { return element(By.id("Order.Schedule:sched.noOfInserts"));										}
    private WebElementFacade saveOrder()   	     { return element(By.xpath("//nav[button='Save']/button[2]"));										}
    private WebElementFacade selectModule()   	 { return element(By.id("Order.Material:material.moduleCode"));							}
    private WebElementFacade nextMonthDM()   	 { return element(By.xpath("//thead/tr[1]/th/span[4]/span[3]/i"));									}
    private WebElementFacade selectPrice()   	 { return element(By.xpath(".//*[@id='SchedulingAccordion']/div/div[3]/div[1]/h4/a/span"));			}
    private WebElementFacade selectInsertion()   { return element(By.xpath("//*[@id='ActivePriceDetailView']/label[3]"));							}
    private WebElementFacade selectedInsertionDate(){ return element(By.xpath("//fieldset/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[2]/a"));	}

    /******DM DISPLAY and TMOS *****/
    private WebElementFacade selectBasePrice()	 { return element(By.xpath("//tbody/tr[14]/td[1]/a"));												}
    private WebElementFacade supplyPriceType()	 { return element(By.xpath("//*[@id=':overridePriceDetail']"));										}
    private WebElementFacade supplyPrice()		 { return element(By.xpath("//tbody/tr[23]/td[3]/div/input"));										}
    private WebElementFacade updateInsLevelRevenue() { return element(By.xpath("//tbody/tr[23]/td[3]/div/span/button/i"));							}
    /******     MAILPLUS      *****/
    private WebElementFacade insertionDateMP()   { return element(By.xpath("//fieldset/div[2]/div/div/div[2]/div/table/thead/tr/th[1]/a"));			}
    private WebElementFacade selectBasePriceMP() { return element(By.xpath("//fieldset/div[2]/div/div/div[2]/div/div/table/tbody/tr[9]/td[1]/a"));	}
    private WebElementFacade supplyPriceMP()	 { return element(By.xpath("//fieldset/div[2]/div/div/div[2]/div/div/table/tbody/tr[18]/td[3]/div/input"));	}
    private WebElementFacade updateRevenueMP()   { return element(By.xpath("//tbody/tr[18]/td[3]/div/span/button/i"));							    }
    /******DAILY MAIL INSERTS*****/
    private WebElementFacade insertionDateDMI()  { return element(By.xpath("//fieldset/div[2]/div/div/div[3]/div/table/thead/tr/th[1]/a"));		    }
    private WebElementFacade selectBasePriceDMI(){ return element(By.xpath("//fieldset/div[2]/div/div/div[3]/div/div/table/tbody/tr[10]/td[1]/a"));	}
    private WebElementFacade supplyPriceDMI()	 { return element(By.xpath("//tbody/tr[19]/td[3]/div/input"));										}
    private WebElementFacade updateRevenueDMI()  { return element(By.xpath("//tbody/tr[19]/td[3]/div/span/button/i"));							    }
    /******Order level Price *****/
    private WebElementFacade selectRevenue()   	 { return element(By.id("Order.Price:UserRevenue"));												}
    private WebElementFacade updateRevenue()   	 { return element(By.xpath("//fieldset/div/div[2]/div/div/span/button"));							}
    private WebElementFacade acceptOrder()   	 { return element(By.xpath("//nav[button='Accept']/button[3]"));									} 
    
/***********************************************************************WEB ELEMENTS************************************************************************************/
	public void type(String mytype) {
    	Select droplist = new Select(find(By.id("acc6")));   
    	droplist.selectByVisibleText(mytype);
    }
    
    public void newAccount() {
    	waitFor(4).second();
    	newButton().click();
    	waitFor(8).second();
    }
     
    public void newAccountChild(String keyword) {
    	
    	searchCustomerName().type(keyword);
    	customerSearchButton.click();
    	waitFor(6).second();
    }
    
    public void newAccountButtonFromSearchResultsSection() {
    	
    	newAccountButtonChild().click();
    }
    
    public void accountMapping(){
    	
    	accountMapping.click();
    	waitFor(3).seconds();
    	getDriver().navigate().back();
    	waitFor(8).seconds();
    }
    
    public void accountCreation(){
    		waitFor(5).seconds();
    		accounts().click();
    		try {
	    		WebDriverWait wait1 = new WebDriverWait(getDriver(), 3);
	    		if(wait1.until(ExpectedConditions.alertIsPresent())!=null)
	    	    getDriver().switchTo().alert().accept();
	    	 	}
	    	 catch (Exception x)  { }
 /*   		waitFor(6).seconds();
			newButton().click();
			waitFor(5).seconds();*/
			searchCustomerName().type("xyz");
	    	customerSearchButton.click();
	    	waitFor(4).seconds();
	    	newAccountButtonChild().click();
	    	waitFor(3).seconds();
    }
    
    public void CCIMailIntegration(){
    	
    	CCICustomerMail().click();
    	waitFor(4).seconds();
		getDriver().switchTo().alert().accept();  
		waitFor(15).seconds();
		getDriver().switchTo().alert().accept(); 
		waitFor(5).seconds();
    }
    
/**************************************************************CSVFile
 * @throws IOException *****************************************************/
    public void read_input(String fileLoc) throws IOException {
    	System.out.println("\n");
		File filePath = new File(fileLoc);
		if (filePath.isFile()) {
			String file = filePath.getAbsolutePath();
				CSVTestDataSource testDataSrc = new CSVTestDataSource(file);
				for (Map<String, String> record : testDataSrc.getData()) {
				try {
					 rowNum = record.get("recordNo");
					/************** Select Agency Type ******************************************/  
				    	selectAccountType().selectByVisibleText(record.get("type"));
				    	continueButt().click();
				    	long timeNow = System.currentTimeMillis();
				    /************** Supply User Account details ********************************/  
				  
				    waitFor(5).seconds();
				    String str = record.get("accountType");
				    selectTypeOfAccount().selectByVisibleText(record.get("accountType"));
			    	accountName().type(record.get("lastName") + " - "+ timeNow);
			    	phoneNumber().type(record.get("phone"));
			    	billingStreet().type(record.get("billingStreet"));
			    	billingPostCode().type(record.get("postalCode"));

					    	if (type().getText().equalsIgnoreCase("Brand")) {
								parentAccount().type(record.get("parentAccount"));
								waitABit(1000);
							}
			    	 
					    	if (str.equalsIgnoreCase("Private Advertiser")) {
					    		 salutation().selectByVisibleText(record.get("salutation"));
				    		     firstname().type(record.get("firstName"));
					    	}
			    	
					    	if (str.equalsIgnoreCase("Direct Advertiser") || str.equalsIgnoreCase("Charity") || str.equalsIgnoreCase("Brand")|| str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
					    	{
					    		waitABit(1000);
								saveButton.click();
								waitFor(8).seconds();
								String Name = readAccountName().getText();
						    	arraylist.add(Name);
						    	clientURL = getDriver().getCurrentUrl();
						    	
/**************************************************************************/ 
									    	if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
									    	{
										    		String readClientAccountName = readAccountName().getText();
										    		clientURL = getDriver().getCurrentUrl();
										    		accountCreation();
										    		selectAccountType().selectByVisibleText("Agency"); //Create Billing a/c
										    		continueButt().click();
										    		waitFor(3).seconds();
													accountName().type("Billing Agency " + timeNow);
										    		phoneNumber().type(record.get("phone"));
											    	billingStreet().type(record.get("billingStreet"));
											    	billingPostCode().type(record.get("postalCode"));
											    	waitFor(1).seconds();
													saveButton.click();
													waitFor(8).seconds();
													CCIMailIntegration(); // CCIMail Integration
													financeAccount.click(); 
													waitFor(5).seconds();
													String id = SOPID().getText();
													while(id.equals(" ")) 
													   {
															waitFor(2).seconds();
															getDriver().navigate().back();
															waitFor(20).seconds();
															financeAccount.click();
															waitFor(5).seconds();
															id = SOPID().getText();
															synctimeforSOPID = synctimeforSOPID + 25;
														}
													financeID = id;
													System.out.print("      " +rowNum + ". " + "A/C Name : "+arraylist.get(0) +  " +  SOPID : " +financeID + " + ");
													getDriver().navigate().back();
													waitFor(8).seconds();
													newRelationship.click(); 
													waitFor(3).seconds();
													accountB_Name().type(readClientAccountName);
											    	billing().selectByVisibleText("Billing");
											    	saveRelationship.click();
											    	waitFor(6).seconds();
											    	getDriver().get(clientURL); // Back to client account page
											    	waitFor(6).seconds();
									    	}
/************** Select Industry Category **********************************/
							    	getDriver().switchTo().frame("066D0000000kh27");
							    	WebElement editable = getDriver().switchTo().activeElement();
							    	editable.findElement(By.cssSelector("input[name='j_id0:j_id1:j_id27:j_id28:j_id31']")).click();
							    	waitFor(4).seconds();
						    	   	mainCate().selectByVisibleText(record.get("mainCategory"));
						    	   	waitFor(5).seconds();
							 	    subCate().selectByVisibleText(record.get("subCategory"));
							 	    waitFor(5).seconds();
							 	    minorCate().selectByVisibleText(record.get("minorCategory"));
							 	    waitFor(3).seconds();
							 	    saveIndCate().sendKeys(Keys.RETURN);
							 	    waitFor(4).seconds();
								    getDriver().switchTo().defaultContent();
					    	}
						    	else 
						    	{
						    	saveButton.click();
						    	waitFor(8).seconds();
						    	String Name = readAccountName().getText();
						    	arraylist.add(Name);
						    	clientURL = getDriver().getCurrentUrl();
						    	
						    	}
									if (str.equalsIgnoreCase("Direct Advertiser") || str.equalsIgnoreCase("Charity") || str.equalsIgnoreCase("Brand")|| str.equalsIgnoreCase("Private Advertiser")){
										
										 CCIMailIntegration(); // CCIMail Integration
										 waitFor(8).seconds();
										  /**************  Account Mapping  *******************************************/
										 
										 	accountMapping.click();
									    	waitFor(3).seconds();
									    	ref =CCIMailCustomerID().getText();
									    	waitFor(2).seconds();
									    	getDriver().navigate().back();
									    	waitFor(8).seconds();
										 
										 /**************  Account Mapping  *******************************************/
										 
												if (str.equalsIgnoreCase("Private Advertiser")){
													privateAdvFinanceAccount.click();   /***** DEPENDENDT ON POSTCODE SUPPLIED*************/
													waitFor(5).seconds();
													String id = SOPID().getText();
													while(id.equals(" ")) {
															waitFor(2).seconds();
															getDriver().navigate().back();
															waitFor(20).seconds();
															privateAdvFinanceAccount.click();
															waitFor(5).seconds();
															id = SOPID().getText();
															synctimeforSOPID = synctimeforSOPID + 25;
													}
												} 
												else 
													{ 
														financeAccount.click(); 
														waitFor(5).seconds();
													}	
												
												String id = SOPID().getText();
												while(id.equals(" ")) 
												  {
														waitFor(2).seconds();
														getDriver().navigate().back();
														waitFor(20).seconds();
														financeAccount.click();
														waitFor(5).seconds();
														id = SOPID().getText();
														synctimeforSOPID = synctimeforSOPID + 25;
													}
										 financeID = id;
//										 ref =CCIMailCustomerID().getText();
										System.out.print("      " +rowNum + ". " +"A/C Name : "+arraylist.get(0) + " +  A/C ID : " +ref + " +  SOPID : " +SOPID().getText() + " + ");
										waitFor(2).seconds();
										getDriver().navigate().back();
									}
									else {
										CCIMailIntegration();
										accountMapping.click();
								    	waitFor(3).seconds();
								    	ref = customerRef().getText();
								    	waitFor(2).seconds();
								    	getDriver().navigate().back();
								    	waitFor(8).seconds();
									}
						waitFor(5).seconds();
						createDirectOrder().click();
/**************  Select Order Type *************************************************************/
				    	
						if (str.equalsIgnoreCase("Direct Advertiser") || str.equalsIgnoreCase("Charity") || str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
				    	{
							waitFor(4).seconds();
							
							    	if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group"))
							    	{
							    		
							    		billingRef().click();
							    		billingSelectionNext().click();
							    		waitFor(5).seconds();
								    		try {
								    			 while(busyIntegrating().getText()!=null) {
								    				 
								    				 waitFor(30).seconds();
								    				 syncNext().click();
								    				 synctimeforSOPID = synctimeforSOPID + 30;
								    			 }
								    		} catch (Exception e) {}
							    	}
							    	else {
							    		
							    		billingSelection().selectByVisibleText("Direct");
									 	billingSelectionNext().click();  
							    	}
				    	}	
					if (str.equalsIgnoreCase("Brand"))
					{
						waitFor(3).seconds();
			    		billingOption().selectByVisibleText("Direct");
			    		billingSelectionNext().click(); 
			    	}
/**************  Create Contact ******************************************************************/
					 	
						String contact = record.get("firstName").concat(" ").concat(record.get("lastName")); // added
					 	waitFor(4).seconds();
						conSalutation().selectByVisibleText(record.get("salutation"));
		    		    conFirstName().type(record.get("firstName"));
		    		    conLastName().type(record.get("lastName"));
				    	emailAddress().type(record.get("email"));
					   	conPhonenumebr().type(record.get("phone"));
					 System.out.println(" Contact name is :   "+contact); 	// added
/**************  Associate Account*****************************************************************/			    	
				    	
					   	if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group")) 
					   	{
				    		selectBillingRef().click();
				    		waitFor(1).seconds();
//				    		i++;
				    	}
						   	else 
						   	{
						   		String endUseraccount = arraylist.get(0);
								accountType().selectByVisibleText(endUseraccount);
								waitFor(1).seconds();
//								i++;
						   	}
						contactNext().click();
						waitFor(2).seconds();
						arraylist.clear();
/************** Launch OrderPlugin and Create Order*************************************************/
						
						 finish().click();
						 waitFor(10).seconds();

/************************************************************************************************************/
						 
							getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe")));
							WebElement element = getDriver().switchTo().activeElement();
							String packageType = record.get("package");
							element.findElement(By.xpath("//td[div="+"'"+packageType+"'"+"]")).click();
							waitFor(8).seconds();
							
								/*******************Order Information***********************/
								 orderPurchaseNo().sendKeys(record.get("PONumber"));
								 orderNote().sendKeys(record.get("orderNote"));
								 orderUrgentNote().sendKeys(record.get("urgentNote"));
								 orderSalesRepId().sendKeys("Tom Leader");
								 
							    /******************Package Selection**************************/
									 addPackage().click();
									 waitFor(3).seconds();
							    /******************Supply Package Details************************/
								 if (packageType.equalsIgnoreCase("DM Display") || packageType.equalsIgnoreCase("TMOS Display")) 
								 {
//									 title().selectByVisibleText(record.get("title"));
									 selectPublication().selectByVisibleText(record.get("publication"));
							    	 waitFor(2).seconds();
							    	 selectSection().selectByVisibleText(record.get("section"));
							    	 waitFor(2).seconds();
							    	 selectZone().selectByVisibleText(record.get("zones"));
							    	 waitFor(6).seconds();
							    	 selectSubSection().selectByVisibleText(record.get("subsection")); // subsection
							    	 waitFor(4).seconds();
							    	 selectModule().selectByVisibleText(record.get("module"));
							    	 waitFor(5).seconds();
							    	 nextMonthDM().click();
									 waitFor(3).seconds();
								 }
								 if (packageType.equalsIgnoreCase("MailPlus")) {
									 
									 webSiteCategory().selectByVisibleText(record.get("websitecategory"));
									 waitFor(2).seconds();
									 webSite().selectByVisibleText(record.get("website"));
									 waitFor(2).seconds();
									 selectSection().selectByVisibleText(record.get("section"));
							    	 waitFor(4).seconds();
									 selectZone().selectByVisibleText(record.get("adunit"));
									 waitFor(6).seconds();
								 }
								 
								 if (packageType.equalsIgnoreCase("Mail Display Inserts")) {
									 
									 title().selectByVisibleText(record.get("title"));
									 selectPublication().selectByVisibleText(record.get("publication"));
							    	 waitFor(2).seconds();
							    	 distribution().selectByVisibleText(record.get("distribution"));
							    	 waitFor(6).seconds();
									 noOfInserts().type(record.get("numberOfInserts"));
									 waitFor(1).seconds();
								 }
								 
								 element.findElement(By.xpath("//tbody/tr[5]/td[4]")).click(); /**************** Date Field*****************/
						    	 waitFor(5).seconds(); 
						    	
								 /***************** Price Details **************************/
						    	 if (packageType.equalsIgnoreCase("DM Display") || packageType.equalsIgnoreCase("TMOS Display")) 
								 {
								    	/* selectPrice().click();
								    	 waitFor(5).seconds();
								    	 selectRevenue().type(record.get("revenue"));
								    	 waitFor(2).seconds();
								    	 updateRevenue().click();
								    	 waitFor(2).seconds();*/
						    		 
						    		 selectPrice().click();
						    		 waitFor(3).seconds();
						    		 selectInsertion().click();
						    		 waitFor(2).seconds();
						    		 selectedInsertionDate().click(); 
						    		 waitFor(3).seconds();
						    		 selectBasePrice().click();
						    		 waitFor(3).seconds();
						    		 supplyPriceType().selectByVisibleText("UserRevenue");
						    		 waitFor(2).seconds();
						    		 supplyPrice().type(record.get("revenue"));
						    		 waitFor(2).seconds();
						    		 updateInsLevelRevenue().click();
						    		 waitFor(4).seconds();
								 }
						    	 if (packageType.equalsIgnoreCase("Mail Display Inserts")) {
					    			 
						    		 selectPrice().click();
						    		 waitFor(3).seconds();
						    		 selectInsertion().click(); 
						    		 waitFor(1).seconds();
						    		 insertionDateDMI().click();
					    			 waitFor(2).seconds();
					    			 selectBasePriceDMI().click();
						    		 waitFor(1).seconds();
						    		 supplyPriceType().selectByVisibleText("UserRevenue");
						    		 waitFor(1).seconds();
						    		 supplyPriceDMI().type(record.get("revenue"));
						    		 waitFor(2).seconds();
						    		 updateRevenueDMI().click();
						    		 waitFor(4).seconds();
						    	 }
						    	 if (packageType.equalsIgnoreCase("MailPlus")) {
						    		 selectPrice().click();
						    		 waitFor(4).seconds();
						    		 selectInsertion().click();
						    		 waitFor(4).seconds();
						    		 insertionDateMP().click();
						    		 waitFor(3).seconds();
						    		 selectBasePriceMP().click();
						    		 waitFor(4).seconds();
						    		 supplyPriceType().selectByVisibleText("UserRevenue");
						    		 waitFor(2).seconds();
						    		 supplyPriceMP().type(record.get("revenue"));
						    		 waitFor(2).seconds();
						    		 updateRevenueMP().click();
						    		 waitFor(4).seconds();
						    	 }
/************************************ Accept Order *************************************************/	
									    	 acceptOrder().click();
									    	 try 
									    	 {
										    	 if(str.equalsIgnoreCase("Private Advertiser") || str.equalsIgnoreCase("Direct Advertiser")|| str.equalsIgnoreCase("Brand")) {
										    	 waitFor(3).seconds();
										    	 WebElement prepaymentwindow1 = getDriver().switchTo().activeElement();
										    	 waitFor(1).seconds();
										    	 prepaymentwindow1.findElement(By.xpath("//input[@value='Prepay']")).click();
										    	 waitFor(3).seconds();
										    	 WebElement prepaymentwindow2 = getDriver().switchTo().activeElement();
										    	 waitFor(1).seconds();
										    	 prepaymentwindow2.findElement(By.xpath("//input[@value='OK']")).click();
										    	 }
									    	 }catch (Exception NoPopUp)	 {}
									    	 waitFor(8).seconds();
									    	 getDriver().switchTo().defaultContent();
/************************************************************************************************/						
				    	 						
				    	 				    	if (readAccountName().isVisible()) {
				    	 				    		waitFor(20).seconds();
				    	 				    		searchTerms().type(financeID);
				    	 				    		searchGlue().click();
				    	 				    		waitFor(3).seconds();
				    	 				    		try {
				    	 				    		if (orderlink().isVisible())
				    	 				    		{ 
				    	 				    			clickOn(orderlink());
				    	 				    			System.out.print("        ORDER IS SYNCED BACK TO GLUE WITH IN 20 SECONDS ");
				    	 				    		}
				    	 				    		}catch (Exception e) { System.out
															.print("        ORDER DIDN'T SYNC BACK TO GLUE WITH IN 20 SECONDS"); }
				    	 				    		System.out.println("\n         SYNC WAIT TIME FOR SOPID IS  : "+synctimeforSOPID + " SECONDS");
				    	 				    		synctimeforSOPID =10;
				    	 				    		waitFor(2).seconds();
				    	 				    		accountCreation();
				    	 				    	}
/**********************************************************************************************/	
			
			
			} catch (Exception e)
				{
					Thucydides.takeScreenshot();
//					i++;
					arraylist.clear();
					System.out.println("       " +rowNum + " ---> " + "Sorry! either Data/Latency issue, please check test report for details" );
					waitFor(2).seconds();
					accountCreation();
				}
	} 
		}
	}
}
