package com.cydeo.tests.p05_dropdowns;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;

public class P02_DropdownSelectOption {


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

//        How to select the option? Playwright has own methods for this topic. We use selectByVisibleText, selectByIndex, selectByValue with selenium.

        Locator yearDropdown = page.locator("#year"); // I want to find my year by using locator.
        Locator monthDropdown = page.locator("#month");
        Locator dayDropdown = page.locator("#day");

        String expectedYear = "1998";
        String expectedMonth = "January";
        int expectedDay = 12;


//        We can use different ways.
//        select with value
//        yearDropdown.selectOption(new SelectOption().setValue("1998"));
        yearDropdown.selectOption(new SelectOption().setValue(expectedYear));
        BrowserUtils.sleepWithThread(1);
//        select with text (Label is a text.) Label is from playwright. Text is from Selenium.
//        monthDropdown.selectOption(new SelectOption().setLabel("January"));
        monthDropdown.selectOption(new SelectOption().setLabel(expectedMonth));
        BrowserUtils.sleepWithThread(1);
//        select with index
//        dayDropdown.selectOption(new SelectOption().setIndex(0));
        dayDropdown.selectOption(new SelectOption().setIndex(expectedDay - 1));
        BrowserUtils.sleepWithThread(1);

//        "el=>el.selectedOptions[0].text" -> el is meaning element. It's not mandatory. I can make different thing, kk, th etc.
//        My type of yearDropdown is locator. But we use inside the evaluate()'s elementHandle as the second parameter. So it's given exception.
//        ElementHandle is part of DOM. We are not able to pass. Locator interface is working cssSelector.
//        We need to convert our elements. We need to use elementHandle().


        String actualYear = page.evaluate("el=>el.selectedOptions[0].text", yearDropdown.elementHandle()).toString(); //todo
        String actualMonth = page.evaluate("el=>el.selectedOptions[0].text", monthDropdown.elementHandle()).toString();
        String actualDay = page.evaluate("el=>el.selectedOptions[0].text", dayDropdown.elementHandle()).toString();

        System.out.println("with DOM knowledge " + page.evaluate("document.querySelector('#year').value").toString());

        System.out.println("actualYear = " + actualYear);
        System.out.println("actualMonth = " + actualMonth);
        System.out.println("actualDay = " + actualDay);


        BrowserUtils.sleepWithThread(3);
        page.close();
        browser.close();
        playwright.close();
    }
}
