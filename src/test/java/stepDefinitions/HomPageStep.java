package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageUI.HomePageUI;

public class HomPageStep extends AbtractPage {
	WebDriver driver;

	public HomPageStep() {
		this.driver = Hooks.openAndQuitBrowser();
	}

	public HomPageStep(WebDriver driver) {
		this.driver = driver;
	}

	@Given("^I open home page$")
	public void iOpenApplicationHomePage() {
//		System.out.println("HomePage"+driver); 
		// PageGeneratorManager.getHomePage(driver);
	}

	@When("^I click to icon menuitem$")
	public void iClickToIconMenuitem() {
		waitToElementClickable(driver, HomePageUI.ICON_MENUITEM);
		clickToElement(driver, HomePageUI.ICON_MENUITEM);
	}

	@When("^I click to accept cooking alert$")
	public void iClickToAcceptCookingAlert() {
		if(isElementDisplayed(driver, HomePageUI.ACCEPT_COOKIES_BUTTON))
		{
		waitToElementClickable(driver, HomePageUI.ACCEPT_COOKIES_BUTTON);
		clickToElement(driver, HomePageUI.ACCEPT_COOKIES_BUTTON);
		}
		else {}
	}

	

}
