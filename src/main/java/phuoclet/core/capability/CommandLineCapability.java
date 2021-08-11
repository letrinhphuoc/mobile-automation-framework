package phuoclet.core.capability;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandLineCapability extends Capability {

    private Logger log = LogManager.getLogger(this);

    private Map<String, Object> map = new HashMap<>();

    @Override
    public Map<String, Object> load() {
// load all properties from command line
        Properties cliProperties = System.getProperties();
        for (String name : cliProperties.stringPropertyNames()) {
            if (name.startsWith("mobile.")) {
                String newkey = name.replace("mobile.", "");
                log.debug(newkey + ": " + cliProperties.getProperty(name));
                map.put(newkey, cliProperties.getProperty(name));
            }
        }
        return map;
    }
}
