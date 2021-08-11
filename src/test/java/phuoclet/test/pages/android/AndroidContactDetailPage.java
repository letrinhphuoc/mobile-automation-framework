package phuoclet.test.pages.android;

import com.google.inject.Inject;
import phuoclet.core.annotation.FindElement;
import phuoclet.core.driver.DriverManager;
import phuoclet.core.element.BaseElement;
import phuoclet.core.element.LocatorType;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import phuoclet.test.pages.abstractpages.ContactDetailPage;

public class AndroidContactDetailPage extends ContactDetailPage {

    @Inject
    public AndroidContactDetailPage(DriverManager manager)  {
        AppiumDriver<WebElement> driver = manager.getDriver();
        initElement(driver);
    }

    @FindElement(type = LocatorType.ID, value = "detail_name")
    private BaseElement contactName;

    @Override
    public String getContactName() {
        return contactName.getText();
    }

}
