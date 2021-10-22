@menuitem
Feature: MenuItem

@about_us_menuitem
Scenario: open about us link menu item
	Given I open home page 
	When I click to accept cooking alert
	When I click to icon menuitem 
	And I click to "About Us" menuitem
	Then verify link "https://www.sytner.co.uk/about-us/" display
	And verify "About Us" page display
@news_menuitem
Scenario: open news link menu item
	Given I click to icon menuitem 
	When I click to "News" menuitem
	Then verify link "https://www.sytner.co.uk/news/" display
	And verify "News" page display
@customer_service
Scenario: open news link menu item
	Given I click to icon menuitem 
	When I click to "Customer Service" menuitem
	Then verify link "https://www.sytner.co.uk/customer-service/" display
	And verify "Customer Service" page display
#@careers_page
#Scenario: open news link menu item
#	Given I click to icon menuitem 
#	When I click to "Careers" menuitem
#	Then verify link "https://www.sytner.co.uk/careers/" display
#	And verify "Careers" page display
@finace_page
Scenario: open news link menu item
	Given I click to icon menuitem 
	When I click to "Finance" menuitem
	Then verify link "https://www.sytner.co.uk/finance/" display
	And verify "Finance" page display
@maintenance_page
Scenario: open news link menu item
	Given I click to icon menuitem 
	When I click to "Servicing, Parts & Repair" menuitem
	Then verify link "https://www.sytner.co.uk/car-maintenance/" display
	And verify "Servicing, Parts & Repair" page display
	
	
	
	
	
	
	
	
	
	