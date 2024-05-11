package com.cydeo.tests.p08_singleton_with_playwright;

import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;

public class P02_RegistrationWithSingleton {

    @Test
    void test1() {

        Driver.getPage().navigate("https://practice.cydeo.com/login");
        Driver.getPage().locator("input").first().fill("tomsmith");
        Driver.getPage().locator("input").last().fill("SuperSecretPassword");
        Driver.getPage().getByTestId("wooden_spoon").click();


        BrowserUtils.sleepWithThread(4);
        Driver.closeDriver();

    }
}