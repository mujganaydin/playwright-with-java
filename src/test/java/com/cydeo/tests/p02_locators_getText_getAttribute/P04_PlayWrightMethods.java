package com.cydeo.tests.p02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
// import com.microsoft.playwright.Page.*;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

public class P04_PlayWrightMethods {

    @Test
    void test() {
//        I can look documentation for methods. --> https://playwright.dev/java/docs/api/class-framelocator#frame-locator-get-by-label
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch(
                //if you want to see browser pass this line
                new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://library2.cybertekschool.com/login.html");
//        page.getByPlaceholder("Email address").fill("incorrectemail@gmail.com");
//        page.getByPlaceholder("Email addre").fill("incorrectemail@gmail.com"); --> It's also working. It's similar contains.

//        new Page.GetByPlaceholderOptions() is called. Because class GetByPlaceholderOptions is inside of Page interface.
//        GetByPlaceholderOptions() is a constructor. We call constructor to create class's object/instance.
        page.getByPlaceholder("Email address", new Page.GetByPlaceholderOptions().setExact(true)).fill("incorrectemail@gmail.com"); //todo new ne?
//        If I write "Email adres" with setExact, it fails.

//        page.getByLabel("Password").fill("incorrectpassword"); // - 1. way
//        page.getByPlaceholder("Password").fill("incorrectpassword"); -> It gives similar result with getByLabel. // 2. way
        page.querySelector("#inputPassword").fill("incorrectpassword"); // --> "inputPassword is id. So I have to use #. // 3. way

//        page.getByRole(AriaRole.BUTTON).click(); // -> I can use it. Because I have only one button in the web page.

//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("sign in")).click(); // If you have more than one button, we can use it.
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("sign in").setExact(true)).click(); // It's given error because setExact() is case sensitive. It's kind of exception. //todo error?

        System.out.println(page.getByRole(AriaRole.ALERT).textContent());
        System.out.println(page.getByRole(AriaRole.ALERT).isVisible());
//        If I write isVisible() before line includes textContent(), it some computer gives error. It's related to isVisible() and auto waiting for playwright.
//        In playwright there is auto wait mechanism for some methods but not for the isVisible() method and if your connection and computer is not powerful you will see false.
        page.waitForTimeout(3000);

        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close(); //playwright object
    }
}
