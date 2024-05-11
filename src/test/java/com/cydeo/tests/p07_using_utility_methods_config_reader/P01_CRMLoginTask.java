package com.cydeo.tests.p07_using_utility_methods_config_reader;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;
import com.cydeo.utils.CRMUtils;

public class P01_CRMLoginTask {


    static private Playwright playwright;

    static private Browser browser;

    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000)
        );
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
//        BrowserUtils.sleepWithThread(100); // We delete then the code run. todo why?
        page.close();
    }

    @Test
    void test1() {
        CRMUtils.login(page);
    }

    @Test
    void test2() {
        CRMUtils.login(page, "marketing@gmail.com", "UserUser");
    }
}
