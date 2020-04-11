package com.testbg;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AlertTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public  void JSTest() throws InterruptedException {
        driver.get("https://www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("这个是一个Jenkins测试");
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"1231231232\");");
        Thread.sleep(4000);
    }
    @Test
    public  void Alert01() throws InterruptedException {
        driver.get("https://classroom.edufe.com.cn/Login");
        Thread.sleep(2000);
        WebElement usernameText = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[1]/input"));
        WebElement passwordText = driver.findElement(By.xpath("/html/body/div[2]/div/form/div[2]/input"));
        usernameText.sendKeys("123456");
        passwordText.sendKeys("123456");
        WebElement login = driver.findElement(By.className("Login-submit"));
        login.click();
        Thread.sleep(2000);

        //选择alert弹框
        Alert alert = driver.switchTo().alert();
        driver.switchTo().frame("属性名称或者ID");
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.className("需要等待响应的选择定位")));
        //点击确认按钮
        alert.accept();
//        //点击取消按钮
//        alert.dismiss();
//        //获取文本内容
//        alert.getText();
//        //文本框输入内容
//        alert.sendKeys("123123");
        Thread.sleep(2000);

    }

    @Test
    public void selectTest(){
        driver.get("0");
        //定位到元素所在位置
        WebElement select1 = driver.findElement(By.xpath(""));
        //实例化下拉框
        Select select = new Select(select1);
        //通过index进行下拉选择
        select.selectByIndex(2);
        //通过value进行下拉选择
        select.selectByValue("111");
        //通过text进行下拉选择
        select.selectByVisibleText("222");
    }

    @Test
    public  void testWin(){
        //打开测试地址
        driver.get("");
        //点击链接，打开新窗口
        driver.findElement(By.xpath("")).click();
        //获取当前窗口handle
        String handle1 = driver.getWindowHandle();
        //获取到所有的handle，通过判断不是当前窗口的名称，来定位到新的窗口
        for (String handles : driver.getWindowHandles()){
            if(handles.equals(handle1)){
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }

    }

    @Test
    public void ActionText() throws InterruptedException {
        driver.get("https://www.baidu.com");
        //等位元素
        WebElement baiduButton = driver.findElement(By.id("su"));
        WebElement baiduButton1 = driver.findElement(By.id("su"));
        //实例化一个Actions
        Actions actions = new Actions(driver);
        //对应元素进行右击
        actions.contextClick(baiduButton).perform();
        //对应元素进行双击
        actions.doubleClick(baiduButton).perform();
        //鼠标移动到对应元素上
        actions.moveToElement(baiduButton).perform();
        //元素拖动到**
        actions.dragAndDropBy(baiduButton,500,500).perform();
        Thread.sleep(3000);

        //元素1拖到元素2上

        actions.clickAndHold(baiduButton).moveToElement(baiduButton1).release(baiduButton).perform();



    }
    public void moreSelctTest(){
        driver.get("");
        //将下拉框下所有元素获取出来
        List<WebElement> list = driver.findElements(By.id("元素id"));
        //实例化一个Actions
        Actions actions = new Actions(driver);
        //重复选择下拉框下的多个元素
        //使用shelt进行选择
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();

        //使用CTRL进行选择
        actions.keyDown(Keys.CONTROL).click(list.get(0)).click(list.get(1)).click(list.get(2)).keyUp(Keys.CONTROL).perform();

    }
    @Test
    public void robotTest() throws AWTException {
        driver.get("http://www.baidu.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
    }


    @AfterMethod
    public void close(){
        driver.quit();
    }
}
