package phuoclet.core;

import phuoclet.core.annotation.FindElement;
import phuoclet.core.element.*;
import phuoclet.core.exception.ElementInitException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ElementFactory {

    public static void initElements(AppiumDriver<WebElement> driver, Object object) {
        Class cls = object.getClass();

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {

            Annotation annotation = f.getAnnotation(FindElement.class);
            if (BaseElement.class.isAssignableFrom(f.getType()) && annotation != null) {

                String value = ((FindElement) annotation).value();
                LocatorType type = ((FindElement) annotation).type();
                String name = f.getName();
                ExpectedCondition condition = ((FindElement) annotation).condition();

                ElementInfo info = new ElementInfo(value, type, name, condition);
                BaseElement element = new BaseMobileElement(driver, info);

                f.setAccessible(true);

                try {
                    f.set(object, element);
                } catch (IllegalAccessException e) {
                    throw new ElementInitException(e.getMessage(), e);
                }

            }
        }
    }
}
