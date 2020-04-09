package com.testbg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class login163MailTest {

    WebDriver driver;
    @BeforeMethod
    public void  openMail(){
//        System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://mail.qq.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void sedMailTest(){

        //点击写信按钮
        driver.findElement(By.id("composebtn")).click();

        //获取ifrom定位，进行移交
        WebElement from1 = driver.findElement(By.id("post"));
        driver.switchTo().frame(from1);

        //输入邮件内容
        driver.findElement(By.id("toAreaCtrl")).sendKeys("714104844@qq.com");
        driver.findElement(By.id("subject")).sendKeys("这是一个主题");
        driver.findElement(By.className("qmEditorBase")).sendKeys("这是一个正文");
        driver.findElement(By.xpath("//*[@id=\"AttachFrame\"]/a")).sendKeys("D:\\test.jpg");

        driver.switchTo().defaultContent();

        //点击发送按钮
        driver.findElement(By.name("sendbtn")).click();

        driver.findElement(By.xpath("//*[@id=\"SetInfo\"]/div[1]/a[3]")).click();
    }

    @Test
    public  void login() throws InterruptedException {
//        WebElement frame1 = driver.findElement(By.xpath("//*[@id=\"\"]"));
//        System.out.println("元素的类型是" + frame1);
        Thread.sleep(3000);
        driver.switchTo().frame("loginform");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"u\"]"));
        username.clear();
        username.sendKeys("714104844@qq.com");
        WebElement pwd = driver.findElement(By.xpath("//*[@id=\"p\"]"));
        pwd.clear();
        pwd.sendKeys("WANGxin@37093982");

        driver.findElement(By.id("login_button")).click();
        driver.switchTo().defaultContent();
    }
    @Test
    public  void login163() throws InterruptedException {
        driver.get("https://mail.163.com/");
        driver.findElement(By.id("switchAccountLogin")).click();
        driver.switchTo().frame("login-form");
        driver.findElement(By.name("email")).sendKeys("714104844@163.com");
        driver.findElement(By.name("password")).sendKeys("wangxin37093982");
        Thread.sleep(5000);
    }
    @AfterMethod
    public void close(){

        driver.quit();
    }
}
