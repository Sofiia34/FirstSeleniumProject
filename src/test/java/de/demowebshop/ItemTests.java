package de.demowebshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ItemTests extends TestBase {

    @Test
    public void addItemToCartTest() {

        login("snaumets28@gmail.com", "Sofa1412best!");

        clearCartIfNotEmpty();

        driver.get("https://demowebshop.tricentis.com/");


        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
        Assert.assertTrue(products.size() >= 2, "На сторінці менше 2 товарів");

        WebElement secondProduct = products.get(1);

        String expectedName = secondProduct
                .findElement(By.cssSelector(".product-title a"))
                .getText()
                .trim();

        Assert.assertFalse(expectedName.isEmpty(), "Не зчиталась назва 2-го товару");


        secondProduct
                .findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button"))
                .click();


        closeBarIfPresent();


        clickWhenClickable(By.cssSelector("a.ico-cart"), 10);


        Assert.assertTrue(isElementPresent(By.cssSelector("table.cart")), "Cart page was not opened");

        List<WebElement> cartNames = driver.findElements(By.cssSelector(".cart-item-row .product-name"));

        boolean found = false;
        for (WebElement nameEl : cartNames) {
            String actualName = nameEl.getText().trim();

            if (actualName.contains(expectedName)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found, "У кошику немає товару з назвою: " + expectedName);
    }
}

