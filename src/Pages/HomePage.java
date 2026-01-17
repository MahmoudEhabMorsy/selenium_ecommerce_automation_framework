import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;

    By accountAndListsLocator = By.id("nav-link-accountList");
    By signInButtonLocator = By.id("nav-flyout-ya-signin");
    By todayDealsLocator = By.linkText("Today's Deals");

    String baseUrl = "https://www.amazon.eg/";

    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    public void navigateToDealsPage() {
        get(todayDealsLocator).click();
    }

    public void hoverToAccountAndLists() {
        Actions actions = new Actions(driver);
        actions.moveToElement(get(accountAndListsLocator)).perform();
    }

    public void clickSignInButton() {
        get(signInButtonLocator).click();
    }
    private WebElement get(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}