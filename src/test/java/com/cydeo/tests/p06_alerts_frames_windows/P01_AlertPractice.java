package com.cydeo.tests.p06_alerts_frames_windows;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

public class P01_AlertPractice {

    //    I made static because we cannot reach instance variable/field from the static method, static block. ??
//    We will use same Browser, same Playwright object. It's belongs to all test cases, belongs the class. But we will use different page.
//    It's private because we use inside the that only this class.
    static private Playwright playwright;
    static private Browser browser;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create(); // It will create playwright object for me.
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000) // Please wait one second each step. It's slow motion.
        );
    }

    @AfterAll
    static void afterAll() {
        browser.close();
        playwright.close();
//        We are closing all browser and playwright object.
    }

    private Page page; // My page object is global now.

    @BeforeEach
    void setUp() {
//        Page page = browser.newContext().newPage(); // Here, our Page variable is not global.
//        It's not static because Page and context belongs each test cases. If it's static belongs the class, belongs the all test cases.
//        This method will run every test cases, before each test.
        page = browser.newPage();
//        Page is an interface.
//        I need to global variable to use inside the method.
//         Hooks for Cucumber.
//        newContext() -> you are opening one browser without any profile, any cookies. You don't have any data.
//        If we have profile, we can delete all data.
        page.navigate("https://practice.cydeo.com/javascript_alerts");
    }

    @AfterEach
    void tearDown() {
        page.close();
    }

    @Test
    void test1() {
//        page.navigate("https://practice.cydeo.com/javascript_alerts"); // We put BeforeEach.
//        We use page object so page object is global.
//        We need to click button. S we firstly inspect it.

//        We need to use before in that example we have only one option then playwright will handle without this line.
//        Playwright automatically handle the alert.
        page.onceDialog(d->d.accept()); //todo I don't understand.??

        page.locator("button")
                .first()
//                .nth(0)
                .click();

//        We want to see "You successfully clicked an alert"
        String s = page.locator("#result").textContent();

        System.out.println("s = " + s);
    }

    @Test
    void test2(){
        page.onceDialog(d->d.accept()); // We put it before the action.
//        onceDialog is getting consumer.
//        We don't need to create alert object with Playwright.

//        page.locator("//button[.='Click for JS Confirm']");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click for JS Confirm")).click();


        String s = page.locator("#result").textContent();

        System.out.println("s = " + s);
    }
}
