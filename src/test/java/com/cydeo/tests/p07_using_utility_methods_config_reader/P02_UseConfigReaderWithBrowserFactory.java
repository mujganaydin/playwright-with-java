package com.cydeo.tests.p07_using_utility_methods_config_reader;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;
import com.cydeo.utils.BrowserFactory;
import com.cydeo.utils.ConfigurationReader;

public class P02_UseConfigReaderWithBrowserFactory {
    static private Playwright playwright;
    static private Browser browser;
    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();

        String browserFromConfig = ConfigurationReader.getProperty("browser");

//        switch (browserFromConfig) {
//            case "chrome":
//                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
//                        .setHeadless(false));
//                break;
//            case "firefox":
//                browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
//                        .setHeadless(false));
//                break;
//        }
//        Playwright object is able to create browser object.
        browser = BrowserFactory.getBrowser(browserFromConfig, playwright);

        System.out.println("browserFromConfig = " + browserFromConfig);

    }

    @AfterAll
    static void afterAll() {

        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        page = browser.newContext().newPage();
        page.navigate("https://login1.nextbasecrm.com/");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {
        page.navigate(ConfigurationReader.getProperty("googleURL"));
    }
}
