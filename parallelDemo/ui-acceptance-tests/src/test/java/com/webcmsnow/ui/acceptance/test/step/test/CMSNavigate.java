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

	// add, update and delete 00_basic module
	public static void check_00_basic_module(WebCMSPage webCMSPage)
			throws InterruptedException {
		String[] cmsModules = { "b_accordion: bootstrap accordion",
				"b_codeEditor:HTML/PHP JavaScript editor",
				"b_image:bootstrap responsive image",
				"b_imageGallery:image gallery",
				"b_mediaObject: image and text", "b_panel:bootstrap panel",
				"b_slider: bootstrap slider", "b_tab: bootstrap tab",
				"b_tinyMCE:Tiny MCE Editor" };

		addAndDeleteModules(webCMSPage, cmsModules, "00_basic");

	}

	// add, update and delete 01_basic and 02_basic modules
	public static void check_other1_modules(WebCMSPage webCMSPage)
			throws InterruptedException {
		String[] cmsbasic_01Modules = {
				"b_allEditor:HTML/PHP JavaScript editor",
				"b_imageHoverClick:bootstrap responsive image swap",
				"b_imageSlipHover:bootstrap responsive slip hover image",
				"b_slick: jquery slick plugin",
				"b_thumImage: bootstrap slider", "b_tinyMCEA:Tiny MCEA Editor" };

		String[] cmsbasic_02Modules = {
				"b_docAndFile:list of description files(pdf/doc/ppt ...",
				"b_itinerary:itineraries",
				"b_mp3PlayDownload: play and download mp3 audio with pagination" };

		addAndDeleteModules(webCMSPage, cmsbasic_01Modules, "01_basic");

		addAndDeleteModules(webCMSPage, cmsbasic_02Modules, "02_basic");

	}

	// add, update and delete 02_compose, 03_animate, 04_link, and 05_misc
	public static void check_module_others(WebCMSPage webCMSPage)
			throws InterruptedException {

		// 02_compose
		String[] cmsModulesCompose = {
				"compose_new: Merge or compose multiple images to one image",
				"multi_img_merge: Merge or compose multiple images to one image" };

		addAndDeleteModules(webCMSPage, cmsModulesCompose, "02_compose");

		// 03_animated
		String[] cmsModulesAnimate = { "b_sliderAnimated: bootstrap slider animated" };

		addAndDeleteModules(webCMSPage, cmsModulesAnimate, "03_animate");

		// 04_link
		String[] cmsModulesLink = { "b_linkList: Summary of List from link" };

		addAndDeleteModules(webCMSPage, cmsModulesLink, "04_link");

		// 05_misc
		String[] cmsModulesMisc = { "aImage:an image",
				"allEditor:HTML/PHP JavaScript editor",
				"angular_blog_edit:blog editor",
				"b_restaurantMenuItems:Add a category",
				"fullCalendar:fullCalendar", "googleMap:Google MAP",
				"minicartItem: add minicart items" };

		addAndDeleteModules(webCMSPage, cmsModulesMisc, "05_misc");

	}

	private static void addAndDeleteModules(WebCMSPage webCMSPage,
			String[] cmsModules, String mod) throws InterruptedException {
		for (String cmsModule : cmsModules) {
			System.out.println(cmsModule);
			webCMSPage.navTo("Root Layout Page");
			webCMSPage.getDriver().findElement(By.id("showemptyarea")).click();
			webCMSPage.getDriver().findElement(By.id("container-1:2")).click();

			selectModule(webCMSPage, mod, cmsModule);
			webCMSPage.navTo("Update Website");
			webCMSPage.navTo("Root Layout Page");
			webCMSPage.getDriver().findElement(By.id("hideemptyarea")).click();
			webCMSPage.getDriver().findElement(By.id("container-1:2")).click();
			webCMSPage.getDriver().findElement(By.id("DeleteArea")).click();
			webCMSPage.getDriver().findElement(By.id("deleteArea")).click();

		}
	}

	// Select a module from a mod group
	private static void selectModule(WebCMSPage webCMSPage, String groupMod,
			String cmsModule) throws InterruptedException {
		// Select module group and module

		Select modGroupDropDown = new Select(webCMSPage.getDriver()
				.findElement(By.id("modgroup")));
		modGroupDropDown.selectByVisibleText(groupMod);

		Select modDropDown = new Select(webCMSPage.getDriver().findElement(
				By.id("mymod")));

		modDropDown.selectByVisibleText(cmsModule);
		webCMSPage
				.getDriver()
				.findElement(
						By.xpath(".//*[@id='frmTest']/table/tbody/tr/td/input"))
				.click();

	}
}
