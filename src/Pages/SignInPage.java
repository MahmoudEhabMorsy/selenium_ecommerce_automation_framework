import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignInPage {

    By emailFieldLocator = By.id("ap_email_login");
    By continueButtonLocator = By.id("continue");
    By newToAmazonMessageLocator = By.xpath("//div[@id='intent-confirmation-container']/h1");
    By invalidEmailAlertLocator= By.id("invalid-email-alert");
    By emptyEmailAlertLocator= By.id("empty-claim-alert");

    private WebDriverWait wait;

    public  SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void enterEmail(String email){
        get(emailFieldLocator).sendKeys(email);
    }
    public void clickContinueButton(){
        get(continueButtonLocator).click();
    }
    public String getIntentConfirmationContainerMessage(){
        return get(newToAmazonMessageLocator).getText();

    }
    public String getInvalidEmailAlertMessage(){
        return get(invalidEmailAlertLocator).getText();
    }

    public String getEmptyEmailAlertMessage(){
        return get(emptyEmailAlertLocator).getText();
    }

    private WebElement get(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}