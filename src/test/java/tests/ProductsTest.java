package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie",
                    "Sauce Labs Fleece Jacket");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);

        productsPage.addToCart();

        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.navigationPanel.checkCountValue(), "4");
        assertEquals(productsPage.navigationPanel.checkCountColor(), "rgba(226, 35, 26, 1)");
        productsPage.navigationPanel.goToCart();
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getTitle(), "Your Cart");
    }
}
