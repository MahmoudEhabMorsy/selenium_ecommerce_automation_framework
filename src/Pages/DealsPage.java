import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DealsPage extends BasePage {


    private final By categorySeeMoreButtonLocator = By.xpath("//button[@aria-labelledby='see-more-departments-label']");
    private final By categoryLocator = By.xpath("//div[@role='radiogroup' and @aria-labelledby='departments']/span");
    private final By productsLocator = By.xpath("//div[@data-test-index]");
    private String pageTitle;

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public void categorySelector(int index) {
        clickOnSeeMore();
        List<WebElement> categories = getElements(categoryLocator);
        // added to handle if chosen category is not available
        if (categories.size() < index) {
            System.out.println("Index out of bounds Selecting the last category instead");
            index = categories.size();
        }
        categories.get(index - 1).click();


    }

    public void productSelector(int index) {
        // old code commented out because it was enhanced to handle more scenarios
        /*By productsLocator = By.xpath("//div[@data-test-index='" + index + "']");
        getElement(productsLocator).click();*/

        //added wait to ensure products are loaded because selenium was faster than the page loading
        wait.until(driver -> {
            int size = driver.findElements(productsLocator).size();
            return size > 0 && size < 90;
        });
        List<WebElement> products = getElements(productsLocator);
        pageTitle = driver.getTitle();
        // added to handle if no products are available
        if (products.isEmpty()) {
            System.out.println("No products found for selection skipping product selection");
            return;
        }
        // added to handle if chosen product is not available
        if (products.size() < index) {
            System.out.println("Index out of bounds Selecting the last product instead");
            index = products.size();
        }
        products.get(index - 1).click();
        // wait until page title changes to ensure navigation is complete and because it caused issues for the next steps
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(pageTitle)));

    }

    private void clickOnSeeMore() {
        getElement(categorySeeMoreButtonLocator).click();
    }


}
