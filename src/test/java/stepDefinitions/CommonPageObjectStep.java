package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import commons.AbtractPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageUI.CommonPageOjectUI;
import pageUI.HomePageUI;

public class CommonPageObjectStep extends AbtractPage {
	WebDriver driver;

	public CommonPageObjectStep() {
		this.driver = Hooks.openAndQuitBrowser();
	}

	@When("^I click to \"([^\"]*)\" menuitem$")
	public void iClickToMenuitem(String namelink) {
		waitToElementClickable(driver, CommonPageOjectUI.LINK_BY_NAME_OF_MENUITEM, namelink);
		clickToElement(driver, CommonPageOjectUI.LINK_BY_NAME_OF_MENUITEM, namelink);
	}

	@Then("^verify link \"([^\"]*)\" display$")
	public void verifyLinkDisplay(String currentUrl) {
		Assert.assertEquals(getCurrentUrl(driver), currentUrl);
	}

	@Then("^verify \"([^\"]*)\" page display$")
	public void verifyPageDisplay(String namePage) {
		Assert.assertTrue(isElementDisplayed(driver, CommonPageOjectUI.VERIFY_PAGE, namePage));
	}

	@When("^I scroll to \"([^\"]*)\" branch$")
	public void iScrollToBranch(String namebranch) {
		scrollToElement(driver, CommonPageOjectUI.ICON_BRANCH,namebranch);
	}

	@When("^I click to \"([^\"]*)\" branch$")
	public void iClickToBranch(String namebranch) {
		waitToElementClickable(driver, CommonPageOjectUI.ICON_BRANCH,namebranch);
		clickToElement(driver, CommonPageOjectUI.ICON_BRANCH,namebranch);
	}

	@Then("^verify icon branch \"([^\"]*)\"  display$")
	public void verifyIconBranchDisplay(String namebranch) {
		waitToElementVisible(driver, CommonPageOjectUI.VERIFY_BRANCH_PAGE,namebranch);
		Assert.assertTrue(isElementDisplayed(driver, CommonPageOjectUI.VERIFY_BRANCH_PAGE, namebranch));
	}

	@Then("^I back to Home Page$")
	public void iBackToHomePage() {
		backPage(driver);
	}
	@And("^I click to hide form$")
	public void iClickToHideForm() {
		if(IsElementPresent(driver, CommonPageOjectUI.BUTTON_TO_HIDE_FORM)) {
			waitToElementClickable(driver, CommonPageOjectUI.BUTTON_TO_HIDE_FORM);
			clickToElement(driver, CommonPageOjectUI.BUTTON_TO_HIDE_FORM);
		}
		else {}
	}
}
