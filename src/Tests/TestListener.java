import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

// i copied this from the internet
public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();

        if (instance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) instance).driver;

            if (driver != null) {
                ScreenshotUtils.takeScreenshot(
                        driver,
                        result.getMethod().getMethodName()
                );
            }
        }
    }
}
