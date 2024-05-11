package com.cydeo.tests.p06_alerts_frames_windows;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import com.cydeo.utils.BrowserUtils;

public class P02_Frames {

    static private Playwright playwright;
    static private Browser browser;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create(); // It will create playwright object for me.
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000) // Please wait one second each step. It's slow motion.
        );
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
    }

    private Page page; // My page object is global now.

    @BeforeEach
    void setUp() {
        page = browser.newPage();
        page.navigate("https://practice.cydeo.com/iframe");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {
//        Instead of locator use frameLocator.
//        FrameLocator is the main iframe.
        FrameLocator firstIframe = page.frameLocator("#mce_0_ifr");
        firstIframe.locator("#tinymce").clear();
//        FrameLocator locator = firstIframe.frameLocator("#secondIframeInsideTheFirst"); //todo I don't understand.??
        BrowserUtils.sleepWithThread(2);
        firstIframe.locator("#tinymce").fill("Here is box");
//        My p element inside the iframe.
//        So we cannot use page, we use firstIframe.
//        page.locator("//p").textContent(); // We cannot it.
        String pValue = firstIframe.locator("//p").textContent();

        Assertions.assertEquals("Here is box", pValue);

        System.out.println(page.locator("//h3").textContent());

    }
}
