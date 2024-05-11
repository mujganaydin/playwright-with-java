package com.cydeo.tests.p04_multipleElements_checkbox_radio;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;

import java.util.List;

public class P03_ClickWithIndex {

    @Test
    void test1() {

        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/");

//        If we have multiple element(list of web element), we can use first().
//        Inside the locator is about css selector. container is class value in the web page.
//        BrowserUtils.sleepWithThread(3); // We can use.

        List<ElementHandle> elementHandles = page.querySelectorAll(".container li a");
        System.out.println("elementHandles.size() = " + elementHandles.size());
        BrowserUtils.sleepWithThread(3);

        page.locator(".container li a")
//                .first()
//                .last()
                .nth(4)
                .click();

        for (int i = 0; i < elementHandles.size(); i++) {
            Locator locator = page.locator(".container li a").nth(i);

            if (locator.textContent().equals("A/B Testing")) {

                page.locator(".container li a")
                        // .first()
                        //  .last()
                        .nth(i)
                        .click();

                break;

            }
        }
        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();
    }
}
