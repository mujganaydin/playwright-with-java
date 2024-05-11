package com.cydeo.tests.p09_upload_actions_js;

import com.microsoft.playwright.ElementHandle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;

public class P02_Hover {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/hovers");
    }

    @AfterEach
    void tearDown() {
        Driver.closeDriver();
    }

    @Test
    void test1() {

//        In Selenium:
//        Actions actions = new Actions(Driver.getDriver());
//        actions.moveToElement(webelement);

//        In Playwright: If we want to hover over it we can use hover().
        System.out.println(Driver.getPage().locator("//h5").nth(0).textContent());
        Driver.getPage().locator("img").nth(0).hover();
        BrowserUtils.sleepWithThread(2);

        System.out.println(Driver.getPage().locator("//h5").nth(1).textContent());
        Driver.getPage().locator("img").nth(1).hover();
        BrowserUtils.sleepWithThread(2);

        System.out.println(Driver.getPage().locator("//h5").nth(2).textContent());
        Driver.getPage().locator("img").nth(2).hover();

    }

    @Test
    void test2() {
        /*
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(webelemnt);

         */

        ElementHandle firstImage = Driver.getPage().locator("(//img)[1]").elementHandle()
                ;
        ElementHandle firstImageName = Driver.getPage().querySelector("(//h5)[1]");
        BrowserUtils.sleepWithThread(2);

        firstImage.hover();
        System.out.println(firstImageName.isVisible());
        Assertions.assertTrue(firstImageName.isVisible());

    }
}
