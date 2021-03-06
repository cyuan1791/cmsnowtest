package com.webcmsnow.ui.acceptance.test.interaction.objects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webcmsnow.ui.acceptance.test.common.RenameFailed;

/**
 * Provides methods for interacting with the WebCMSPage
 */
public class WebCMSPage extends AbstractPageObject {
	public static final String PATH = "/";

	// page elements
	private final By searchTextbox = By.name("q");

	public WebCMSPage(String baseUrl, WebDriver driver, int waitTimeOutSeconds) {
		super(baseUrl + PATH, driver, waitTimeOutSeconds);
	}

	public void search(String searchText) {
		setText(find(searchTextbox), searchText);
		submit(find(searchTextbox));
	}

	public boolean isSearchResultPresent(String searchResultUrl) {
		return is_text_present(searchResultUrl);
	}

	// Login to WebCMSNow
	public void login(String user, String password) throws InterruptedException {
		// getDriver().get(baseUrl + "/");
		getDriver().findElement(By.id("UserLogin_password")).clear();
		getDriver().findElement(By.id("UserLogin_password")).sendKeys(password);
		getDriver().findElement(By.id("UserLogin_username")).clear();
		getDriver().findElement(By.id("UserLogin_username")).sendKeys(user);
		getDriver().findElement(By.name("yt0")).click();
		// Thread.sleep(100000);

	}

