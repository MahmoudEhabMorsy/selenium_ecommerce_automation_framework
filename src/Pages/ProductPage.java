import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    private final By quantityDropdownLocator = By.id("selectQuantity");
    private final By quantityOptionLocator = By.xpath("//ul[@class='a-nostyle a-list-link']/li");
    private final By addToCartButtonLocator = By.id("add-to-cart-button");
    private final By itemsLocator = By.xpath("//li[@data-idxintoggleswatchlist]");
    private final By productTitleLocator = By.id("productTitle");
    private final By productPriceWholeLocator = By.xpath("//div[@id='corePrice_feature_div']//span[@class='a-price-whole']");
    private final By productPriceFractionLocator = By.xpath("//div[@id='corePrice_feature_div']//span[@class='a-price-fraction']");
    private String currentUrl;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void ItemSelector(int index) throws InterruptedException {
        // old code commented out because it was enhanced to handle more scenarios
        /*
        By ItemLocator = By.xpath("//li[@data-idxintoggleswatchlist='" + index + "']");
        getElement(styleItemLocator).click();
         */
        currentUrl = driver.getCurrentUrl();
        //didnot use getElements because I wanted to handle the case of no items found
        List<WebElement> items = driver.findElements(itemsLocator);
        // added to handle if no items are available
        if (items.isEmpty()) {
            System.out.println("No items found for selection skipping item selection");
            return;
        }
        // added to handle if chosen item is not available
        if (items.size() < index) {
            System.out.println("Index out of bounds Selecting the last item instead");
            index = items.size();
        }
        items.get(index - 1).click();
        // added sleep to allow time for the page to update after item selection settled on this rather than using explicit wait because it was causing issues in some cases
        Thread.sleep(1000);

        //old code commented out because it was causing issues in some cases
        /*
        // added to handle the case where the selected item is the same as the current one causing no url change
        if(currentUrl.equals(driver.getCurrentUrl())) {
            System.out.println("URL did not change after item selection because the selected item is the same as the current one");
            return;
        }else{
            // wait until url changes to ensure navigation is complete and because it caused issues for the next steps
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(currentUrl)));
        }
        */

    }
    // made quantitySelector return the actual selected quantity to handle cases where the requested quantity is not available or there is no quantity dropdown
    public String quantitySelector(int quantity) {
        // didnot use getElements because I wanted to handle the case of no quantity dropdown found
        if (driver.findElements(quantityDropdownLocator).isEmpty()) {
            System.out.println("Quantity dropdown not found skipping quantity selection");
            return "1";
        }
        getElement(quantityDropdownLocator).click();
        List<WebElement> quantityList = getElements(quantityOptionLocator);
        // added to handle if chosen quantity is not available
        if (quantityList.size() < quantity) {
            System.out.println("Quantity out of bounds Selecting the maximum available quantity instead");
            quantity = quantityList.size();
        }
        quantityList.get(quantity - 1).click();
        return String.valueOf(quantity);
    }

    public void addToCart() {
        // didnot use getElements because I wanted to handle the case of no add to cart button found
        if (driver.findElements(addToCartButtonLocator).isEmpty()) {
            System.out.println("Add to cart button not found item out of stock");
            return;
        }
        getElement(addToCartButtonLocator).click();
    }

    public String getProductTitle() {
        return getElement(productTitleLocator).getText();
    }

    public String getProductPrice() {
        return getElement(productPriceWholeLocator).getText().replaceAll(",", "")+
                "."+
                getElement(productPriceFractionLocator).getText();
    }

}
