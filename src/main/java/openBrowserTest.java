import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class openBrowserTest {


    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\Users\\Administrator\\IdeaProjects\\selenium_Dome\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void ChickTest() throws InterruptedException {
        WebElement nowslink;
        WebElement nows = driver.findElement(By.className("mnav"));
        System.out.println(nows);;
        String testurl = driver.getCurrentUrl();
        Assert.assertEquals(testurl,"http://news.baidu.com/");
        Thread.sleep(2000);

    }
    @Test
    public void getAtest(){

    }
    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
