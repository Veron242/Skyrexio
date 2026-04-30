package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By product = By.cssSelector(".inventory_item_name");
    private final By continueShoppingBtn = By.id("continue-shopping");
    private final By checkoutBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("checkout"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public ArrayList<String> getProductsNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingBtn));
        List<WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }
}
