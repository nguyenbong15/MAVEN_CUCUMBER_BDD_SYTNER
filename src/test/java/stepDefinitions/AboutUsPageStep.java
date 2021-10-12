package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.Then;

public class AboutUsPageStep extends AbtractPage {
	 WebDriver driver;

	 public AboutUsPageStep() {
		 this.driver=Hooks.openAndQuitBrowser();
	 }
	
	

	@Then("^verify link \"([^\"]*)\" display$")
	public void verifyLinkDisplay(String currentUrl)  {
		System.out.println("aboutpage"+driver);
    Assert.assertEquals(getCurrentUrl(driver), currentUrl);
	}
}
