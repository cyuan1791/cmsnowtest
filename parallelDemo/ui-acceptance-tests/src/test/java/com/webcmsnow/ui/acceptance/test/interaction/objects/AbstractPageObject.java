package com.webcmsnow.ui.acceptance.test.interaction.objects;

import com.webcmsnow.ui.acceptance.test.config.webdriver.WaitConditions;

import cucumber.api.Scenario;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;

/**
 * Reusable methods for all page objects
 */
public abstract class AbstractPageObject {
	protected Scenario scenario;
	private String path;
	private final WebDriver driver;
	private final int waitTimeOutSeconds;
	// Mouse over a target element and make sub menu visiable
	String javaScript = "var evObj = document.createEvent('MouseEvents');"
			+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
			+ "arguments[0].dispatchEvent(evObj);";

	public AbstractPageObject(String path, WebDriver driver,
			int waitTimeOutSeconds) {
		this.path = path;
		this.driver = driver;
		this.waitTimeOutSeconds = waitTimeOutSeconds;
	}

	public void setSenario(Scenario scenario) {
		this.scenario = scenario;
	}
	public void deleteAllCookies() {
		getDriver().manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void goTo() {
		getDriver().navigate().to(path);
	}

	public String getPath() {
		return path;
	}

	// Mouse over an webElement
	public void mouseOver(By bid) throws InterruptedException{
		// ((JavascriptExecutor)driver).executeScript(javaScript,
		// this.driver.findElement(by));
		WebElement mytarget = driver.findElement(bid);

		Actions builder = new Actions(driver);
		builder.moveToElement(mytarget).perform();
		Thread.sleep(500);
	}
	// Mouse over second level
		public void mouseOver(By top, By second) throws InterruptedException{
			// ((JavascriptExecutor)driver).executeScript(javaScript,
			// this.driver.findElement(by));
			
            WebElement mainmenu1 = driver.findElement(top);
            Actions builder = new Actions(driver);
            builder.moveToElement(mainmenu1 ).build().perform();
            Thread.sleep(2000); //add a wait
            WebElement submenu1=  driver.findElement(second); //Find the submenu
            builder.moveToElement(submenu1).click().build().perform();
            Thread.sleep(2000);
		}

	/**
	 * Go to page and wait until url reflects expected page (or timeout reached)
	 */
	public void goToAndWait() {
		goTo();
		ensure_is_current();
	}

	public void ensure_is_current() {
		wait_until_true_or_timeout(WaitConditions.urlContains(path));
	}

	public boolean is_text_present(String text) {
		wait_until_true_or_timeout(WaitConditions.pageContainsText(text));
		return true;
	}

	/**
	 * wait until condition is true or timeout kicks in
	 */
	protected <V> V wait_until_true_or_timeout(ExpectedCondition<V> isTrue) {
		Wait<WebDriver> wait = new WebDriverWait(this.driver,
				waitTimeOutSeconds)
				.ignoring(StaleElementReferenceException.class);
		try {
			return wait.until(isTrue);
		} catch (TimeoutException rte) {
			throw new TimeoutException(rte.getMessage() + "\n\nPageSource:\n\n"
					+ getDriver().getPageSource());
		}
	}

	public void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public void selectDropdownByText(WebElement element, String visibleText) {
		Select filterSelect = new Select(element);
		waitForDropdownItems(element);
		filterSelect.selectByVisibleText(visibleText);
	}

	private void waitForDropdownItems(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeOutSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected WebElement find(By locator) {
		try {
			return getDriver().findElement(locator);
		} catch (NoSuchElementException ex) {
			throw new NoSuchElementException(ex.getMessage()
					+ "\n\nPageSource:\n\n" + getDriver().getPageSource());
		}
	}

	// take sceenshot, only works using "mvn install"
    protected void myTakeScreenShot(WebDriver driver) {
    	try {
			scenario.write("From AbstractPageObject: Current Page URL is "
					+ driver.getCurrentUrl());
			byte[] screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots
					.getMessage());
		}
    }
}
