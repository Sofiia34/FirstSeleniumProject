package de.ait.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWork2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementsTask() {

        List<WebElement> tags1 = driver.findElements(By.cssSelector("meta"));
        List<WebElement> tags2 = driver.findElements(By.cssSelector("link"));
        List<WebElement> tags3 = driver.findElements(By.cssSelector("script"));
        List<WebElement> tags4 = driver.findElements(By.cssSelector("div"));
        List<WebElement> tags5 = driver.findElements(By.cssSelector("title"));
        System.out.println("TAG elements count = 5");

        WebElement id1 = driver.findElement(By.cssSelector("#dialog-notifications-success"));
        WebElement id2 = driver.findElement(By.cssSelector("[id='dialog-notifications-error']"));
        WebElement id3 = driver.findElement(By.cssSelector("div#bar-notification"));
        System.out.println("ID elements count = 3");

        WebElement cl1 = driver.findElement(By.cssSelector(".bar-notification"));
        WebElement cl2 = driver.findElement(By.cssSelector("[class='close']"));
        WebElement cl3 = driver.findElement(By.cssSelector("[class^='master']"));
        WebElement cl4 = driver.findElement(By.cssSelector("[class*='content']"));
        WebElement cl5 = driver.findElement(By.cssSelector("div.footer"));
        System.out.println("CLASS elements count = 5");
    }
}

