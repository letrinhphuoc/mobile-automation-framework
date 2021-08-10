package core.capability;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandLineCapability extends Capability {

    private Map<String, Object> map = new HashMap<>();

    @Override
    public Map<String, Object> load() {
        // Load all properties from command line:
        Properties cliProperties = System.getProperties();
        for (String name : cliProperties.stringPropertyNames()) {
            if (name.startsWith("mobile.")) {
                String newkey = name.replace("mobile.", "");
                map.put(newkey, cliProperties.getProperty(name));
            }
        }
        return map;
    }
}
