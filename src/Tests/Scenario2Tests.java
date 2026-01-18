import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Scenario2Tests extends BaseTest{
    private String quantity = "2";
    private String productPrice ;
    private String productName ;
    private String productSubtotal ;
    List<String> cartItemAttributes = new ArrayList<>();
    @Test(priority = 1,description =  "Verify items are added to cart successfully and calculated correctly")
    public void verifyItemsAddedToCartSuccessfully() {
        //reinitialize  softAssert for this test to avoid interference from other tests
        softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        // Navigate to Deals Page
        homePage.navigateToDealsPage();
        DealsPage dealsPage = new DealsPage(driver);
        // Select Category and Product as per requirement
        dealsPage.categorySelector(2);
        dealsPage.productSelector(1);
        ProductPage productPage = new ProductPage(driver);
        // Select Item Attributes and Add to Cart as per requirement
        productPage.ItemSelector(2);
        productPage.quantitySelector(Integer.parseInt(quantity));
        productName = productPage.getProductTitle();
        productPrice = productPage.getProductPrice();
        productSubtotal = String.valueOf(Integer.parseInt(productPrice) * Integer.parseInt(quantity));
        productPage.addToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.goToBasket();
        cartItemAttributes = cartPage.verifyCartItemsAttributes();
        softAssert.assertEquals(cartItemAttributes.get(0),productName,"Product name in cart does not match selected product");
        softAssert.assertEquals(cartItemAttributes.get(1),productPrice,"Product price in cart does not match selected product price");
        softAssert.assertEquals(cartItemAttributes.get(2),quantity,"Product quantity in cart does not match selected quantity");
        softAssert.assertEquals(cartItemAttributes.get(3).replaceAll(",",""),productSubtotal,"Product subtotal in cart is not calculated correctly");
        softAssert.assertAll();


    }
}
