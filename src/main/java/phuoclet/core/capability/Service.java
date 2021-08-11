package phuoclet.core.capability;

import java.util.Map;

public interface Service {
    Map<String, Object> loadCapability();

    void add(String name, String testcaseName);

    void add(Capability extra);
}
