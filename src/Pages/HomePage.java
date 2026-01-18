import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {


    private final By accountAndListsLocator = By.id("nav-link-accountList");
    private final By signInButtonLocator = By.id("nav-flyout-ya-signin");
    private final By todayDealsLocator = By.linkText("Today's Deals");
    private final By yourOrdersLocator = By.id("nav_prefetch_yourorders");
    private final By yourAddressLocator = By.id("nav_prefetch_youraddresses");
    //why I used normalize-space(.) is to avoid issues with extra spaces in the text and the '.' to access the child text node of the <a> element
    private final By yourListsLocator = By.xpath("//a[normalize-space(.)='Your Lists']");

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

    public void clickYourOrders() {
        getElement(yourOrdersLocator).click();
    }

    public void clickYourAddress() {
        getElement(yourAddressLocator).click();
    }

    public void clickYourLists() {
        getElement(yourListsLocator).click();
    }


}