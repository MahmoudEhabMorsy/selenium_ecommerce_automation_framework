import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AccountAccessTests extends BaseTest {
    @Test(priority = 1, description = "verify that user cannot see 'your orders' page without signing in")
    public void verifyUserCannotSeeYourOrdersWithoutSigningIn() {
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        // Hover to Account & Lists
        homePage.hoverToAccountAndLists();
        homePage.clickYourOrders();
        //used current url instead of title because title is not always consistent and used regex to account for different possible formats of sign-in page url
        softAssert.assertTrue(driver.getCurrentUrl().matches("(?i).*sign[-_]?in.*"), "User is unable to access 'Your Orders' page without signing in");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "verify that user cannot see 'your addresses' page without signing in")
    public void verifyUserCannotSeeYourAddressesWithoutSigningIn() {
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        // Hover to Account & Lists
        homePage.hoverToAccountAndLists();
        homePage.clickYourAddress();
        //used current url instead of title because title is not always consistent and used regex to account for different possible formats of sign-in page url
        softAssert.assertTrue(driver.getCurrentUrl().matches("(?i).*sign[-_]?in.*"), "User is unable to access 'Your Addresses' page without signing in");
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "verify that user can see 'your lists' page without signing in")
    public void verifyUserCanSeeYourListsWithoutSigningIn() {
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        // Hover to Account & Lists
        homePage.hoverToAccountAndLists();
        homePage.clickYourLists();
        //used title here because 'Your Lists' page title always contains the word 'List' in what I tested at least
        softAssert.assertTrue(driver.getTitle().toLowerCase().contains("list"), "User is able to access 'Your Lists' page without signing in");
        softAssert.assertAll();
    }

}
