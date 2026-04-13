package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
