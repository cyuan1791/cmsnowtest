package com.webcmsnow.ui.acceptance.test.config.webdriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Creates a browser session which can be used to interact with a web UI. This
 * class allows for a single session to be re-used across multiple test cases
 * for increased speed.
 */
public class SharedDriver extends EventFiringWebDriver {
	private static WebDriver REAL_DRIVER;

	// private static final Thread CLOSE_THREAD = new Thread() {

	/*
	 * @Override public void run() {
	 * 
	 * 
	 * System.out.println("Call quit");
	 * 
	 * try { quitGlobalInstance(); } catch (Exception e) { }
	 * 
	 * }
	 * 
	 * };
	 */
	/*
	 * private static void quitGlobalInstance() { // WebDriver driver =
	 * REAL_DRIVER; // REAL_DRIVER = null; if (REAL_DRIVER != null) {
	 * REAL_DRIVER.quit(); } }
	 */

	private static WebDriver getRealDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/Users/cmsnow/jsrc/chromedriver");
		// driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		if (REAL_DRIVER == null) {
			//REAL_DRIVER = new FirefoxDriver();
			 REAL_DRIVER = new ChromeDriver();
			// REAL_DRIVER = new RemoteWebDriver(
			// new URL("http://vm1:4444/wd/hub"),
			// DesiredCapabilities.firefox());
			REAL_DRIVER.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		}
		return REAL_DRIVER;
	}

	public SharedDriver() throws Exception {
		super(getRealDriver());
		// Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
	}

	
	/*
	 * @Override public void quit() { if (Thread.currentThread() !=
	 * CLOSE_THREAD) { throw new UnsupportedOperationException(
	 * "You shouldn't quit this WebDriver. It's shared and will close when the JVM exits."
	 * ); } try { super.quit(); } catch (Throwable e) { e.printStackTrace(); } }
	 */
}
