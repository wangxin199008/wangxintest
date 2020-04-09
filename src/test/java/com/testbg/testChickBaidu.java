package com.testbg;

import com.sun.org.apache.xml.internal.resolver.helpers.FileURL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class testChickBaidu {

    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void sedkeyTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement key = driver.findElement(By.id("kw"));
        key.click();
        key.sendKeys("selenium");
        WebElement baiduButton = driver.findElement(By.id("su"));
        baiduButton.click();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"selenium_百度搜索");
        File  screenShotFie = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenShotFie,new File("D:/test.jpg"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void getATest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        String a = driver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(a,"百度一下");
    }

    @Test
    public void getAaTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Boolean b= driver.findElement(By.id("su")).isDisplayed();
        driver.findElement(By.id("su")).isSelected();
        Assert.assertTrue(b);
    }


    @Test
    public void downHuoHu() throws InterruptedException {
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("火狐浏览器下载");
        driver.findElement(By.id("su")).click();
        driver.findElement(By.xpath("//*[@id=\"2\"]")).click();

        Thread.sleep(10000);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
