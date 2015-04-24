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
    public void login(String user, String password) throws InterruptedException {
    	goTo();
    	WebCMSPageSteps page = new WebCMSPageSteps(getDriver());
    	page.login(user, password);
    	page.createWebsite("");
    	page.renameWebsite("w1");
    	page.removeWebsite();
    }
    public boolean isSearchResultPresent(String searchResultUrl) {
        return is_text_present(searchResultUrl);
    }
}
