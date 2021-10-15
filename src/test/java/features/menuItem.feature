@menuitem
Feature: MenuItem

@about_us_menuitem
Scenario: open about us link menu item
	Given I open home page 
	When I click to accept cooking alert
	When I click to icon menuitem 
	And I click to "About Us" menuitem
	Then verify link "https://www.sytner.co.uk/about-us/" display
@news_menuitem
Scenario: open news link menu item
	Given I click to icon menuitem 
	When I click to "News" menuitem
	Then verify link "https://www.sytner.co.uk/news/" display