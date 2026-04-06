import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void checkLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        String title = driver.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(title, "Products");
    }

    @Test
    public void checkIncorrectLogin() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("[id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        assertTrue(isErrorMsgDisplayed, "The error message fails to appear");
        String errorText  = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(errorText,"Epic sadface: Sorry, this user has been locked out.", errorText);
    }

}
