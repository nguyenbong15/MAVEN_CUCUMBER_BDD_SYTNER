package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbtractPage {
		private WebElement element;
		private Actions action;
		private Select select;
		private WebDriverWait explicitWait;
		private JavascriptExecutor js;
		private List<WebElement> elements;
		
		public void openUrl(WebDriver driver, String url) {
			driver.get(url);
		}

		public String getTitlePage(WebDriver driver) {
			return driver.getTitle();
		}

		public String getCurrentUrl(WebDriver driver) {
			return driver.getCurrentUrl();
		}

		public String getWindowHandle(WebDriver driver) {
			return driver.getWindowHandle();
		}

		public void backPage(WebDriver driver) {
			driver.navigate().back();
		}

		public void forwardPage(WebDriver driver) {
			driver.navigate().forward();
		}
		
		public void refreshCurrentPage(WebDriver driver) {
			driver.navigate().refresh();
		}

		public Set<String> getWindowHandles(WebDriver driver) {
			return driver.getWindowHandles();
		}
	    
		public By getXpath(String locator) {
			return By.xpath(locator);
		}

		public WebElement getElement(WebDriver driver, String locator) {
			return driver.findElement(getXpath(locator));
		}

		public List<WebElement> getElements(WebDriver driver, String locator) {
			return driver.findElements(getXpath(locator));
		}

		public void clickToElement(WebDriver driver ,String locator) {
			getElement(driver, locator).click();
		}
		
		public void senkeyToElement(WebDriver driver ,String locator,String value) {
			element=getElement(driver, locator);
			element.clear();
			element.sendKeys(value);
		}
		
		public String getAttributeElement(WebDriver driver ,String locator,String nameValue) {
			return getElement(driver, locator).getAttribute(nameValue);
		}
		
		public String getTextElement(WebDriver driver, String locator) {
			return getElement(driver, locator).getText();
		}
		
		public String getTextAlert(WebDriver driver) {
			return driver.switchTo().alert().getText();
		}
		
		public void acceptAlert(WebDriver driver){
			driver.switchTo().alert().accept();
		}
		
		public void cancelAlert(WebDriver driver){
			driver.switchTo().alert().dismiss();
		}
		
		public void setTextAlert(WebDriver driver,String value){
	       driver.switchTo().alert().sendKeys(value);
	       }
		
		public void waitAlertPresent(WebDriver driver) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.alertIsPresent());
		}
		
		public void clickAndHoverToElement(WebDriver driver, String locator)
		{
			action=new Actions(driver);
			action.clickAndHold(getElement(driver, locator)).perform();
		}
		
		public void hoverMouseToElement(WebDriver driver, String locator) {
			action=new Actions(driver);
			action.moveToElement(getElement(driver, locator)).perform();
		}
		
		public void rightClickToElement(WebDriver driver, String locator) {
			action=new Actions(driver);
			action.contextClick(getElement(driver, locator)).perform();
		}
		
		public void doubleClickToElement(WebDriver driver, String locator) {
			action=new Actions(driver);
			action.doubleClick(getElement(driver, locator)).perform();
		}
		
		public void switchToFrame(WebDriver driver, String locator) {
			driver.switchTo().frame(getElement(driver, locator));
		}
		
		public void switchToDefaulContent(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		
		public void selectItemInDropdown(WebDriver driver, String locator,String valueItem) {
			element=getElement(driver, locator);
			select=new Select(element);
			select.selectByVisibleText(valueItem);
		}
		public String getFistItemIndropdown(WebDriver driver, String locator) {
			select =new Select(getElement(driver, locator));
			return select.getFirstSelectedOption().getText();
		}
		public boolean isMultipleDropdown(WebDriver driver,String locator) {
			select=new Select(getElement(driver, locator));
			return select.isMultiple();
		}
		public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator,String valueItem) {
			element=getElement(driver, parentLocator);
			element.click();
			explicitWait=new WebDriverWait(driver,GlobalConstant.SHORT_TIME);
			explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getXpath(childLocator)));
			elements=getElements(driver, childLocator);
			for (WebElement x : elements) {
				if( x.getText().equals(valueItem)) {
					js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true);", x);
					sleepMiliSecond(500);
					x.click();
					sleepMiliSecond(500);
					break;
				}
			}
			
			
		}
	    
		public boolean isElementDisplayed(WebDriver driver, String locator) {
			return getElement(driver, locator).isDisplayed();
		}
		
		public boolean isElementSelected(WebDriver driver, String locator) {
			return getElement(driver, locator).isSelected();
		}
		
		public boolean isElementEnable(WebDriver driver, String locator) {
			return getElement(driver, locator).isEnabled();
		}
		
		public void checkToCheckbox(WebDriver driver, String locator) {
			element=getElement(driver, locator);
			if(!element.isSelected()) {
				element.click();
			}
		}
		public void uncheckToCheckbox(WebDriver driver, String locator) {
		   element=getElement(driver, locator);
			if(element.isSelected()) {
				element.click();
			}
		}
		public void sleepMiliSecond(long time) {
			try {
				Thread.sleep(1000*time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		public void sleepSecond(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public void switchToWindowByParentID(WebDriver driver,String parentID ) {
			Set<String> allWindows= getWindowHandles(driver);
			for (String string : allWindows) {
				if(!string.equals(parentID)) {
					driver.switchTo().window(string);
					break;
				}
			}
		}
		public void switchToWindowByTitle(WebDriver driver,String title ) {
			Set<String> allWindows= getWindowHandles(driver);
			for (String x : allWindows) {
					driver.switchTo().window(x);
					String titleCurrentWindow= driver.getTitle();
					if(!titleCurrentWindow.equals(title)) {
					  break;
				}
			}
		}
		public Object excecutorForBrower(String javaScript, WebDriver driver) {
			js = (JavascriptExecutor) driver;
			return js.executeScript(javaScript);
		}

		public void scrollToElement( WebDriver driver,String locator) {
			js = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public boolean verifyTextInInnerText(String textExpected, WebDriver driver) {
			js = (JavascriptExecutor) driver;
			String textActual = (String) js.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
			System.out.println("Text actual =" + textActual);
			return textActual.equals(textExpected);
		}

		public void clickToElementByJS(WebDriver driver, String locator) {
			js = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			js.executeScript("arguments[0].click();", element);
		}

		public void sendkeyToElementByJS(String locator, String value, WebDriver driver) {
			js = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			js.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
		}

		public void scrollToBottomPage(WebDriver driver) {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}

		public void removeAttributeInDom(String attributeRemove, WebDriver driver, String locator) {
			js = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "'", element);
		}

		public void navigateToUrlByJS(String url, WebDriver driver) {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.location='" + url + "'");
		}

		public boolean isImageLoaded(WebDriver driver, String locator) {

			js = (JavascriptExecutor) driver;
			element = getElement(driver, locator);
			element = getElement(driver, locator);
			boolean status = (boolean) js.executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					element);
			if (status) {
				return true;
			}
			return false;
		}
		public void highlightElement(WebDriver driver, String locator) {
//			js = (JavascriptExecutor) driver;
//			element = getElement(driver, locator);
//			String originalStyle = element.getAttribute("style");
	//
//			js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
//					"border: 4px solid red; border-style: dashed;");
//			sleepMiliSecond(500);
//			js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style", originalStyle);

		}

		public void waitToElementClickable (WebDriver driver,String locator) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getXpath(locator)));
		}
		
		public void waitToElementVisible (WebDriver driver,String locator) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(locator)));
		}
		
		public void waitToAllElementVisible (WebDriver driver,String locator) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getXpath(locator)));
		}
		
		public void waitToElementInVisible (WebDriver driver,String locator) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getXpath(locator)));
		}
		
		public void waitToElementPresent(WebDriver driver, String locator,int number) {
			explicitWait = new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.numberOfElementsToBe(getXpath(locator),number));

		}
		
		public String getDynamicLocator(String locator, String... values) {
			return String.format(locator,(Object[]) values);
		}
		public void waitToElementClickable (WebDriver driver,String locator,String... values) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getXpath(getDynamicLocator(locator, values))));
		}
		
		public void waitToElementVisible (WebDriver driver,String locator,String... values) {
			explicitWait=new WebDriverWait(driver, GlobalConstant.LONG_TIME);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getXpath(getDynamicLocator(locator, values))));
		}
		
		public void clickToElement(WebDriver driver ,String locator,String... values) {
			getElement(driver, getDynamicLocator(locator, values)).click();
		}
		
	}
