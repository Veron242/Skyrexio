package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static enums.TitleNaming.CART;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

@Epic("Каталог товаров")
@Feature("Страница товаров")
@Owner("Veronika")
public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie",
                    "Sauce Labs Fleece Jacket");

    @Test
    @Story("Добавление товаров в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка что несколько товаров корректно добавляются в корзину")
    @TmsLink("TMS-003")
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
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
        assertEquals(productsPage.getTitle(), CART.getDisplayName());
    }
}
