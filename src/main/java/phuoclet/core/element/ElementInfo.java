package phuoclet.core.element;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ElementInfo {

    private String value;
    private LocatorType type;
    private String name;
    private ExpectedCondition condition;

}
