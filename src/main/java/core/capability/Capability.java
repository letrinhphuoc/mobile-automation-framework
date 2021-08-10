package core.capability;

import java.util.Map;
import java.util.Objects;

public abstract class Capability {
    protected Map<String, Object> map;

    public abstract Map<String, Object> load();
}
