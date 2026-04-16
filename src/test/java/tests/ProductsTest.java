package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie",
                    "Sauce Labs Fleece Jacket");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertTrue(productsPage.pageTitleDisplayed());
        productsPage.addToCart();

        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.checkCountValue(), "4");
        assertEquals(productsPage.checkCountColor(), "rgba(226, 35, 26, 1)");
        productsPage.goToCart();
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getTitle(), "Your Cart");
    }
}
