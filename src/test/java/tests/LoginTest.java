package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static org.testng.Assert.*;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {
    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(dataProvider = "incorrectData")
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsg(), errorMessage,
                "актуальный текст не совпал с ожидаемым");
    }

    @DataProvider (name = "incorrectData")
    public Object[][] loginData(){
        return new Object[][]{
                {withLockedPermission(),"Epic sadface: Sorry, this user has been locked out."},
                {withEmptyLogin(),"Epic sadface: Username is required"},
                {withEmptyPassword(),"Epic sadface: Password is required"},
                {withIncorrectPermission(),"Epic sadface: Username and password do not match any user in this service"},
        };
    }
}
