package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomPageStep extends AbtractPage {
	 WebDriver driver;

	public HomPageStep() {
		this.driver=Hooks.openAndQuitBrowser();
	}
	
	@Given("^I open application$")
	public void iOpenApplication()  {
	    
	}

	@When("^I click to icon menuitem$")
	public void iClickToIconMenuitem() {
	}

	@When("^I click to about us menuitem$")
	public void iClickToAboutUsMenuitem()  {
	}

	@Then("^verify link \"([^\"]*)\" display$")
	public void verifyLinkDisplay(String arg1)  {
	}
}
