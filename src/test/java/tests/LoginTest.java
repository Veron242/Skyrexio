package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.*;

@Epic("Авторизация")
@Feature("Страница логина")
@Owner("Veronika")
public class LoginTest extends BaseTest {

    @Test
    @Story("Успешная авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка успешного входа с валидными данными")
    @TmsLink("TMS-001")
    public void checkLogin() {
        loginPage
                .open()
                .login(withAdminPermission());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @Test(dataProvider = "incorrectData")
    @Story("Негативная авторизация")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка отображения ошибок при вводе некорректных данных")
    @TmsLink("TMS-002")
    @Issue("BUG-001")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage
                .open()
                .login(user);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsg(), errorMessage,
                "актуальный текст не совпал с ожидаемым");
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyLogin(), "Epic sadface: Username is required"},
                {withEmptyPassword(), "Epic sadface: Password is required"},
                {withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"},
        };
    }
}
