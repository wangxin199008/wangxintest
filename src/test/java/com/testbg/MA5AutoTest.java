package com.testbg;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MA5AutoTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
         System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.get("http://ma5.rtmap.com/#/login");
         driver.findElement(By.xpath("//*[@id=\"loginVueApp\"]/div[2]/div/p[1]/span[2]/div/input")).sendKeys("test");
         driver.findElement(By.xpath("//*[@id=\"loginVueApp\"]/div[2]/div/p[2]/span[2]/div/input")).sendKeys("888888");
         driver.findElement(By.xpath("//*[@id=\"loginVueApp\"]/div[2]/div/button")).click();
    }
    @Test
    public void createCoupon() throws InterruptedException, IOException {

        HashMap<String,Object> chromeprefs = new HashMap<String, Object>();
        chromeprefs.put("profile.default_content_settings.popups",0);
        chromeprefs.put("download.default_directory","D://Down");
        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs",chromeprefs);

        driver = new ChromeDriver(option);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div/div[1]/div[3]/a[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/ul[1]/li[1]")).click();
//        //展示时间点击日期范围
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[7]/div/div[1]/label[2]"))
//                .click();
//        //输入展示日期的开始时间
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[8]/div/div/div/input[1]"))
//                .sendKeys("2020 年 04 月 06 日");
//        //输入展示日期的结束时间
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[7]/div/div[2]/div/input[2]"))
//                .sendKeys("2020 年 04 月 16 日");
        //输入领取日期的开始时间
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[8]/div/div/div/input[1]"))
                .sendKeys("2020 年 04 月 06 日");
        //输入领取日期的结束时间
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[8]/div/div/div/input[2]"))
                .sendKeys("2020 年 04 月 16 日");
        //配置核销有效期

        WebElement day1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[9]/div/div[2]/div/input[1]"));
        WebElement day2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[9]/div/div[2]/div/input[2]"));
        day1.clear();
        day1.sendKeys("2020 年 04 月 06 日");
        day2.clear();
        day2.sendKeys("2020 年 04 月 16 日");
        //输入券数量
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[12]/div/div/input"))
                .sendKeys("50");
        //上传封面图片
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[1]/div[21]/div/div/input"))
                .sendKeys("F:\\照片\\118_0905\\IMGP1177.jpg");
        File screenShotFie = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFie,new File("D:/test.jpg"));
        //点击创建按钮
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/div[2]/div[2]/div/div[1]")).click();
        Thread.sleep(2000);
    }
    @Test
    public void downTest(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div/div[1]/div[3]/a[5]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/ul[1]/li[1]")).click();
    }

    @AfterMethod
    public void close(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/div/div[1]/div[4]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div/section/div/ul[1]/li[6]")).click();
        driver.quit();
    }
}
