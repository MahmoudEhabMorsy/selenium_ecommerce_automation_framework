import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {


    private final  By accountAndListsLocator = By.id("nav-link-accountList");
    private final  By signInButtonLocator = By.id("nav-flyout-ya-signin");
    private final By todayDealsLocator = By.linkText("Today's Deals");

    String baseUrl = "https://www.amazon.eg/";

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl);
    }

    public void navigateToDealsPage() {
        getElement(todayDealsLocator).click();
    }

    public void hoverToAccountAndLists() {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(accountAndListsLocator)).perform();
    }

    public void clickSignInButton() {
        getElement(signInButtonLocator).click();
    }

}