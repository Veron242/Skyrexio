package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertTrue(productsPage.pageTitleDisplayed());
        productsPage.addToCart();
        assertEquals(productsPage.checkCountValue(), "1");
        assertEquals(productsPage.checkCountColor(), "rgba(226, 35, 26, 1)");
        productsPage.goToCart();
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getTitle(), "Your Cart");
    }
}
