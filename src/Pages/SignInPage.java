import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPage extends BasePage {

    private final By emailFieldLocator = By.id("ap_email_login");
    private final By continueButtonLocator = By.id("continue");
    private final By newToAmazonMessageLocator = By.xpath("//div[@id='intent-confirmation-container']/h1");
    private final By invalidEmailAlertLocator = By.id("invalid-email-alert");
    private final By emptyEmailAlertLocator = By.id("empty-claim-alert");


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        getElement(emailFieldLocator).sendKeys(email);
    }

    public void clickContinueButton() {
        getElement(continueButtonLocator).click();
    }

    public String getIntentConfirmationContainerMessage() {
        return getElement(newToAmazonMessageLocator).getText();

    }

    public String getInvalidEmailAlertMessage() {
        return getElement(invalidEmailAlertLocator).getText();
    }

    public String getEmptyEmailAlertMessage() {
        return getElement(emptyEmailAlertLocator).getText();
    }


}