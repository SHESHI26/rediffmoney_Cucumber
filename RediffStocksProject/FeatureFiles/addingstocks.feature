 Feature: Rediff Money
  I want to use this template to add stocks in Rediff Money

  @signin
  Scenario: rediff money login
    Given I open browser with url "https://portfolio.rediff.com/portfolio-login"
    When I enter useremail "sandisheshi@gmail.com"
    And I enter password "sheshi@26"
    And I click on login button
    Then I should see My portfolio
    
    
    @addstocks
  Scenario Outline: Adding stocks
   When I click on add stock button
   And I add stocks entering "<stname>" and "<date>" and "<quantity>" and "<price>"
   And I click escape
  
   Examples:
   |stname|date|quantity|price|
    |Infosys|05-07-2022|10|1100|
    |Wi|06-07-2022|15|350|
    |Zomato|07-07-2022|10|70|
    |Tata steel|08-07-2022|20|800|
    |Oil|09-07-2022|20|110|
    
    @mutualfunds
    Scenario Outline: Adding mutual funds
    When I click on add mutualfund button
    And I add mutualfunds entering "<mfname>","<iniamount>","<mfdate>"
     And I click escape
    Examples:
    |mfname|iniamount|mfdate|
    |ICICI|10000|05-07-2022|
    |HDFC|5000|04-07-2022|
    |LIC|6000|06-07-2022|
    |Shriram|4000|08-07-2022|
    |SBI|7000|09-07-2022|

   @mywatchlist
   Scenario: Opening My watchlist
   When I click on My Watchlist
   Then I should see My Watchlist
   
   @watchliststocks
   Scenario Outline: Adding stocks in My Watchlist
   When I click on AddStock 
   And I enter "<stockname>","<aboveprice>","<belowprice>"
   And I click on addstock button
   
   Examples:
   |stockname|aboveprice|belowprice|
   |Reliance|2500|2350|
   |Ambuja|380|335|
   |Ultra|6000|5800|
   |Larsen|1750|1620|
   |Maruti|8800|8350|
  
   @signout
    Scenario: rediff money logout
    When I click on signout 
    Then I should see logout successful
    
    
