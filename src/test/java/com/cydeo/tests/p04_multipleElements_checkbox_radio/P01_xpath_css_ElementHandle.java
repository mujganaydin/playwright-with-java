package com.cydeo.tests.p04_multipleElements_checkbox_radio;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

public class P01_xpath_css_ElementHandle {

    @Test
    void test1() {

        Playwright playwright = Playwright.create();
//        BrowserType chromium = playwright.chromium(); // instead of here, we can write directly browser. (line 19)
//        Browser browser = chromium.launch( new BrowserType.LaunchOptions().setHeadless(false));
//        webkit() is for safari etc.

        Browser browser = playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false)); //todo? chromium ne method mu?

        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/forgot_password");

//        ElementHandle is an interface.
//        Inside the querySelector should be xpath or cssSelector.
        ElementHandle homeLink = page.querySelector("a.nav-link");

        ElementHandle emailLabel = page.querySelector("div label");
//        ElementHandle and locator differences, hover overing, multiple element, change locator will work most of the time? todo arastir

        System.out.println(homeLink.textContent());
        System.out.println(emailLabel.textContent());
        System.out.println("homeLink.isVisible = " + homeLink.isVisible());
        System.out.println("emailLabel.isVisible = " + emailLabel.isVisible());


        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();

    }
}
