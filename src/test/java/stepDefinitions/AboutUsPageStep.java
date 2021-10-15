package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbtractPage;

public class AboutUsPageStep extends AbtractPage {
	 WebDriver driver;

	 public AboutUsPageStep() {
		 this.driver=Hooks.openAndQuitBrowser();
	 }
	
}
