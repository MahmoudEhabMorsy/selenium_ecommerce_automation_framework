package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// i copied this from the internet
public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            // Create screenshots directory if it doesn't exist
            File screenshotsDir = new File("Failure screenshots");
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }

            // Format timestamp
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Screenshot file name
            File screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destination = new File(
                    screenshotsDir,
                    testName + "_" + timestamp + ".png"
            );

            Files.copy(screenshot.toPath(), destination.toPath());

            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
