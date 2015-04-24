package com.webcmsnow.ui.acceptance.test.interaction.objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Provides methods for interacting with the Google search page
 */
public class WebCMSPageSteps extends AbstractWebCMSPageSteps{
    public static final String PATH = "/";


  
    public WebCMSPageSteps( WebDriver driver) {
        this.driver = driver;
    }

   
    public void login(String user, String password) throws InterruptedException {
    	//getDriver().get(baseUrl + "/");
        this.driver.findElement(By.id("UserLogin_password")).clear();
        this.driver.findElement(By.id("UserLogin_password")).sendKeys(password);
        this.driver.findElement(By.id("UserLogin_username")).clear();
        this.driver.findElement(By.id("UserLogin_username")).sendKeys(user);
        this.driver.findElement(By.name("yt0")).click();
        //Thread.sleep(100000);
        
    }
    public void createWebsite(String template) throws InterruptedException {
        // Create website
    	this.driver.findElement(By.xpath("//*[@id='search-type']/li[3]/a/span")).click();
    	this.driver.findElement(By.name("yt0")).click();
    	this.driver.findElement(By.xpath("//*[@id='page']/div[2]/div/div/table/tbody/tr[1]/td[1]/form"));
        
        //mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    }
    public void renameWebsite(String newname) {
    	// renmae the first website
    	mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    	this.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span")).click();
    	this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")).click();
    	this.driver.findElement(By.linkText("Update Web")).click();
    	this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/input")).clear();
    	this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/input")).sendKeys(newname);
    	this.driver.findElement(By.name("yt0")).click();
    }

    // remove the first website
    public void removeWebsite() {
    	mouseOver(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/a/span"));
    	this.driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/ul/li[1]/ul/li[1]/a/span")).click();
    	this.driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[3]/div[1]/a")).click();
    	this.driver.findElement(By.linkText("Delete Web")).click();
    	Alert alert = this.driver.switchTo().alert();
    	alert.accept();
    	//this.driver.switchTo().alert().dismiss();
    }
    
}
