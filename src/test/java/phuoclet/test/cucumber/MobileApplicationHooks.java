package phuoclet.test.cucumber;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import phuoclet.core.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

@Singleton
public class MobileApplicationHooks {

    @Inject
    private Injector injector;

    private AppiumDriver<WebElement> driver;
    private DriverManager manager;

    public void start() {
        manager = injector.getInstance(DriverManager.class);
        driver = manager.getDriver();
    }

    public void quit() {
        driver.quit();
    }

    public byte[] takeScreenshotMobile(String image) {
        byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        File destFile = new File(image);
//        try {
//            FileUtils.copyFile(srcFile, destFile);
//        } catch (IOException e) {
//            throw new TakeScreenshotException("There's a problem during take screenshot", e.getCause());
//        }
        return srcFile;
    }
}
