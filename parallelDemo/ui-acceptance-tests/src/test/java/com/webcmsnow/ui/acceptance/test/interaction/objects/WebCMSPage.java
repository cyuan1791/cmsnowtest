package com.webcmsnow.ui.acceptance.test.interaction.objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public void createWebsite(String template) throws InterruptedException {
        // Create website
    	getDriver().findElement(By.xpath("//*[@id='search-type']/li[3]/a/span")).click();
    	getDriver().findElement(By.name("yt0")).click();
    	getDriver().findElement(By.xpath("//*[@id='page']/div[2]/div/div/table/tbody/tr[1]/td[1]/form"));
        
        //mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    }
    public void renameWebsite(String newname) {
    	// renmae the first website
    	mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")).click();
    	getDriver().findElement(By.linkText("Update Web")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/input")).clear();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/input")).sendKeys(newname);
    	getDriver().findElement(By.name("yt0")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[2]/a")).click();
    }
    
    public void updateWebsite() throws InterruptedException {
    	//Thread.sleep(10000);
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/table/tbody/tr[1]/td[1]/form/input[10]")).click();
    	getDriver().findElement(By.linkText("Update Website"));
    	getDriver().findElement(By.linkText("Logout")).click();
    	
    }

    // remove the first website
    public void removeWebsite() throws InterruptedException {
    	goTo();
    	getDriver().findElement(By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/a")).click();
    	mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span")).click();
    	getDriver().findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")).click();
    	getDriver().findElement(By.linkText("Delete Web")).click();
    	Alert alert = getDriver().switchTo().alert();
    	alert.accept();
    	//getDriver().switchTo().alert().dismiss();
    }
    
}
