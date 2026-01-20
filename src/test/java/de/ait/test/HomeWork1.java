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

public class HomeWork1 {

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


        List<WebElement> tags1 = driver.findElements(By.tagName("meta"));
        List<WebElement> tags2 = driver.findElements(By.tagName("link"));
        List<WebElement> tags3 = driver.findElements(By.tagName("script"));
        List<WebElement> tags4 = driver.findElements(By.tagName("div"));
        List<WebElement> tags5 = driver.findElements(By.tagName("title"));
        System.out.println("TAG elements count = 5");

        WebElement id1 = driver.findElement(By.id("dialog-notifications-success"));
        WebElement id2 = driver.findElement(By.id("dialog-notifications-error"));
        WebElement id3 = driver.findElement(By.id("bar-notification"));
        System.out.println("ID elements count = 3");

        WebElement cl1 = driver.findElement(By.className("bar-notification"));
        WebElement cl2 = driver.findElement(By.className("close"));
        WebElement cl3 = driver.findElement(By.className("master-wrapper-page"));
        WebElement cl4 = driver.findElement(By.className("master-wrapper-content"));
        WebElement cl5 = driver.findElement(By.className("footer"));
        System.out.println("CLASS elements count = 5");
    }
}


