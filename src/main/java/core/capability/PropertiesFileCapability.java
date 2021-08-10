package core.capability;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import core.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesFileCapability extends Capability {
    private Map<String, Object> map = new HashMap<>();
    @Inject
    @Named("platform")
    private String platform;

    @Override
    public Map<String, Object> load() {

        //Load all properties from config file:
        Properties fileProperties = new Properties();
        try {
            fileProperties.load(new FileReader(System.getProperty("user.dir") + "/res/config/" + platform + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String name : fileProperties.stringPropertyNames()) {
            String value = fileProperties.getProperty(name);
            // nếu name có dạng ${VARIABLE_NAME}, thì sẽ lấy String VARIABLE_NAME, và get giá trị từ biến môi trường
            // create a REGEX String
            String REGEX = "^\\$\\{(.*)}$"; // regular expression
            String envVariable = Utils.getValue(value, REGEX, 1);
            if (!envVariable.equals(value))
                value = System.getenv(envVariable);
            map.put(name, value);
        }

        return map;

    }
}
