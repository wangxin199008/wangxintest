package com.testbg;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGDome1 {
    WebDriver webdriver;
    @BeforeTest
    public void beforTestCase1(){
        System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver11.exe");
        webdriver = new ChromeDriver();
        System.out.println("beforetest22");
    }

    @Test
    public void testCase1(){
        System.out.println("22");
        String a = "123123";
        String b = "123123";
        Assert.assertEquals(a,b,"这个结果不正确");
    }

    @Test
    public void openChrome() throws InterruptedException {

        webdriver.get("http://www.baidu.com");
        Thread.sleep(3000);
        String url = webdriver.getCurrentUrl();
        System.out.println("获取到的地址" + url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        webdriver.navigate().back();
        Thread.sleep(3000);
        webdriver.navigate().forward();
        Thread.sleep(3000);
        webdriver.navigate().refresh();
    }

    public  void JSTest() throws InterruptedException {
        webdriver.get("https://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"1231231232\");");
        Thread.sleep(4000);
    }
    @AfterTest
    public void closeChrome(){
        webdriver.quit();
    }


}
