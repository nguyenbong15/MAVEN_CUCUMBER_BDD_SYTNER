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
		 this.driver=Hooks.openAndQuitBrowser();
	 }
	public HomPageStep(WebDriver driver) {
		this.driver=driver;
	}
	
	@Given("^I open application$")
	public void iOpenApplication()  {
//		System.out.println("HomePage"+driver); 
		//PageGeneratorManager.getHomePage(driver);
	}

	@When("^I click to icon menuitem$")
	public void iClickToIconMenuitem() {
		waitToElementClickable(driver, HomePageUI.ICON_MENUITEM);
		clickToElement(driver, HomePageUI.ICON_MENUITEM);
	}

	@When("^I click to about us menuitem$")
	public void iClickToAboutUsMenuitem()  {
		waitToElementClickable(driver, HomePageUI.ICON_MENUITEM);
		clickToElement(driver, HomePageUI.ICON_MENUITEM);
		//PageGeneratorManager.getAbouUsPage(driver);
	}

}
