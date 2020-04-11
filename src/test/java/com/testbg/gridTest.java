package com.testbg;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class gridTest {

    WebDriver driver;
    @DataProvider(name = "datetest")
    public Object[][] dataTest(){
        return new Object[][]{
                {"firefox"},
                {"chrome"}
        };
    }




    @Test(dataProvider = "datetest")
    public void openbaidu(String browser) throws InterruptedException, MalformedURLException {
        DesiredCapabilities rc=null;
        if (browser.contentEquals("firefox")){
            rc = DesiredCapabilities.firefox();
        }else if(browser.contentEquals("chrome")){
            rc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        driver = new RemoteWebDriver(new URL("http://169.254.15.25:4445/wd/hub"), rc);
        driver.get("http    s://www.baidu.com");
        Thread.sleep(10000);
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
}
