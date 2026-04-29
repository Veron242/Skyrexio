package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By firstNameField  = By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastNameField   = By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCodeField = By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By continueBtn     = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));
    private final By finishBtn       = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));
    private final By pageTitle       = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By totalPrice      = By.cssSelector(DATA_TEST_PATTERN.formatted("total-label"));
    private final By completeHeader  = By.cssSelector(DATA_TEST_PATTERN.formatted("complete-header"));

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(postalCode);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public String getTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText();
    }

    public String getCompleteHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
    }
}
