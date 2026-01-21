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

public class FindElementTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app/search");

        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void findElementByTagName() {

        WebElement title = driver.findElement(By.tagName("h1"));
        System.out.println(title.getText());

        WebElement title2 = driver.findElement(By.tagName("h2"));
        System.out.println(title2.getText());

        WebElement link = driver.findElement(By.tagName("a"));
        System.out.println(link.getText());
        System.out.println(link.getAttribute("class"));


        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println(labels.size());
    }

    @Test
    public void findElementById() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));

        WebElement dates = driver.findElement(By.id("dates"));
        System.out.println(dates.getAttribute("id"));
    }

    @Test
    public void findElementByClassName() {

        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());

        WebElement container = driver.findElement(By.className("input-container"));
        System.out.println(container.getDomAttribute("class"));
    }

    @Test
    public void findElementByLinkText() {
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        WebElement linkText2 = driver.findElement(By.linkText("Los Angeles"));
        System.out.println(linkText2.getText());
    }

    @Test
    public void findElementPartialLinkText() {
        WebElement partialText = driver.findElement(By.partialLinkText("car work"));
        System.out.println(partialText.getText());

    }

    @Test
    public void findElementByCssSelector() {

        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("h2"));


        driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.cssSelector("#dates"));


        driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.cssSelector(".input-container"));

        driver.findElement(By.cssSelector("[href='/search']"));
        driver.findElement(By.cssSelector("[for='city']"));

        driver.findElement(By.cssSelector("[class*='cities']"));

        driver.findElement(By.cssSelector("[class^='top']"));

        driver.findElement(By.cssSelector("[class$='container']"));

        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));

        driver.findElement(By.cssSelector(".logo>img"));

        driver.findElement(By.cssSelector(".feedback-body .feedback-date"));


        WebElement feedback = driver.findElement(By.cssSelector(".feedback:nth-child(1)"));
        System.out.println(feedback.getText());
        WebElement logIN = driver.findElement(By.cssSelector(".navigation-link:nth-child(6)"));
        System.out.println(logIN.getText());
    }
    @Test
    public void findElementByXpath() {
        //    //tag[@attribute='value']
        //   //tag[1]
        //  //tag[@attr='value1' and @attr='value2']
        //  //tag[text()='Text']
        //   //tag[contains(text(),'Partial text')]

        driver.findElement(By.xpath("//h1"));
        driver.findElement(By.xpath("//h2"));

        driver.findElement(By.xpath("//input[@id='city']"));
        driver.findElement(By.xpath("//input[@id='dates']"));

        driver.findElement(By.xpath("//a[@class='telephone']"));
        driver.findElement(By.xpath("//div[@class='input-container']"));

        driver.findElement(By.xpath("//a[@href='/search']"));
        driver.findElement(By.xpath("//label[@for='city']"));

        driver.findElement(By.xpath("//*[starts-with(@class,'top')]"));

        driver.findElement(By.xpath("//*[contains(@class,'cities')]"));

        driver.findElement(By.xpath("//*[contains(.,'Our car was modern')]"));

        driver.findElement(By.xpath("//span[.=' Latest feedback from our customers ']"));

        driver.findElement(By.xpath("//a[@class='navigation-link' and @href='/search']"));

        driver.findElement(By.xpath("//a[@class='logo']/img"));

        driver.findElement(By.xpath("//div[@class='feedback-body']//span[@class='feedback-date']"));
    }

    @Test
    public void findElementByXpathFamily() {

        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));

        driver.findElement(By.xpath("//h1/ancestor::*"));
        driver.findElement(By.xpath("//h1/ancestor::div"));
        driver.findElement(By.xpath("//h1/ancestor::div[1]"));

        driver.findElement(By.xpath("//h1/following-sibling::h2"));

        driver.findElement(By.xpath("//h2/preceding-sibling::h1"));
    }

}



