package de.demowebshop;



import de.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {

        click(By.linkText("Register"));

        click(By.id("gender-female"));

        type(By.id("FirstName"), "Naumets");
        type(By.id("LastName"), "Sofiia");

        type(By.id("Email"), "snaumets28@gmail.com");

        type(By.id("Password"), "Sofa1412best!");
        type(By.id("ConfirmPassword"), "Sofa1412best!");

        click(By.id("register-button"));

        Assert.assertTrue(
                isElementPresent(By.cssSelector(".result")),
                "Registration was not successful"
        );
    }
}


