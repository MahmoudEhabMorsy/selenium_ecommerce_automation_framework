import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {

   private final By quantityDropdownLocator = By.id("selectQuantity");
    private final By quantityOptionLocator = By.xpath("//ul[@class='a-nostyle a-list-link']/li");
  private final By addToCartButtonLocator = By.id("add-to-cart-button");
    private final By itemsLocator = By.xpath("//li[@data-idxintoggleswatchlist]");
    private final  By productTitleLocator = By.id("productTitle");
    private final By productPriceLocator = By.xpath("//div[@id='corePrice_feature_div']//span[@class='a-price-whole']");
    private String currentUrl;
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void ItemSelector(int index){
        // old code commented out because it was enhanced to handle more scenarios
        /*
        By ItemLocator = By.xpath("//li[@data-idxintoggleswatchlist='" + index + "']");
        getElement(styleItemLocator).click();
         */
        currentUrl = driver.getCurrentUrl();
        //didnot use getElements because I wanted to handle the case of no items found
        List<WebElement> items = driver.findElements(itemsLocator);
        // added to handle if no items are available
        if(items.isEmpty()){
            System.out.println("No items found for selection skipping item selection");
            return;
        }
        // added to handle if chosen item is not available
        if(items.size() < index){
            System.out.println("Index out of bounds Selecting the last item instead");
            index = items.size();
        }
        items.get(index-1).click();
        // wait until url changes to ensure navigation is complete and because it caused issues for the next steps
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));


    }
    public void quantitySelector(int quantity){
        // didnot use getElements because I wanted to handle the case of no quantity dropdown found
        if(driver.findElements(quantityDropdownLocator).isEmpty()){
            System.out.println("Quantity dropdown not found skipping quantity selection");
            return;
        }
        getElement(quantityDropdownLocator).click();
        List<WebElement> quantityList = getElements(quantityOptionLocator);
        // added to handle if chosen quantity is not available
        if(quantityList.size() < quantity){
            System.out.println("Quantity out of bounds Selecting the maximum available quantity instead");
            quantity = quantityList.size();
        }
        quantityList.get(quantity - 1).click();
    }
    public void addToCart(){
        // didnot use getElements because I wanted to handle the case of no add to cart button found
        if(driver.findElements(addToCartButtonLocator).isEmpty()){
            System.out.println("Add to cart button not found item out of stock");
            return;
        }
        getElement(addToCartButtonLocator).click();
    }
    public String getProductTitle(){
        return getElement(productTitleLocator).getText();
    }
    public String getProductPrice(){
        return getElement(productPriceLocator).getText().replaceAll(",","");
    }

}
