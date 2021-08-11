package phuoclet.test;
import phuoclet.core.capability.Capability;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ExtraCapability extends Capability {

    private Method method;

    public ExtraCapability(Method method) {
        map = new HashMap<>();
        this.method = method;
    }

    @Override
    public Map<String, Object> load() {
        map.put("name", method.getName());
        return map;
    }
}
