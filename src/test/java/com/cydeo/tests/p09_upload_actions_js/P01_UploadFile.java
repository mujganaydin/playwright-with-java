package com.cydeo.tests.p09_upload_actions_js;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.cydeo.utils.BrowserUtils;
import com.cydeo.utils.Driver;

import java.nio.file.Path;


public class P01_UploadFile {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://practice.cydeo.com/upload");
    }

    @Test
    void test1() {
//        System.getProperty("user.dir") is given path of our project.
//        "/src/test/resources/uploadtest.txt" is coming from our file path.
        String pathOfFile = System.getProperty("user.dir") + "/src/test/resources/uploadtest.txt";

//        way 1.
        Driver.getPage().getByTestId("file-upload").setInputFiles(Path.of(pathOfFile));

//        way 2.
//        Driver.getPage().getByTestId("file-upload").setInputFiles(Paths.get(pathOfFile));
//                                                         //.sendKeys(pathOfFile) //selenium

//        way 3. - for multiple files
//        Driver.getPage().getByLabel("Upload files").setInputFiles(new Path[]{Paths.get("pathOfFirstFile"), Paths.get
//                ("pathOfSecondFile")});


        BrowserUtils.sleepWithThread(3);

//        if you want to delete uploaded file go on with below line
//        Driver.getPage().getByTestId("file-upload").setInputFiles(new Path[0]);

        Driver.getPage().getByTestId("file-submit").click();
        System.out.println(Driver.getPage().locator("h3").textContent()); // We can choose "h3" -> css, "//h3" -> xpath
//        locator("h3") -> File Uploaded!

        Assertions.assertEquals("File Uploaded!", Driver.getPage().locator("h3").textContent());

    }

    @AfterEach
    void tearDown() {
        Driver.closeDriver();
    }
}
