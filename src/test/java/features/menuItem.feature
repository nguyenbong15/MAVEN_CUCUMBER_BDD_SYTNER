Feature: MenuItem

@about_us_menuitem
Scenario: open about us menu item
	Given I open application 
	When I click to icon menuitem 
	And I click to about us menuitem
	Then verify link "https://www.sytner.co.uk/about-us/" display