

@tag
Feature: Login web ui Test

  Scenario: login with valid credentials
	  Given I am on the login page
	  When I fill username user1
	  And I fill password user1pass
	  And I press login
	  Then I should be on the home page and see welcome user1
	  
	  