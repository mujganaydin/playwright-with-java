package com.cydeo.tests.p03_css_xpath;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class P02_Differences_InnerText_TextContent {

    @Test
    void test1() {


        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("http://localhost:63342/playwriht-with-java/getText.html?_ijt=n90ol3n16e84lk5v9lgksglail&_ij_reload=RELOAD_ON_SAVE");
//        It's coming resources - getText - right click - open in - browser - chrome.

        String textContent = page.querySelector("#example").textContent();
        String innerText = page.querySelector("#example").innerText();

        System.out.println("textContent = " + textContent);
        System.out.println("innerText = " + innerText);

        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();



    }
}