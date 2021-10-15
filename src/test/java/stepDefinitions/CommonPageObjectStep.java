package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageUI.CommonPageOjectUI;

public class CommonPageObjectStep extends AbtractPage{
	WebDriver driver;
	public CommonPageObjectStep() {
		this.driver=Hooks.openAndQuitBrowser();
	}
	@When("^I click to \"([^\"]*)\" menuitem$")
	public void iClickToMenuitem(String namelink)  {
		waitToElementClickable(driver,CommonPageOjectUI.LINK_BY_NAME_OF_MENUITEM,namelink);
		clickToElement(driver, CommonPageOjectUI.LINK_BY_NAME_OF_MENUITEM,namelink);
	}
	@Then("^verify link \"([^\"]*)\" display$")
	public void verifyLinkDisplay(String currentUrl)  {
       Assert.assertEquals(getCurrentUrl(driver), currentUrl);
	}
}
