package com.cydeo.tests.p09_upload_actions_js;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;

public class P04_JSPractice {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/infinite_scroll");
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void test1() {

        for (int i = 0; i < 10; i++) {
//            Driver.getPage().evaluate("window.scrollBy(0, 500)"); // executable part todo? i don't understand.
            Driver.getPage().evaluate("() => {window.scrollBy(0, 500);}"); // part of function for the javascript
            BrowserUtils.sleepWithThread(1);
        }
    }
}
