package com.cydeo.tests.p04_multipleElements_checkbox_radio;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;

import java.util.List;

public class P02_findElements {

    @Test
    void name() {
        Playwright playwright = Playwright.create();
//        BrowserType chromium = playwright.chromium(); // 1.way
//        Browser browser = chromium.launch( new BrowserType.LaunchOptions().setHeadless(false));

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // 2. way

        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/abtest");

        List<ElementHandle> links = page.querySelectorAll("//a"); //It returns list of element handle
//        We can easily manipulate it.
        for (ElementHandle each : links) {
            System.out.println(each.getAttribute("href"));
        }

//        BrowserUtils.sleepWithPage(page, 1);
        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();

    }
}
