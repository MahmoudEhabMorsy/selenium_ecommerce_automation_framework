import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By basketLocator = By.id("sw-gtc");
    private final By cartItemLocator = By.xpath("//ul[@aria-labelledby='sc-active-items-header']//div[@data-itemtype='active']");
    private final By cartSubtotalLocator = By.id("sc-subtotal-amount-activecart");
    private final By cartItemNameLocator = By.xpath(".//span[@class='a-truncate-full a-offscreen']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToBasket(){
        getElement(basketLocator).click();
    }

    public List<String> verifyCartItemsAttributes(){
        WebElement cartItem = getElement(cartItemLocator);
        String cartPrice = cartItem.getAttribute("data-price");
        String cartQuantity = cartItem.getAttribute("data-quantity");
        // Extract numeric value from subtotal text and remove any non-numeric characters
        String cartSubtotal = getElement(cartSubtotalLocator).getText().replaceAll("[^0-9.]","");
        // Convert subtotal to integer string
        cartSubtotal = String.valueOf((int)Double.parseDouble(cartSubtotal));
        String cartItemName = cartItem.findElement(cartItemNameLocator).getAttribute("textContent");
        return  List.of(cartItemName,cartPrice,cartQuantity,cartSubtotal);
    }


}
