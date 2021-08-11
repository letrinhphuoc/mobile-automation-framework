package phuoclet.core.capability;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.HashMap;
import java.util.Map;

/**
 * priority
 * 1. add capability from test case
 * 2. load capability from command line
 * 3. load capability from file
 * <p>
 * must be Singleton
 */
public class CapabilityService implements Service {
    private Map<String, Object> map;

    public CapabilityService() {
        map = new HashMap<>();
    }

    @Inject
    @Named("properties")
    private Capability properties;

    @Inject
    @Named("cli")
    private Capability commandLine;

    @Override
    public Map<String, Object> loadCapability() {
        // priority cua capability:
        // Highest. From code (test method)
        // High. Command line interface (CLI)
        // Medium. File config (properties, json, xml)
        map.putAll(properties.load());
        map.putAll(commandLine.load());
        return map;
    }

    @Override
    public void add(String key, String value){
        map.put(key, value);
    }

    @Override
    public void add(Capability extra) {
        map.putAll(extra.load());
    }
}
