package com.vytrack.utilities;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class BrowserUtils {
    public static void titleVerification(WebDriver driver,String expTitle){
        Assert.assertEquals(expTitle,driver.getTitle());
    }
}
