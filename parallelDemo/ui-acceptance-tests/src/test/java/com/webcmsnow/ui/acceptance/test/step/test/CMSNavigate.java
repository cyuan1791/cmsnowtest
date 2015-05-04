package com.webcmsnow.ui.acceptance.test.step.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.webcmsnow.ui.acceptance.test.interaction.objects.WebCMSPage;

public class CMSNavigate {
	public static void basicNavigate(WebCMSPage webCMSPage)
			throws InterruptedException {
		Thread.sleep(300);
		webCMSPage.navTo("Misc");
		webCMSPage.navTo("ShortCut");
		webCMSPage.navTo("Edit", "Home Page", "Edit Page Title");
		webCMSPage.navTo("Edit", "Home Page", "Edit Meta Property");
		webCMSPage.navTo("Edit", "Home Page", "Edit Meta Name");

		webCMSPage.navTo("Edit", "Menu", "EditMenu");
		webCMSPage.navTo("Edit", "Menu", "InsertMenu");

		webCMSPage.navTo("Edit", "CSS", "Global InLine CSS");
		webCMSPage.navTo("Edit", "CSS", "Update Theme, Font, Others");
		webCMSPage.navTo("Edit", "CSS", "Manage Backup");
		webCMSPage.navTo("Edit", "CSS", "Snapshot");

		webCMSPage.navTo("Edit", "Edit Files", "File global.css");
		webCMSPage.navTo("Edit", "Edit Files", "File global.js");

		webCMSPage.navTo("Misc", "Manage ShortCut");
		webCMSPage.navTo("Misc", "Logging", "Show Log");
		webCMSPage.navTo("Misc", "Change Active Priority Level");
		webCMSPage.navTo("Misc", "Manage ShortCut");

	}

	// add and delete 00_basic module
	public static void check_00_basic_module(WebCMSPage webCMSPage)
			throws InterruptedException {
		String[] cmsModules = { "b_accordion: bootstrap accordion",
				"b_codeEditor:HTML/PHP JavaScript editor",
				"b_image:bootstrap responsive image ",
				"b_imageGallery:image gallery",
				"b_mediaObject: image and text ", "b_panel:bootstrap panel",
				"b_slider: bootstrap slider", "b_tab: bootstrap tab",
				"b_tinyMCE:Tiny MCE Editor " };

		for (String cmsModule : cmsModules) {
			System.out.println(cmsModule);
			webCMSPage.navTo("Root Layout Page");
			webCMSPage.getDriver().findElement(By.id("showemptyarea")).click();
			webCMSPage.getDriver().findElement(By.id("container-1:2")).click();

			// Select module group and module
			Select modGroupDropDown = new Select(webCMSPage.getDriver()
					.findElement(By.id("modgroup")));
			modGroupDropDown.selectByVisibleText("00_basic");
			Select modDropDown = new Select(webCMSPage.getDriver().findElement(
					By.id("mymod")));
			modDropDown.selectByVisibleText(cmsModule);
			webCMSPage.getDriver().findElement(By.xpath(".//*[@id='frmTest']/table/tbody/tr/td/input")).click();
			
			webCMSPage.navTo("Update Website");
			webCMSPage.navTo("Root Layout Page");
			webCMSPage.getDriver().findElement(By.id("hideemptyarea")).click();
			webCMSPage.getDriver().findElement(By.id("container-1:2")).click();
			webCMSPage.getDriver().findElement(By.id("DeleteArea")).click();
			webCMSPage.getDriver().findElement(By.id("deleteArea")).click();

		}
	}

}
