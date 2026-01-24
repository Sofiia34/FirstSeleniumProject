package de.demowebshop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public void clickWhenClickable(By locator, int seconds) {
        wait(seconds).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitUntilInvisible(By locator, int seconds) {
        wait(seconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


    public void login(String email, String password) {
        click(By.linkText("Log in"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.login-button"));
        Assert.assertTrue(isElementPresent(By.linkText("Log out")), "Login failed");
    }


    public void closeBarIfPresent() {
        By bar = By.id("bar-notification");
        By close = By.cssSelector("#bar-notification .close");

        if (isElementPresent(bar)) {
            if (isElementPresent(close)) {
                clickWhenClickable(close, 10);
            }
            waitUntilInvisible(bar, 10);
        }
    }


    public void clearCartIfNotEmpty() {
        driver.get("https://demowebshop.tricentis.com/cart");


        if (isElementPresent(By.name("removefromcart"))) {
            List<WebElement> removeCheckboxes = driver.findElements(By.name("removefromcart"));
            for (WebElement cb : removeCheckboxes) {
                if (!cb.isSelected()) {
                    cb.click();
                }
            }
            click(By.name("updatecart"));


            wait(10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cart-item-row")));
        }
    }
}

