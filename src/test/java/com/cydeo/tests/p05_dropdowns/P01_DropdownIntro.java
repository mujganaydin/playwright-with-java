package com.cydeo.tests.p05_dropdowns;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;

public class P01_DropdownIntro {

    @Test
    void test1() {


        Playwright playwright = Playwright.create();
        /*
       BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

         */

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/dropdown");

//        How to get the selected option by using JavaScript? We use javascript executor with Selenium.

        ElementHandle elementHandle = page.querySelector("#dropdown");

//        Playwright is not have selectedOption. How to get selectedOption with playwright?
//        Inside the evaluate() we can run any javascript code. Normally we use Java. We can go on with javascript with this method.
//        We were passing the argument. So we use inside the evaluate()'s elementHandle as the second parameter.
        String selectedOption = page.evaluate("el=>el.selectedOptions[0].text", elementHandle).toString();
        System.out.println("selectedOption = " + selectedOption);

        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();


    }
}
