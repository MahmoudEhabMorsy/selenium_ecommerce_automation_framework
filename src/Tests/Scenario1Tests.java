import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Scenario1Tests extends BaseTest {
    String validUnregisteredEmail = "unregistered_email_test@gmail.com";
    String invalidEmail = "invalid_email";

    @Test(priority = 1, description = "Verify sign in with valid unregistered email shows appropriate message")
    public void testSignInWithValidUnregisteredEmail() {
        //reinitialize  softAssert for this test to avoid interference from other tests
        softAssert = new SoftAssert();
        // Navigate to Home Page
        HomePage homePage = new HomePage(driver);
        // Hover over Account & Lists and click Sign In
        homePage.hoverToAccountAndLists();
        homePage.clickSignInButton();
        // On Sign In Page enter a valid unregistered email and click Continue as per requirement
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmail(validUnregisteredEmail);
        signInPage.clickContinueButton();
        softAssert.assertEquals(signInPage.getIntentConfirmationContainerMessage().trim(), "Looks like you're new to Amazon");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Verify sign in with invalid email shows appropriate error message")
    public void testSignInWithInvalidEmail() {
        //reinitialize  softAssert for this test to avoid interference from other tests
        softAssert = new SoftAssert();
        // Navigate to Home Page
        HomePage homePage = new HomePage(driver);
        // Hover over Account & Lists and click Sign In
        homePage.hoverToAccountAndLists();
        homePage.clickSignInButton();
        // On Sign In Page enter an invalid email and click Continue
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmail(invalidEmail);
        signInPage.clickContinueButton();
        softAssert.assertEquals(signInPage.getInvalidEmailAlertMessage().trim(), "Invalid email address");
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Verify sign in with empty email")
    public void testSignInWithEmptyEmail() {
        //reinitialize  softAssert for this test to avoid interference from other tests
        softAssert = new SoftAssert();
        // Navigate to Home Page
        HomePage homePage = new HomePage(driver);
        // Hover over Account & Lists and click Sign In
        homePage.hoverToAccountAndLists();
        homePage.clickSignInButton();
        // On Sign In Page leave email field empty and click Continue
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmail("");
        signInPage.clickContinueButton();
        softAssert.assertEquals(signInPage.getEmptyEmailAlertMessage().trim(), "Enter your mobile number or email");
        softAssert.assertAll();
    }


}