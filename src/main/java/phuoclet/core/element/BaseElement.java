package phuoclet.core.element;

import org.openqa.selenium.WebElement;

public interface BaseElement extends WebElement {

    void format(String name);

    void click(long timeout);
}
