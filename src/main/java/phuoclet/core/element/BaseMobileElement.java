package phuoclet.core.element;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseMobileElement implements BaseElement {
    private AppiumDriver<WebElement> driver;
    private By by;
    private ElementInfo info;
    private String formatedValue;
    private long DEFAULT_TIMEOUT = 10;

    public BaseMobileElement(AppiumDriver<WebElement> driver, ElementInfo info) {
        this.driver = driver;
        this.info = info;
        this.formatedValue = info.getValue();
    }

    private By getBy() {
        switch (info.getType()) {
            case ID:
                return By.id(formatedValue);
            case XPATH:
                return By.xpath(formatedValue);
        }
        return null;
    }

    private WebElement getElement(long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        switch (info.getCondition()) {
            case VISIBILITY:
            default:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(getBy()));
            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(getBy()));
        }
    }

    @Override
    public void format(String name) {
        this.formatedValue = String.format(this.info.getValue(), name);
    }

    @Override
    public void click(long timeout) {
        getElement(timeout).click();
    }

    @Override
    public void click() {
        getElement(DEFAULT_TIMEOUT).click();
    }

    @Override
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        getElement(DEFAULT_TIMEOUT).sendKeys(charSequences);
    }

    @Override
    public void clear() {
        getElement(DEFAULT_TIMEOUT).clear();
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public <T extends WebElement> List<T> findElements(By by) {
        return null;
    }

    @Override
    public <T extends WebElement> T findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
