package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Корзина")
@Feature("Страница корзины")
@Owner("Veronika")
public class CartTest extends BaseTest{
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";
    @Test
    @Story("Товар добавлен в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка что добавленный товар отображается в корзине")
    @TmsLink("TMS-004")
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.goToCart();

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(),1);
        assertTrue(cartPage.getProductsNames().contains(goodsName));
    }
}
