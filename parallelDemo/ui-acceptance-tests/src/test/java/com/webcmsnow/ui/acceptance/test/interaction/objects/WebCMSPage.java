package com.webcmsnow.ui.acceptance.test.interaction.objects;



import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.webcmsnow.ui.acceptance.test.common.RenameFailed;

/**
 * Provides methods for interacting with the Google search page
 */
public class WebCMSPage extends AbstractPageObject {
    public static final String PATH = "/";

    //page elements
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
    public void login(String user, String password) throws InterruptedException {
    	//getDriver().get(baseUrl + "/");
        getDriver().findElement(By.id("UserLogin_password")).clear();
        getDriver().findElement(By.id("UserLogin_password")).sendKeys(password);
        getDriver().findElement(By.id("UserLogin_username")).clear();
        getDriver().findElement(By.id("UserLogin_username")).sendKeys(user);
        getDriver().findElement(By.name("yt0")).click();
        //Thread.sleep(100000);
        
    }
    public void createWebsite(String template, String Navigation) throws InterruptedException {
        // Create website
    	getDriver().findElement(By.xpath("//*[@id='search-type']/li[3]/a/span")).click();
    	
    	Select dropdownTemplate = new Select(getDriver().findElement(By.xpath(".//*[@id='Web_template']")));
    	dropdownTemplate.selectByVisibleText(template);
    	
    	Select dropdownNav = new Select(getDriver().findElement(By.xpath(".//*[@id='Web_nav']")));
    	dropdownNav.selectByVisibleText(Navigation);
    	
    	myTakeScreenShot(getDriver());
    	getDriver().findElement(By.name("yt0")).click();
    	getDriver().findElement(By.xpath("//*[@id='page']/div[2]/div/div/table/tbody/tr[1]/td[1]/form"));
        
        //mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    }
    public void renameWebsite(String newname) throws RenameFailed, InterruptedException  {
    	// renmae the first website
    	goTo();
    	getDriver().findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/a/span")).click();
    	mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")).click();
    	getDriver().findElement(By.linkText("Update Web")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/input")).clear();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/input")).sendKeys(newname);
    	getDriver().findElement(By.name("yt0")).click();
    	
    	// make sure rename is successful
    	//System.out.println(getDriver().getPageSource());
    	
    	// Throw an exception if response page contain text "Rename website failed"
    	if (getDriver().getPageSource().contains("Rename website failed"))  {
    		throw new RenameFailed();
    	}
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[2]/a")).click();
    }
    
    public void navTo(String top, String second, String nav) throws InterruptedException {
    	System.out.println("Edit nav "+ top + "-> " + second + " -> " + nav);
    	mouseOver(By.linkText(top),By.linkText(second));
    	getDriver().findElement(By.linkText(nav)).click();
    }
    
    public void updateTitle(String newTitle) throws InterruptedException {
    	navTo("Edit", "Home Page", "Edit Page Title");
    	getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr/td/input[1]")).clear();
    	getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr/td/input[1]")).sendKeys(newTitle);
    	getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr/td/input[2]")).click();
    }
    
    // visit my website
    public void getMyWebsite() {
    	String parentHandle = getDriver().getWindowHandle(); // get the current window handle
    	
    	getDriver().findElement(By.xpath("/html/body/table/tbody/tr[2]/td/span/a")).click(); // click some link that opens a new window

    	for (String winHandle : getDriver().getWindowHandles()) {
    		System.out.println(winHandle);
    		getDriver().switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    		//System.out.println("my title is : " + getDriver().getTitle());
    	}

    	//code to do something on new window
    	System.out.println("my title is : " + getDriver().getTitle());

    	getDriver().close(); // close newly opened window when done with it
    	getDriver().switchTo().window(parentHandle); // switch back to the original window
    }
    
 // visit my website
    public String getMyWebsiteTitle() {
    	String myTitle;
    	String parentHandle = getDriver().getWindowHandle(); // get the current window handle
    	
    	getDriver().findElement(By.xpath("/html/body/table/tbody/tr[2]/td/span/a")).click(); // click some link that opens a new window

    	for (String winHandle : getDriver().getWindowHandles()) {
    		System.out.println(winHandle);
    		getDriver().switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    		//System.out.println("my title is : " + getDriver().getTitle());
    	}

    	//code to do something on new window
    	System.out.println("my title is : " + getDriver().getTitle());
    	myTitle = getDriver().getTitle();

    	getDriver().close(); // close newly opened window when done with it
    	getDriver().switchTo().window(parentHandle); // switch back to the original window
    	System.out.println("Switch to " + parentHandle);
    	return myTitle;
    }
    public void updateWebsite() throws InterruptedException {
    	//Thread.sleep(10000);
    	goTo();
    	Thread.sleep(1000);
    	getDriver().findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/a/span")).click();
    	Thread.sleep(1000);
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/form/input[10]")).click();
    	Thread.sleep(1000);
    	getDriver().findElement(By.linkText("Update Website")).click();
    	//getDriver().findElement(By.linkText("Logout")).click();
    	
    	
    }

    // remove the first website
    public void removeWebsite() throws InterruptedException {
    	goTo();
    	Thread.sleep(1000);
    	getDriver().findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/a")).click();
    	mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")).click();
    	Thread.sleep(1000);
    	getDriver().findElement(By.linkText("Delete Web")).click();
    	Thread.sleep(1000);
    	Alert alert = getDriver().switchTo().alert();
    	Thread.sleep(1000);
    	alert.accept();
    	//getDriver().switchTo().alert().dismiss();
    }
    
}