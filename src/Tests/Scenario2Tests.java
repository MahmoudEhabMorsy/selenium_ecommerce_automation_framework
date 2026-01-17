import org.testng.annotations.Test;

public class Scenario2Tests extends BaseTest{

    @Test(priority = 1,description =  "Verify items are added to cart successfully and calculated correctly")
    public void verifyItemsAddedToCartSuccessfully() {
        HomePage homePage = new HomePage(driver);
        // Navigate to Deals Page
        homePage.navigateToDealsPage();
    }
}
