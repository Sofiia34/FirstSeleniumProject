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

public class HomeWork3 {

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
    public void findElementsTask_Xpath() {


        List<WebElement> tags1 = driver.findElements(By.xpath("//meta"));
        List<WebElement> tags2 = driver.findElements(By.xpath("//link"));
        List<WebElement> tags3 = driver.findElements(By.xpath("//script"));
        List<WebElement> tags4 = driver.findElements(By.xpath("//div"));
        List<WebElement> tags5 = driver.findElements(By.xpath("//title"));
        System.out.println("TAG elements count = 5");

        WebElement id1 = driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        WebElement id2 = driver.findElement(By.xpath("//div[@id='dialog-notifications-error']"));
        WebElement id3 = driver.findElement(By.xpath("//div[@id='bar-notification']"));
        System.out.println("ID elements count = 3");

        WebElement cl1 = driver.findElement(By.xpath("//*[@class='bar-notification']"));
        WebElement cl2 = driver.findElement(By.xpath("//*[@class='close']"));
        WebElement cl3 = driver.findElement(By.xpath("//*[starts-with(@class,'master')]"));
        WebElement cl4 = driver.findElement(By.xpath("//*[contains(@class,'content')]"));
        WebElement cl5 = driver.findElement(By.xpath("//div[contains(@class,'footer')]"));
        System.out.println("CLASS elements count = 5");
    }
}
