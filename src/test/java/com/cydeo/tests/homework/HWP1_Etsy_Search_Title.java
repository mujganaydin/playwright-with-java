package com.cydeo.tests.homework;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;

public class HWP1_Etsy_Search_Title {

    @Test
    void test1() {

        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        //Setting up our chromedriver using WebDriverManager

        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                new BrowserType.LaunchOptions().setHeadless(false));

        //Creating a new ChromeDriver and storing it in "driver"
        Page page = browser.newPage();

        //2. Go to https://www.etsy.com
        page.navigate("https://www.etsy.com");

        BrowserUtils.sleepWithThread(2);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();

        //3. Search for “wooden spoon”

        Locator searchBoxElement = page.locator("//input[@name='search_query']");
        searchBoxElement.fill("Wooden spoon");
//        searchBoxElement.type("wooden spoon");
//        searchBoxElement.pressSequentially("wooden spoon",
//                //put that statement to put delay between letters while writing
//                new Locator.PressSequentiallyOptions().setDelay(100));

        Keyboard keyboard = page.keyboard();
        keyboard.press("Enter");
        BrowserUtils.sleepWithThread(2);

        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”

        String expectedTitle = "Wooden spoon - Etsy Estonia";

        String actualTitle = page.title();

        Assertions.assertEquals(expectedTitle, actualTitle);



        //close the page


        //close the browser


        //close the playwright



    }
}