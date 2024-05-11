package com.cydeo.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class Driver {
    static private Playwright playwright;
    static private Browser browser;
    static private Page page;

    private Driver() {
    }

    public static Page getPage() {
//        this line for deciding the browser type
        String browserFromConfig = ConfigurationReader.getProperty("browser");

        if (page == null) {
//            Firstly I need to create playwright object.
            playwright = Playwright.create();
//            In playwright default one is data-testid. But we say that playwright, please use id instead of data-testid. Because my html is using id.
//            If your app is using id attribute you need to change default settings of the playwright
            playwright.selectors().setTestIdAttribute("id");
            switch (browserFromConfig.toLowerCase()) {
                case "chrome":
                    BrowserType chromium = playwright.chromium();
                    browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page = browser.newPage();
                    break;

                case "firefox":
                    BrowserType firefox = playwright.firefox();
                    browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page = browser.newPage(); // We are able to create page object for firefox as well.
                    break;
            }
        }
        return page;
    }
    public static void closeDriver() {

        if (page != null) {
            page.close();
            page = null;
            browser.close();
            browser = null;
            playwright.close();
            playwright = null;
        }
    }
}
