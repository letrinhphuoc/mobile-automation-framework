package core.driver;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.google.inject.Provider;

public class DriverManagerProvider implements Provider<DriverManager> {
    @Inject
    private Injector injector;

    @Override
    public DriverManager get() {
        String platform = System.getProperty("mobile.platform");
        DriverManager manager = injector.getInstance(Key.get(DriverManager.class, Names.named(platform)));
        return manager;
    }
}