	public void createWebsiteFromFileTemplate(String template, String Navigation)
			throws InterruptedException {
		// Create website
		getDriver()
				.findElement(By.xpath("//*[@id='search-type']/li[3]/a/span"))
				.click();

		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		WebElement elem = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath(".//*[@id='Web_template']")));
		Select dropdownTemplate = new Select(elem);

		dropdownTemplate.selectByVisibleText(template);

		Select dropdownNav = new Select(getDriver().findElement(
				By.xpath(".//*[@id='Web_nav']")));
		dropdownNav.selectByVisibleText(Navigation);

		getDriver().findElement(By.name("yt0")).click();

		getDriver()
				.findElement(
						By.xpath("//*[@id='page']/div[2]/div/div/table/tbody/tr[1]/td[1]/form"));

	}

	public void renameWebsite(String newname) throws RenameFailed,
			InterruptedException {
		// renmae the first website
		// Goto http://manage.vm2/ WebSite
		goToManage();

		// Mouseover WebSite
		mouseOver(By
				.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));

		Thread.sleep(300);
		// locate Manage WebSite and click
		getDriver()
				.findElement(
						By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span"))
				.click();

		// Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		WebElement elem = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")));
		elem.click();

		// Thread.sleep(500);
		WebDriverWait waitTop = new WebDriverWait(getDriver(), 5);

		WebElement updateLink = waitTop.until(ExpectedConditions
				.visibilityOfElementLocated(By.linkText("Update Web")));
		updateLink.click();
		// getDriver().findElement(By.linkText("Update Web")).click();

		getDriver().findElement(By.id("Web_url")).clear();
		getDriver().findElement(By.id("Web_url")).sendKeys(newname);
		getDriver().findElement(By.name("yt0")).click();
		// Thread.sleep(500);
		// make sure rename is successful
		// System.out.println(getDriver().getPageSource());

		// Throw an exception if response page contain text
		// "Rename website failed"
		if (getDriver().getPageSource().contains("Rename website failed")) {
			throw new RenameFailed();
		}

		WebDriverWait waitM = new WebDriverWait(getDriver(), 30);
		WebElement elemM = waitM
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[2]/a/span")));
		elemM.click();
	}

	// Three level navigation
	public void navTo(String top, String second, String nav)
			throws InterruptedException {
		int count = 0;
		int maxTries = 3;
		while (true) {
			try {
				System.out.println(count + " : Edit nav " + top + "-> "
						+ second + " -> " + nav);
				mouseOver(By.linkText(top), By.linkText(second));

				getDriver().findElement(By.linkText(nav)).click();
				break;
			} catch (Exception e) {
				// handle exception
				if (++count == maxTries)
					throw e;
			}
		}

	}

	// Two level navigation
	public void navTo(String top, String second) throws InterruptedException {

		int count = 0;
		int maxTries = 3;
		while (true) {
			try {
				System.out.println(count + " : Edit nav " + top + "-> " + second);

				mouseOver(By.linkText(top));
				WebDriverWait wait = new WebDriverWait(getDriver(), 5);

				WebElement submenu1 = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.linkText(second)));
				submenu1.click();
				break;
			} catch (Exception e) {
				// handle exception
				if (++count == maxTries)
					throw e;
			}
		}

	}

	// One level navigation
	public void navTo(String top) throws InterruptedException {
		getDriver().findElement(By.linkText(top)).click();
	}

	public void navToById(String top, String second, String nav)
			throws InterruptedException {
		System.out.println("Edit nav by id" + top + "-> " + second + " -> "
				+ nav);
		mouseOver(By.xpath("//*[@id='" + top + "']/a"), By.linkText(second));
		getDriver().findElement(By.linkText(nav)).click();
	}

	public void changeWebsiteTitle(String newTitle) throws InterruptedException {
		// navTo("Edit", "Home Page", "Edit Page Title");
		// Thread.sleep(300);
		navTo("Edit", "Home Page", "Edit Page Title");
		// Thread.sleep(1000);
		// myTakeScreenShot(getDriver());
		// Thread.sleep(500);
		getDriver().findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/input[1]")).clear();
		getDriver().findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/input[1]"))
				.sendKeys(newTitle);
		getDriver().findElement(
				By.xpath("/html/body/form/table/tbody/tr/td/input[2]")).click();
	}

	// visit my website
	public void getMyWebsite() {
		String parentHandle = getDriver().getWindowHandle(); // get the current
																// window handle

		getDriver().findElement(
				By.xpath("/html/body/table/tbody/tr[2]/td/span/a")).click(); // click
																				// some
																				// link
																				// that
																				// opens
																				// a
																				// new
																				// window

		for (String winHandle : getDriver().getWindowHandles()) {
			System.out.println(winHandle);
			getDriver().switchTo().window(winHandle); // switch focus of
														// WebDriver to the next
														// found window handle
														// (that's your newly
														// opened window)
			// System.out.println("my title is : " + getDriver().getTitle());
		}

		// code to do something on new window
		System.out.println("my title is : " + getDriver().getTitle());

		getDriver().close(); // close newly opened window when done with it
		getDriver().switchTo().window(parentHandle); // switch back to the
														// original window
	}

	// visit my website
	public String getMyWebsiteTitle() throws InterruptedException {
		String myTitle;
		String parentHandle = getDriver().getWindowHandle(); // get the current
																// window handle

		getDriver().findElement(
				By.xpath("/html/body/table/tbody/tr[2]/td/span/a")).click(); // click
																				// some
																				// link
																				// that
																				// opens
																				// a
																				// new
																				// window
		// Thread.sleep(10000);
		for (String winHandle : getDriver().getWindowHandles()) {
			System.out.println(winHandle);
			getDriver().switchTo().window(winHandle); // switch focus of
														// WebDriver to the next
														// found window handle
														// (that's your newly
														// opened window)
			// System.out.println("my title is : " + getDriver().getTitle());
		}

		getDriver().navigate().refresh();
		// code to do something on new window
		System.out.println("my title is : " + getDriver().getTitle());
		myTitle = getDriver().getTitle();

		getDriver().close(); // close newly opened window when done with it
		Thread.sleep(1000);
		getDriver().switchTo().window(parentHandle); // switch back to the
														// original window
		System.out.println("Switch to " + parentHandle);
		return myTitle;
	}

	public void updateWebsite() throws InterruptedException {
		// Thread.sleep(10000);
		goToManage();

		// Thread.sleep(1000);
		getDriver().findElement(By.id("WebCMSNow1")).click();
		// Thread.sleep(1000);
		// myTakeScreenShot(getDriver());
		getDriver().findElement(By.linkText("Update Website")).click();
		// getDriver().findElement(By.linkText("Logout")).click();

	}

	public void removeWebsite(String webSiteName) throws InterruptedException {
		Integer websiteIdx = 0;
		goToManage();

		// Locate the index of target website
		if (webSiteName.equals("")) {
			// passed "", will default to remove first website
			websiteIdx = 1;
		} else {
			List<WebElement> webs = getDriver().findElements(
					By.cssSelector("td:first-child a"));

			for (WebElement element : webs) {
				websiteIdx++;
				System.out.println(element.getText());
				if (element.getText().equals(webSiteName))
					break; // find it
			}
			if (websiteIdx.equals(0)) {
				// trying to remove a non exist website
				System.out
						.println("Warning! Trying to remove a non exist website:"
								+ webSiteName);
				return;
			}
		}

		mouseOver(By
				.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));

		getDriver()
				.findElement(
						By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span"))
				.click();

		getDriver()
				.findElement(
						By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div["
								+ websiteIdx + "]/a")).click();
		// Thread.sleep(1000);
		getDriver().findElement(By.linkText("Delete Web")).click();
		// Thread.sleep(100);
		Alert alert = getDriver().switchTo().alert();
		// Thread.sleep(100);
		alert.accept();
		// getDriver().switchTo().alert().dismiss();
	}

}