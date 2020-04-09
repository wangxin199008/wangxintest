package com.testbg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class idTestBaidu {

    WebDriver driver;
    @BeforeTest
    public void OpenBaidu(){
        System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testBaidu() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement FindEdit = driver.findElement(By.id("su"));
        List<WebElement> list = driver.findElements(By.tagName("input"));
        System.out.println(list.size());
        Thread.sleep(3000);
    }

    @Test
    public void testXpth() throws InterruptedException {
        driver.get("https://www.baidu.com");

        List<WebElement> test1 = driver.findElements(By.xpath("//*[@id=\"u_sp\"]/a"));
        Thread.sleep(2000);
        System.out.println(test1.size());

    }

    @AfterTest
    public void closeBaidu(){

        driver.quit();
    }
}
