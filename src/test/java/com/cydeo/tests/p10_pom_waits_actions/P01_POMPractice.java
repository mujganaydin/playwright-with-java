package com.cydeo.tests.p10_pom_waits_actions;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P01_POMPractice {

//    LibraryLoginPage libraryLoginPage = new LibraryLoginPage(); //todo why we didn't create and initialize inside the class level, here?.
    LibraryLoginPage libraryLoginPage;

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage(); //todo why we didn't create and initialize inside the class level.
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void test1() {
        libraryLoginPage.getEmailInput().fill("invalid");
        libraryLoginPage.getPasswordInput().fill("invalid");
        libraryLoginPage.getSignInButton().click();
    }

    @Test
    void test2() {
        libraryLoginPage.login("invalid", "invalid");
        libraryLoginPage.getSignInButton().click();

        Assertions.assertTrue(libraryLoginPage.getErrorMessage().isVisible());
    }

}
