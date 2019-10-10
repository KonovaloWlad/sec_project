package mytest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;


import java.util.Random;

public class mytest {
    public WebDriver driver;
    public WebDriverWait wait;
    @Before
    public void setUp(){
        // driver.manage().window().setSize(new Dimension(100,100));
        //System.setProperty("webdriver.chrome.driver","D:\\webdriverchrome\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","D:\\geckodriver\\geckodriver.exe");
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 20);
        System.out.println("test started");
    }
    @After
    public void close(){
        driver.quit();
        System.out.println("test closed");
    }
    @Test
    public void firsttest() throws InterruptedException {
        driver.get("https://eu3.piratestorm.com/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Pirate Storm | Экшен-игра про пиратов"));
        int a = 0;
        while ( a < 3 ){
            a++;
            Random random = new Random();
            int n = random.nextInt(500) + 100;
            String login = "Vfdgxdstdz" + n;
            String mail = "VldEx" + n + "@mail.ru";

            driver.findElement(By.id("bgc_signup_form_username")).sendKeys(login);
            System.out.println("login");
            driver.findElement(By.id("bgc_signup_form_password")).sendKeys("qweqazxswedc");
            System.out.println("password");
            driver.findElement(By.id("bgc_signup_form_email")).sendKeys(mail);
            System.out.println("mail");
            driver.findElement(By.id("bgc_signup_form_termsAndConditions")).click();
            driver.findElement(By.id("bigActionButtonContainer")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fancybox-close"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-details")));
            WebElement div = driver.findElement(By.id("buttonContainer"));
            div.findElement(By.cssSelector("[href=\"index.php?controller=user&action=logout\"]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class=\"logoutBoxLeft\"]"))).click();
            Thread.sleep(5000);
            System.out.println("Test Passed");
        }
    }

}

