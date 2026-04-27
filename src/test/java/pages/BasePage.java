package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertyReader;


public class BasePage {
    public static final String BASE_URL = PropertyReader.getProperty("skyrexio.url");
    public static final String DATA_TEST_PATTERN = "[data-test='%s']";

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
