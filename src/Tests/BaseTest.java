import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize SoftAssert used soft assertion instead of hard assertion because it allows multiple assertions to be collected and reported together at the end of the test
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
