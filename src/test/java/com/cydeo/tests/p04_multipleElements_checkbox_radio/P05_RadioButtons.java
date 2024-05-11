package com.cydeo.tests.p04_multipleElements_checkbox_radio;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;

public class P05_RadioButtons {


    @Test
    void test1() {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://practice.cydeo.com/radio_buttons");

//        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Red")).click(); // It's not working.
//        Because HTML is no connection between label and input tag.
//        It's able to understand belongs to the line that has input label, if it has for="red". //todo for="red" in connection sagladigini nereden anladik?

//        page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Hockey")).check(); // It's working.
//        Because it's HTML page has for="Hockey". So HTML is connection between label and input tag.

        Locator hockey = page.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Hockey"));

        BrowserUtils.sleepWithThread(3);
        System.out.println(hockey.isChecked());

        hockey.check();

        BrowserUtils.sleepWithThread(3);
        System.out.println(hockey.isChecked());

        page.close();
        browser.close();
        playwright.close();
    }
}