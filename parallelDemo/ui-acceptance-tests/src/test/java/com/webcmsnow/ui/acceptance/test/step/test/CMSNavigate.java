package com.webcmsnow.ui.acceptance.test.step.test;

import com.webcmsnow.ui.acceptance.test.interaction.objects.WebCMSPage;

public class CMSNavigate {
	public static void basicNavigate(WebCMSPage webCMSPage) throws InterruptedException {
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

}
