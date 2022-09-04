Feature: Deleting all stocks
  I want to use this template for deleting stocks

  @deletingstocks
  Scenario: Deleting all stocks
    Given I open browser with url "https://portfolio.rediff.com/portfolio-login"
    When I enter useremail "sandisheshi@gmail.com"
    And I enter password "sheshi@26"
    And I click on login button
    Then I should see My portfolio
    When I delete my portfolio
    And I create new portfolio
    And I click on My Watchlist
    And I delete all stocks in mywatchlist
    When I click on signout 
    Then I should see logout successful
    When I close browser