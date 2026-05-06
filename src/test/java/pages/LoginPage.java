package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public LoginPage open() {
        driver.get(BASE_URL);

        return this;
    }

    @Step("Открыть страницу: {url}")
    public void open(final String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Войти как {user.login}")
    public LoginPage login(User user) {
    driver.findElement(userField).sendKeys(user.getLogin());
    driver.findElement(passwordField).sendKeys(user.getPassword());
    driver.findElement(submitButton).click();

    return this;
    }

    @Step("Проверить отображение ошибки")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    @Step("Получить текст ошибки")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
