package core.capability;
import java.util.Map;

public interface Service {
    Map<String, Object> loadCapability();

    void add(Capability extra);
}
