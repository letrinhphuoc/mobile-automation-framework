package phuoclet.test.pages.ios;

import com.google.inject.Inject;
import phuoclet.core.annotation.FindElement;
import phuoclet.core.driver.DriverManager;
import phuoclet.core.element.BaseElement;
import phuoclet.core.element.LocatorType;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import phuoclet.test.pages.abstractpages.ContactDetailPage;

public class IosContactDetailPage extends ContactDetailPage {

    @Inject
    public IosContactDetailPage(DriverManager manager) {
        AppiumDriver<WebElement> driver = manager.getDriver();
        initElement(driver);
    }

    @FindElement(type = LocatorType.XPATH, value = "//XCUIElementTypeApplication[@name=\"Contacts\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]")
    private BaseElement contactName;

    @Override
    public String getContactName() {
        return contactName.getText();
    }

}
