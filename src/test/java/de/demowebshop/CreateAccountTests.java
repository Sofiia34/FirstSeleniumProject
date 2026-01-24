package de.demowebshop;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        openRegistrationForm();
        fillRegistrationFormFemale("Naumets", "Sofiia", generateUniqueEmail(), "Sofa1412best!");
        submitRegistration();

        Assert.assertTrue(isLogoutPresent(), "Registration was not successful");
    }

    // ---------- helpers ----------

    private void openRegistrationForm() {
        click(By.linkText("Register"));
    }

    private void fillRegistrationFormFemale(String firstName, String lastName, String email, String password) {
        click(By.id("gender-female"));
        type(By.id("FirstName"), firstName);
        type(By.id("LastName"), lastName);
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        type(By.id("ConfirmPassword"), password);
    }

    private void submitRegistration() {
        click(By.id("register-button"));
    }

    private boolean isLogoutPresent() {
        return isElementPresent(By.linkText("Log out"));
    }

    private String generateUniqueEmail() {
        return "snaumets28+" + System.currentTimeMillis() + "@gmail.com";
    }
}