package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class CheckoutTest extends BaseTest {
    private static final List<String> GOODS_LIST = List.of(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket"
    );
    private static final String FIRST_NAME = "Veronika";
    private static final String LAST_NAME  = "Konstantinova";
    private static final String POSTAL     = "180000";

    @Test
    public void checkSuccessfulCheckout() {
        loginPage.open();
        loginPage.login(withAdminPermission());

        for (String goods : GOODS_LIST) {
            productsPage.addToCart(goods);
        }
        productsPage.navigationPanel.goToCart();

        cartPage.proceedToCheckout();

        checkoutPage.fillForm(FIRST_NAME, LAST_NAME, POSTAL);
        checkoutPage.clickContinue();
        assertEquals(checkoutPage.getTitle(), "Checkout: Overview");
        assertEquals(checkoutPage.getTotalPrice(), "Total: $79.89");

        checkoutPage.clickFinish();
        assertEquals(checkoutPage.getTitle(), "Checkout: Complete!");
        assertEquals(checkoutPage.getCompleteHeader(), "Thank you for your order!");
    }
}
