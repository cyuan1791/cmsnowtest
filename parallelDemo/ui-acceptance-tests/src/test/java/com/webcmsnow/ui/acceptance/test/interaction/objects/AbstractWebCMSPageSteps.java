package com.webcmsnow.ui.acceptance.test.interaction.objects;

import com.webcmsnow.ui.acceptance.test.config.webdriver.WaitConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

/**
 * Reusable methods for all page objects
 */
public abstract class AbstractWebCMSPageSteps {
	public WebDriver driver;
   
 // Mouse over a target element and make sub menu visiable
  //  String javaScript = "var evObj = document.createEvent('MouseEvents');" +
  //       "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
  //       "arguments[0].dispatchEvent(evObj);";
    
    


    // Mouse over an webElement
    public void mouseOver(By bid) {
    	//((JavascriptExecutor)driver).executeScript(javaScript, this.driver.findElement(by));
    	WebElement mytarget = driver.findElement(bid);
        
        Actions builder = new Actions(driver);
        builder.moveToElement(mytarget).perform();
    }
   
}
