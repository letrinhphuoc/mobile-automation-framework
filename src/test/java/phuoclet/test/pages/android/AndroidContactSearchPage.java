package phuoclet.test.pages.android;

import com.google.inject.Inject;
import phuoclet.core.annotation.FindElement;
import phuoclet.core.driver.DriverManager;
import phuoclet.core.element.BaseElement;
import phuoclet.core.element.ExpectedCondition;
import phuoclet.core.element.LocatorType;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import phuoclet.test.pages.abstractpages.ContactSearchPage;


public class AndroidContactSearchPage extends ContactSearchPage {

    private Logger log = LogManager.getLogger(this);

    @Inject
    public AndroidContactSearchPage(DriverManager manager) {
        AppiumDriver<WebElement> driver = manager.getDriver();
        initElement(driver);
    }

    @FindElement(type = LocatorType.ID, value = "main_search", condition = ExpectedCondition.PRESENCE)
    private BaseElement searchField;

    @FindElement(type = LocatorType.XPATH, value = "//android.widget.TextView[@text='Sara Alston']")
    private BaseElement firstSearchResultName; // new BaseMobileElement(driver, type, value, name);

    @Override
    public void search(String name) {
        searchField.click();
        searchField.sendKeys(name);
    }

    @Override
    public void navigateToSearchResultDetails() {
        firstSearchResultName.click();
    }

    @Override
    public String getFirstContact() {
        return firstSearchResultName.getText();
    }


    @Override
    public void select(String name) {
        firstSearchResultName.format(name);
//        firstSearchResultName.click();
        log.info(firstSearchResultName.getText());
    }

    public void set() {
        //  code implement here
    }
}























