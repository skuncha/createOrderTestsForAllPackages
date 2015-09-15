!-- Objective : As a sales rep i should be able to login to glue and create Billing Agency Account 
!-- srinivasa.kuncha@mailnewspapers.co.uk.prodmirror *glue1234*
!-- srinivasa.kuncha@dmgmedia.co.uk.systest   *best1234*

Narrative:
In order to Create Agency Accounts using CSV file
As a Sales Representative
I want to login to SalesforceGlue and create Accounts

Scenario: Sales reprasentative will be able to create accounts using CSV file

Meta:
@author Srinivasa Kuncha
@tags feature: User Login

Given Sales rep is on the Salesforce home page
When Sales rep login to glue as Mail user by supplying [username] and [password]
Then Mail user should be able to login to glue successfully
When Mail user navigate to Accounts page and click on New button
And Mail user search for an Account using [searchAccountName]
And Mail user access New Account from search results section
When Mail user provides input data from CSV [file] and create account

Examples:
|username												|password	|searchAccountName 	|file											|
|srinivasa.kuncha@mailnewspapers.co.uk.systest			|glue1234	|xyz123				|src\main\resources\createOrders.csv			|