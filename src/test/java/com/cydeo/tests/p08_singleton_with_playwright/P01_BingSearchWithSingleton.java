package com.cydeo.tests.p08_singleton_with_playwright;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;

public class P01_BingSearchWithSingleton {

    @Test
    void bing_search_1(){
        Driver.getPage().navigate(ConfigurationReader.getProperty("bingURL"));

        BrowserUtils.sleepWithThread(3);

//        If we want to use getByTestId() by default data-testid attribute ... My id inside the id attribute, we say please use the id attribute with the getByTestId().
//        data-testid = id. In our HTML file we use data-testid. But we don't have it, we have id instead of it as an attribute in HTML page.
//        playwright.selectors().setTestIdAttribute("id"); -> Driver class line 22. // We say that playwright default one is data-testid, but please use id.
        Driver.getPage().getByTestId("bnp_btn_accept").click();

        BrowserUtils.sleepWithThread(3);

        Driver.getPage().getByTestId("sb_form_q").fill("playwright");

        Driver.getPage().getByTestId("sb_form_q").press("Enter");

        Assertions.assertTrue(Driver.getPage().title().contains("playwright"));

        BrowserUtils.sleepWithThread(3);

        Driver.closeDriver();
    }
}
