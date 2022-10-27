package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Create private constructor to restrict access to object of class
    private Driver(){};

    //private static WebDriver so we restrict access to change it elsewhere
    private static WebDriver driver;

    //Getter method to create driver instance or get current instance of driver
    public static WebDriver getDriver(){

        //If statement and switch statment to create new browser based on browser declared in configuration properties doc
        if(driver==null){
            String browserType= ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }return driver;
    }



        public static void closeDriver(){
            if(driver!=null){
                driver.quit();
                 driver=null;
        }
}



}
