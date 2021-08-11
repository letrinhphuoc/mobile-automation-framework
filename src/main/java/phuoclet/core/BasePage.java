package phuoclet.core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void initElement(AppiumDriver<WebElement> driver)  {
        ElementFactory.initElements(driver, this);
    }

}
