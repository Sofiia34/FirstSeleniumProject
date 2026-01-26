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
        Assert.assertTrue(products.size() >= 2, "Less than 2 products found on the page");

        WebElement secondProduct = products.get(1);
        WebElement productLink = secondProduct.findElement(By.cssSelector(".product-title a"));
        String expectedHref = productLink.getAttribute("href");
        Assert.assertNotNull(expectedHref, "Product href is null");
        Assert.assertFalse(expectedHref.trim().isEmpty(), "Product href is empty");

        secondProduct.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button")).click();
        closeBarIfPresent();
        clickWhenClickable(By.cssSelector("a.ico-cart"), 10);
        Assert.assertTrue(isElementPresent(By.cssSelector("table.cart")), "Cart page was not opened");

        List<WebElement> cartLinks = driver.findElements(By.cssSelector("tr.cart-item-row a.product-name"));
        Assert.assertTrue(cartLinks.size() > 0, "No items found in the cart (cart-item-row is empty)");

        boolean found = false;
        for (WebElement link : cartLinks) {
            String actualHref = link.getAttribute("href");
            if (expectedHref.equals(actualHref)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found, "Product with href was not found in the cart: " + expectedHref);
    }
}



