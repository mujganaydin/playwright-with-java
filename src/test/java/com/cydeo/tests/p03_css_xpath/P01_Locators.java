package com.cydeo.tests.p03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P01_Locators {

    @Test
    void test() {

        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false)); //todo default headless?
        Page page = browser.newPage();

        page.navigate("https://login1.nextbasecrm.com/");

        page.querySelector("[name=USER_LOGIN]").fill("incorrectuser");
        page.querySelector("[name='USER_PASSWORD']").fill("incorrectpassword");

        page.querySelector(".login-btn").click(); // If it's a class, we can use .

        String errorMessage = page.querySelector(".errortext").textContent();

        System.out.println("errorMessage = " + errorMessage);

        page.waitForTimeout(3000); // If we not write here, we cannot see browser. //todo why?
        page.close();
        browser.close();
        playwright.close();

    }
}