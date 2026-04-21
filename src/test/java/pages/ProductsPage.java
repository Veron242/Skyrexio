package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']" +
                    "//ancestor::div[@class='inventory_item']" +
                    "//child::button[text()='Add to cart']";

    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addToCart() {
       driver.findElements(addToCartBtn).get(2).click();
    }

    public void addToCart(final String goodsName) {
       By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));

        driver.findElement(addToCart).click();
    }

    public boolean pageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public String checkCountValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCountColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
