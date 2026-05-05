package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static enums.TitleNaming.CHECKOUTS;
import static enums.TitleNaming.CHECKOUT_COMPLETE;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Оформление заказа")
@Feature("Страница checkout")
@Owner("Veronika")
public class CheckoutTest extends BaseTest {
    private static final List<String> GOODS_LIST = List.of(
            "Test.allTheThings() T-Shirt (Red)",
            "Sauce Labs Onesie",
            "Sauce Labs Fleece Jacket"
    );
    private static final String FIRST_NAME = "Veronika";
    private static final String LAST_NAME = "Konstantinova";
    private static final String POSTAL = "180000";

    @Test
    @Story("Успешное оформление заказа")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка успешного прохождения всех шагов оформления заказа")
    @TmsLink("TMS-005")
    public void checkSuccessfulCheckout() {
        loginPage
                .open()
                .login(withAdminPermission());

        for (String goods : GOODS_LIST) {
            productsPage.addToCart(goods);
        }
        productsPage.navigationPanel.goToCart();

        cartPage.proceedToCheckout();

        checkoutPage
                .fillForm(FIRST_NAME, LAST_NAME, POSTAL)
                .clickContinue();
        assertEquals(checkoutPage.getTitle(), CHECKOUTS.getDisplayName());
        assertEquals(checkoutPage.getTotalPrice(), "Total: $79.89");

        checkoutPage.clickFinish();
        assertEquals(checkoutPage.getTitle(), CHECKOUT_COMPLETE.getDisplayName());
        assertEquals(checkoutPage.getCompleteHeader(), "Thank you for your order!");
    }
}
