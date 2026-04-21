package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BasePage.BASE_URL);
    }

    public void open (final String url) {
        driver.get(BasePage.BASE_URL + url);
    }

    public void login(String login, String password) {
    driver.findElement(userField).sendKeys(login);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(submitButton).click();
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
